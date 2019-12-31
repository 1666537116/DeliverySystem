package com.newer.indexloaddata.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newer.indexloaddata.domian.Menu;
import com.newer.indexloaddata.servcie.MenuServcie;
import com.newer.logreg.domian.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet( "/DetaServlet")
public class DetaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        response.setContentType("text/html;charset=UTF-8");

        if("loadmenu".equals(method)){
            Integer menuId = Integer.valueOf(request.getParameter("menuId"));
            Gson gson = new GsonBuilder().create();
            PrintWriter pw = response.getWriter();
            MenuServcie menuServcie = new MenuServcie();
            Menu menu = menuServcie.findByid(menuId);
            pw.print(gson.toJson(menu));
            pw.close();
        }else if ("adduserIdtomenu".equals(method)){
            MenuServcie menuServcie = new MenuServcie();
            HttpSession session =request.getSession();
            User user = (User)session.getAttribute("user");
            Integer userId= user.getUserId();
             Integer meid = Integer.valueOf(request.getParameter("meId"));
            menuServcie.updataUserId(userId,meid);
        }else if("loadmenus".equals(method)){
            PrintWriter pw = response.getWriter();
            Gson gson = new GsonBuilder().create();
            Integer meid =Integer.valueOf(request.getParameter("meid")) ;
            MenuServcie menuServcie = new MenuServcie();
            Menu menu = menuServcie.findByid(meid);
            pw.print(gson.toJson(meid));
pw.close();

        }


    }
}
