package com.oddfar.campus.business.service;

import com.oddfar.campus.business.entity.IAuthCode;
import com.oddfar.campus.common.domain.entity.SysUserEntity;

public interface IAuthService {
    void insertIAuthCode(IAuthCode iAuthCode);

    IAuthCode selectAuthCode(IAuthCode iAuthCode);

    void updateStatus(IAuthCode iAuth);
}
