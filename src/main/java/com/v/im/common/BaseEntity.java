package com.v.im.common;

import lombok.Data;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
/**
 * 基础类别
 *
 * @author 乐天
 * @since 2018-10-07
 */
@Data
public class BaseEntity {

    /**
     * 说明
     */
    private String remarks;

    @TableField(value="create_date")
    private Date createDate = new Date();

    @TableField(value="create_by")
    private String createBy;

    @TableField(value="update_date")
    private Date updateDate =new Date();

    @TableField(value="update_by")
    private String updateBy;

    @TableField(value="del_flag")
    private String delFlag =  "0";

    public void preInsert() {
        this.createDate = new Date();
        this.updateDate = new Date();
        this.delFlag = "0";
    }
}
