package com.oddfar.campus.business.controller;

import com.oddfar.campus.business.entity.IItem;
import com.oddfar.campus.business.mapper.IItemMapper;
import com.oddfar.campus.business.service.IShopService;
import com.oddfar.campus.common.annotation.ApiResource;
import com.oddfar.campus.common.domain.R;
import com.oddfar.campus.common.domain.entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * I茅台预约商品列表Controller
 *
 * @author oddfar
 * @date 2023-07-05
 */
@RestController
@RequestMapping("/imt/item")
@ApiResource(name = "I茅台预约商品列Controller")
public class IItemController {

    @Autowired
    private IItemMapper iItemMapper;
    @Autowired
    private IShopService iShopService;



    /**
     * 查询I茅台预约商品列列表
     */
    @GetMapping(value = "/list", name = "查询I茅台预约商品列列表")
    public R list() {
        List<IItem> iItems = iItemMapper.selectList();

        return R.ok(iItems);
    }

    @GetMapping(value = "/getUserInfoByName")
    public R getAccountMaxCount(@RequestParam() String username) {
        SysUserEntity res = iShopService.getUserInfoByName(username);

        return R.ok(res);

    }

    /**
     * 刷新i茅台预约商品列表
     */
    @GetMapping(value = "/refresh", name = "刷新i茅台预约商品列表")
    @PreAuthorize("@ss.resourceAuth()")
    public R refreshItem() {
        iShopService.refreshItem();
        return R.ok();
    }

}
