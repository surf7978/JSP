package co.micol.VO;

public class reviewVO {
	private String rNumber;
	private String rTitle;
	private String rCountent;
	private int rScope;
	
	
	public reviewVO() {
		// TODO Auto-generated constructor stub
	}
	public String getrNumber() {
		return rNumber;
	}
	public void setrNumber(String rNumber) {
		this.rNumber = rNumber;
	}
	public String getrTitle() {
		return rTitle;
	}
	public void setrTitle(String rTitle) {
		this.rTitle = rTitle;
	}
	public String getrCountent() {
		return rCountent;
	}
	public void setrCountent(String rCountent) {
		this.rCountent = rCountent;
	}
	public int getrScope() {
		return rScope;
	}
	public void setrScope(int rScope) {
		this.rScope = rScope;
	}
}
