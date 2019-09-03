package zygh.yfb.wxy.vo;

public class ReasonsTj extends Analysis {

    private String ReasonType;

    private int ReasonsId;

    private String invalidation;

    private long cssl;

    private long ffsl;

    private String riqi;

    public String getReasonType() {
        return ReasonType;
    }

    public void setReasonType(String reasonType) {
        ReasonType = reasonType;
    }

    @Override
    public int getReasonsId() {
        return ReasonsId;
    }

    @Override
    public void setReasonsId(int reasonsId) {
        ReasonsId = reasonsId;
    }

    public String getInvalidation() {
        return invalidation;
    }

    public void setInvalidation(String invalidation) {
        this.invalidation = invalidation;
    }

    public long getCssl() {
        return cssl;
    }

    public void setCssl(long cssl) {
        this.cssl = cssl;
    }

    public long getFfsl() {
        return ffsl;
    }

    public void setFfsl(long ffsl) {
        this.ffsl = ffsl;
    }

    public String getRiqi() {
        return riqi;
    }

    public void setRiqi(String riqi) {
        this.riqi = riqi;
    }

    @Override
    public String toString() {
        return "ReasonsTj{" +
                "ReasonType='" + ReasonType + '\'' +
                ", ReasonsId=" + ReasonsId +
                ", invalidation='" + invalidation + '\'' +
                ", cssl=" + cssl +
                ", ffsl=" + ffsl +
                ", riqi='" + riqi + '\'' +
                '}';
    }
}
