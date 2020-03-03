package com.v.im.user.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * <p>
 * 群
 * </p>
 *
 * @author 乐天
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
    @TableId(value = "chat_group_id",type = IdType.INPUT) 
    private String chatGroupId;

    /**
     * 用户id
     */
    @TableId(value = "user_id",type = IdType.INPUT) 
    private String userId;

    /**
     * 入群时间
     */
    private Date createDate;


}
