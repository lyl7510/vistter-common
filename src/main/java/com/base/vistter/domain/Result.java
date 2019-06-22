package com.base.vistter.domain;

import java.io.Serializable;

public class Result implements Serializable {

    private static final long serialVersionUID = 5165102514695998105L;

    private Integer code = 100;

    private Object data = null;

    private long total;

    public Result() {

    }

    public Result(Object data) {
        this.data = data;
    }

    public static Result generErrorJson(Integer code) {
        Result result = new Result();
        result.setCode(code);
        return result;
    }

    public static Result generJson(Object data) {
        return new Result(data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
