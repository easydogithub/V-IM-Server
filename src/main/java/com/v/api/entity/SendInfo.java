package com.v.api.entity;

public class SendInfo {

    /**
     * ChatUtils.msg_*
     */
    private String code;

    private Message message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
