package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connect.DBConnect;
import entity.Account;

public class AccountDAO {
	
	public Account getAccount(String username, String password) {
		String query = "select * from Account where username = ? and password = ?";
		Account account = null;
		try (Connection conn = new DBConnect().getConnection();
                PreparedStatement ps = conn.prepareStatement(query)){
			
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				account = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}
}
