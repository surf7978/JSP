package co.micol.VO;

public class cartVO {

	private String cartDate;
	private String cartMemberId;
	
	private String boardDate;
	
	private int price;
	private String productName;
	
	private String memberId;
	private String memberSiAddress;
	private String memberGuAddress;
	private String memberPhoneNumber;
	private String tradeProcess;
	
	public cartVO() {
		// TODO Auto-generated constructor stub
	}

	public String getCartDate() {
		return cartDate;
	}

	public void setCartDate(String cartDate) {
		this.cartDate = cartDate;
	}

	public String getCartMemberId() {
		return cartMemberId;
	}

	public void setCartMemberId(String cartMemberId) {
		this.cartMemberId = cartMemberId;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberSiAddress() {
		return memberSiAddress;
	}

	public void setMemberSiAddress(String memberSiAddress) {
		this.memberSiAddress = memberSiAddress;
	}

	public String getMemberGuAddress() {
		return memberGuAddress;
	}

	public void setMemberGuAddress(String memberGuAddress) {
		this.memberGuAddress = memberGuAddress;
	}

	public String getMemberPhoneNumber() {
		return memberPhoneNumber;
	}

	public void setMemberPhoneNumber(String memberPhoneNumber) {
		this.memberPhoneNumber = memberPhoneNumber;
	}

	public String getTradeProcess() {
		return tradeProcess;
	}

	public void setTradeProcess(String tradeProcess) {
		this.tradeProcess = tradeProcess;
	}

	@Override
	public String toString() {
		return "cartVO [cartDate=" + cartDate + ", cartMemberId=" + cartMemberId + ", boardDate=" + boardDate
				+ ", price=" + price + ", productName=" + productName + ", memberId=" + memberId + ", memberSiAddress="
				+ memberSiAddress + ", memberGuAddress=" + memberGuAddress + ", memberPhoneNumber=" + memberPhoneNumber
				+ ", tradeProcess=" + tradeProcess + "]";
	}

}
