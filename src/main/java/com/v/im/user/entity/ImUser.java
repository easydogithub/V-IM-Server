package com.v.im.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.v.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author v
 * @since 2018-10-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ImUser  extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String id;

    private String avatar;

    private String name;

    private String sign;

    private String mobile;

    private String email;

    private String password;

    @TableField("login_name")
    private String loginName;


}
