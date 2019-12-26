package com.newer.logreg.tool;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 梁虔硕版权所有 哈哈哈哈
 * @date 2019/12/17 - 18:13
 */
public class SqlSessionFactoryUtils {
    private static  SqlSessionFactory sqlSessionFactory;

    static {
        InputStream in =null;
        try {
            in  = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
            sqlSessionFactory = sessionFactoryBuilder.build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  static  SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
}
