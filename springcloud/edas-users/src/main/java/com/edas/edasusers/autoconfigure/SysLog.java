package com.edas.edasusers.autoconfigure;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    boolean isLog() default true;

}
