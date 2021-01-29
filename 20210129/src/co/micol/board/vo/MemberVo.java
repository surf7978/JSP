package co.micol.board.vo;

public class MemberVo {
	private String mId;
	private String mName;
	private String mPassword;
	private String mAuth;
	
	public MemberVo() {
		
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}

	public String getmAuth() {
		return mAuth;
	}

	public void setmAuth(String mAuth) {
		this.mAuth = mAuth;
	}

	@Override
	public String toString() {
		return "MemberVo [mId=" + mId + ", mName=" + mName + ", mPassword=" + mPassword + ", mAuth=" + mAuth + "]";
	}
	
	
}