package zygh.yfb.wxy.vo;

/**
 * illegal_behavior
 * 违法行为
 * @author 王喜亚
 *
 */
public class IllegalBehavior {
	
	private int sysId;
	
	//违法编码
	private String illegal_number;
	
	//违法行为
	private String illegal_explanation;

	public int getSysId() {
		return sysId;
	}

	public void setSysId(int sysId) {
		this.sysId = sysId;
	}

	public String getIllegal_number() {
		return illegal_number;
	}

	public void setIllegal_number(String illegal_number) {
		this.illegal_number = illegal_number;
	}

	public String getIllegal_explanation() {
		return illegal_explanation;
	}

	public void setIllegal_explanation(String illegal_explanation) {
		this.illegal_explanation = illegal_explanation;
	}

	@Override
	public String toString() {
		return "IllegalBehavior [sysId=" + sysId + ", illegal_number="
				+ illegal_number + ", illegal_explanation="
				+ illegal_explanation + "]";
	}
	
}
