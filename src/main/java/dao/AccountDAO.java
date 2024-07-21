package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import connect.DBConnect;
import entity.Account;

public class AccountDAO {

	public Account getAccount(String username, String password) {
		String query = "select * from Account where username = ? and password = ?";
		Account account = null;
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				account = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getBoolean(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}

	public Account getAccountByID(int id) {
		String sql = "Select * from Account where uID = ?";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Account(rs.getInt("uID"), rs.getString("username"), rs.getString("password"),
						rs.getString("email"), rs.getBoolean("isAdmin"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insertAccount(String username, String password, String email, boolean isAdmin) {
		String sql = "Insert into Account(username, password, email, isAdmin) values(?,?,?,?)";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setBoolean(4, isAdmin);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkUsername(String username) {
		String sql = "Select * from Account where username = ?";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Account getAccountByUsernameAndEmail(String username, String email) {
		String sql = "Select * from Account where username = ? and email = ?";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, username);
			ps.setString(2, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Account(rs.getInt("uID"), rs.getString("username"), rs.getString("password"),
						rs.getString("email"), rs.getBoolean("isAdmin"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void sendEmail(String email, String subject, String content) {
		final String username = "sfshop153@gmail.com";
		final String password = "dpnktbjuopndvsqf";

		Properties prop = new Properties();

		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");

		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject(subject);
			message.setText(content);

			Transport.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean editAccount(String password, String email, int id) {
		String sql = "Update Account set password = ?, email = ? where uID = ?";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, password);
			ps.setString(2, email);
			ps.setInt(3, id);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkPassword(String password, int id) {
		String sql = "Select * from Account where uID = ? and password = ?";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean getIsAdmin(int id) {
		String sql = "Select isAdmin from Account where uID = ?";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getBoolean("isAdmin");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Account> getAllAccount() {
		String sql = "Select * from Account";
		List<Account> list = new ArrayList<>();
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Account(rs.getInt("uID"), rs.getString("username"), rs.getString("password"),
						rs.getString("email"), rs.getBoolean("isAdmin")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
