package zygh.yfb.wxy.vo;

/**
 * djwf
 * 电子警察违法抓拍
 * @author 王喜亚
 *
 */

public class IntervalVM {

//	private int sysId;
	private int sysid;
	
	private String jyid;
	//接口类型
//	private String interfaceType;
	private String JKLX;
	//接口版本
//	private String interfaceVersion;
	private String JKBB;
	//厂商ID 
//	private String manufacturerId;
	private String CSID;
	//UUID
	private String MSGID;
	//违法数据来源
//	private String illegal_D_D;
	private String WFSJLY;
	//号牌种类
//	private String licensePlateType;
	private String HPZL;
	//号牌号码
//	private String licensePlateNum;
	private String HPHM;
	//违法代码
//	private String illegalCode;
	private String WFDM;
	//采集机关代码
//	private String collectionUnitCode;
	private String CJJGDM;
	//数据来源
//	private String dataSources;
	private String SJLY;
	//抓拍类型
//	private String snapType;
	private String ZPLX;
	//起点采集时间
//	private String start_C_T;
	//采集点编号
//	private String start_C_T_N;
	private String CJDBH;
	//采集地址
//	private String collectionAddress;
	private String CJDZ;
	//区间名称
//	private String intervalName;
	//区间距离
//	private String intervalDistance;
	//区间编号
//	private String intervalNum;
	//方向编号
//	private String directionNum;
	private String FXBH;
	//车道编号
//	private String vehicleLaneNum;
	private String CDBH;
	//终点采集时间
//	private String end_C_T;
	//终止采集点编号
//	private String end_C_T_N;
	//车辆速度
//	private String vehicleSpeed;
	//大车限速
//	private String bigCarMaxSpeed;
	//卡车限速
//	private String truckMaxSpeed;
	//小车限速
//	private String carMaxSpeed;
	//大车执法限速
//	private String bigCarMaxSpeed_l_e;
	//卡车执法限速
//	private String truckMaxSpeed_l_e;
	//小车执法限速
//	private String carMaxSpeed_l_e;
	//最低限速
//	private String min_speed;
	//起点证据图片1
//	private String start_e_p;
	private String URL1;
	//终点证据图片2
//	private String end_e_p;
	private String URL2;
	//证据合成图片3
//	private String evidence_S_P;
	private String URL3;
	//号牌特征图片信息
//	private String licensePlate_F_P_I;
	private String HPTZTP;
	//号牌颜色
//	private String licensePlateColor;
	private String HPYS;
	//数据上传时间
//	private String data_S_U_T;
	private String SJSCSJ;
	//是否上传     0-未上传，1-已上传
//	private String toUpload;
	//是否已审核    0-未审核 未上传，1-通过 已上传，2-作废
	//新改  是否已审核    -1未审核 未上传，0-通过 已上传，1-作废
//	private String toExamine;
	private String SFSH;
	//民警上传状态：2:通过，3:作废。默认1
	private int MJSCZT;
	
	//开始时间
	private String startTime;
	//结束时间
	private String endTime;
	//当前ID
	private int nowId;
	//当前时间
	private int nowTime;
	//地址总数
	private int addcount;
	//新增设备编号
	private String SBBH;
	//新增红灯亮起时间
	private String HDLQSJ;
	//新增红灯持续时间
	private String HDCXSJ;
	//新增证据视频
	private String ZJSP;
	//新增辅助证据视频或图片
	private String FZZJSPTP;
	//新增采集时间
	private String CJSJ;
	
	//新增郑州区
	//设备所在区域
	private String area;
	//新增筛选日期
	private String screenDate;
	//民警筛选日期
	private String screenDatemj;
	
	//所有：通过和作废的
	private long allTotal;
	//通过
	private long pass;
	//作废
	private long tovoid;
	
	//筛选人信息
	private String userId;
	private String userName;
	private String secId;
	private String secName;
	
	//民警筛选人
	private String mjuserName;
	
	//违法代码的中文，看看能不能出来
	private String illegal_explanation;
	
	//摄像头厂商名字
	private String CSMZ;

	//数据状态  1：未画模板的路口数据
	private int SJZT;

	public int getSJZT() {
		return SJZT;
	}
	public void setSJZT(int SJZT) {
		this.SJZT = SJZT;
	}
	public String getMjuserName() {
		return mjuserName;
	}
	public String getJyid() {
		return jyid;
	}
	public void setJyid(String jyid) {
		this.jyid = jyid;
	}
	public void setMjuserName(String mjuserName) {
		this.mjuserName = mjuserName;
	}
	public int getMJSCZT() {
		return MJSCZT;
	}
	public void setMJSCZT(int mJSCZT) {
		MJSCZT = mJSCZT;
	}
	
	public String getScreenDatemj() {
		return screenDatemj;
	}
	public void setScreenDatemj(String screenDatemj) {
		this.screenDatemj = screenDatemj;
	}
	public String getIllegal_explanation() {
		return illegal_explanation;
	}
	public String getCSMZ() {
		return CSMZ;
	}
	public void setCSMZ(String cSMZ) {
		CSMZ = cSMZ;
	}
	public void setIllegal_explanation(String illegal_explanation) {
		this.illegal_explanation = illegal_explanation;
	}
	
