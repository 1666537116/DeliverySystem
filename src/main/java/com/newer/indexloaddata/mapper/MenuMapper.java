package com.newer.indexloaddata.mapper;

import com.newer.indexloaddata.domian.Menu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 梁虔硕版权所有 哈哈哈哈
 * @date 2019/12/26 - 21:23
 */
public interface MenuMapper {
    //根据商家id查询所有菜
    @Select("select * from menu where merchants_id =#{merchantsId}")
    List<Menu> findById(Integer merchantsId);
    //根据商家id分页查询所有菜
    @Select("select * from menu where merchants_id =#{merchantsId} limit #{currentPage}, #{pageSize}")
    List<Menu> pagingFindById(@Param("merchantsId")Integer merchantsId , @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    //根据菜的id查询菜信息
    @Select("select * from menu where me_id=#{meunId}")
    Menu findBymeunId(Integer meunId);

    //查询所有
    @Select("select * from menu ")
    List<Menu> findAll( );

}
