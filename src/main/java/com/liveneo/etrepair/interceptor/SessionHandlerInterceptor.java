package com.liveneo.etrepair.interceptor;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionHandlerInterceptor extends HandlerInterceptorAdapter {
    private List<String> allowUrls;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // if (request.getHeader("x-requested-with") != null&&
        // request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest"))
        if (request.getSession(true).getAttribute("user") == null) {
            response.setHeader("sessionstatus", "timeout");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("********************session检查请求***************");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("********************session检查完成***************");
    }

    public List<String> getAllowUrls() {
        return allowUrls;
    }

    public void setAllowUrls(List<String> allowUrls) {
        this.allowUrls = allowUrls;
    }
}