	public int getSysid() {
		return sysid;
	}
	public void setSysid(int sysid) {
		this.sysid = sysid;
	}
	public String getJKLX() {
		return JKLX;
	}
	public void setJKLX(String jKLX) {
		JKLX = jKLX;
	}
	public String getJKBB() {
		return JKBB;
	}
	public void setJKBB(String jKBB) {
		JKBB = jKBB;
	}
	public String getCSID() {
		return CSID;
	}
	public void setCSID(String cSID) {
		CSID = cSID;
	}
	public String getMSGID() {
		return MSGID;
	}
	public void setMSGID(String mSGID) {
		MSGID = mSGID;
	}
	public String getWFSJLY() {
		return WFSJLY;
	}
	public void setWFSJLY(String wFSJLY) {
		WFSJLY = wFSJLY;
	}
	public String getHPZL() {
		return HPZL;
	}
	public void setHPZL(String hPZL) {
		HPZL = hPZL;
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
	public String getCJJGDM() {
		return CJJGDM;
	}
	public void setCJJGDM(String cJJGDM) {
		CJJGDM = cJJGDM;
	}
	public String getSJLY() {
		return SJLY;
	}
	public void setSJLY(String sJLY) {
		SJLY = sJLY;
	}
	public String getZPLX() {
		return ZPLX;
	}
	public void setZPLX(String zPLX) {
		ZPLX = zPLX;
	}
	public String getCJDBH() {
		return CJDBH;
	}
	public void setCJDBH(String cJDBH) {
		CJDBH = cJDBH;
	}
	public String getCJDZ() {
		return CJDZ;
	}
	public void setCJDZ(String cJDZ) {
		CJDZ = cJDZ;
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
	public String getURL2() {
		return URL2;
	}
	public void setURL2(String uRL2) {
		URL2 = uRL2;
	}
	public String getURL3() {
		return URL3;
	}
	public void setURL3(String uRL3) {
		URL3 = uRL3;
	}
	public String getHPTZTP() {
		return HPTZTP;
	}
	public void setHPTZTP(String hPTZTP) {
		HPTZTP = hPTZTP;
	}
	public String getHPYS() {
		return HPYS;
	}
	public void setHPYS(String hPYS) {
		HPYS = hPYS;
	}
	public String getSJSCSJ() {
		return SJSCSJ;
	}
	public void setSJSCSJ(String sJSCSJ) {
		SJSCSJ = sJSCSJ;
	}
	public String getSFSH() {
		return SFSH;
	}
	public void setSFSH(String sFSH) {
		SFSH = sFSH;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getNowId() {
		return nowId;
	}
	public void setNowId(int nowId) {
		this.nowId = nowId;
	}
	public int getAddcount() {
		return addcount;
	}
	public void setAddcount(int addcount) {
		this.addcount = addcount;
	}
	public String getSBBH() {
		return SBBH;
	}
	public void setSBBH(String sBBH) {
		SBBH = sBBH;
	}
	public String getHDLQSJ() {
		return HDLQSJ;
	}
	public void setHDLQSJ(String hDLQSJ) {
		HDLQSJ = hDLQSJ;
	}
	public String getHDCXSJ() {
		return HDCXSJ;
	}
	public void setHDCXSJ(String hDCXSJ) {
		HDCXSJ = hDCXSJ;
	}
	public String getZJSP() {
		return ZJSP;
	}
	public void setZJSP(String zJSP) {
		ZJSP = zJSP;
	}
	public String getFZZJSPTP() {
		return FZZJSPTP;
	}
	public void setFZZJSPTP(String fZZJSPTP) {
		FZZJSPTP = fZZJSPTP;
	}
	public String getCJSJ() {
		return CJSJ;
	}
	public void setCJSJ(String cJSJ) {
		CJSJ = cJSJ;
	}
	public String getScreenDate() {
		return screenDate;
	}
	public void setScreenDate(String screenDate) {
		this.screenDate = screenDate;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
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
		return "IntervalVM [sysid=" + sysid + ", JKLX=" + JKLX + ", JKBB="
				+ JKBB + ", CSID=" + CSID + ", MSGID=" + MSGID + ", WFSJLY="
				+ WFSJLY + ", HPZL=" + HPZL + ", HPHM=" + HPHM + ", WFDM="
				+ WFDM + ", CJJGDM=" + CJJGDM + ", SJLY=" + SJLY + ", ZPLX="
				+ ZPLX + ", CJDBH=" + CJDBH + ", CJDZ=" + CJDZ + ", FXBH="
				+ FXBH + ", CDBH=" + CDBH + ", URL1=" + URL1 + ", URL2=" + URL2
				+ ", URL3=" + URL3 + ", HPTZTP=" + HPTZTP + ", HPYS=" + HPYS
				+ ", SJSCSJ=" + SJSCSJ + ", SFSH=" + SFSH + ", startTime="
				+ startTime + ", endTime=" + endTime + ", nowId=" + nowId
				+ ", addcount=" + addcount + ", SBBH=" + SBBH + ", HDLQSJ="
				+ HDLQSJ + ", HDCXSJ=" + HDCXSJ + ", ZJSP=" + ZJSP
				+ ", FZZJSPTP=" + FZZJSPTP + ", CJSJ=" + CJSJ + ", area="
				+ area + ", screenDate=" + screenDate + ", userId=" + userId
				+ ", userName=" + userName + ", secId=" + secId + ", secName="
				+ secName + ", illegal_explanation=" + illegal_explanation
				+ "]";
	}
	
}
