package com.newer.indexloaddata.servcie;


import com.newer.indexloaddata.domian.UserAddress;
import com.newer.indexloaddata.mapper.UserAddressMapper;
import com.newer.indexloaddata.tool.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserAddressService {
    private SqlSession sqlSession;
    private UserAddressMapper userAddressMapper;

    private void init(){
        sqlSession= SqlSessionUtil.getSqlSession();
        userAddressMapper=sqlSession.getMapper(UserAddressMapper.class);
    }
    public List<UserAddress> findAll(Integer userId){
        init();
        List<UserAddress> list=userAddressMapper.findAll(userId);
        SqlSessionUtil.close(sqlSession);
        return list;
    }
    public int addAddress(UserAddress userAddress){
        init();
        int count=userAddressMapper.addAddress(userAddress);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        return count;
    }
    public int delAddress(Integer uaId){
        init();
        int count = userAddressMapper.delAddress(uaId);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        return count;

    }



}
