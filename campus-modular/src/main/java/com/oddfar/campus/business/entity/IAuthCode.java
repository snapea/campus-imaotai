package com.oddfar.campus.business.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("i_auth_code")
public class IAuthCode {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String code;
    private String bindPhone;
    private boolean disabled;
    private Integer effectTime;
    private String username;
}
