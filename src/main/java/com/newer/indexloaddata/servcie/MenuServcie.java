package com.newer.indexloaddata.servcie;

import com.newer.indexloaddata.domian.Menu;
import com.newer.indexloaddata.domian.Merchants;
import com.newer.indexloaddata.mapper.MenuMapper;
import com.newer.indexloaddata.mapper.MerchantsMapper;
import com.newer.logreg.tool.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 梁虔硕版权所有 哈哈哈哈
 * @date 2019/12/26 - 21:38
 */
public class MenuServcie {
    MenuMapper menuMapper ;
    SqlSession sqlSession;
    MerchantsMapper merchantsMapper;
    private  void init(){

        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
         sqlSession = sqlSessionFactory.openSession(true);
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        merchantsMapper= sqlSession.getMapper(MerchantsMapper.class);
    }
   //根据商家id查询所有菜
    public List<Menu> findByMerchantsId(Integer merchantsId  ){
        init();
        List<Menu> list = menuMapper.findById(merchantsId);
        sqlSession.close();
        return list;
    }
    //根据商家id分页查询所有菜
    public List<Menu> pagingFindById(Integer merchantsId ,Integer currentPage ,Integer pageSize  ){
        init();
        List<Menu> list = menuMapper.pagingFindById(merchantsId,currentPage,pageSize);
        sqlSession.close();

        return list;
    }
    //根据菜的id  查询菜信息
    public  Menu findByid(  Integer menuId){
        init();
        Menu menu = menuMapper.findBymeunId(menuId);
        return menu;
    }
   //根据userdeid 商家id查询菜的集合信息
    public  List<Menu>  findBymeIdAndmerchId(Integer userId){
        init();

       Map<String,Integer> map = new HashMap<String, Integer>();
       // map.put("merchantsId",merchantsId);
        map.put("userId",userId);
        return menuMapper.findBymerIdAndMenuId(map) ;


    }

  //查询所有
  public  List<Menu> findAll( ){
      init();

      return menuMapper.findAll();
  }
  //当用户点击了加入购物车把菜的设置为该用户
  public Integer updataUserId(Integer userId,Integer meId){
        init();
        return menuMapper.updataBymeId(userId,meId);
  }
    //根据菜的id修改userid(购物车删除功能)

    public Integer  updataUserId( Integer menuId){
        init();
        return  menuMapper.updataUserId(menuId);
    }


}
