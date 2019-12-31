package com.newer.indexloaddata.mapper;

import com.newer.indexloaddata.domian.Menu;
import org.apache.ibatis.annotations.*;

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

    //根据菜的id查询菜信息和商家信息
    @Results(value = {
            @Result(property = "meId" ,column = "me_id",id = true),
            @Result(property = "menuName" ,column = "menu_name"),
            @Result(property = "menuPrice" ,column = "menu_price"),
            @Result(property = "menuNum" ,column = "menu_num"),
            @Result(property = "comment" ,column = "comment"),
            @Result(property = "pictureurl" ,column = "pictureurl"),
/*
            @Result(property = "merchantsId" ,column = "merchants_id"),
*/
            @Result(property = "merchants" , javaType = com.newer.indexloaddata.domian.Merchants.class,
                    column = "merchants_id",
                    one = @One(select ="com.newer.indexloaddata.mapper.MerchantsMapper.findBymerchantsId")
            )
            })
    @Select("select * from menu  where me_id=#{meunId}")
    Menu findBymeunId(Integer meunId);

    //查询所有
    @Select("select * from menu ")
    List<Menu> findAll( );

    //根据用户id查询所有
    @Select("select * from menu where user_id=#{userId} ")
    List<Menu> findByUserId(Integer userId );

   //根据菜的id设置userid
    @Update("update  menu set user_id=#{userId} where me_id=#{meId}")
    Integer updataBymeId(@Param("userId") Integer userId,@Param("meId") Integer meId);

}
