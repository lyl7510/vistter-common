package com.base.vistter.common.exception;

public class PlatformException extends Exception{

    public int code = 999; //服务器异常

    public PlatformException(int code){
        this.code = code;
    }

    public PlatformException() {
        super();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
