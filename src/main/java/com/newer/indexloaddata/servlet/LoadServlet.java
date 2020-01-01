package com.newer.indexloaddata.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newer.indexloaddata.domian.Menu;
import com.newer.indexloaddata.domian.Merchants;
import com.newer.indexloaddata.servcie.MenuServcie;
import com.newer.indexloaddata.servcie.MerchantsServcie;
import com.newer.indexloaddata.tool.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 梁虔硕版权所有 哈哈哈哈
 * @date 2019/12/26 - 21:53
 */
@WebServlet("/LoadServlet")
public class LoadServlet extends HttpServlet {
 private Page page = new Page();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("utf-8");
      // response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");


        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println("开始分页："+df.format(new Date()));// new Date()为获取当前系统时间

        request.setCharacterEncoding("utf-8");
        //response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String method = request.getParameter("method");
      if("menu".equals(method)){
          MenuServcie menuServcie = new MenuServcie();
          MerchantsServcie merchantsServcie = new MerchantsServcie();

          //System.out.println("查询菜的信息");
          Integer currentPage = Integer.valueOf( request.getParameter("currentPage")) ;
          Integer pageSize = Integer.valueOf( request.getParameter("pageSize")) ;
          PrintWriter pw = response.getWriter();
          Gson gson = new GsonBuilder().create();
          Integer merchantsId = Integer.valueOf(request.getParameter("merchantsId"));
          Merchants merchants = merchantsServcie.findByid(merchantsId);
          page.setMerchants(merchants);
          List<Menu> list1 = menuServcie.pagingFindById(merchantsId,currentPage,pageSize);
          List<Menu> list = menuServcie.findAll();
           Integer totalPage = null;
             if(list.size()%pageSize==0){
                 totalPage = list.size()/pageSize;
             }else{
                 totalPage = (list.size()/pageSize)+1;
             }
              page.setTotalPage(totalPage);
          page.setCurrentPage(currentPage);
          page.setPageSize(pageSize);
          page.setData(list1);
          pw.print(gson.toJson(page));

          pw.close();
          System.out.println(new Date());
      }else if("merchants".equals(method)){
         // System.out.println("查询商家的信息");
          MerchantsServcie merchantsServcie = new MerchantsServcie();
          Integer currentPage = Integer.valueOf( request.getParameter("currentPage")) ;
          Integer pageSize = Integer.valueOf( request.getParameter("pageSize")) ;
          PrintWriter pw = response.getWriter();
          Gson gson = new GsonBuilder().create();
          List<Merchants> list1 = merchantsServcie.PagingQuery(currentPage,pageSize);
          List<Merchants> list =merchantsServcie.findAll();
          page.setCurrentPage(currentPage);
          page.setPageSize(pageSize);
          page.setData(list1);
          Integer totalPage = null;
          if(list.size()%pageSize==0){
              totalPage = list.size()/pageSize;
          }else{
              totalPage = (list.size()/pageSize)+1;
          }
          page.setTotalPage(totalPage);
          pw.print(gson.toJson(page));

          pw.close();
      }else if ("destroy".equals(method)){
          HttpSession session = request.getSession();
  session.removeAttribute("user");

      }
        System.out.println("结束分页："+df.format(new Date()));// new Date()为获取当前系统时间

    }
}
