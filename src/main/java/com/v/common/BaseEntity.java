package com.v.common;

import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {

    /**
     * 说明
     */
    private String remarks;

    private Date createDate;

    private String createBy;

    private Date updateDate;

    private String updateBy;

    private String delFlag;

    public void preInsert(){
        this.createDate = new Date();
        this.updateDate = new Date();
        this.delFlag = "0";
    }
}
