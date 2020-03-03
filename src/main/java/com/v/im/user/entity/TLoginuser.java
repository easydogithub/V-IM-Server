package com.v.im.user.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TLoginuser implements Serializable {

    private String id;

    private String logname;

    private String username;

    private String dcode;

}
