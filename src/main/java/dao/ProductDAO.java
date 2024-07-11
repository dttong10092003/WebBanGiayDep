package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.DBConnect;
import entity.Product;
import entity.ProductVariant;

public class ProductDAO {

	private BrandDAO brandDAO = new BrandDAO();
	private CategoryDAO categoryDAO = new CategoryDAO();
	private SupplierDAO supplierDAO = new SupplierDAO();
	private static final String SELECT_PRODUCTS_SQL = "SELECT * FROM Product p WHERE 1=1 ";

	private static final String SELECT_PRODUCTS_SQL_HAVECOLOR = "SELECT * FROM Product p "
			+ "JOIN (SELECT productID, color from ProductVariant where color = ? group by productID, color) pv ON p.id = pv.productID WHERE 1=1 ";

	private static final String COUNT_PRODUCTS_SQL = "SELECT COUNT(*) FROM Product p WHERE 1=1 ";
	private static final String COUNT_PRODUCTS_SQL_HAVECOLOR = "SELECT COUNT(*) FROM Product p "
			+ "JOIN (SELECT productID, color from ProductVariant where color = ? group by productID, color) pv ON p.id = pv.productID WHERE 1=1 ";

	// Top 8 sản phẩm có soldQuantity cao nhất
	public List<Product> getTop8Products() {

		List<Product> topp8Products = new ArrayList<Product>();
		String query = "SELECT TOP 8 p.id, p.name, p.image, p.price, p.description, p.categoryID, p.brandID, p.supplierID, p.gender, "
				+ "       SUM(pv.soldQuantity) AS totalSoldQuantity " + "FROM ProductVariant pv "
				+ "JOIN Product p ON pv.productId = p.id "
				+ "GROUP BY p.id, p.name, p.image, p.price, p.description, p.categoryID, p.brandID, p.supplierID, p.gender "
				+ "ORDER BY totalSoldQuantity DESC;";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setImage(rs.getString("image"));
				product.setPrice(rs.getDouble("price"));
				product.setDescription(rs.getString("description"));

				product.setCategoryID(categoryDAO.getCategoryByID(rs.getInt("categoryID")));

				product.setBrandID(brandDAO.getBrandByID(rs.getInt("brandID")));

				product.setSupplierID(supplierDAO.getSupplierByID(rs.getInt("supplierID")));

				product.setGender(rs.getInt("gender"));
				topp8Products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return topp8Products;
	}

	// Top 4 sản phẩm brand Nike mới nhất
	public List<Product> getTop4NikeProductsNew() {
		List<Product> top4NikeProductsNew = new ArrayList<Product>();
		String query = "SELECT TOP 4 p.* " + "FROM Product p " + "JOIN Brand b ON p.brandID = b.bID "
				+ "WHERE b.bName = 'Nike' " + "ORDER BY id desc";

		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setImage(rs.getString("image"));
				product.setPrice(rs.getDouble("price"));
				product.setDescription(rs.getString("description"));

				product.setCategoryID(categoryDAO.getCategoryByID(rs.getInt("categoryID")));

				product.setBrandID(brandDAO.getBrandByID(rs.getInt("brandID")));

				product.setSupplierID(supplierDAO.getSupplierByID(rs.getInt("supplierID")));

				product.setGender(rs.getInt("gender"));
				top4NikeProductsNew.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return top4NikeProductsNew;
	}

	// Top 4 sản phẩm brand Adidas mới nhất
	public List<Product> getTop4AdidasProductsNew() {
		List<Product> top4AdidasProductsNew = new ArrayList<Product>();
		String query = "SELECT TOP 4 p.* " + "FROM Product p " + "JOIN Brand b ON p.brandID = b.bID "
				+ "WHERE b.bName = 'Adidas' " + "ORDER BY id desc";

		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setImage(rs.getString("image"));
				product.setPrice(rs.getDouble("price"));
				product.setDescription(rs.getString("description"));

				product.setCategoryID(categoryDAO.getCategoryByID(rs.getInt("categoryID")));

				product.setBrandID(brandDAO.getBrandByID(rs.getInt("brandID")));

				product.setSupplierID(supplierDAO.getSupplierByID(rs.getInt("supplierID")));

				product.setGender(rs.getInt("gender"));
				top4AdidasProductsNew.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return top4AdidasProductsNew;
	}

