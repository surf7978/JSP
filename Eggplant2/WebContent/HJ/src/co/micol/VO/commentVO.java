package co.micol.VO;

public class commentVO {

	private String commentContent;
	private String commentDate;
	private String boardDate;
	
	private String memberId;
	
	public commentVO() {
		// TODO Auto-generated constructor stub
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "commentVO [commentContent=" + commentContent + ", commentDate=" + commentDate + ", boardDate="
				+ boardDate + ", memberId=" + memberId + "]";
	}


	
}
