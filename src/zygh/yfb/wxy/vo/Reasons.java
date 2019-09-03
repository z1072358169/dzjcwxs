package zygh.yfb.wxy.vo;

/**
 * 作废原因表
 */
public class Reasons extends ReasonsType{

    //主键
    private int ReasonsId;
    //作废原因
    private String invalidation;
    //分类id
    //private int ReasonsTypeId;

    public int getReasonsId() {
        return ReasonsId;
    }

    public void setReasonsId(int reasonsId) {
        ReasonsId = reasonsId;
    }

    public String getInvalidation() {
        return invalidation;
    }

    public void setInvalidation(String invalidation) {
        this.invalidation = invalidation;
    }

    @Override
    public String toString() {
        return "Reasons{" +
                "ReasonsId=" + ReasonsId +
                ", invalidation='" + invalidation + '\'' +
                '}';
    }
}
