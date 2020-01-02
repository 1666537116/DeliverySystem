package com.newer.indexloaddata.mapper;


import com.newer.indexloaddata.domian.UserAddress;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserAddressMapper {

    List<UserAddress> findAll(Integer userId);

    @Update(" delete from user_address where ua_id=#{uaId}")
    int delAddress(Integer auId);

    int addAddress(UserAddress userAddress);

}
