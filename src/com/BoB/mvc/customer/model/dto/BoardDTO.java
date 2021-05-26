package com.BoB.mvc.customer.model.dto;

import java.sql.Date;

public class BoardDTO implements java.io.Serializable {
	
	private int no;
	private String title;
	private String body;
	private String status;
	private int writerUserCode;
	private Date createdDate;
	private String reply;
	private Date replyDate;
	
	public BoardDTO() {

	}

	public BoardDTO(int no, String title, String body, String status, int writerUserCode, Date createdDate,
			String reply, Date replyDate) {
		super();
		this.no = no;
		this.title = title;
		this.body = body;
		this.status = status;
		this.writerUserCode = writerUserCode;
		this.createdDate = createdDate;
	    this.reply = reply;
		this.replyDate = replyDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getWriterUserCode() {
		return writerUserCode;
	}

	public void setWriterUserCode(int writerUserCode) {
		this.writerUserCode = writerUserCode;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	@Override
	public String toString() {
		return "BoardDTO [no=" + no + ", title=" + title + ", body=" + body + ", status=" + status + ", writerUserCode="
				+ writerUserCode + ", createdDate=" + createdDate + ", reply=" + reply + ", replyDate=" + replyDate
				+ "]";
	}
	
	

	
	

}
