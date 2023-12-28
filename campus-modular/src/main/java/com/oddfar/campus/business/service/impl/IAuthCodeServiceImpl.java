package com.oddfar.campus.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oddfar.campus.business.entity.IAuthCode;
import com.oddfar.campus.business.mapper.IAuthCodeMapper;
import com.oddfar.campus.business.service.IAuthService;
import com.oddfar.campus.common.domain.entity.SysUserEntity;
import com.oddfar.campus.framework.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IAuthCodeServiceImpl implements IAuthService {
    @Autowired
    private IAuthCodeMapper iAuthCodeMapper;

    @Override
    public void insertIAuthCode(IAuthCode iAuthCode) {
        iAuthCodeMapper.insert(iAuthCode);
    }

    @Override
    public IAuthCode selectAuthCode(IAuthCode iAuthCode) {
        QueryWrapper<IAuthCode> QueryWrapper = new QueryWrapper<>();
        QueryWrapper.eq("code", iAuthCode.getCode());
        return iAuthCodeMapper.selectOne(QueryWrapper);
    }

    @Override
    public void updateStatus(IAuthCode iAuth) {
        iAuth.setDisabled(true);
        QueryWrapper<IAuthCode> QueryWrapper = new QueryWrapper<>();
        QueryWrapper.eq("code", iAuth.getCode());
        iAuthCodeMapper.update(iAuth, QueryWrapper);
    }
}
