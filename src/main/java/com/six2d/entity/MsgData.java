package com.six2d.entity;

public class MsgData<T> {
    private Integer code;
    private String msg;
    private T data;

    public static MsgData SUCCESS = new MsgData(0, "success");
    public static MsgData FAIL = new MsgData(1, "fail");
    public static MsgData ERROR = new MsgData(-1, "error");

    public MsgData(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
