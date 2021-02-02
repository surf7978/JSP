package co.micol.vo;

public class BookVo {
	private String bookCode;
	private String bookName;
	private int quantity;
	private int bCount;
	private int viewCount;
	private int rentalCount;
	private int likeIt;
	private int hateIt;
	
	public BookVo() {
		
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getbCount() {
		return bCount;
	}

	public void setbCount(int bCount) {
		this.bCount = bCount;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getRentalCount() {
		return rentalCount;
	}

	public void setRentalCount(int rentalCount) {
		this.rentalCount = rentalCount;
	}

	public int getLikeIt() {
		return likeIt;
	}

	public void setLikeIt(int likeIt) {
		this.likeIt = likeIt;
	}

	public int getHateIt() {
		return hateIt;
	}

	public void setHateIt(int hateIt) {
		this.hateIt = hateIt;
	}

	@Override
	public String toString() {
		return "BookVo [bookCode=" + bookCode + ", bookName=" + bookName + ", quantity=" + quantity + ", bCount="
				+ bCount + ", viewCount=" + viewCount + ", rentalCount=" + rentalCount + ", likeIt=" + likeIt
				+ ", hateIt=" + hateIt + "]";
	}

	
}
