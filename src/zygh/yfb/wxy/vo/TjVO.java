package zygh.yfb.wxy.vo;


public class TjVO {

    //开始时间
    private String startTime;
    //结束时间
    private String endTime;
    //采集地址
    private String CJDZ;
    //新改  是否已审核    -1未审核 未上传，0-通过 已上传，1-作废
    private String SFSH;
    //民警上传状态：2:通过，3:作废。默认1
    private int MJSCZT;
    //设备编号
    private String SBBH;
    //数据状态  1：未画模板的路口数据,2:已画模板的路口
    private int SJZT;
    //抓取总数
    private long zqcount;
    //初筛通过数
    private long sfsfcount;
    //复核通过数
    private long mjscztcount;

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

    public String getCJDZ() {
        return CJDZ;
    }

    public void setCJDZ(String CJDZ) {
        this.CJDZ = CJDZ;
    }

    public String getSFSH() {
        return SFSH;
    }

    public void setSFSH(String SFSH) {
        this.SFSH = SFSH;
    }

    public int getMJSCZT() {
        return MJSCZT;
    }

    public void setMJSCZT(int MJSCZT) {
        this.MJSCZT = MJSCZT;
    }

    public String getSBBH() {
        return SBBH;
    }

    public void setSBBH(String SBBH) {
        this.SBBH = SBBH;
    }

    public int getSJZT() {
        return SJZT;
    }

    public void setSJZT(int SJZT) {
        this.SJZT = SJZT;
    }

    public long getZqcount() {
        return zqcount;
    }

    public void setZqcount(long zqcount) {
        this.zqcount = zqcount;
    }

    public long getSfsfcount() {
        return sfsfcount;
    }

    public void setSfsfcount(long sfsfcount) {
        this.sfsfcount = sfsfcount;
    }

    public long getMjscztcount() {
        return mjscztcount;
    }

    public void setMjscztcount(long mjscztcount) {
        this.mjscztcount = mjscztcount;
    }

    @Override
    public String toString() {
        return "TjVO{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", CJDZ='" + CJDZ + '\'' +
                ", SFSH='" + SFSH + '\'' +
                ", MJSCZT=" + MJSCZT +
                ", SBBH='" + SBBH + '\'' +
                ", SJZT=" + SJZT +
                ", zqcount=" + zqcount +
                ", sfsfcount=" + sfsfcount +
                ", mjscztcount=" + mjscztcount +
                '}';
    }
}
