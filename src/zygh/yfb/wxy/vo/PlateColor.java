package zygh.yfb.wxy.vo;

/**
 * 号牌颜色表
 * plate_color
 * @author 王喜亚
 *
 */
public class PlateColor {
	
	private int sysId;
	
	//号牌颜色
	private String licensePlateColor;
	
	//说明
	private String pExplain;

	public int getSysId() {
		return sysId;
	}

	public void setSysId(int sysId) {
		this.sysId = sysId;
	}

	public String getLicensePlateColor() {
		return licensePlateColor;
	}

	public void setLicensePlateColor(String licensePlateColor) {
		this.licensePlateColor = licensePlateColor;
	}

	public String getpExplain() {
		return pExplain;
	}

	public void setpExplain(String pExplain) {
		this.pExplain = pExplain;
	}

	@Override
	public String toString() {
		return "PlateColor [sysId=" + sysId + ", licensePlateColor="
				+ licensePlateColor + ", pExplain=" + pExplain + "]";
	}
	
	

}
