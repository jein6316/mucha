package kr.spring.member.vo;

import java.io.IOException;
import java.sql.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class MemberVO {

	private int mem_num;
	private String email;
	private int auth;
	@NotEmpty
	private String nickname;
	@Size(min=4,max=10)
	private String password;
	private Date birth;
	@NotEmpty
	private String phone;
	private Date mem_regdate;
	private Date mem_modifydate;
	private Date purchase_date;
	private Date expire_date;
	private byte[] mem_image;
	private String mem_imagename;
	private int prefer;
	//뮤지컬 삭제폼에서 사용할 mus_num
	private int mus_num; 

	//비밀번호 변경시 현재 비밀번호를 저장하는 용도로 사용
	@Size(min=4,max=10)
	private String now_password;

	//비밀번호 일치 여부 체크
	public boolean isCheckedPassword(String userPassword) {
		if(auth <3 && password.equals(userPassword)) {
			return true;
		}
		return false;
	}


	/*
	//비밀번호 일치 여부 체크 -- 비밀번호 암호화 
	//import kr.spring.util.SecurityUtil; memberVO의 isCheckedPassword; controller의 password암호화 ___
		public boolean isCheckedPassword(String userPassword) {
			SecurityUtil securityUtil = new SecurityUtil();
			
			String sDbPassword = securityUtil.encryptSHA256(password);
			
			if(auth <3 && sDbPassword.equals(userPassword)) {
				return true;
			}
			return false;
		}*/
	
	//이미지 BLOB 처리
	public void setUpload(MultipartFile upload) throws IOException{
		//MultipartFile -> byte[]
		setMem_image(upload.getBytes());
		//파일 이름
		setMem_imagename(upload.getOriginalFilename());
	}	

	//Getter, Setter
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAuth() {
		return auth;
	}
	public void setAuth(int auth) {
		this.auth = auth;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getMem_regdate() {
		return mem_regdate;
	}
	public void setMem_regdate(Date mem_regdate) {
		this.mem_regdate = mem_regdate;
	}
	public Date getMem_modifydate() {
		return mem_modifydate;
	}
	public void setMem_modifydate(Date mem_modifydate) {
		this.mem_modifydate = mem_modifydate;
	}
	public Date getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}
	public Date getExpire_date() {
		return expire_date;
	}
	public void setExpire_date(Date expire_date) {
		this.expire_date = expire_date;
	}
	public byte[] getMem_image() {
		return mem_image;
	}
	public void setMem_image(byte[] mem_image) {
		this.mem_image = mem_image;
	}
	public String getMem_imagename() {
		return mem_imagename;
	}
	public void setMem_imagename(String mem_imagename) {
		this.mem_imagename = mem_imagename;
	}

	public String getNow_password() {
		return now_password;
	}

	public void setNow_password(String now_password) {
		this.now_password = now_password;
	}

	public int getMus_num() {
		return mus_num;
	}

	public void setMus_num(int mus_num) {
		this.mus_num = mus_num;
	}

	
	public int getPrefer() {
		return prefer;
	}

	public void setPrefer(int prefer) {
		this.prefer = prefer;
	}

	
	//toString
	@Override
	public String toString() {
		return "MemberVO [mem_num=" + mem_num + ", email=" + email + ", auth=" + auth + ", nickname=" + nickname
				+ ", password=" + password + ", birth=" + birth + ", phone=" + phone + ", mem_regdate=" + mem_regdate
				+ ", mem_modifydate=" + mem_modifydate + ", purchase_date=" + purchase_date + ", expire_date="
				+ expire_date + ", mem_imagename=" + mem_imagename + ", prefer=" + prefer + ", mus_num=" + mus_num
				+ ", now_password=" + now_password + "]";
	}


}
