package com.oddfar.campus.business.service;

import com.oddfar.campus.business.entity.SysUser;

public interface SysUserService {
    SysUser selectUserByName(String username);

    Integer updateUser(SysUser sysUser);
}
