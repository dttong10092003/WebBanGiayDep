package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connect.DBConnect;
import entity.Category;

public class CategoryDAO {
	public Category getCategoryByID(int id) {
		String query = "SELECT * FROM Category WHERE cID = ?";
		Category c = new Category();
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				c.setId(rs.getInt("cID"));
				c.setName(rs.getString("cName"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public int getCateIDByProductID(String id) {
		String query = "SELECT categoryID FROM Product WHERE id = ?";
		int cateID = 0;
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cateID = rs.getInt("categoryID");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cateID;
	}
}
