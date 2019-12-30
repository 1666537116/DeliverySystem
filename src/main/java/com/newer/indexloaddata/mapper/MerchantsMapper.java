package com.newer.indexloaddata.mapper;

import com.newer.indexloaddata.domian.Menu;
import com.newer.indexloaddata.domian.Merchants;
import com.newer.indexloaddata.tool.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 梁虔硕版权所有 哈哈哈哈
 * @date 2019/12/26 - 15:48
 */
public interface MerchantsMapper {
    //查询所有
    @Select("select * from merchants")
    List<Merchants>fiandAll();

    /**
     *
     * @param currentPage 当前页
     * @param pageSize 每页显示多少条记录
     * @return
     */
    @Select("select * from merchants limit #{currentPage}, #{pageSize}")
    List<Merchants>AdvancedQuery(@Param("currentPage") Integer currentPage,@Param("pageSize") Integer pageSize);

    //根据商家id查询信息
    @Select("select * from merchants where mid=#{merchantsId}")
    Merchants findBymerchantsId(Integer merchantsId);

}
