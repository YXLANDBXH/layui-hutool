package com.shop.service;

import com.shop.domain.Product;

import java.util.List;

/**
 * @author XLong
 * @create 2021-04-19 19:27
 */
public interface ProductService {
    //显示商品信息
    List<Product> findAll(int pageNum,int pageSize);
}
