package entity;

public class Product {
	private String id;
	private String name;
	private String image;
	private double price;
	private String description;
	private Category categoryID;
	private Brand brandID;
	private Supplier supplierID;
	private int gender;
	
	public Product() {
		super();
	}

	public Product(String id, String name, String image, double price, String description, Category categoryID,
			Brand brandID, Supplier supplierID, int gender) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.description = description;
		this.categoryID = categoryID;
		this.brandID = brandID;
		this.supplierID = supplierID;
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Category categoryID) {
		this.categoryID = categoryID;
	}

	public Brand getBrandID() {
		return brandID;
	}

	public void setBrandID(Brand brandID) {
		this.brandID = brandID;
	}

	public Supplier getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(Supplier supplierID) {
		this.supplierID = supplierID;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", image=" + image + ", price=" + price + ", description="
				+ description + ", categoryID=" + categoryID + ", brandID=" + brandID + ", supplierID=" + supplierID
				+ ", gender=" + gender + "]";
	}
	
	
	
}
