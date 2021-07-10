package com.shop.web;

import com.shop.domain.User;
import com.shop.service.UserServce;
import com.shop.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author XLong
 * @create 2021-04-19 20:24
 */
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取页面元素
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //获取系统生成的验证码
        HttpSession session = req.getSession();
        String randCode = (String) session.getAttribute("randomCode");

        //获取页面输入的验证码
        String validateCode = req.getParameter("validateCode");

        //先判断验证码是否输入正确
        if (!randCode.equalsIgnoreCase(validateCode)) { //忽略大小写
            //验证码错误信息存在域中
            req.setAttribute("errorMeg","验证码不一致！");
            //返回login.jsp
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }

        //验证用户名和密码
        UserServce us = new UserServiceImpl();
        User user = us.login(username, password);
        if (user != null && user.getUsername() != null) {  //登录成功
            // 将信息存在session中
            session.setAttribute("user",user);
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        } else {
            req.setAttribute("errorMeg","用户名和密码错误！");
            //返回login.jsp
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
