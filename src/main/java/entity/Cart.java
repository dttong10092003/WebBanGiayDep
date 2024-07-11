package entity;

public class Cart {
	private int id;
	private Account account;
	private ProductVariant productVariant;
	private int amount;
	
	public Cart() {
		
	}
	
	
	public Cart(int id, Account account, ProductVariant productVariant, int amount) {
		super();
		this.id = id;
		this.account = account;
		this.productVariant = productVariant;
		this.amount = amount;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	public ProductVariant getProductVariant() {
		return productVariant;
	}


	public void setProductVariant(ProductVariant productVariant) {
		this.productVariant = productVariant;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "Cart [id=" + id + ", account=" + account + ", productVariant=" + productVariant + ", amount=" + amount
				+ "]";
	}
	
	
	
	
	
	
}