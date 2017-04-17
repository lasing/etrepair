package com.liveneo.etrepair.auth;

import java.util.Collection;
import java.util.Iterator;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class MyAccessDescisionManager implements AccessDecisionManager {
    /**
     * @description 认证用户是否具有权限访问该url地址
     * 
     */
    @Override
    public void decide(Authentication authentication, Object obj, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException,
            InsufficientAuthenticationException {
        if (configAttributes == null) {
            return;
        }
        Iterator<ConfigAttribute> it = configAttributes.iterator();
        while (it.hasNext()) {
            String needRole = it.next().getAttribute();
            // authentication.getAuthorities() 用户所有的权限
            for (GrantedAuthority ga : authentication.getAuthorities()) {
                if (needRole.equals(ga.getAuthority())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("--------MyAccessDescisionManager：decide-------权限认证失败！");
    }

    /**
     * 启动时候被AbstractSecurityInterceptor调用，
     * 决定AccessDecisionManager是否可以执行传递ConfigAttribute。
     */
    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    /**
     * 被安全拦截器实现调用，包含安全拦截器将显示的AccessDecisionManager支持安全对象的类型
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
