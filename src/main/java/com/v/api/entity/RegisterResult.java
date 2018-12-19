package com.v.api.entity;

/**
 * 注册返回信息
 * @author zkp
 */
public class RegisterResult {

    public static final String SUCCESS = "0";

    public static final String ERROR = "1";

    /**
     * 返回代码
     */
    private String resultCode;

    /**
     * 返回结果
     */
    private String message;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
