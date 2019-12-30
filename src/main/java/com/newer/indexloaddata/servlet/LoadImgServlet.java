package com.newer.indexloaddata.servlet;



import com.newer.indexloaddata.servcie.MenuServcie;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 梁虔硕版权所有 哈哈哈哈
 * @date 2019/11/5 - 12:49
 * 读取图片
 *    <a href="buyinfo.html?id=${v.id}"><img src="ImgServlet?id=${v.id}"
 */
@WebServlet("/LoadImgServlet")
public class LoadImgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println("图片加载开始："+df.format(new Date()));// new Date()为获取当前系统时间
        //final String  path = "D:\\tupian\\xiaofeiy\\";
       String imgpath = request.getServletContext().getRealPath("images");
        String imgpath1 =imgpath+"/" +request.getParameter("pictureurl")  ;
       // String imgpath = path+goods.getImage();


        FileInputStream fis = new FileInputStream(imgpath1);
        ServletOutputStream out = response.getOutputStream();
   int len = 0;
       byte[] by =new byte[1024];
        while ((len =fis.read(by))!=-1){
           out.write(by,0,len);
        }
     fis.close();
        out.close();
        System.out.println("图片加载结束："+df.format(new Date()));// new Date()为获取当前系统时间
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request,response);
    }
}
