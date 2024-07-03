package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connect.DBConnect;
import entity.Supplier;

public class SupplierDAO {
	public Supplier getSupplierByID(int id) {
		String query = "SELECT * FROM Supplier WHERE id = ?";
		Supplier s = new Supplier();
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setAddress(rs.getString("address"));
				s.setPhoneNumber(rs.getString("phoneNumber"));
				s.setEmail(rs.getString("email"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
}
