package co.micol.VO;


public class noticeVO {
	private int nNumber;
	private String nTitle;
	private String nContent;
	private String nWriter;
	private String memberId;
	private String nDate; 
	
	public noticeVO() {
		// TODO Auto-generated constructor stub
	}

	public int getnNumber() {
		return nNumber;
	}

	public void setnNumber(int nNumber) {
		this.nNumber = nNumber;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public String getnWriter() {
		return nWriter;
	}

	public void setnWriter(String nWriter) {
		this.nWriter = nWriter;
	}

	public String getnDate() {
		return nDate;
	}

	public void setnDate(String nDate) {
		this.nDate = nDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "noticeVO [nNumber=" + nNumber + ", nTitle=" + nTitle + ", nContent=" + nContent + ", nWriter=" + nWriter
				+ ", memberId=" + memberId + ", nDate=" + nDate + "]";
	}

}
