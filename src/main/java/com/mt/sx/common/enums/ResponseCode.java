package com.mt.sx.common.enums;

/**
 * 通用返回code和msg
 */
public enum ResponseCode implements IResponseCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    UNAUTH(403, "没有相关权限"),
    UNLOGIN(401, "未登录或登陆过期"),
    UPDATE_FALSE(-1,"更新失败"),
    INSERT_FALSE(-1,"添加失败"),
    DELETE_FALSE(-1,"删除失败");

    private  Integer code;
    private String msg;

    private ResponseCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
