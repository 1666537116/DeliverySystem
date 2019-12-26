package com.newer.test.logreg;

import com.newer.logreg.domian.User;
import com.newer.logreg.mapper.UserMapper;
import com.newer.logreg.servcie.LogRegServcie;
import com.newer.logreg.tool.SqlSessionFactoryUtils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 梁虔硕版权所有 哈哈哈哈
 * @date 2019/12/26 - 10:58
 */
public class LogRegTest {
    private UserMapper userMapper;
    private SqlSession sqlSession;
    private LogRegServcie logRegServcie;
    @Before
    public  void init(){
       // System.out.println("init");
        logRegServcie = new LogRegServcie();
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
          sqlSession = sqlSessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);
       // System.out.println(userMapper);
    }

    @After
    public  void  destroy(){
sqlSession.close();
    }
    /**
     * 测试 usermapper 添加查询
      */
    @Test
 public  void testAdduser(){
     User user = new User();
     user.setEmail("1666537116@qq.com");
     user.setPassword("111111");
     user.setUserName("梁虔硕");
     user.setPhone("17673370595");
      //  System.out.println( userMapper.findByUserName("梁虔硕"));
        System.out.println(userMapper.findByUserNameAndpwd("梁虔硕","111111"));
     //System.out.println( userMapper.addUser(user));
        //System.out.println(user);
 }

    /**
     * 测试LogRegServcie 登录和注册方法
     */
    @Test
    public  void  testLogReg(){
        User user = new User();
        user.setEmail("1666537116@qq.com");
        user.setPassword("111111");
        user.setUserName("梁虔硕");
        user.setPhone("17673370595");
        //logRegServcie.isreg(user);
        System.out.println( logRegServcie.islogin(user.getUserName(),user.getPassword()));

    }
}
