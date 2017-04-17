package com.liveneo.etrepair.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import com.liveneo.etrepair.common.Constant;

@Component(value = "myAuthenticationFailureHandler")
public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Value(value = "${login.failure.target.url}")
    private String defaultFailureUrl;
    @Value(value = "${login.roles.failure.target.url}")
    private String noRolesFailureUrl;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException,
            ServletException {
        if (Constant.USER_NO_ROLES_ERROR.equals(exception.getMessage())) {// 用户角色未配置
            super.setDefaultFailureUrl(noRolesFailureUrl);
        } else {
            super.setDefaultFailureUrl(defaultFailureUrl);
        }
        super.onAuthenticationFailure(request, response, exception);
    }
}
