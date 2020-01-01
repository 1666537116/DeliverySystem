package com.newer.test.loaddata;

import com.newer.indexloaddata.domian.Menu;
import com.newer.indexloaddata.domian.Merchants;
import com.newer.indexloaddata.mapper.MenuMapper;
import com.newer.indexloaddata.mapper.MerchantsMapper;
import com.newer.indexloaddata.servcie.MerchantsServcie;
import com.newer.logreg.mapper.UserMapper;
import com.newer.logreg.tool.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author 梁虔硕版权所有 哈哈哈哈
 * @date 2019/12/26 - 20:28
 */
public class LoadDataTest {
    MerchantsMapper merchantsMapper ;
    MenuMapper menuMapper;
    SqlSession sqlSession ;
    @Before
    public void init(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    sqlSession = sqlSessionFactory.openSession();
        merchantsMapper = sqlSession.getMapper(MerchantsMapper.class);

    }
    //商家测试查询
    @Test
    public  void find(){
       // List<Merchants> list = merchantsMapper.fiandAll();
         List<Merchants> list = merchantsMapper.AdvancedQuery(0,3);


        for (Merchants merchants : list) {
            System.out.println(merchants);
        }
    }
  //菜单表查询 根据商家id查询
    @Test
    public  void findMenu(){
        menuMapper = sqlSession.getMapper(MenuMapper.class);
       // List<Menu> list = menuMapper.findById(4);
        List<Menu> list = menuMapper.pagingFindById(4,0,2);

        for (Menu menu : list) {
            System.out.println(menu);
        }
    }
    //测试商家服务层
    @Test
    public  void tetsmerchantsServcie(){
        MerchantsServcie merchantsServcie = new MerchantsServcie();
        List<Merchants> list = merchantsServcie.PagingQuery(1,4);
        for (Merchants merchants : list) {
            System.out.println(merchants);
        }
    }
    @After
    public  void destroy(){
sqlSession.close();
    }
}
