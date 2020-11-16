package com.lpw.springboot02.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //设置编码格式
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        if(session.getAttribute("currentUser") == null){
            response.getWriter().print("<script>alert('您还没有登录，暂无权访问！')</script>");
            return false;
        }
        return true;
    }
}
