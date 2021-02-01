package co.micol.vo;

import java.sql.Date;

public class BookRentalVo {
	private Date rentalDate;
	private String bookCode;
	private String memberId;
	private String returnDate;
	private int rentalNo;
	
	public BookRentalVo() {
		
	}

	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
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

	public int getRentalNo() {
		return rentalNo;
	}

	public void setRentalNo(int rentalNo) {
		this.rentalNo = rentalNo;
	}

	@Override
	public String toString() {
		return "BookRentalVo [rentalDate=" + rentalDate + ", bookCode=" + bookCode + ", memberId=" + memberId
				+ ", returnDate=" + returnDate + ", rentalNo=" + rentalNo + "]";
	}

	
	
	
}
