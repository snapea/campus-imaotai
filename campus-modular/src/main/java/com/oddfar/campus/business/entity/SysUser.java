package com.oddfar.campus.business.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oddfar.campus.common.domain.entity.SysRoleEntity;
import com.oddfar.campus.common.validator.Xss;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@TableName("sys_user")
@Data
@NoArgsConstructor
public class SysUser {

    private static final long serialVersionUID = 1L;

    /** 用户ID */
    @TableId("user_id")
    private Long userId;

    /** 用户账号 */
    @Xss(message = "用户账号不能包含脚本字符")
    @NotBlank(message = "用户账号不能为空")
    @Size(min = 0, max = 30, message = "用户账号长度不能超过30个字符")
    private String userName;

    /** 用户昵称 */
    @Xss(message = "用户昵称不能包含脚本字符")
    @Size(min = 0, max = 30, message = "用户昵称长度不能超过30个字符")
    private String nickName;

    /** 用户邮箱 */
    @Email(message = "邮箱格式不正确")
    @Size(min = 0, max = 50, message = "邮箱长度不能超过50个字符")
    private String email;

    /** 手机号码 */
    @Size(min = 0, max = 11, message = "手机号码长度不能超过11个字符")
    private String phonenumber;

    /** 用户性别 */
    private String sex;

    /** 用户头像 */
    private String avatar;

    /** 密码 */
//    @JsonIgnore
    private String password;

    /** 帐号状态（0正常 1停用） */
    private String status;

    /** 最后登录IP */
    private String loginIp;

    /** 最后登录时间 */
    private Date loginDate;

    /** 备注 */
    private String remark;

    /** 到期时间 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Date expirationTime;

    /** 最大账号数 */
    private Integer accountMaxCount;

    /** 角色对象 */
    @TableField(exist = false)
    private List<SysRoleEntity> roles;

    /** 资源对象 */
//    @TableField(exist = false)
//    private List<SysResourceEntity> resources;

    /** 角色组 */
    @TableField(exist = false)
    private Long[] roleIds;

    /** 岗位组 */
    @TableField(exist = false)
    private Long[] postIds;

    /** 角色ID */
    @TableField(exist = false)
    private Long roleId;
    private static final Integer PAGE_NUM = 1;
    private static final Integer PAGE_SIZE = 10;


    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @TableField(fill = FieldFill.INSERT)
    private Long createUser;

    @TableField(fill = FieldFill.UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @TableField(fill = FieldFill.UPDATE)
    private Long updateUser;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    @JsonIgnore
    private Integer delFlag;

    @TableField(exist = false)
    private Map<String, Object> params;

    @NotNull(message = "页码不能为空")
    @Min(value = 1, message = "页码最小值为 1")
    @TableField(exist = false)
    @JsonIgnore
    private Integer pageNum = PAGE_NUM;

    @NotNull(message = "每页条数不能为空")
    @Min(value = 1, message = "每页条数最小值为 1")
    @Max(value = 100, message = "每页条数最大值为 100")
    @TableField(exist = false)
    @JsonIgnore
    private Integer pageSize = PAGE_SIZE;

    public Map<String, Object> getParams() {
        if (params == null) {
            params = new HashMap<>();
        }
        return params;
    }
}
