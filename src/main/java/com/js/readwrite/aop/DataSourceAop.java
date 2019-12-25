package com.js.readwrite.aop;

import com.js.readwrite.utils.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: JS
 * @Date: Created in 2019-7-9 10:47
 */
@Aspect
@Component
public class DataSourceAop {

    @Pointcut("!@annotation(com.js.readwrite.aop.Master) " +
            "&& (execution(* com.js.readwrite.service..*.select*(..)) " +
            "|| execution(* com.js.readwrite.service..*.get*(..)))")
    public void readPoint() {
    }

    @Pointcut("@annotation(com.js.readwrite.aop.Master) " +
            "|| execution(* com.js.readwrite.service..*.insert*(..)) " +
            "|| execution(* com.js.readwrite.service..*.add*(..)) " +
            "|| execution(* com.js.readwrite.service..*.update*(..)) " +
            "|| execution(* com.js.readwrite.service..*.edit*(..)) " +
            "|| execution(* com.js.readwrite.service..*.delete*(..)) " +
            "|| execution(* com.js.readwrite.service..*.remove*(..))")
    public void writePoint() {
    }

    @Before("readPoint()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePoint()")
    public void write() {
        DBContextHolder.master();
    }

    /**
     * 另一种写法：if...else... 判断哪些需要读从数据库，其余的走主数据库
     */
  /*  @Before("execution(* com.js.readwrite.service..*.*(..))")
    public void before(JoinPoint jp) {
        String methodName = jp.getSignature().getName();

        if (StringUtils.startsWithAny(methodName, "get", "select", "find")) {
            DBContextHolder.slave();
        } else {
            DBContextHolder.master();
        }
    }*/
}