	// Lấy 4 sản phẩm Nike tiếp theo
	public List<Product> getNext4NikeProducts(int amount) {
		List<Product> list = new ArrayList<Product>();
		String query = "select * from Product p join Brand b on p.brandID = b.bID\r\n"
				+ "        		where b.bName = 'Nike'\r\n" + "        		order by id desc\r\n"
				+ "        		offset ? rows\r\n" + "        		fetch next 4 rows only";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {

			ps.setInt(1, amount);
			System.out.println(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setImage(rs.getString("image"));
				product.setPrice(rs.getDouble("price"));
				product.setDescription(rs.getString("description"));

				product.setCategoryID(categoryDAO.getCategoryByID(rs.getInt("categoryID")));

				product.setBrandID(brandDAO.getBrandByID(rs.getInt("brandID")));

				product.setSupplierID(supplierDAO.getSupplierByID(rs.getInt("supplierID")));

				product.setGender(rs.getInt("gender"));
				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;

	}

	public ProductVariant getProductVariantByProductIDSizeAndImg(String productID, int size, String image) {
		ProductVariant productVariant = new ProductVariant();
		String query = "SELECT * FROM ProductVariant WHERE productID = ? AND size = ? AND image1 = ?";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setString(1, productID);
			ps.setInt(2, size);
			ps.setString(3, image);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				productVariant.setId(rs.getInt("id"));
				productVariant.setProductID(getProductByID(rs.getString("productID")));
				productVariant.setSize(rs.getInt("size"));
				productVariant.setColor(rs.getString("color"));
				productVariant.setQuantity(rs.getInt("quantity"));
				productVariant.setSoldQuantity(rs.getInt("soldQuantity"));
				productVariant.setImage1(rs.getString("image1"));
				productVariant.setImage2(rs.getString("image2"));
				productVariant.setImage3(rs.getString("image3"));
				productVariant.setImage4(rs.getString("image4"));
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return productVariant;

	}

	// Lấy 4 sản phẩm Adidas tiếp theo
	public List<Product> getNext4AdidasProducts(int amount) {
		List<Product> list = new ArrayList<Product>();
		String query = "select * from Product p join Brand b on p.brandID = b.bID\r\n"
				+ "        		where b.bName = 'Adidas'\r\n" + "        		order by id desc\r\n"
				+ "        		offset ? rows\r\n" + "        		fetch next 4 rows only";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setInt(1, amount);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setImage(rs.getString("image"));
				product.setPrice(rs.getDouble("price"));
				product.setDescription(rs.getString("description"));

				product.setCategoryID(categoryDAO.getCategoryByID(rs.getInt("categoryID")));

				product.setBrandID(brandDAO.getBrandByID(rs.getInt("brandID")));

				product.setSupplierID(supplierDAO.getSupplierByID(rs.getInt("supplierID")));

				product.setGender(rs.getInt("gender"));
				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;

	}

	// Lây SanPham theo ID
	public Product getProductByID(String id) {
		Product product = new Product();
		String query = "SELECT * FROM Product WHERE id = ?";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setImage(rs.getString("image"));
				product.setPrice(rs.getDouble("price"));
				product.setDescription(rs.getString("description"));

				product.setCategoryID(categoryDAO.getCategoryByID(rs.getInt("categoryID")));

				product.setBrandID(brandDAO.getBrandByID(rs.getInt("brandID")));

				product.setSupplierID(supplierDAO.getSupplierByID(rs.getInt("supplierID")));

				product.setGender(rs.getInt("gender"));
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return product;

	}

	// Lấy sản phẩm theo categoryID và brandID
	public List<Product> getRelatedProduct(int categoryID, int brandID) {
		List<Product> list = new ArrayList<Product>();
		String query = "SELECT * FROM Product WHERE categoryID = ? AND brandID = ?";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setInt(1, categoryID);
			ps.setInt(2, brandID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setImage(rs.getString("image"));
				product.setPrice(rs.getDouble("price"));
				product.setDescription(rs.getString("description"));

				product.setCategoryID(categoryDAO.getCategoryByID(rs.getInt("categoryID")));

				product.setBrandID(brandDAO.getBrandByID(rs.getInt("brandID")));

				product.setSupplierID(supplierDAO.getSupplierByID(rs.getInt("supplierID")));

				product.setGender(rs.getInt("gender"));
				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;

	}

	// Lấy ProductVariant theo productID
	public List<ProductVariant> getProductVariantByProductID(String productID) {
		List<ProductVariant> list = new ArrayList<ProductVariant>();
		String query = "SELECT * FROM ProductVariant WHERE productID = ?";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setString(1, productID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductVariant productVariant = new ProductVariant();
				productVariant.setId(rs.getInt("id"));
				productVariant.setProductID(getProductByID(rs.getString("productID")));
				productVariant.setSize(rs.getInt("size"));
				productVariant.setColor(rs.getString("color"));
				productVariant.setQuantity(rs.getInt("quantity"));
				productVariant.setSoldQuantity(rs.getInt("soldQuantity"));
				productVariant.setImage1(rs.getString("image1"));
				productVariant.setImage2(rs.getString("image2"));
				productVariant.setImage3(rs.getString("image3"));
				productVariant.setImage4(rs.getString("image4"));
				list.add(productVariant);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;

	}

	public ProductVariant getProductVariantById(int id) {
		String sql = "Select * from ProductVariant where id = ?";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductVariant productVariant = new ProductVariant();
				productVariant.setProductID(getProductByID(rs.getString("productID")));
				productVariant.setColor(rs.getString("color"));
				productVariant.setQuantity(rs.getInt("quantity"));
				productVariant.setSoldQuantity(rs.getInt("soldQuantity"));
				productVariant.setSize(rs.getInt("size"));
				productVariant.setImage1(rs.getString("image1"));
				productVariant.setImage2(rs.getString("image2"));
				productVariant.setImage3(rs.getString("image3"));
				productVariant.setImage4(rs.getString("image4"));
				return productVariant;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

	// Lấy ProductVariant theo productID và gom nhóm không theo size
	public List<ProductVariant> getProductVariantByProductIDGroupBy(String productID) {
		List<ProductVariant> list = new ArrayList<ProductVariant>();
		String query = "SELECT " + "    productID, " + "    color, " + "    image1, " + "    image2, " + "    image3, "
				+ "    image4, " + "    SUM(quantity) AS totalQuantity, "
				+ "    SUM(soldQuantity) AS totalSoldQuantity " + "FROM " + "    ProductVariant " + "WHERE "
				+ "    productID = ? " + "GROUP BY " + "    productID, " + "    color, " + "    image1, "
				+ "    image2, " + "    image3, " + "    image4  order by min(id)";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setString(1, productID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductVariant productVariant = new ProductVariant();
				productVariant.setProductID(getProductByID(rs.getString("productID")));
				productVariant.setColor(rs.getString("color"));
				productVariant.setQuantity(rs.getInt("totalQuantity"));
				productVariant.setSoldQuantity(rs.getInt("totalSoldQuantity"));
				productVariant.setImage1(rs.getString("image1"));
				productVariant.setImage2(rs.getString("image2"));
				productVariant.setImage3(rs.getString("image3"));
				productVariant.setImage4(rs.getString("image4"));
				list.add(productVariant);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;

	}

	// Lấy ProductVariant theo productID và lấy size của màu đầu tiên (Do chưa biết
	// màu)
	public List<ProductVariant> getProductVariantByProductIDAndTop1Color(String productID) {
		List<ProductVariant> list = new ArrayList<ProductVariant>();
		String query = "SELECT * FROM ProductVariant WHERE productID = ? and color = (SELECT top 1 color FROM ProductVariant WHERE productID = ? order by id)";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setString(1, productID);
			ps.setString(2, productID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductVariant productVariant = new ProductVariant();
				productVariant.setId(rs.getInt("id"));
				productVariant.setProductID(getProductByID(rs.getString("productID")));
				productVariant.setSize(rs.getInt("size"));
				productVariant.setColor(rs.getString("color"));
				productVariant.setQuantity(rs.getInt("quantity"));
				productVariant.setSoldQuantity(rs.getInt("soldQuantity"));
				productVariant.setImage1(rs.getString("image1"));
				productVariant.setImage2(rs.getString("image2"));
				productVariant.setImage3(rs.getString("image3"));
				productVariant.setImage4(rs.getString("image4"));
				list.add(productVariant);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;

	}

	// Lấy ProductVariant theo productID và color
	public List<ProductVariant> getProductVariantByProductIDAndColor(String productID, String color) {
		List<ProductVariant> list = new ArrayList<ProductVariant>();
		String query = "SELECT * FROM ProductVariant WHERE productID = ? and color = ?";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setString(1, productID);
			ps.setString(2, color);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductVariant productVariant = new ProductVariant();
				productVariant.setId(rs.getInt("id"));
				productVariant.setProductID(getProductByID(rs.getString("productID")));
				productVariant.setSize(rs.getInt("size"));
				productVariant.setColor(rs.getString("color"));
				productVariant.setQuantity(rs.getInt("quantity"));
				productVariant.setSoldQuantity(rs.getInt("soldQuantity"));
				productVariant.setImage1(rs.getString("image1"));
				productVariant.setImage2(rs.getString("image2"));
				productVariant.setImage3(rs.getString("image3"));
				productVariant.setImage4(rs.getString("image4"));
				list.add(productVariant);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;

	}

	public List<Product> getProductByIndex(int index) {
		List<Product> list = new ArrayList<Product>();
		String query = "select * from Product \r\n" + "order by [id] desc\r\n" + "offset ? rows\r\n"
				+ "fetch next 9 rows only";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setInt(1, (index - 1) * 9);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setImage(rs.getString("image"));
				product.setPrice(rs.getDouble("price"));
				product.setDescription(rs.getString("description"));

				product.setCategoryID(categoryDAO.getCategoryByID(rs.getInt("categoryID")));

				product.setBrandID(brandDAO.getBrandByID(rs.getInt("brandID")));

				product.setSupplierID(supplierDAO.getSupplierByID(rs.getInt("supplierID")));

				product.setGender(rs.getInt("gender"));
				list.add(product);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public int getCountAllProduct() {
		String query = "select count(*) as total from Product";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt("total");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public List<String> getAllColor() {
		List<String> list = new ArrayList<String>();
		String query = "select color from ProductVariant group by color";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("color"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Product> getProductByCategoryID(int categoryID) {
		List<Product> list = new ArrayList<Product>();
		String query = "select * from Product where categoryID = ?";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setInt(1, categoryID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setImage(rs.getString("image"));
				product.setPrice(rs.getDouble("price"));
				product.setDescription(rs.getString("description"));

				product.setCategoryID(categoryDAO.getCategoryByID(rs.getInt("categoryID")));

				product.setBrandID(brandDAO.getBrandByID(rs.getInt("brandID")));

				product.setSupplierID(supplierDAO.getSupplierByID(rs.getInt("supplierID")));

				product.setGender(rs.getInt("gender"));
				list.add(product);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

//	public int countProducts(String[] genders, String brandID, String categoryID, String price, String priceMin,
//			String priceMax, String color, String txtS) {
//		StringBuilder queryBuilder = new StringBuilder();
//		sql +=("SELECT COUNT(*) FROM Product p ");
//		sql +=("JOIN ProductVariant pv ON p.id = pv.productID WHERE 1=1 ");
//
//		List<Object> params = new ArrayList<>();
//
//		if (genders != null && genders.length > 0) {
//			sql +=("AND (");
//			for (int i = 0; i < genders.length; i++) {
//				if (i > 0) {
//					sql +=("OR ");
//				}
//				sql +=("p.gender = ? ");
//				params.add(Integer.parseInt(genders[i]));
//			}
//			sql +=(") ");
//		}
//
//		if (brandID != null && !brandID.isEmpty()) {
//			sql +=("AND p.brandID = ? ");
//			params.add(Integer.parseInt(brandID));
//		}
//
//		if (categoryID != null && !categoryID.isEmpty()) {
//			sql +=("AND p.categoryID = ? ");
//			params.add(Integer.parseInt(categoryID));
//		}
//
//		if (price != null && !price.isEmpty()) {
//			sql +=("AND p.price = ? ");
//			params.add(Double.parseDouble(price));
//		} else if (priceMin != null && !priceMin.isEmpty() && priceMax != null && !priceMax.isEmpty()) {
//			sql +=("AND p.price BETWEEN ? AND ? ");
//			params.add(Double.parseDouble(priceMin));
//			params.add(Double.parseDouble(priceMax));
//		}
//
//		if (color != null && !color.isEmpty()) {
//			sql +=("AND pv.color = ? ");
//			params.add(color);
//		}
//
//		if (txtS != null && !txtS.isEmpty()) {
//			sql +=("AND (p.name LIKE ? OR p.description LIKE ?) ");
//			params.add("%" + txtS + "%");
//			params.add("%" + txtS + "%");
//		}
//
//		String query = queryBuilder.toString();
//
//		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
//			for (int i = 0; i < params.size(); i++) {
//				ps.setObject(i + 1, params.get(i));
//			}
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				return rs.getInt(1);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return 0;
//
//	}

	// Method to count products based on filters
	public int countProducts(String[] genders, String brand, String category, String price, String priceMin,
			String priceMax, String color, String txtS) {
		String sql = COUNT_PRODUCTS_SQL;
		List<Object> params = new ArrayList<>();

		if (color != null && !color.isEmpty()) {
			sql = COUNT_PRODUCTS_SQL_HAVECOLOR;
			params.add(color);
		}

		// Xử lý điều kiện lọc cho genders
		if (genders != null && genders.length > 0) {
			sql += (" AND gender IN (");
			for (int i = 0; i < genders.length; i++) {
				sql += ("?");
				if (i < genders.length - 1) {
					sql += (",");
				}
				params.add(genders[i]);
			}
			sql += (")");
		}

		if (brand != null && !brand.isEmpty()) {
			sql += ("AND p.brandID = ? ");
			params.add(brand);
		}

		if (category != null && !category.isEmpty()) {
			sql += ("AND p.categoryID = ? ");
			params.add(category);
		}

		if (price != null && !price.isEmpty()) {
			sql += ("AND p.price = ? ");
			params.add(price);
		} else if (priceMin != null && !priceMin.isEmpty() && priceMax != null && !priceMax.isEmpty()) {
			sql += ("AND p.price BETWEEN ? AND ? ");
			params.add(priceMin);
			params.add(priceMax);
		}

		if (txtS != null && !txtS.isEmpty()) {
			sql += ("AND (p.name LIKE ? OR p.description LIKE ?) ");
			params.add("%" + txtS + "%");
			params.add("%" + txtS + "%");
		}
		System.out.println("query: " + sql);

		// Execute query and return count
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {

			for (int i = 0; i < params.size(); i++) {
				ps.setObject(i + 1, params.get(i));
			}

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	// Method to get products based on filters and pagination
	public List<Product> getFilterProducts(int index, String[] genders, String brand, String category, String price,
			String priceMin, String priceMax, String color, String txtS) {
		String sql = SELECT_PRODUCTS_SQL;
		List<Object> params = new ArrayList<Object>();

		if (color != null && !color.isEmpty()) {
			sql = SELECT_PRODUCTS_SQL_HAVECOLOR;
			params.add(color);
		}

		// Xử lý điều kiện lọc cho genders
		if (genders != null && genders.length > 0) {
			sql += (" AND gender IN (");
			for (int i = 0; i < genders.length; i++) {
				sql += ("?");
				if (i < genders.length - 1) {
					sql += (",");
				}
				params.add(genders[i]);
				System.out.println(genders[i]);
			}
			sql += (")");
		}

		if (brand != null && !brand.isEmpty()) {
			sql += ("AND p.brandID = ? ");
			params.add(brand);
		}

		if (category != null && !category.isEmpty()) {
			sql += ("AND p.categoryID = ? ");
			params.add(category);
		}

		if (priceMin != null && !priceMin.isEmpty() && priceMax != null && !priceMax.isEmpty()) {
			sql += ("AND p.price BETWEEN ? AND ? ");
			params.add(priceMin);
			params.add(priceMax);
		} else if (price != null && !price.isEmpty()) {
			if (price.equalsIgnoreCase("under100")) {
				sql += ("AND p.price < 100 ");
			} else if (price.equalsIgnoreCase("100to200")) {
				sql += ("AND p.price BETWEEN 100 AND 200 ");
			} else if (price.equalsIgnoreCase("200above")) {
				sql += ("AND p.price > 200 ");
			}
		}

		if (txtS != null && !txtS.isEmpty()) {
			sql += ("AND p.name LIKE ? ");
			params.add("%" + txtS + "%");
		}

		// Append pagination
//        sql +=(" LIMIT ?, ?");
//        params.add((page - 1) * pageSize);
//        params.add(pageSize);
		sql += (" ORDER BY p.id DESC OFFSET ? ROWS FETCH NEXT 9 ROWS ONLY");
		params.add((index - 1) * 9);
		System.out.println("query: " + sql);

		// Execute query and return list of products
		List<Product> products = new ArrayList<>();
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {

			System.out.println(params.size() + params.toString());
			for (int i = 0; i < params.size(); i++) {
				ps.setObject(i + 1, params.get(i));
			}

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setImage(rs.getString("image"));
				product.setPrice(rs.getDouble("price"));
				product.setDescription(rs.getString("description"));

				product.setCategoryID(categoryDAO.getCategoryByID(rs.getInt("categoryID")));

				product.setBrandID(brandDAO.getBrandByID(rs.getInt("brandID")));

				product.setSupplierID(supplierDAO.getSupplierByID(rs.getInt("supplierID")));

				product.setGender(rs.getInt("gender"));
				products.add(product);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return products;
	}

}