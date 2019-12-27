package com.mt.sx.common.exception;


import com.mt.sx.common.enums.ResponseCode;

/**
 * 自定义全局异常
 */
public class GlobalException extends RuntimeException {

    public GlobalException( int code,String message) {
        super(message);
        this.code = code;
    }
    public GlobalException(ResponseCode responseCode) {
        super(responseCode.getMsg());
        this.code = responseCode.getCode();
    }


    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
