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
				productVariant.setProductID(rs.getString("productID"));
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
	//Đang fix lỗi
	// Lấy ProductVariant theo productID và gom nhóm không theo size
	public List<ProductVariant> getProductVariantByProductIDGroupBy(String productID) {
		List<ProductVariant> list = new ArrayList<ProductVariant>();
		String query = "SELECT "
		           + "    productID, "
		           + "    color, "
		           + "    image1, "
		           + "    image2, "
		           + "    image3, "
		           + "    image4, "
		           + "    SUM(quantity) AS totalQuantity, "
		           + "    SUM(soldQuantity) AS totalSoldQuantity "
		           + "FROM "
		           + "    ProductVariant "
		           + "WHERE "
		           + "    productID = ? "  
		           + "GROUP BY "
		           + "    productID, "
		           + "    color, "
		           + "    image1, "
		           + "    image2, "
		           + "    image3, "
		           + "    image4 ";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setString(1, productID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductVariant productVariant = new ProductVariant();
				productVariant.setProductID(rs.getString("productID"));
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
	
}