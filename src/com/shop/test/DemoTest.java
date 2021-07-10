package com.shop.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author XLong
 * @create 2021-04-20 9:18
 */
public class DemoTest {
    public static void main(String[] args) throws JsonProcessingException {
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setUid("1");
        user.setUsername("张三");
        user.setPassword("123456");
        userList.add(user);
        //将字符串转换为json格式
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(userList);
        System.out.println(s);

        System.out.println("-------------将map集合转换为json格式------------");
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("name","xiaolong");
        map.put("age",18);
        map.put("hobby","篮球");
        String s1 = objectMapper.writeValueAsString(map);
        System.out.println(s1);
    }
}
