package com.liveneo.etrepair.common;

public class StringUtil {
    public static boolean isEmptyOrNull(String str) {
        return str == null || "".equals(str.trim());
    }
}
