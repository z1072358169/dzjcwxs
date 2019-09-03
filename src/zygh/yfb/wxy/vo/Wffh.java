package zygh.yfb.wxy.vo;


import util.Page;

/**
 * 新增民警po类
 */

public class Wffh {

    private int pageNow = 1; // 当前页数

    private int pageSize = 10; // 每页显示记录的条数

    private long totalCount; // 总的记录条数

    private int totalPageCount; // 总的页数

    private int start;

    //冗余号牌种类
    private String pExplain;
    private String licensePlateType;

    //主键
    private int sysid;

    //uuid
    private String MSGID;

    //外键
    private int z_sysid;

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

    //是否已上传金惠（默认未0：未上传，1：已上传）
    private int YSCHX;

    //民警筛选状态（默认为 1：未筛选，2:通过，3:作废）
    private int MJSCZT;

    //民警筛选时间
    private String screenDatemj;

    //民警筛选人
    private String mjuserName;

    //上传金惠时间
    private String YSCHXSJ;

    //违法图片
    private String URL1;

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

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

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

    public int getZ_sysid() {
        return z_sysid;
    }

    public void setZ_sysid(int z_sysid) {
        this.z_sysid = z_sysid;
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

    public int getYSCHX() {
        return YSCHX;
    }

    public void setYSCHX(int YSCHX) {
        this.YSCHX = YSCHX;
    }

    public int getMJSCZT() {
        return MJSCZT;
    }

    public void setMJSCZT(int MJSCZT) {
        this.MJSCZT = MJSCZT;
    }

    public String getScreenDatemj() {
        return screenDatemj;
    }

    public void setScreenDatemj(String screenDatemj) {
        this.screenDatemj = screenDatemj;
    }

    public String getMjuserName() {
        return mjuserName;
    }

    public void setMjuserName(String mjuserName) {
        this.mjuserName = mjuserName;
    }

    public String getYSCHXSJ() {
        return YSCHXSJ;
    }

    public void setYSCHXSJ(String YSCHXSJ) {
        this.YSCHXSJ = YSCHXSJ;
    }

    public String getURL1() {
        return URL1;
    }

    public void setURL1(String URL1) {
        this.URL1 = URL1;
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

    @Override
    public String toString() {
        return "Wffh{" +
                "pageNow=" + pageNow +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", totalPageCount=" + totalPageCount +
                ", start=" + start +
                ", pExplain='" + pExplain + '\'' +
                ", licensePlateType='" + licensePlateType + '\'' +
                ", sysid=" + sysid +
                ", MSGID='" + MSGID + '\'' +
                ", z_sysid=" + z_sysid +
                ", HPHM='" + HPHM + '\'' +
                ", HPZL='" + HPZL + '\'' +
                ", CJSJ='" + CJSJ + '\'' +
                ", WFDM='" + WFDM + '\'' +
                ", CJDZ='" + CJDZ + '\'' +
                ", SBBH='" + SBBH + '\'' +
                ", YSCHX=" + YSCHX +
                ", MJSCZT=" + MJSCZT +
                ", screenDatemj='" + screenDatemj + '\'' +
                ", mjuserName='" + mjuserName + '\'' +
                ", YSCHXSJ='" + YSCHXSJ + '\'' +
                ", URL1='" + URL1 + '\'' +
                ", allTotal=" + allTotal +
                ", pass=" + pass +
                ", tovoid=" + tovoid +
                ", screening=" + screening +
                ", allwsx=" + allwsx +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", addcount=" + addcount +
                '}';
    }
}
