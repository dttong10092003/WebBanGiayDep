package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.DBConnect;
import entity.Category;
import entity.Product;

public class ProductDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// Top 8 sản phẩm có soldQuantity cao nhất
	public List<Product> top8Products() {

		List<Product> topp8Products = new ArrayList<Product>();
		String query = "SELECT TOP 8 p.id AS productId, p.name, p.image, p.price, p.description, p.categoryID, p.gender, "
				+ "       SUM(pv.soldQuantity) AS totalSoldQuantity "
				+ "FROM ProductVariant pv "
				+ "JOIN Product p ON pv.productId = p.id "
				+ "GROUP BY p.id, p.name, p.image, p.price, p.description, p.categoryID, p.gender "
				+ "ORDER BY totalSoldQuantity DESC;";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("productId"));
				product.setName(rs.getString("name"));
				product.setImage(rs.getString("image"));
				product.setPrice(rs.getDouble("price"));
				product.setDescription(rs.getString("description"));
				Category category = new Category();
				category.setId(rs.getInt("categoryID"));
				product.setCategoryID(category);
				product.setGender(rs.getInt("gender"));
				topp8Products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return topp8Products;
	}

}
