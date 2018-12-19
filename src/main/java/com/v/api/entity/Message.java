package com.v.api.entity;

public class Message {

    private String username;//消息来源用户名

    private String avatar;//发送者头像

    private String id;//消息的来源ID（如果是私聊，则是用户id，如果是群聊，则是群组id）

    private String type;//消息类型 friend

    private String content; //消息内容

    private String cid; //消息id

    private boolean mine; //是否被人发送

    private String fromid; //消息的发送者id

    private long timestamp;//服务端时间戳毫秒数

    public Message() {
    }

    public Message(String username, String avatar, String id, String type, String content, String cid, boolean mine, String fromid, long timestamp) {
        this.username = username;
        this.avatar = avatar;
        this.id = id;
        this.type = type;
        this.content = content;
        this.cid = cid;
        this.mine = mine;
        this.fromid = fromid;
        this.timestamp = timestamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public boolean isMine() {
        return mine;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public String getFromid() {
        return fromid;
    }

    public void setFromid(String fromid) {
        this.fromid = fromid;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
