package com.v.im.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.v.im.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 树
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ImPeople implements Serializable {

    private String code;

    private String name;

    private String loginCode;

    private String type;

    private String isfav;

    @TableField(exist = false)
    private ImUser user;
}
