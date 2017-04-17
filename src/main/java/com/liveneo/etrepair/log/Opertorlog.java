package com.liveneo.etrepair.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wujun
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Opertorlog {
    String functionPath() default "无描述信息";

    String name() default "无描述信息";

    byte operateType() default 0;
}
