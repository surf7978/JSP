package co.micol.vo;

public class BookRentalVo {
	private String rentalDate;
	private String bookCode;
	private String memberId;
	private String returnDate;
	
	public BookRentalVo() {
		
	}

	public String getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(String rentalDate) {
		this.rentalDate = rentalDate;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "BookRentalVo [rentalDate=" + rentalDate + ", bookCode=" + bookCode + ", memberId=" + memberId
				+ ", returnDate=" + returnDate + "]";
	}
	
}
