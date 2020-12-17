package kr.spring.musinfo.vo;

//import javax.validation.constraints.NotEmpty;

public class PickVO {
	private int pick_num;
	private int mem_num;
	private int mus_num;
	

	public int getPick_num() {
		return pick_num;
	}
	public void setPick_num(int pick_num) {
		this.pick_num = pick_num;
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
	@Override
	public String toString() {
		return "PickVO [pick_num=" + pick_num + ", mem_num=" + mem_num + ", mus_num=" + mus_num + "]";
	}
		
}
