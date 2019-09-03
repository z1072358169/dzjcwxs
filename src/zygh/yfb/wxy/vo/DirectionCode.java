package zygh.yfb.wxy.vo;

/**
 * 方向编码表
 * direction_code
 * @author 王喜亚
 *
 */
public class DirectionCode {
	
	private int sysId;
	
	//方向编号
	private String directionNum;
	
	//说明
	private String dExplain;

	public int getSysId() {
		return sysId;
	}

	public void setSysId(int sysId) {
		this.sysId = sysId;
	}

	public String getDirectionNum() {
		return directionNum;
	}

	public void setDirectionNum(String directionNum) {
		this.directionNum = directionNum;
	}

	public String getdExplain() {
		return dExplain;
	}

	public void setdExplain(String dExplain) {
		this.dExplain = dExplain;
	}

	@Override
	public String toString() {
		return "DirectionCode [sysId=" + sysId + ", directionNum="
				+ directionNum + ", dExplain=" + dExplain + "]";
	}
	
	

}
