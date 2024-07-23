package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<Supplier> getAllSupplier(){
		String query = "SELECT * FROM Supplier";
        List<Supplier> list = new ArrayList<>();
        try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Supplier s = new Supplier();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setAddress(rs.getString("address"));
                s.setPhoneNumber(rs.getString("phoneNumber"));
                s.setEmail(rs.getString("email"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public boolean insertSupplier(Supplier s) {
		String query = "INSERT INTO Supplier(name, address, phoneNumber, email) VALUES(?,?,?,?)";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setString(1, s.getName());
			ps.setString(2, s.getAddress());
			ps.setString(3, s.getPhoneNumber());
			ps.setString(4, s.getEmail());
			return ps.executeUpdate() == 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
