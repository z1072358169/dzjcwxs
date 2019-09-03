package zygh.yfb.wxy.vo;

/**
 * ViewObject
 * 视图对象
 * HTTP请求返回的最外层对象
 */
public class RestultVo<T> {

    /** 错误码. */
    private Integer code;
    /** 提示信息 */
    private String msg;

    /** 返回的具体内容 */
    private T Data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

    @Override
    public String toString() {
        return "RestultVo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", Data=" + Data +
                '}';
    }
}
