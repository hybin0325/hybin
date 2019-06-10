package com.edas.edasmessage.cache.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface RedisLock {
 
    String lockPrefix() default "";
    String lockKey() default "";
    long timeOut() default 5;
    TimeUnit timeUnit() default TimeUnit.SECONDS;
}
