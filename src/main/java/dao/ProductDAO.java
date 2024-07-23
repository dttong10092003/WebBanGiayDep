package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
		String query = "SELECT TOP 8 p.id, p.name, p.image, p.price, p.retailPrice, p.description, p.categoryID, p.brandID, p.supplierID, p.gender, "
				+ "       SUM(pv.soldQuantity) AS totalSoldQuantity " + "FROM ProductVariant pv "
				+ "JOIN Product p ON pv.productId = p.id "
				+ "GROUP BY p.id, p.name, p.image, p.price, p.retailPrice, p.description, p.categoryID, p.brandID, p.supplierID, p.gender "
				+ "ORDER BY totalSoldQuantity DESC;";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setImage(rs.getString("image"));
				product.setPrice(rs.getDouble("price"));
				product.setRetailPrice(rs.getDouble("retailPrice"));
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
				product.setRetailPrice(rs.getDouble("retailPrice"));
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
				product.setRetailPrice(rs.getDouble("retailPrice"));
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
				product.setRetailPrice(rs.getDouble("retailPrice"));
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
				product.setRetailPrice(rs.getDouble("retailPrice"));
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
				product.setRetailPrice(rs.getDouble("retailPrice"));
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
				product.setRetailPrice(rs.getDouble("retailPrice"));
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
				productVariant.setId(rs.getInt("id"));
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
				product.setRetailPrice(rs.getDouble("retailPrice"));
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

	public List<Product> get5ProductByIndex(int index) {
		List<Product> list = new ArrayList<Product>();
		String query = "select * from Product \r\n" + "order by [id] desc\r\n" + "offset ? rows\r\n"
				+ "fetch next 5 rows only";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setInt(1, (index - 1) * 5);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setImage(rs.getString("image"));
				product.setPrice(rs.getDouble("price"));
				product.setRetailPrice(rs.getDouble("retailPrice"));
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
				product.setRetailPrice(rs.getDouble("retailPrice"));
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
			sql += ("AND p.retailPrice BETWEEN ? AND ? ");
			params.add(priceMin);
			params.add(priceMax);
		} else if (price != null && !price.isEmpty()) {
			if (price.equalsIgnoreCase("under100")) {
				sql += ("AND p.retailPrice < 100 ");
			} else if (price.equalsIgnoreCase("100to200")) {
				sql += ("AND p.retailPrice BETWEEN 100 AND 200 ");
			} else if (price.equalsIgnoreCase("200above")) {
				sql += ("AND p.retailPrice > 200 ");
			}
		}

		if (txtS != null && !txtS.isEmpty()) {
			sql += ("AND p.name LIKE ? ");
			params.add("%" + txtS + "%");
		}

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
				product.setRetailPrice(rs.getDouble("retailPrice"));
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

	public int getQuantity(int productVatiantID) {
		int quantity = 0;
		String sql = "Select quantity from ProductVariant where id = ?";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, productVatiantID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				quantity = rs.getInt("quantity");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return quantity;
	}

	public boolean updateQuantityAndSoldQuantity(int productVariantID, int quantity) {
		String sql = "UPDATE ProductVariant SET quantity = quantity - ?, soldQuantity = soldQuantity + ? WHERE id = ?";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, quantity);
			ps.setInt(2, quantity);
			ps.setInt(3, productVariantID);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public int totalSoldQuantity() {
		int totalSoldQuantity = 0;
		String sql = "SELECT SUM(soldQuantity) FROM ProductVariant";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				totalSoldQuantity = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalSoldQuantity;
	}

	public Product getProductLast() {
		Product product = new Product();
		String sql = "SELECT TOP 1 * FROM Product ORDER BY id DESC";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setImage(rs.getString("image"));
				product.setPrice(rs.getDouble("price"));
				product.setRetailPrice(rs.getDouble("retailPrice"));
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

	public boolean addProduct(String id, String name, String image, double price, double retailPrice,
			String description, int categoryID, int brandID, int supplierID, int gender) {
		String sql = "INSERT INTO Product (id, name, image, price, retailPrice, description, categoryID, brandID, supplierID, gender) VALUES(?,?,?,?,?,?,?,?,?,?)";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, image);
			ps.setDouble(4, price);
			ps.setDouble(5, retailPrice);
			ps.setString(6, description);
			ps.setInt(7, categoryID);
			ps.setInt(8, brandID);
			ps.setInt(9, supplierID);
			ps.setInt(10, gender);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateProduct(String id, String name, String image, double price, double retailPrice,
			String description, int categoryID, int brandID, int supplierID, int gender) {
		String sql = "UPDATE Product SET name = ?, image = ?, price = ?, retailPrice = ?, description = ?, categoryID = ?, brandID = ?, supplierID = ?, gender = ? WHERE id = ?";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, name);
			ps.setString(2, image);
			ps.setDouble(3, price);
			ps.setDouble(4, retailPrice);
			ps.setString(5, description);
			ps.setInt(6, categoryID);
			ps.setInt(7, brandID);
			ps.setInt(8, supplierID);
			ps.setInt(9, gender);
			ps.setString(10, id);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean addProductVariant(ProductVariant productVariant) {
		String sql = "INSERT INTO ProductVariant (productID, size, color, quantity, soldQuantity, image1, image2, image3, image4) VALUES(?,?,?,?,?,?,?,?,?)";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, productVariant.getProductID().getId());
			ps.setInt(2, productVariant.getSize());
			ps.setString(3, productVariant.getColor());
			ps.setInt(4, productVariant.getQuantity());
			ps.setInt(5, 0);
			ps.setString(6, productVariant.getImage1());
			ps.setString(7, productVariant.getImage2());
			ps.setString(8, productVariant.getImage3());
			ps.setString(9, productVariant.getImage4());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateProductVariant(int quantity, String image1, String image2, String image3, String image4,
			int id) {
		String sql = "UPDATE ProductVariant SET quantity = ?, image1 = ?, image2 = ?, image3 = ?, image4 = ? WHERE id = ?";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, quantity);
			ps.setString(2, image1);
			ps.setString(3, image2);
			ps.setString(4, image3);
			ps.setString(5, image4);
			ps.setInt(6, id);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Map<Product, Integer> getTop10ProductSold() {

		Map<Product, Integer> top10Products = new LinkedHashMap<Product, Integer>();
		String query = "SELECT TOP 10 p.id, p.name, p.image, p.price, p.retailPrice, p.description, p.categoryID, p.brandID, p.supplierID, p.gender, "
				+ "       SUM(pv.soldQuantity) AS totalSoldQuantity " + "FROM ProductVariant pv "
				+ "JOIN Product p ON pv.productId = p.id "
				+ "GROUP BY p.id, p.name, p.image, p.price, p.retailPrice, p.description, p.categoryID, p.brandID, p.supplierID, p.gender "
				+ "ORDER BY totalSoldQuantity DESC;";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	Product product = new Product();
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setImage(rs.getString("image"));
				product.setPrice(rs.getDouble("price"));
				product.setRetailPrice(rs.getDouble("retailPrice"));
				product.setDescription(rs.getString("description"));

				product.setCategoryID(categoryDAO.getCategoryByID(rs.getInt("categoryID")));

				product.setBrandID(brandDAO.getBrandByID(rs.getInt("brandID")));

				product.setSupplierID(supplierDAO.getSupplierByID(rs.getInt("supplierID")));

				product.setGender(rs.getInt("gender"));
				
				top10Products.put(product, rs.getInt("totalSoldQuantity"));
            }
		} catch (Exception e) {
			e.printStackTrace();

		}
		return top10Products;
	}
}