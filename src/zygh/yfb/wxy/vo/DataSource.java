package zygh.yfb.wxy.vo;

/**
 * data_source
 * 数据来源表
 * @author 王喜亚
 *
 */
public class DataSource {
	
	private int sysId;
	
	//数据来源
	private String dataSources;
	
	//说明
	private String dExplain;

	public int getSysId() {
		return sysId;
	}

	public void setSysId(int sysId) {
		this.sysId = sysId;
	}

	public String getDataSources() {
		return dataSources;
	}

	public void setDataSources(String dataSources) {
		this.dataSources = dataSources;
	}

	public String getdExplain() {
		return dExplain;
	}

	public void setdExplain(String dExplain) {
		this.dExplain = dExplain;
	}

	@Override
	public String toString() {
		return "DataSource [sysId=" + sysId + ", dataSources=" + dataSources
				+ ", dExplain=" + dExplain + "]";
	}
	
	
	
}
