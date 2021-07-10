package com.shop.service.impl;

import com.shop.domain.Product;
import com.shop.domain.User;
import com.shop.domain.UserExample;
import com.shop.mapper.UserMapper;
import com.shop.service.UserServce;
import com.shop.util.MybatisTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author XLong
 * @create 2021-04-19 19:17
 */
public class UserServiceImpl implements UserServce {
    /*
    登录
     */
    @Override
    public User login(String username, String password) {
        SqlSession sqlSession = MybatisTools.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList.size() > 0)
            return userList.get(0);
        return null;
    }
}
