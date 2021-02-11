package co.micol.VO;

public class productVO {
	
	private String productName;
	private String productImage;
	private String category1;
	private String category2;
	
	public productVO() {
		// TODO Auto-generated constructor stub
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getCategory1() {
		return category1;
	}

	public void setCategory1(String category1) {
		this.category1 = category1;
	}

	public String getCategory2() {
		return category1;
	}

	public void setCategory2(String category1) {
		this.category1 = category1;
	}

	@Override
	public String toString() {
		return "productVO [productName=" + productName + ", productImage=" + productImage + ", category1=" + category1
				+ ", category2=" + category2 + "]";
	}

}
