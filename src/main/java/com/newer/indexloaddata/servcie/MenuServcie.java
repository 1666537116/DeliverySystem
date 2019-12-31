package com.newer.indexloaddata.servcie;

import com.newer.indexloaddata.domian.Menu;
import com.newer.indexloaddata.mapper.MenuMapper;
import com.newer.logreg.tool.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author 梁虔硕版权所有 哈哈哈哈
 * @date 2019/12/26 - 21:38
 */
public class MenuServcie {
    MenuMapper menuMapper ;
    SqlSession sqlSession;
    private  void init(){

        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
         sqlSession = sqlSessionFactory.openSession(true);
        menuMapper = sqlSession.getMapper(MenuMapper.class);
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
    //根据菜的id查询菜品信息
    public  Menu findByid(Integer menuId){
        init();
        Menu menu = menuMapper.findBymeunId(menuId);
        return menu;
    }
  //查询所有
  public  List<Menu> findAll( ){
      init();

      return menuMapper.findAll();
  }
  public Integer updataUserId(Integer userId,Integer meId){
        init();
        return menuMapper.updataBymeId(userId,meId);
  }
    public static void main(String[] args) {
        MenuServcie menuServcie = new MenuServcie();
        System.out.println(menuServcie.updataUserId(4,9));
       /*List<Menu>  list =menuServcie.pagingFindById(9,1,3);
        for (Menu menu : list) {
            System.out.println(menu);
        }*/
    }
}
