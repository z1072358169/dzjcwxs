package zygh.yfb.wxy.vo;
/**
 * 部门表
 * sectors
 * @author 王喜亚
 *
 */
public class Sectors {

	private Integer sectorsNum;			//部门编号
	private String secId;				//部门id
	private String secName;				//部门名字
	private String userId;				//用户id
	private String userName;			//用户名称
	private String secRemarks;			//部门备注ע
	public Integer getSectorsNum() {
		return sectorsNum;
	}
	public void setSectorsNum(Integer sectorsNum) {
		this.sectorsNum = sectorsNum;
	}
	public String getSecId() {
		return secId;
	}
	public void setSecId(String secId) {
		this.secId = secId;
	}
	public String getSecName() {
		return secName;
	}
	public void setSecName(String secName) {
		this.secName = secName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSecRemarks() {
		return secRemarks;
	}
	public void setSecRemarks(String secRemarks) {
		this.secRemarks = secRemarks;
	}
	@Override
	public String toString() {
		return "Sectors [sectorsNum=" + sectorsNum + ", secId=" + secId
				+ ", secName=" + secName + ", userId=" + userId + ", userName="
				+ userName + ", secRemarks=" + secRemarks + "]";
	}
	
	
	
	
}
