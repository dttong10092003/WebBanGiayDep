package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import connect.DBConnect;

public class InvoiceDAO {
	// Để lấy ra id của Invoice do sử dụng identity cho id
	public int insertInvoice(int accountID, String customerName, String phoneNumber, String address, double totalPrice,
			Date date) {
		String query = "INSERT INTO Invoice(accountID, date, customerName, phoneNumber, address, totalPrice) VALUES(?,?,?,?,?,?)";
		int invoiceID = -1;
		try (Connection conn = new DBConnect().getConnection();
				PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);) {
			ps.setInt(1, accountID);
			ps.setDate(2, new java.sql.Date(date.getTime()));
			ps.setString(3, customerName);
			ps.setString(4, phoneNumber);
			ps.setString(5, address);
			ps.setDouble(6, totalPrice);
			int rows = ps.executeUpdate();

			if (rows > 0) {
				try (ResultSet rs = ps.getGeneratedKeys()) {
					if (rs.next()) {
						invoiceID = rs.getInt(1);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return invoiceID;
	}

	public boolean updateTotalPrice(int invoiceID, double totalPrice) {
		String query = "UPDATE Invoice SET totalPrice = ? WHERE id = ?";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setDouble(1, totalPrice);
			ps.setInt(2, invoiceID);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean insertInvoiceDetail(int invoiceID, int productVariantID, int amount, double totalPrice) {
		String query = "INSERT INTO InvoiceDetail(invoiceID, productVariantID, amount, totalPrice) VALUES(?,?,?,?)";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setInt(1, invoiceID);
			ps.setInt(2, productVariantID);
			ps.setInt(3, amount);
			ps.setDouble(4, totalPrice);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
