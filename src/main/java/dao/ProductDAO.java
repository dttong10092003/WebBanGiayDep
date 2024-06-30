package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.DBConnect;
import entity.Brand;
import entity.Category;
import entity.Product;
import entity.Supplier;

public class ProductDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// Top 8 sản phẩm có soldQuantity cao nhất
	public List<Product> getTop8Products() {

		List<Product> topp8Products = new ArrayList<Product>();
		String query = "SELECT TOP 8 p.id, p.name, p.image, p.price, p.description, p.categoryID, p.brandID, p.supplierID, p.gender, "
				+ "       SUM(pv.soldQuantity) AS totalSoldQuantity " + "FROM ProductVariant pv "
				+ "JOIN Product p ON pv.productId = p.id "
				+ "GROUP BY p.id, p.name, p.image, p.price, p.description, p.categoryID, p.brandID, p.supplierID, p.gender "
				+ "ORDER BY totalSoldQuantity DESC;";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setImage(rs.getString("image"));
				product.setPrice(rs.getDouble("price"));
				product.setDescription(rs.getString("description"));

				Category category = new Category();
				category.setId(rs.getInt("categoryID"));
				product.setCategoryID(category);
				Brand brand = new Brand();
				brand.setId(rs.getInt("brandID"));
				product.setBrandID(brand);
				Supplier supplier = new Supplier();
				supplier.setId(rs.getInt("supplierID"));
				product.setSupplierID(supplier);

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

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setImage(rs.getString("image"));
				product.setPrice(rs.getDouble("price"));
				product.setDescription(rs.getString("description"));

				Category category = new Category();
				category.setId(rs.getInt("categoryID"));
				product.setCategoryID(category);
				Brand brand = new Brand();
				brand.setId(rs.getInt("brandID"));
				product.setBrandID(brand);
				Supplier supplier = new Supplier();
				supplier.setId(rs.getInt("supplierID"));
				product.setSupplierID(supplier);

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

			try {
				conn = new DBConnect().getConnection();
				ps = conn.prepareStatement(query);
				rs = ps.executeQuery();
				while (rs.next()) {
					Product product = new Product();
					product.setId(rs.getString("id"));
					product.setName(rs.getString("name"));
					product.setImage(rs.getString("image"));
					product.setPrice(rs.getDouble("price"));
					product.setDescription(rs.getString("description"));

					Category category = new Category();
					category.setId(rs.getInt("categoryID"));
					product.setCategoryID(category);
					Brand brand = new Brand();
					brand.setId(rs.getInt("brandID"));
					product.setBrandID(brand);
					Supplier supplier = new Supplier();
					supplier.setId(rs.getInt("supplierID"));
					product.setSupplierID(supplier);

					product.setGender(rs.getInt("gender"));
					top4AdidasProductsNew.add(product);
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
			return top4AdidasProductsNew;
		}

}
