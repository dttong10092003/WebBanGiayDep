package entity;

public class InvoiceDetails {
	private int id;
	private ProductVariant productVariantID;
	private int amount;
	private double totalPrice;
	private Invoice invoiceID;
	
	public InvoiceDetails() {

	}
	
	public InvoiceDetails(int id, ProductVariant productVariantID, int amount, double totalPrice, Invoice invoiceID) {
		super();
		this.id = id;
		this.productVariantID = productVariantID;
		this.amount = amount;
		this.totalPrice = totalPrice;
		this.invoiceID = invoiceID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProductVariant getProductVariantID() {
		return productVariantID;
	}

	public void setProductVariantID(ProductVariant productVariantID) {
		this.productVariantID = productVariantID;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Invoice getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(Invoice invoiceID) {
		this.invoiceID = invoiceID;
	}

	@Override
	public String toString() {
		return "InvoiceDetails [id=" + id + ", productVariantID=" + productVariantID + ", amount=" + amount
				+ ", totalPrice=" + totalPrice + ", invoiceID=" + invoiceID + "]";
	}
	
	
}
