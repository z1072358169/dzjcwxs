package zygh.yfb.wxy.vo;

/**
 * 车标表
 * carlogo
 * @author 王喜亚
 *
 */
public class CarLogo {
	
	private int sysId;
	
	//代码
	private String cCode;
	
	//车牌名称
	private String cExplain;

	public int getSysId() {
		return sysId;
	}

	public void setSysId(int sysId) {
		this.sysId = sysId;
	}

	public String getcCode() {
		return cCode;
	}

	public void setcCode(String cCode) {
		this.cCode = cCode;
	}

	public String getcExplain() {
		return cExplain;
	}

	public void setcExplain(String cExplain) {
		this.cExplain = cExplain;
	}

	@Override
	public String toString() {
		return "CarLogo [sysId=" + sysId + ", cCode=" + cCode + ", cExplain="
				+ cExplain + "]";
	}

	
	
}
