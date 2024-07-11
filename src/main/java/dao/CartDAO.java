package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.DBConnect;
import entity.Cart;

public class CartDAO {
	public Cart checkCartExisted(int accountID, int productVariantID) {
		ProductDAO productDAO = new ProductDAO();
		AccountDAO accountDAO = new AccountDAO();
		String query = "SELECT * FROM Cart WHERE accountID = ? AND productVariantID = ?";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setInt(1, accountID);
			ps.setInt(2, productVariantID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Cart c = new Cart();
				c.setId(rs.getInt("id"));
				c.setAmount(rs.getInt("amount"));
				c.setProductVariant(productDAO.getProductVariantById(rs.getInt("accountID")));
				c.setProductVariant(productDAO.getProductVariantById(rs.getInt("productVariantID")));
				c.setAccount(accountDAO.getAccountByID(rs.getInt("accountID")));
				return c;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Cart> getCartByAccountID(int accountID) {
		ProductDAO productDAO = new ProductDAO();
		AccountDAO accountDAO = new AccountDAO();
		List<Cart> list = new ArrayList<>();
		String query = "SELECT * FROM Cart WHERE accountID = ?";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setInt(1, accountID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cart c = new Cart();
				c.setId(rs.getInt("id"));
				c.setAmount(rs.getInt("amount"));
				c.setProductVariant(productDAO.getProductVariantById(rs.getInt("productVariantID")));
				c.setAccount(accountDAO.getAccountByID(rs.getInt("accountID")));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean updateAmountCart(int id, int amount) {
		String query = "UPDATE Cart SET amount = ? WHERE id = ?";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setInt(1, amount);
			ps.setInt(2, id);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean insertCart(int accountID, int productVariantID, int amount) {
		String query = "INSERT INTO Cart(accountID, productVariantID, amount) VALUES(?, ?, ?)";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
			ps.setInt(1, accountID);
			ps.setInt(2, productVariantID);
			ps.setInt(3, amount);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public double getTotalPriceCartByAccountID(int accountID) {
        String query = "  SELECT SUM(p.price * c.amount) AS totalPrice FROM Cart c JOIN ProductVariant pv ON c.productVariantID = pv.id JOIN Product p ON pv.productID = p.id WHERE c.accountID = ?";
        try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setInt(1, accountID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("totalPrice");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
