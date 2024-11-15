package entity;

public class ProductVariant {
		private int id;
		private Product productID;
		private String color;
		private int size;
		private int quantity;
		private int soldQuantity;
		private String image1;
		private String image2;
		private String image3;
		private String image4;
		
		public ProductVariant() {

		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Product getProductID() {
			return productID;
		}

		public void setProductID(Product productID) {
			this.productID = productID;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public int getSoldQuantity() {
			return soldQuantity;
		}

		public void setSoldQuantity(int soldQuantity) {
			this.soldQuantity = soldQuantity;
		}

		public String getImage1() {
			return image1;
		}

		public void setImage1(String image1) {
			this.image1 = image1;
		}

		public String getImage2() {
			return image2;
		}

		public void setImage2(String image2) {
			this.image2 = image2;
		}

		@Override
		public String toString() {
			return "ProductVariant [id=" + id + ", productID=" + productID + ", color=" + color + ", size=" + size
					+ ", quantity=" + quantity + ", soldQuantity=" + soldQuantity + ", image1=" + image1 + ", image2="
					+ image2 + ", image3=" + image3 + ", image4=" + image4 + "]";
		}

		public ProductVariant(int id, Product productID, String color, int size, int quantity, int soldQuantity,
				String image1, String image2, String image3, String image4) {
			super();
			this.id = id;
			this.productID = productID;
			this.color = color;
			this.size = size;
			this.quantity = quantity;
			this.soldQuantity = soldQuantity;
			this.image1 = image1;
			this.image2 = image2;
			this.image3 = image3;
			this.image4 = image4;
		}

		public String getImage3() {
			return image3;
		}

		public void setImage3(String image3) {
			this.image3 = image3;
		}

		public String getImage4() {
			return image4;
		}

		public void setImage4(String image4) {
			this.image4 = image4;
		}
		
		
		
		
}