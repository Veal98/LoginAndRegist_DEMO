package com.smallbeef.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
//    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

//    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 解决post乱码问题，设置请求的参数字符集为UTf-8
        request.setCharacterEncoding("UTF-8");
        // 获取要调用的方法
        String method = request.getParameter("method");
        System.out.println(method);
        // 通过反射找到该方法并调用
        // getDeclaredMethod(方法名，参数列表（传的是各个参数的类））
        try {
            Method declaredMethod = this.getClass().getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            // 把方法权限设大
            declaredMethod.setAccessible(true);
            // invoke(对象，参数） 执行该方法
            declaredMethod.invoke(this,request,response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
