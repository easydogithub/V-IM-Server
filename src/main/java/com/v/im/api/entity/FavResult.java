package com.v.im.api.entity;

import com.v.im.user.entity.ImUser;
import lombok.Data;

@Data
public class FavResult {

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

    /**
     * 操作
     */
    private String action;
}
