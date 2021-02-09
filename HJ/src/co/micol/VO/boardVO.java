package co.micol.VO;

public class boardVO {

	private String boardTitle;
	private String boardContent;
	private String boardDate;
	private int boardView;
	
	private int price;
	private String productName;
	
	private String memberId;
	private String memberSiAddress;
	private String memberGuAddress;
	private String memberPhoneNumber;
	private String productImage;
	private int productVolume;
	private String productColor;
	
	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public int getProductVolume() {
		return productVolume;
	}

	public void setProductVolume(int productVolume) {
		this.productVolume = productVolume;
	}

	public String getProductColor() {
		return productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

	private String tradeProcess;
	
	public boardVO() {
		// TODO Auto-generated constructor stub
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	public int getBoardView() {
		return boardView;
	}

	public void setBoardView(int boardView) {
		this.boardView = boardView;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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
		return "boardVO [boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", boardDate=" + boardDate
				+ ", boardView=" + boardView + ", price=" + price + ", productName=" + productName + ", memberId="
				+ memberId + ", memberSiAddress=" + memberSiAddress + ", memberGuAddress=" + memberGuAddress
				+ ", memberPhoneNumber=" + memberPhoneNumber + ", tradeProcess=" + tradeProcess + "]";
	}




	
}
