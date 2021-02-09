package co.micol.VO;

public class memberVO {
	
	private String mId;
	private String mPassword;
	private String mName;
	private String mBirth;
	private String mAuth;
	private String mNumber;
	private String mAccount;
	
	public memberVO() {
		// TODO Auto-generated constructor stub
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmBirth() {
		return mBirth;
	}

	public void setmBirth(String mBirth) {
		this.mBirth = mBirth;
	}

	public String getmAuth() {
		return mAuth;
	}

	public void setmAuth(String mAuth) {
		this.mAuth = mAuth;
	}

	public String getmNumber() {
		return mNumber;
	}

	public void setmNumber(String mNumber) {
		this.mNumber = mNumber;
	}

	public String getmAccount() {
		return mAccount;
	}

	public void setmAccount(String mAccount) {
		this.mAccount = mAccount;
	}

	@Override
	public String toString() {
		return "memberVO [mId=" + mId + ", mPassword=" + mPassword + ", mName=" + mName + ", mBirth=" + mBirth
				+ ", mAuth=" + mAuth + ", mNumber=" + mNumber + ", mAccount=" + mAccount + "]";
	}
	
	

}

