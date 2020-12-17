package kr.spring.admin.vo;

import java.io.IOException;
import java.sql.Date;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

public class AdminMusicalVO {
	private int mus_num;
	@NotEmpty
	private String mus_name;
	private int gen_num;
	private int mus_age;
	@NotEmpty
	private String mus_actor;
	private int mus_time;
	@NotEmpty
	private String mus_video;
	private int mus_rate;
	private byte[] mus_post;
	private String mus_postname;
	@NotEmpty
	private String mus_summary;
	@NotEmpty
	private String mus_detail;
	private Date mus_regdate;
	private int mus_hit;
	
	public int getMus_num() {
		return mus_num;
	}
	//이미지 업로드 파일 처리
	public void setUpload(MultipartFile upload)throws IOException{
		//MultipartFile - > byte[] 반환
		//마이바티스는 byte 배열로 된 것만 db에 저장을 할 수 있음 그러므로 변환해야함
		setMus_post(upload.getBytes());
		System.out.println("//MultipartFile - > byte[] 반환");
		
		//파일명 구하기(byte배열로 바꾼후에는 파일명을 구할 수 없으므로 미리 파일명을 구해 놓기)
		setMus_postname(upload.getOriginalFilename());
		System.out.println("//파일명 구하기");
	}
	public String getMus_name() {
		return mus_name;
	}
	public void setMus_name(String mus_name) {
		this.mus_name = mus_name;
	}
	public int getGen_num() {
		return gen_num;
	}
	public void setGen_num(int gen_num) {
		this.gen_num = gen_num;
	}
	public int getMus_age() {
		return mus_age;
	}
	public void setMus_age(int mus_age) {
		this.mus_age = mus_age;
	}
	public String getMus_actor() {
		return mus_actor;
	}
	public void setMus_actor(String mus_actor2) {
		this.mus_actor = mus_actor2;
	}
	public int getMus_time() {
		return mus_time;
	}
	public void setMus_time(int mus_time) {
		this.mus_time = mus_time;
	}
	public String getMus_video() {
		return mus_video;
	}
	public void setMus_video(String mus_video) {
		this.mus_video = mus_video;
	}
	public int getMus_rate() {
		return mus_rate;
	}
	public void setMus_rate(int mus_rate) {
		this.mus_rate = mus_rate;
	}
	public byte[] getMus_post() {
		return mus_post;
	}
	public void setMus_post(byte[] mus_post) {
		this.mus_post = mus_post;
	}
	public String getMus_postname() {
		return mus_postname;
	}
	public void setMus_postname(String mus_postname) {
		this.mus_postname = mus_postname;
	}
	public String getMus_summary() {
		return mus_summary;
	}
	public void setMus_summary(String mus_summary) {
		this.mus_summary = mus_summary;
	}
	public String getMus_detail() {
		return mus_detail;
	}
	public void setMus_detail(String mus_detail) {
		this.mus_detail = mus_detail;
	}
	public Date getMus_regdate() {
		return mus_regdate;
	}
	public void setMus_regdate(Date mus_regdate) {
		this.mus_regdate = mus_regdate;
	}
	public void setMus_num(int mus_num) {
		this.mus_num = mus_num;
	}
	@Override
	public String toString() {
		return "AdminMusicalVO [mus_num=" + mus_num + ", mus_name=" + mus_name + ", gen_num=" + gen_num + ", mus_age="
				+ mus_age + ", mus_actor=" + mus_actor + ", mus_time=" + mus_time + ", mus_video=" + mus_video
				+ ", mus_rate=" + mus_rate + ", mus_postname=" + mus_postname + ", mus_summary=" + mus_summary
				+ ", mus_detail=" + mus_detail + ", mus_regdate=" + mus_regdate + "]";
	}
	public int getMus_hit() {
		return mus_hit;
	}
	public void setMus_hit(int mus_hit) {
		this.mus_hit = mus_hit;
	}
}
