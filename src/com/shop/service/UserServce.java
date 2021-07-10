package com.shop.service;

import com.shop.domain.Product;
import com.shop.domain.User;
import com.shop.util.MybatisTools;

import java.util.List;

/**
 * @author XLong
 * @create 2021-04-19 19:13
 */
public interface UserServce {
    //登录
    User login(String username, String password);
}
