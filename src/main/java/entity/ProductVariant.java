package entity;

public class ProductVariant {
		private int id;
		private String productID;
		private String color;
		private int size;
		private int quantity;
		private int soldQuantity;
		private String image1;
		private String image2;
		private String image3;
		
		
		public ProductVariant() {
			super();
		}


		public ProductVariant(int id, String productID, String color, int size, int quantity, int soldQuantity,
				String image1, String image2, String image3) {
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
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getProductID() {
			return productID;
		}


		public void setProductID(String productID) {
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


		public String getImage3() {
			return image3;
		}


		public void setImage3(String image3) {
			this.image3 = image3;
		}


		@Override
		public String toString() {
			return "ProductVariant [id=" + id + ", productID=" + productID + ", color=" + color + ", size=" + size
					+ ", quantity=" + quantity + ", soldQuantity=" + soldQuantity + ", image1=" + image1 + ", image2="
					+ image2 + ", image3=" + image3 + "]";
		}
		
		
		
}