package kr.spring.admin.vo;

import java.sql.Date;

public class NoticeVO {
	private int no_num;
	private int mem_num;
	private String no_title;
	private String no_content;
	private Date no_regdate;	
	private int no_hit;
	private Date noticeDate;
	public int getNo_num() {
		return no_num;
	}
	public void setNo_num(int no_num) {
		this.no_num = no_num;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public String getNo_title() {
		return no_title;
	}
	public void setNo_title(String no_title) {
		this.no_title = no_title;
	}
	public String getNo_content() {
		return no_content;
	}
	public void setNo_content(String no_content) {
		this.no_content = no_content;
	}
	public Date getNo_regdate() {
		return no_regdate;
	}
	public void setNo_regdate(Date no_regdate) {
		this.no_regdate = no_regdate;
	}
	public int getNo_hit() {
		return no_hit;
	}
	public void setNo_hit(int no_hit) {
		this.no_hit = no_hit;
	}
	
	public Date getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}
	@Override
	public String toString() {
		return "NoticeVO [no_num=" + no_num + ", mem_num=" + mem_num + ", no_title=" + no_title + ", no_content="
				+ no_content + ", no_regdate=" + no_regdate + ", no_hit=" + no_hit + ", noticeDate=" + noticeDate + "]";
	}

	
	
	


	
}