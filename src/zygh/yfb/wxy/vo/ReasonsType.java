package zygh.yfb.wxy.vo;

/**
 * 作废原因分类表
 */
public class ReasonsType {

    //主键
    private int ReasonsTypeId;

    //分类
    private String ReasonType;

    //违法代码
    private String WFDM;

    public int getReasonsTypeId() {
        return ReasonsTypeId;
    }

    public void setReasonsTypeId(int reasonsTypeId) {
        ReasonsTypeId = reasonsTypeId;
    }

    public String getReasonType() {
        return ReasonType;
    }

    public void setReasonType(String reasonType) {
        ReasonType = reasonType;
    }

    public String getWFDM() {
        return WFDM;
    }

    public void setWFDM(String WFDM) {
        this.WFDM = WFDM;
    }

    @Override
    public String toString() {
        return "Reasonstype{" +
                "ReasonsTypeId=" + ReasonsTypeId +
                ", ReasonType='" + ReasonType + '\'' +
                ", WFDM='" + WFDM + '\'' +
                '}';
    }
}
