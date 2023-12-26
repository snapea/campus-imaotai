package com.oddfar.campus.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oddfar.campus.business.entity.SysUser;
import com.oddfar.campus.business.mapper.SystemUserMapper;
import com.oddfar.campus.business.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemUserServiceImpl implements SysUserService {
    @Autowired
    private SystemUserMapper systemUserMapper;
    @Override
    public SysUser selectUserByName(String username) {
        System.out.println(username);
        QueryWrapper<SysUser> sysUserQueryWrapper = new QueryWrapper<>();
        sysUserQueryWrapper.eq("user_name", username);
        SysUser sysUser = systemUserMapper.selectOne(sysUserQueryWrapper);
        return sysUser;
    }

    @Override
    public Integer updateUser(SysUser sysUser) {
        QueryWrapper<SysUser> sysUserQueryWrapper = new QueryWrapper<>();
        sysUserQueryWrapper.eq("user_id", sysUser.getUserId());

        int res = systemUserMapper.update(sysUser, sysUserQueryWrapper);
        return res;
    }

}
