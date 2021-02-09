package co.micol.VO;

public class noteVO {
	private String tId;
	private String nTItle;
	private String nContent;
	private String fId;
	
	public noteVO() {
		// TODO Auto-generated constructor stub
	}

	public String gettId() {
		return tId;
	}

	public void settId(String tId) {
		this.tId = tId;
	}

	public String getnTItle() {
		return nTItle;
	}

	public void setnTItle(String nTItle) {
		this.nTItle = nTItle;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public String getfId() {
		return fId;
	}

	public void setfId(String fId) {
		this.fId = fId;
	}
}
