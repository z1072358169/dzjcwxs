package zygh.yfb.wxy.vo;

/**
 * 车身颜色表
 * car_body_c
 * @author 王喜亚
 *
 */
public class CarBodyC {
	
	private int sysId;
	
	//代码
	private String cCode;
	
	//说明
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
		return "CarBodyC [sysId=" + sysId + ", cCode=" + cCode + ", cExplain="
				+ cExplain + "]";
	}
	
	

}
