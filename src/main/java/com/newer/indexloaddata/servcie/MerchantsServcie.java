package com.newer.indexloaddata.servcie;

import com.newer.indexloaddata.domian.Menu;
import com.newer.indexloaddata.domian.Merchants;
import com.newer.indexloaddata.mapper.MerchantsMapper;
import com.newer.logreg.tool.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 梁虔硕版权所有 哈哈哈哈
 * @date 2019/12/26 - 20:34
 */
public class MerchantsServcie {
 private MerchantsMapper merchantsMapper;
    SqlSession sqlSession;
    private  void  init(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
         sqlSession = sqlSessionFactory.openSession();
        merchantsMapper = sqlSession.getMapper(MerchantsMapper.class);
    }

    //查询所有商家信息 返回一个集合
    public List<Merchants> findAll(){
        init();
        List<Merchants> list = merchantsMapper.fiandAll();
        sqlSession.close();
        return  list;
    }
//分页查询
    public    List<Merchants> PagingQuery(Integer currentPage,Integer pageSize){
        init();
        currentPage = (currentPage-1)*pageSize;

        List<Merchants> list = merchantsMapper.AdvancedQuery(currentPage,pageSize);
        sqlSession.close();
        return  list;
    }

    //根据商家id查询商家信息
   public    Merchants findByid(Integer merchantsId){
        init();
        Merchants merchants = merchantsMapper.findBymerchantsId(merchantsId);
   return merchants;
   }

    public static void main(String[] args) {
        MerchantsServcie merchantsServcie = new MerchantsServcie();
        System.out.println(merchantsServcie.findByid(3));
    }
}
