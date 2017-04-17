package com.liveneo.etrepair.common;

import java.io.IOException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    public static void cleanCookie(HttpServletRequest request, HttpServletResponse response, String appId) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().contains("" + appId)) {
                String cookieName = cookie.getName();
                Cookie newCookie = new Cookie(cookieName, null);
                newCookie.setPath("/dispatch/");
                response.addCookie(newCookie);
            }
        }
    }

    public static String buildCooikeValue(int nameIndex, int pwdIndex, int length, String userName, String password, String seprCode) {
        StringBuilder returnStr = new StringBuilder();
        for (int i = 0; i < length; i++) {
            try {
                if (nameIndex == i) {// 用户名的处理
                    returnStr.append(DesUtil.encrypt(userName, PropertyConfigurer.getValue("cookie_key")));
                } else if (pwdIndex == i) {// 密码的处理
                    returnStr.append(DesUtil.encrypt(password, PropertyConfigurer.getValue("cookie_key")));
                } else {// 其他的处理
                    returnStr.append(DesUtil.encrypt(RandomStringUtil.getRandomString(password.length()), PropertyConfigurer.getValue("cookie_key")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (i != length - 1) {// 非结尾的处理
                returnStr.append(seprCode);
            }
        }
        return returnStr.toString();
    }

    public static String getCooikeNameOrPwdValue(int nameIndex, String seprCode, String cookieValue) {
        String[] splitStrs = cookieValue.split(seprCode);
        String returnStr = "";
        try {
            returnStr = DesUtil.decrypt(splitStrs[nameIndex], PropertyConfigurer.getValue("cookie_key"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return returnStr;
    }

    public static void main(String[] args) {
        String str = "kZMTqi074Xc=&Tb+vfEe/4/U=&lGLFIyxf4tw=&nQdI/rL3HTWbqKWYfQrM5Q==&6HhUbmo5zeI=&KLaUOTz5DL0=&5IEV48c+hF0=&q09DHTuL3Po=&Ym3l9nrwAKQ=&rkrvJfSstxU=";
        System.out.println(getCooikeNameOrPwdValue(3, "&", str));
        System.out.println(getCooikeNameOrPwdValue(6, "&", str));
    }
}
