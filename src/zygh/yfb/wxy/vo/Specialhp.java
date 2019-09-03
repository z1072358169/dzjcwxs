package zygh.yfb.wxy.vo;

public class Specialhp {
	
	private Integer id;
	
	private String HPHM;
	
	private int incount;
	
	//过期时间
	private String gqDate;
		
	//备注
	private String remarks;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHPHM() {
		return HPHM;
	}

	public void setHPHM(String hPHM) {
		HPHM = hPHM;
	}

	public int getIncount() {
		return incount;
	}

	public void setIncount(int incount) {
		this.incount = incount;
	}

	public String getGqDate() {
		return gqDate;
	}

	public void setGqDate(String gqDate) {
		this.gqDate = gqDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Specialhp [id=" + id + ", HPHM=" + HPHM + ", incount="
				+ incount + ", gqDate=" + gqDate + ", remarks=" + remarks + "]";
	}

}
