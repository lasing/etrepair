package com.liveneo.etrepair.common;

import java.util.Collection;
import org.springframework.util.CollectionUtils;

public class ServiceAssert {
    public static void isNull(Object obj, String fieldName) {
        if (obj != null) {
            throw new UserReadableException(fieldName + "必须为空");
        }
    }

    public static void notNull(Object obj, String fieldName) {
        if (obj == null) {
            throw new UserReadableException(fieldName + "不能为空");
        }
    }

    public static void notEmpty(Collection<?> collection, String name) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new UserReadableException(name + "不能为空");
        }
    }

    public static void notNullWithMessage(Object obj, String message) {
        if (obj == null) {
            throw new UserReadableException(message);
        }
    }
}
