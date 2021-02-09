package co.micol.VO;

public class memberVO {
	
	private String memberId;
	private String memberPassword;
	private String memberName;
	private String memberAuth;
	private String memberSiAddress;
	private String memberGuAddress;
	private String memberPhoneNumber;
	
	public memberVO() {
		
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberAuth() {
		return memberAuth;
	}

	public void setMemberAuth(String memberAuth) {
		this.memberAuth = memberAuth;
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

	@Override
	public String toString() {
		return "memberVO [memberId=" + memberId + ", memberPassword=" + memberPassword + ", memberName=" + memberName
				+ ", memberAuth=" + memberAuth + ", memberSiAddress=" + memberSiAddress + ", memberGuAddress="
				+ memberGuAddress + ", memberPhoneNumber=" + memberPhoneNumber + "]";
	}

}

