package com.newer.logreg.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newer.logreg.domian.Login;
import com.newer.logreg.domian.User;
import com.newer.logreg.servcie.LogRegServcie;
import sun.rmi.runtime.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 梁虔硕版权所有 哈哈哈哈
 * @date 2019/12/25 - 13:12
 * 处理登录注册请求
 */
@WebServlet("/LogRegServlet")
public class LogRegServlet extends HttpServlet {
    private LogRegServcie logRegServcie = new LogRegServcie();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String  method = req.getParameter("method");
      //  System.out.println("LogRegServlet");
        if("login".equals(method)){
            PrintWriter pw = resp.getWriter();
        //    System.out.println("登录功能");

         String yzm =  req.getParameter("yzm");
         String msg = null;
            HttpSession session = req.getSession();
            String code =(String)session.getAttribute("code");
            Login login = new Login();
            //校验验证码
            if(!code.equals(yzm)){
                msg="验证码错误!";
              //  System.out.println("验证码错误");
            }else {
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                User user = logRegServcie.islogin(username, password);

                //登录校验

                if (user != null) {
                    msg = "1";
                    System.out.println("登录成功");
                    session.setAttribute("user", user);
                    login.setUser(user);
                } else if (user == null) {
                    msg = "用户名或密码错误!";
                    System.out.println("用户名或密码错误!");

                }

            }
            login.setMsg(msg);
            Gson gson = new GsonBuilder().create();
   pw.print(gson.toJson(login));
pw.close();










        } else  if("reg".equals(method)){
            PrintWriter pw = resp.getWriter();
           //把页面拿到的数据封装成一个对象
            User user =encapsulationUser(req,resp) ;
         boolean f =   logRegServcie.isreg(user);
         String msg ="-1";
            if(f){
            msg = "1";

            }
            pw.print(msg);
            pw.close();
        }
    }

    /**
     *  把页面传过来的值封装成一个user对象
     * @param req
     * @param resp
     * @return
     */
    private User encapsulationUser(HttpServletRequest req, HttpServletResponse resp) {
     User user = new User();
        String username = req.getParameter("username");
        String password = req.getParameter("password1");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
   user.setPassword(password);
   user.setEmail(email);
   user.setPhone(phone);
   user.setUserName(username);
        return user;
    }
}
