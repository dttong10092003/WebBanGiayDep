package entity;

import java.util.Date;

public class Invoice {
	private int id;
	private Account accountID;
	private Date date;
	private double totalPrice;
	private String customerName;
	private String phoneNumber;
	private String address;
	
	public Invoice() {
		
	}
	
	public Invoice(int id, Account accountID, Date date, double totalPrice, String customerName, String phoneNumber,
			String address) {
		super();
		this.id = id;
		this.accountID = accountID;
		this.date = date;
		this.totalPrice = totalPrice;
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Account getAccountID() {
		return accountID;
	}

	public void setAccountID(Account accountID) {
		this.accountID = accountID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", accountID=" + accountID + ", date=" + date + ", totalPrice=" + totalPrice
				+ ", customerName=" + customerName + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}
	
	
	
	
}
