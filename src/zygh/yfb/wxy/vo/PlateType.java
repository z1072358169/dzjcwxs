package zygh.yfb.wxy.vo;

/**
 * plate_type
 * 号牌种类
 * @author 王喜亚
 *
 */
public class PlateType extends DataSource {
	
	private int sysId;
	
	//号牌种类
	private String licensePlateType;
	
	//说明
	private String pExplain;
	
	public int getSysId() {
		return sysId;
	}

	public void setSysId(int sysId) {
		this.sysId = sysId;
	}

	public String getLicensePlateType() {
		return licensePlateType;
	}

	public void setLicensePlateType(String licensePlateType) {
		this.licensePlateType = licensePlateType;
	}

	public String getpExplain() {
		return pExplain;
	}

	public void setpExplain(String pExplain) {
		this.pExplain = pExplain;
	}

	@Override
	public String toString() {
		return "PlateType [sysId=" + sysId + ", licensePlateType="
				+ licensePlateType + ", pExplain=" + pExplain + "]";
	}

	
	
}
