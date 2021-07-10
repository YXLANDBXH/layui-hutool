package com.shop.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.domain.Product;
import com.shop.service.ProductService;
import com.shop.service.impl.ProductServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNum = request.getParameter("page");
        String pageSize = request.getParameter("limit");

        //调用service
        ProductService ps = new ProductServiceImpl();
        //查询
//      List<Product> productList = ps.selectProductList();
        List<Product> productList = ps.findAll(Integer.parseInt(pageNum),Integer.parseInt(pageSize));

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",100);
        map.put("data",productList);

        //将查询出来的数据转为json数据
        ObjectMapper objectMapper = new ObjectMapper();
        String json_str = objectMapper.writeValueAsString(map);

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json_str);
    }
}
