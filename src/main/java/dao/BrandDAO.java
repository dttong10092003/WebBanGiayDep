package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.DBConnect;
import entity.Brand;

public class BrandDAO {
	public List<Brand> getAllBrand() {
		String query = "SELECT * FROM Brand";
		List<Brand> list = new ArrayList<>();
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Brand b = new Brand();
				b.setId(rs.getInt("bID"));
				b.setName(rs.getString("bName"));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Brand getBrandByID(int id) {
		String query = "SELECT * FROM Brand WHERE bID = ?";
		Brand b = new Brand();
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				b.setId(rs.getInt("bID"));
				b.setName(rs.getString("bName"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public int getBrandIDByProductID(String id) {
		String query = "SELECT brandID FROM Product WHERE id = ?";
		int brandID = 0;
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				brandID = rs.getInt("brandID");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return brandID;
	}
	
	public boolean insertBrand(String name) {
		String query = "INSERT INTO Brand(bName) VALUES(?)";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setString(1, name);
			return ps.executeUpdate() == 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
