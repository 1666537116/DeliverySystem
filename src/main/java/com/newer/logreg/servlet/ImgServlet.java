package com.newer.logreg.servlet;



import com.newer.logreg.tool.SecurityCode;
import com.newer.logreg.tool.SecurityImage;

import javax.imageio.ImageIO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 梁虔硕版权所有 哈哈哈哈
 * @date 2019/12/10 - 9:55
 */
@WebServlet("/ImgServlet")
public class ImgServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
     doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
       // InputStream in  = null;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset="+"utf-8");
        String code = SecurityCode.getSecurityCode();
        HttpSession session = request.getSession();
        session.setAttribute("code",code);
        response.setContentType("image/jpeg");
        //设置浏览器图片不要缓存
        response.setHeader("pragma","no-cache");
        //设置响应类容立即失效时间
        response.setDateHeader("Expires",0);
        ImageIO.write(SecurityImage.getImage(code),"jpeg",response.getOutputStream());
    }
}
