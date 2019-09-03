package zygh.yfb.wxy.vo;
/**
 * 用户表
 * user
 * @author 王喜亚
 *
 */
public class User {

	private Integer userNum;			//用户编号
	private String userId;				//用户id
	private String userName;			//用户名称
	private String userOA;				//用户OA号码
	private String passWord;            //用户密码
	private String phone;               //联系电话
	private String user_restate;        //接收状态
	private String user_retime;         //接收时间
	private String user_state;        	//完成状态
	private String user_time;        	//完成时间
	private String user_wctime;        	//完成时间
	private String oldpasswd;			//原密码
	private String secId;
	private String secName;
	private String roleName;
	private String userRemarks;
	private String wxOpenId;
	private String wxName;

	public Integer getUserNum() {
		return userNum;
	}

	public void setUserNum(Integer userNum) {
		this.userNum = userNum;
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

	public String getUserOA() {
		return userOA;
	}

	public void setUserOA(String userOA) {
		this.userOA = userOA;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUser_restate() {
		return user_restate;
	}

	public void setUser_restate(String user_restate) {
		this.user_restate = user_restate;
	}

	public String getUser_retime() {
		return user_retime;
	}

	public void setUser_retime(String user_retime) {
		this.user_retime = user_retime;
	}

	public String getUser_state() {
		return user_state;
	}

	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}

	public String getUser_time() {
		return user_time;
	}

	public void setUser_time(String user_time) {
		this.user_time = user_time;
	}

	public String getUser_wctime() {
		return user_wctime;
	}

	public void setUser_wctime(String user_wctime) {
		this.user_wctime = user_wctime;
	}

	public String getOldpasswd() {
		return oldpasswd;
	}

	public void setOldpasswd(String oldpasswd) {
		this.oldpasswd = oldpasswd;
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

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getUserRemarks() {
		return userRemarks;
	}

	public void setUserRemarks(String userRemarks) {
		this.userRemarks = userRemarks;
	}

	public String getWxOpenId() {
		return wxOpenId;
	}

	public void setWxOpenId(String wxOpenId) {
		this.wxOpenId = wxOpenId;
	}

	public String getWxName() {
		return wxName;
	}

	public void setWxName(String wxName) {
		this.wxName = wxName;
	}

	@Override
	public String toString() {
		return "User{" +
				"userNum=" + userNum +
				", userId='" + userId + '\'' +
				", userName='" + userName + '\'' +
				", userOA='" + userOA + '\'' +
				", passWord='" + passWord + '\'' +
				", phone='" + phone + '\'' +
				", user_restate='" + user_restate + '\'' +
				", user_retime='" + user_retime + '\'' +
				", user_state='" + user_state + '\'' +
				", user_time='" + user_time + '\'' +
				", user_wctime='" + user_wctime + '\'' +
				", oldpasswd='" + oldpasswd + '\'' +
				", secId='" + secId + '\'' +
				", secName='" + secName + '\'' +
				", roleName='" + roleName + '\'' +
				", userRemarks='" + userRemarks + '\'' +
				", wxOpenId='" + wxOpenId + '\'' +
				", wxName='" + wxName + '\'' +
				'}';
	}
}
