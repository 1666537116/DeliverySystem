package com.newer.indexloaddata.servlet;

import com.google.gson.Gson;

import com.newer.indexloaddata.domian.UserAddress;
import com.newer.indexloaddata.servcie.UserAddressService;
import com.newer.logreg.domian.User;
import org.apache.commons.beanutils.BeanUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet("/useraddress")
public class UserAddressServlet extends HttpServlet {
    private UserAddressService userAddressService= new UserAddressService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        PrintWriter out=resp.getWriter();

        if("show".equals(action)){
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");
            Integer userId = user.getUserId();
            List<UserAddress> list = userAddressService.findAll(userId);
            Gson gson = new Gson();
            out.print(gson.toJson(list));
            out.close();
        }else if("addAddress".equals(action)){
            //添加员工信息
            addAddress(req, resp);
        }else if("delAddress".equals(action)){
            delAddress(req,resp);
        }

    }

    private void delAddress(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String uaId=request.getParameter("uaId");
        System.out.println("-----------");
        System.out.println(uaId);
        System.out.println("-----------");
        int i=userAddressService.delAddress(Integer.parseInt(uaId));
        PrintWriter out=response.getWriter();
        out.print(1);
        out.close();
    }

    private void addAddress(HttpServletRequest request, HttpServletResponse response) throws IOException {
            UserAddress userAddress = new UserAddress();
        HttpSession session = request.getSession();
       String province = request.getParameter("province") ;
        String city = request.getParameter("city") ;
        String area = request.getParameter("area");
        String address = request.getParameter("address") ;
        String userName= request.getParameter("userName") ;
        String phone = request.getParameter("phone");
          userAddress.setPhone(phone);
          userAddress.setAddress(address);
userAddress.setArea(area);
userAddress.setUserName(userName);
userAddress.setProvince(province);
userAddress.setCity(city);
        User user = (User) session.getAttribute("user");
         Integer userId = user.getUserId();
         userAddress.setUserId(userId);
        int k =  userAddressService.addAddress(userAddress);
        PrintWriter out=response.getWriter();
        out.print(k);
        out.close();
       /* try {
           // BeanUtils.populate(userAddress, request.getParameterMap());
        BeanUtils.populate(userAddress,request.getParameterMap());
          int k =  userAddressService.addAddress(userAddress);
            PrintWriter out=response.getWriter();
            out.print(k);
            out.close();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }*/

    }

}
