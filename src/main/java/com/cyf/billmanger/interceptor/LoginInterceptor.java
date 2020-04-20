package com.cyf.billmanger.interceptor;

import com.cyf.billmanger.entities.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if(user!=null){
            return true;
        }
        request.setAttribute("msg","请先完成登录");
        request.getRequestDispatcher("/login.html").forward(request,response);
        return false;
    }
}
