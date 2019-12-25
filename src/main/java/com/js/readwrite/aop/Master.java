package com.js.readwrite.aop;

import java.lang.annotation.*;

/**
 * @Description: 使用注解时，强制使用master主数据库
 * @Author: JS
 * @Date: Created in 2019-7-9 10:53
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Master {
}
