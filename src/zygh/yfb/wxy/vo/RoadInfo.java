package zygh.yfb.wxy.vo;

/**
 * 从燕云接口抓取海康平台的路口id和路口名字的信息
 * @author 王喜亚
 *
 */


public class RoadInfo {

	private String id;
	
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "RoadInfo [id=" + id + ", name=" + name + "]";
	}
	
}
