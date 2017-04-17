package com.liveneo.etrepair.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.liveneo.etrepair.common.StringUtil;
import com.liveneo.etrepair.log.LVLogger;
import com.liveneo.etrepair.pojo.User;
import com.liveneo.etrepair.service.FunctionService;

public class FunctionReadOnlyInterceptor implements HandlerInterceptor {
    LVLogger                       logger      = LVLogger.getLogger(this.getClass());
    @Autowired
    private FunctionService        functionService;
    private NamedThreadLocal<Long> threadLocal = new NamedThreadLocal<Long>("startTime");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long beginTime = System.currentTimeMillis();// 1、开始时间
        threadLocal.set(beginTime);// 线程绑定变量（该数据只有当前请求的线程可见）
        String rootPath = request.getContextPath();
        User user = new User();
        String url = request.getRequestURI();
        if (!StringUtil.isEmptyOrNull(rootPath) && !StringUtil.isEmptyOrNull(url)) {
            int index = url.indexOf(rootPath);
            String functionUrl = url.substring(index + rootPath.length() + 1, url.length());
            user = (User) request.getSession(true).getAttribute("user");
            if (user != null && !functionUrl.equals("index")) {
                // 判断URL是否在菜单中配置
                // 判断是否可读
                boolean isReadOnly = this.functionService.isFunctionReadonly(user.getUserId(), functionUrl);
                request.setAttribute("isReadOnly", isReadOnly);
                logger.info(user.getUserName() + " 请求  " + url + " 的 只读权限为" + isReadOnly);
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long endTime = System.currentTimeMillis();
        long startTime = threadLocal.get();// 得到线程绑定的局部变量（开始时间）
        long consumeTime = endTime - startTime;// 请求消耗的时间
        System.out.println("请求消耗的时间：" + consumeTime + " 毫秒");
    }
}
