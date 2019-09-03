package zygh.yfb.wxy.vo;

/**
 * 电子警察违法数据作废原因统计表
 */
public class Analysis {

    //主键
    private Integer analysisId;

    //作废分类ID
    private int ReasonsTypeId;

    //作废原因ID
    private int ReasonsId;

    //违法代码
    private String WFDM;

    //采集时间
    private String CJSJ;

    //主表主键
    private int sysid;

    //初筛('1')或者复核('2')
    private String Screening;

   /* //作废原因分类
    private String Type;

    //作废原因
    private String invalidation;*/

    public Integer getAnalysisId() {
        return analysisId;
    }

    public void setAnalysisId(Integer analysisId) {
        this.analysisId = analysisId;
    }

    public int getReasonsTypeId() {
        return ReasonsTypeId;
    }

    public void setReasonsTypeId(int reasonsTypeId) {
        ReasonsTypeId = reasonsTypeId;
    }

    public int getReasonsId() {
        return ReasonsId;
    }

    public void setReasonsId(int reasonsId) {
        ReasonsId = reasonsId;
    }

    public String getWFDM() {
        return WFDM;
    }

    public void setWFDM(String WFDM) {
        this.WFDM = WFDM;
    }

    public String getCJSJ() {
        return CJSJ;
    }

    public void setCJSJ(String CJSJ) {
        this.CJSJ = CJSJ;
    }

    public int getSysid() {
        return sysid;
    }

    public void setSysid(int sysid) {
        this.sysid = sysid;
    }

    public String getScreening() {
        return Screening;
    }

    public void setScreening(String screening) {
        Screening = screening;
    }

    @Override
    public String toString() {
        return "Analysis{" +
                "analysisId=" + analysisId +
                ", ReasonsTypeId=" + ReasonsTypeId +
                ", ReasonsId=" + ReasonsId +
                ", WFDM='" + WFDM + '\'' +
                ", CJSJ='" + CJSJ + '\'' +
                ", sysid=" + sysid +
                ", Screening='" + Screening + '\'' +
                '}';
    }
}
