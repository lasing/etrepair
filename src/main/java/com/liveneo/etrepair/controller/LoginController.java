package com.liveneo.etrepair.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.liveneo.etrepair.common.CookieUtil;
import com.liveneo.etrepair.common.MD5Util;
import com.liveneo.etrepair.common.PropertyConfigurer;
import com.liveneo.etrepair.pojo.User;
import com.liveneo.etrepair.service.FunctionService;

@Controller
public class LoginController extends BaseController {
    //
    @Autowired
    private FunctionService functionService;
    private String          cookieNameIndex = PropertyConfigurer.getValue("cookie_username_index"); ;
    private String          cookiePwdIndex  = PropertyConfigurer.getValue("cookie_userpwd_index");  ;
    private String          cookieSepCode   = PropertyConfigurer.getValue("cookie_separate_code");
    private String          cookieName      = PropertyConfigurer.getValue("cookie_name");

    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
        if ("1".equals(request.getParameter("type"))) {
            if ("1".equals(request.getSession(true).getAttribute("type"))) {
                request.getSession().removeAttribute("type");
                Cookie[] cookies = request.getCookies();
                if (cookies != null && cookies.length > 0) {
                    for (int i = 0; i < cookies.length; i++) {
                        if (cookieName.equals(cookies[i].getName())) {
                            if (cookies[i].getValue() != null && (!"".equals(cookies[i].getValue()))) {
                                model.addAttribute("username",
                                        CookieUtil.getCooikeNameOrPwdValue(Integer.valueOf(cookieNameIndex), cookieSepCode, cookies[i].getValue()));
                                model.addAttribute("password",
                                        CookieUtil.getCooikeNameOrPwdValue(Integer.valueOf(cookiePwdIndex), cookieSepCode, cookies[i].getValue()));
                                model.addAttribute("code", request.getSession().getAttribute("code"));
                            }
                        }
                    }
                }
            } else {
                request.getSession(true).setAttribute("type", "1");
            }
        } else {
            if (request.getSession().getAttribute("type") != null) {
                request.getSession().removeAttribute("type");
            }
            Cookie[] cookies = request.getCookies();
            if (cookies != null && cookies.length > 0) {
                for (int i = 0; i < cookies.length; i++) {
                    if (cookieName.equals(cookies[i].getName())) {
                        if (cookies[i].getValue() != null && (!"".equals(cookies[i].getValue()))) {
                            model.addAttribute("username",
                                    CookieUtil.getCooikeNameOrPwdValue(Integer.valueOf(cookieNameIndex), cookieSepCode, cookies[i].getValue()));
                            model.addAttribute("password",
                                    CookieUtil.getCooikeNameOrPwdValue(Integer.valueOf(cookiePwdIndex), cookieSepCode, cookies[i].getValue()));
                            model.addAttribute("code", request.getSession().getAttribute("code"));
                        }
                    }
                }
            }
        }
        return "login";
    }

    /**
     * 首页
     * @return
     */
    @RequestMapping("/index")
    public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
        long start = new Date().getTime();
        HttpSession Session = request.getSession();
        User user = (User) Session.getAttribute("user");
        String registNo = (String) Session.getAttribute("registNo");
        Session.removeAttribute("registNo");
        String userName = "";
        String usercode = "";
        if (user != null) {
            userName = user.getUserName();
            usercode = user.getUserCode();
        }
        model.addAttribute("registNo", registNo);
        model.addAttribute("userName", userName);
        model.addAttribute("userCode", usercode);
        long end = new Date().getTime();
        System.out.println(end - start);
        return "index";
    }

    /**
     * 获取中兴 登录参数
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/getLoginParamForZTE")
    public Map<String, String> getLoginParamForZTE(HttpSession session) {
        Map<String, String> loginParams = new HashMap<String, String>();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            String userId = "admin";
            String time = DateFormatUtils.format(new Date(), "yyyyMMddHHmmss");
            String key1 = MD5Util.GetMD5Code(userId + time);
            // 操作员工号
            loginParams.put("userid", userId);
            // 工号和当前时间的MD5加密
            loginParams.put("key1", key1);
            // 当前时间
            loginParams.put("key2", time);
        }
        return loginParams;
    }

    /**
     * 校验验证码
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/validateCode", method = RequestMethod.GET)
    @ResponseBody
    public String doPost(String vCode, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        String code = (String) request.getSession().getAttribute("code");
        if (code.toLowerCase().equals(vCode.toLowerCase())) {
            return resultOK();
        } else {
            return resultError("验证码失败");
        }
    }
}
