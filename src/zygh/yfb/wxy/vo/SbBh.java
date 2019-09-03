package zygh.yfb.wxy.vo;

/**
 * 设备编号
 * @author 王喜亚
 *
 */
public class SbBh {

	private Integer sysid;
	//科达设备编号
	private String kdsbbh;
	//道路名字
	private String roadname;
	//海信设备编号
	private String hxsbbh;
	//设备所在区域
	private String area;
	
	public Integer getSysid() {
		return sysid;
	}
	public void setSysid(Integer sysid) {
		this.sysid = sysid;
	}
	public String getKdsbbh() {
		return kdsbbh;
	}
	public void setKdsbbh(String kdsbbh) {
		this.kdsbbh = kdsbbh;
	}
	public String getRoadname() {
		return roadname;
	}
	public void setRoadname(String roadname) {
		this.roadname = roadname;
	}
	public String getHxsbbh() {
		return hxsbbh;
	}
	public void setHxsbbh(String hxsbbh) {
		this.hxsbbh = hxsbbh;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "SbBh [sysid=" + sysid + ", kdsbbh=" + kdsbbh + ", roadname="
				+ roadname + ", hxsbbh=" + hxsbbh + ", area=" + area + "]";
	}
	
	
}
