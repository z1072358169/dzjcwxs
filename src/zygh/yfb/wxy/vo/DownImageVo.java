package zygh.yfb.wxy.vo;

/**
 * 下载图片的vo
 * @author 王喜亚
 *
 */

public class DownImageVo {

	private Integer sysid;
	
	//号牌号码
	private String HPHM;
	
	//违法代码
	private String WFDM;
	
	//设备编号
	private String SBBH;
	
	//方向编号
	private String FXBH;
	
	//车道编号
	private String CDBH;
	
	//图片地址
	private String URL1;

	public Integer getSysid() {
		return sysid;
	}

	public void setSysid(Integer sysid) {
		this.sysid = sysid;
	}

	public String getHPHM() {
		return HPHM;
	}

	public void setHPHM(String hPHM) {
		HPHM = hPHM;
	}

	public String getWFDM() {
		return WFDM;
	}

	public void setWFDM(String wFDM) {
		WFDM = wFDM;
	}

	public String getSBBH() {
		return SBBH;
	}

	public void setSBBH(String sBBH) {
		SBBH = sBBH;
	}

	public String getFXBH() {
		return FXBH;
	}

	public void setFXBH(String fXBH) {
		FXBH = fXBH;
	}

	public String getCDBH() {
		return CDBH;
	}

	public void setCDBH(String cDBH) {
		CDBH = cDBH;
	}

	public String getURL1() {
		return URL1;
	}

	public void setURL1(String uRL1) {
		URL1 = uRL1;
	}

	@Override
	public String toString() {
		return "DownImageVo [sysid=" + sysid + ", HPHM=" + HPHM + ", WFDM="
				+ WFDM + ", SBBH=" + SBBH + ", FXBH=" + FXBH + ", CDBH=" + CDBH
				+ ", URL1=" + URL1 + "]";
	}
	
}
