package com.shop.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

/**
 * 工具封装类
 * @author XLong
 * @create 2021-04-19 19:04
 */
public class MybatisTools {
    private static SqlSessionFactory sf = null;

    static {
        //读取mybatis的核心配置文件
        String configXml = "mybatis-config.xml";
        try {
            InputStream is = Resources.getResourceAsStream(configXml);
            sf = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打开SQLSession方法
     */
    public static SqlSession getSession() {
        /*
         * // 读取mybatis的核心配置文件 String configXml = "mybatis-config.xml";
         *
         * InputStream inputStream = Resources.getResourceAsStream(configXml);
         */

        // 创建sqlSessionFactory
        // SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);
        return sf.openSession(true);
    }

    /**
     * 关闭SqlSession方法
     */
    public static void CloseSqlSession(SqlSession ss) {
        if (ss != null) {
            ss.close();
        }
    }
}
