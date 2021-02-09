package co.micol.VO;

public class sellVO {

	private String buyMemberId;
	private String buyDate;
	private int price;
	private String tradeProcess;
	private String memberId;
	private String productName;
	
	public sellVO() {
		// TODO Auto-generated constructor stub
	}

	public String getBuyMemberId() {
		return buyMemberId;
	}

	public void setBuyMemberId(String buyMemberId) {
		this.buyMemberId = buyMemberId;
	}

	public String getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTradeProcess() {
		return tradeProcess;
	}

	public void setTradeProcess(String tradeProcess) {
		this.tradeProcess = tradeProcess;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "sellVO [buyMemberId=" + buyMemberId + ", buyDate=" + buyDate + ", price=" + price + ", tradeProcess="
				+ tradeProcess + ", memberId=" + memberId + ", productName=" + productName + "]";
	}



	
}
