package com.newer.indexloaddata.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newer.indexloaddata.domian.Merchants;
import com.newer.indexloaddata.servcie.MerchantsServcie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 梁虔硕版权所有 哈哈哈哈
 * @date 2019/12/29 - 22:15
 */
@WebServlet("/MerchantsServlet")
public class MerchantsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println("商家信息开始："+df.format(new Date()));// new Date()为获取当前系统时间
        request.setCharacterEncoding("utf-8");
        // response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        MerchantsServcie merchantsServcie = new MerchantsServcie();
        Integer merchantsId = Integer.valueOf(request.getParameter("merchantsId"));

        Merchants merchants = merchantsServcie.findByid(merchantsId);
        Gson gson = new GsonBuilder().create();
      PrintWriter printWriter = response.getWriter();
      printWriter.print(gson.toJson(merchants));
      printWriter.close();
        System.out.println("商家信息结束1："+df.format(new Date()));// new Date()为获取当前系统时间
    }
}
