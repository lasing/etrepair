package com.liveneo.etrepair.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import com.liveneo.etrepair.common.Constant;
import com.liveneo.etrepair.common.CookieUtil;
import com.liveneo.etrepair.dao.mapper.impl.UserDaoImpl;
import com.liveneo.etrepair.log.Opertorlog;
import com.liveneo.etrepair.pojo.User;

@Component(value = "myAuthenticationSuccessHandler")
public class MyAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private UserDaoImpl userDaoImpl;
    @Value(value = "${login.default.target.url}")
    private String      defaultUrl;
    @Value(value = "${cookie_name}")
    private String      cookieName;
    @Value(value = "${cookie_username_index}")
    private int         cookieNameIndex;
    @Value(value = "${cookie_userpwd_index}")
    private int         cookiePwdIndex;
    @Value(value = "${cookie_separate_code}")
    private String      cookieSepCode;

    /**
     * 用户登录成功后保存session
     */
    @Override
    @Opertorlog(name = "用户登录", functionPath = "用户登录", operateType = Constant.OPERATE_TYPE_LOGIN)
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException,
            ServletException {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        // 用户采用员工号登录
        String userName = userDetails.getUsername();
        User user = userDaoImpl.getUserByUserName(userName);
        request.getSession(true).setAttribute("user", user);
        String caseNo = request.getParameter("caseNo");
        if ("on".equals(request.getParameter("rememberPwd"))) {
            String primitivePwd = (String) request.getAttribute("primitivePwd");
            String cookieValue = CookieUtil.buildCooikeValue(cookieNameIndex, cookiePwdIndex, 10, userName, primitivePwd, cookieSepCode);
            Cookie cookie = new Cookie(cookieName, cookieValue);
            cookie.setMaxAge(15 * 24 * 60 * 60);
            response.addCookie(cookie);
        } else {
            Cookie cookie = new Cookie(cookieName, "");
            response.addCookie(cookie);
        }
        if (caseNo != null && (!"".equals(caseNo))) {
            request.getSession(true).setAttribute("registNo", caseNo);//
        }
        super.setDefaultTargetUrl(defaultUrl);
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
