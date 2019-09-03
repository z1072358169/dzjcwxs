package zygh.yfb.wxy.vo;

/**
 * 违法数据来源表
 * illega_datasource
 * @author 王喜亚
 *
 */
public class IllegaDatasource {
	
	private int sysId;
	
	//违法数据来源
	private String illegal_D_D;
	
	//说明
	private String iExplain;

	public int getSysId() {
		return sysId;
	}

	public void setSysId(int sysId) {
		this.sysId = sysId;
	}

	public String getIllegal_D_D() {
		return illegal_D_D;
	}

	public void setIllegal_D_D(String illegal_D_D) {
		this.illegal_D_D = illegal_D_D;
	}

	public String getiExplain() {
		return iExplain;
	}

	public void setiExplain(String iExplain) {
		this.iExplain = iExplain;
	}

	@Override
	public String toString() {
		return "IllegaDatasource [sysId=" + sysId + ", illegal_D_D="
				+ illegal_D_D + ", iExplain=" + iExplain + "]";
	}
	
	

}
