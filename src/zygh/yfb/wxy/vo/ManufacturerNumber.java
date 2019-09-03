package zygh.yfb.wxy.vo;

/**
 * 厂商编号表
 * @author 王喜亚
 *
 */
public class ManufacturerNumber {

	private int sysId;
	
	//厂商编号
	private String manufacturerId;
	
	//说明
	private String mExplain;
	
	private String mExplain2;

	public int getSysId() {
		return sysId;
	}

	public void setSysId(int sysId) {
		this.sysId = sysId;
	}

	public String getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(String manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getmExplain() {
		return mExplain;
	}

	public void setmExplain(String mExplain) {
		this.mExplain = mExplain;
	}

	public String getmExplain2() {
		return mExplain2;
	}

	public void setmExplain2(String mExplain2) {
		this.mExplain2 = mExplain2;
	}

	@Override
	public String toString() {
		return "ManufacturerNumber [sysId=" + sysId + ", manufacturerId="
				+ manufacturerId + ", mExplain=" + mExplain + ", mExplain2="
				+ mExplain2 + "]";
	}
	

	
}
