package zygh.yfb.wxy.vo;

public class ScreenTotel {

	//新增筛选日期
	private String screenDate;
	//所有：通过和作废的
	private long allTotal = 0;
	//通过
	private long pass = 0;
	//作废
	private long tovoid = 0;
	//正在筛选
	private long screening = 0;
	//所有人已经提取还没筛选的
	private long allwsx = 0;
	//民警筛选人
	private String mjuserName;
	//筛选人信息
	private String userId;
	private String userName;
	private String secId;
	private String secName;

	//数据状态  1：未画模板的路口数据
	private int SJZT;

	public int getSJZT() {
		return SJZT;
	}
	public void setSJZT(int SJZT) {
		this.SJZT = SJZT;
	}
	
	
	public long getAllwsx() {
		return allwsx;
	}
	public void setAllwsx(long allwsx) {
		this.allwsx = allwsx;
	}
	public String getScreenDate() {
		return screenDate;
	}
	public void setScreenDate(String screenDate) {
		this.screenDate = screenDate;
	}
	public long getAllTotal() {
		return allTotal;
	}
	public void setAllTotal(long allTotal) {
		this.allTotal = allTotal;
	}
	public long getPass() {
		return pass;
	}
	public void setPass(long pass) {
		this.pass = pass;
	}
	public long getTovoid() {
		return tovoid;
	}
	public void setTovoid(long tovoid) {
		this.tovoid = tovoid;
	}
	public long getScreening() {
		return screening;
	}
	public void setScreening(long screening) {
		this.screening = screening;
	}
	public String getMjuserName() {
		return mjuserName;
	}
	public void setMjuserName(String mjuserName) {
		this.mjuserName = mjuserName;
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
	
	@Override
	public String toString() {
		return "ScreenTotel [screenDate=" + screenDate + ", allTotal="
				+ allTotal + ", pass=" + pass + ", tovoid=" + tovoid
				+ ", screening=" + screening + ", allwsx=" + allwsx
				+ ", mjuserName=" + mjuserName + ", userId=" + userId
				+ ", userName=" + userName + ", secId=" + secId + ", secName="
				+ secName + "]";
	}
}
