package com.v.im.user.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 群
 * </p>
 *
 * @author v
 * @since 2018-10-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ImChatGroupUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 群id
     */
    private String chatGroupId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 入群时间
     */
    private Date createDate;


}
