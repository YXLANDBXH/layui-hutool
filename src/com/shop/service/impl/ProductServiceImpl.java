package com.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.shop.domain.Product;
import com.shop.mapper.ProductMapper;
import com.shop.service.ProductService;
import com.shop.util.MybatisTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author XLong
 * @create 2021-04-19 19:28
 */
public class ProductServiceImpl implements ProductService {
    /*
    商品显示
     */
    @Override
    public List<Product> findAll(int pageNum, int pageSize) {
        SqlSession sqlSession = MybatisTools.getSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        // 进行分页操作
        PageHelper.startPage(pageNum,pageSize);
        List<Product> productList = productMapper.selectByExample(null);
        return productList;
    }
}
