package enums;

public enum UploadStatusEnum {
    NOLOAD(0, "未上传"),
    UPLOAD(1, "已上传"),
    ;

    private Integer code;

    private String msg;

    UploadStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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
}
