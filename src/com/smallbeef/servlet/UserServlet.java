package com.smallbeef.servlet;

import com.smallbeef.bean.User;
import com.smallbeef.service.UserService;
import com.smallbeef.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet" ,urlPatterns = "/UserServlet")
public class UserServlet extends BaseServlet {


    private UserService us = new UserServiceImpl();

    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        boolean b = us.regist(new User(null, username, password));
        if(b){
            //注册成功，返回成功页面，重定向
            request.getRequestDispatcher("/pages/regist_success.html").forward(request,response);

        }else{
            //注册失败，返回注册页面，转发
            response.sendRedirect(request.getContextPath()+"/pages/error.html");
        }
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = us.login(new User(null, username, password));
        if(user == null){
            //登录失败,返回登录页面，转发
            System.out.println("[" + username + "]用户登录失败！跳转去登录页面login.html");
            request.getRequestDispatcher("/pages/error.html").forward(request,response);
        }else{
            //登录成功，返回成功界面 重定向
            System.out.println("[" + username +  "]用户登录成功！跳转去登录成功页面login_success.html");
            response.sendRedirect(request.getContextPath() + "/pages/login_success.html");
        }
    }
}