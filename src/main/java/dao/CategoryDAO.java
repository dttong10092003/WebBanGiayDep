package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.DBConnect;
import entity.Category;

public class CategoryDAO {

	public List<Category> getAllCategory() {
		String query = "SELECT * FROM Category";
		List<Category> list = new ArrayList<>();
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category c = new Category();
				c.setId(rs.getInt("cID"));
				c.setName(rs.getString("cName"));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

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
