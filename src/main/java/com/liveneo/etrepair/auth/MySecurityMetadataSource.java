package com.liveneo.etrepair.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;
import com.liveneo.etrepair.dao.mapper.impl.FunctionDaoImpl;
import com.liveneo.etrepair.dao.mapper.impl.RoleDaoImpl;
import com.liveneo.etrepair.pojo.Function;
import com.liveneo.etrepair.pojo.Role;

public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    private FunctionDaoImpl                                 functionDaoImpl;
    private RoleDaoImpl                                     roleDaoImpl;
    private AntPathMatcher                                  urlMatcher  = new AntPathMatcher();
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

    public MySecurityMetadataSource(FunctionDaoImpl functionDaoImpl, RoleDaoImpl roleDaoImpl) {
        this.functionDaoImpl = functionDaoImpl;
        this.roleDaoImpl = roleDaoImpl;
        loadResourceDefine();
    }

    public void loadResourceDefine() {
        if (resourceMap != null) {
            resourceMap.clear();
        } else {
            resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
        }
        // 获取角色信息
        List<Role> roles = roleDaoImpl.getAllRoles();
        for (Role role : roles) {
            {
                Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
                ConfigAttribute ca = new SecurityConfig(role.getRoleCode());
                String url = "**/index";
                if (resourceMap.containsKey(url)) {
                    Collection<ConfigAttribute> value = resourceMap.get(url);
                    value.add(ca);
                    resourceMap.put(url, value);
                } else {
                    atts.add(ca);
                    resourceMap.put(url, atts);
                }
            }
            // 根据角id获取资源信息
            List<Function> functions = functionDaoImpl.getFunctionByRoleId(role.getRoleId());
            for (Function function : functions) {
                ConfigAttribute ca = new SecurityConfig(role.getRoleCode());
                String url = function.getFunctionUrl();
                url = handleUrl(url);// 转换url
                if (url == null) {
                    continue;
                }
                if (resourceMap.containsKey(url)) {
                    Collection<ConfigAttribute> value = resourceMap.get(url);
                    value.add(ca);
                    resourceMap.put(url, value);
                } else {
                    Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
                    atts.add(ca);
                    resourceMap.put(url, atts);
                }
            }
        }
    }

    public Collection<ConfigAttribute> getAttributes(Object object) {
        String url = ((FilterInvocation) object).getFullRequestUrl();
        Iterator<String> iterator = resourceMap.keySet().iterator();
        while (iterator.hasNext()) {
            String resUrl = iterator.next();
            if (urlMatcher.match(resUrl, url)) {
                return resourceMap.get(resUrl);
            }
        }
        return null;
    }

    public String handleUrl(String url) {
        if (url.equals("")) {
            return null;
        } else if (url.startsWith("/")) {
            return "**" + url;
        } else {
            return "**/" + url;
        }
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }
}
