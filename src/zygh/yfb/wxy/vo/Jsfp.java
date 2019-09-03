package zygh.yfb.wxy.vo;

public class Jsfp {

    //冗余号牌种类
    private String pExplain;
    private String licensePlateType;

    //主键
    private int sysid;

    //uuid
    private String MSGID;

    //号牌号码
    private String HPHM;

    //号牌种类
    private String HPZL;

    //采集时间
    private String CJSJ;

    //违法代码
    private String WFDM;

    //违法地址
    private String CJDZ;

    //设备编号
    private String SBBH;

    //初筛筛选状态（默认为 -1：未筛选，0:通过，1:作废）
    private String SFSH;

    //初筛筛选时间
    private String screenDate;

    //筛选人
    private String userName;

    //违法图片1
    private String URL1;

    //厂商名字
    private String CSMZ;

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

    //开始时间
    private String startTime;
    //结束时间
    private String endTime;
    //地址总数
    private int addcount;

    private int pageSize = 10; // 每页显示记录的条数

    public String getpExplain() {
        return pExplain;
    }

    public void setpExplain(String pExplain) {
        this.pExplain = pExplain;
    }

    public String getLicensePlateType() {
        return licensePlateType;
    }

    public void setLicensePlateType(String licensePlateType) {
        this.licensePlateType = licensePlateType;
    }

    public int getSysid() {
        return sysid;
    }

    public void setSysid(int sysid) {
        this.sysid = sysid;
    }

    public String getMSGID() {
        return MSGID;
    }

    public void setMSGID(String MSGID) {
        this.MSGID = MSGID;
    }

    public String getHPHM() {
        return HPHM;
    }

    public void setHPHM(String HPHM) {
        this.HPHM = HPHM;
    }

    public String getHPZL() {
        return HPZL;
    }

    public void setHPZL(String HPZL) {
        this.HPZL = HPZL;
    }

    public String getCJSJ() {
        return CJSJ;
    }

    public void setCJSJ(String CJSJ) {
        this.CJSJ = CJSJ;
    }

    public String getWFDM() {
        return WFDM;
    }

    public void setWFDM(String WFDM) {
        this.WFDM = WFDM;
    }

    public String getCJDZ() {
        return CJDZ;
    }

    public void setCJDZ(String CJDZ) {
        this.CJDZ = CJDZ;
    }

    public String getSBBH() {
        return SBBH;
    }

    public void setSBBH(String SBBH) {
        this.SBBH = SBBH;
    }

    public String getSFSH() {
        return SFSH;
    }

    public void setSFSH(String SFSH) {
        this.SFSH = SFSH;
    }

    public String getScreenDate() {
        return screenDate;
    }

    public void setScreenDate(String screenDate) {
        this.screenDate = screenDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getURL1() {
        return URL1;
    }

    public void setURL1(String URL1) {
        this.URL1 = URL1;
    }

    public String getCSMZ() {
        return CSMZ;
    }

    public void setCSMZ(String CSMZ) {
        this.CSMZ = CSMZ;
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

    public long getAllwsx() {
        return allwsx;
    }

    public void setAllwsx(long allwsx) {
        this.allwsx = allwsx;
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

    public int getAddcount() {
        return addcount;
    }

    public void setAddcount(int addcount) {
        this.addcount = addcount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "Jsfp{" +
                "pExplain='" + pExplain + '\'' +
                ", licensePlateType='" + licensePlateType + '\'' +
                ", sysid=" + sysid +
                ", MSGID='" + MSGID + '\'' +
                ", HPHM='" + HPHM + '\'' +
                ", HPZL='" + HPZL + '\'' +
                ", CJSJ='" + CJSJ + '\'' +
                ", WFDM='" + WFDM + '\'' +
                ", CJDZ='" + CJDZ + '\'' +
                ", SBBH='" + SBBH + '\'' +
                ", SFSH='" + SFSH + '\'' +
                ", screenDate='" + screenDate + '\'' +
                ", userName='" + userName + '\'' +
                ", URL1='" + URL1 + '\'' +
                ", CSMZ='" + CSMZ + '\'' +
                ", allTotal=" + allTotal +
                ", pass=" + pass +
                ", tovoid=" + tovoid +
                ", screening=" + screening +
                ", allwsx=" + allwsx +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", addcount=" + addcount +
                ", pageSize=" + pageSize +
                '}';
    }
}
