package kr.spring.musinfo.vo;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class CommentsVO {
	private int rev_num;
	private int mem_num;
	private int mus_num;
	@Positive
	private double rev_rate;
	@NotEmpty
	private String review;
	private Date rev_regdate;
	private String hide_rev;
	
	
	//리뷰에 사용할 사용자 닉네임
	private String nickname;
	//리뷰에 사용할 뮤지컬 이름
	private String mus_name;
	
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getMus_name() {
		return mus_name;
	}
	public void setMus_name(String mus_name) {
		this.mus_name = mus_name;
	}
	public int getRev_num() {
		return rev_num;
	}
	public void setRev_num(int rev_num) {
		this.rev_num = rev_num;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public int getMus_num() {
		return mus_num;
	}
	public void setMus_num(int mus_num) {
		this.mus_num = mus_num;
	}
	
	public double getRev_rate() {
		return rev_rate;
	}
	public void setRev_rate(double rev_rate) {
		this.rev_rate = rev_rate;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Date getRev_regdate() {
		return rev_regdate;
	}
	public void setRev_regdate(Date rev_regdate) {
		this.rev_regdate = rev_regdate;
	}
	public String getHide_rev() {
		return hide_rev;
	}
	public void setHide_rev(String hide_rev) {
		this.hide_rev = hide_rev;
	}
	@Override
	public String toString() {
		return "CommentsVO [rev_num=" + rev_num + ", mem_num=" + mem_num + ", mus_num=" + mus_num + ", rev_rate="
				+ rev_rate + ", review=" + review + ", rev_regdate=" + rev_regdate + ", hide_rev=" + hide_rev
				+ ", nickname=" + nickname + ", mus_name=" + mus_name + "]";
	}
	
	
	
	
}
