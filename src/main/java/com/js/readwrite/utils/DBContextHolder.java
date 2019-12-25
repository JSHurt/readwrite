package com.js.readwrite.utils;

import com.js.readwrite.Enum.DBTypeEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Author: JS
 * @Date: Created in 2019-7-9 10:01
 */
@Slf4j
public class DBContextHolder {

    public static final ThreadLocal<DBTypeEnum> CONTEXT_HOLDER = new ThreadLocal<>();

    public static final AtomicInteger COUNTER = new AtomicInteger(-1);

    public static void set(DBTypeEnum typeEnum) {
        CONTEXT_HOLDER.set(typeEnum);
    }

    public static DBTypeEnum get() {
        return CONTEXT_HOLDER.get();
    }

    public static void master() {
        set(DBTypeEnum.MASTER);
        System.out.println("切换到主数据库，执行增、删、改操作");
        log.info("切换到主数据库，执行增、删、改操作");
    }

    public static void slave() {
        int index = COUNTER.getAndIncrement() % 2;

        if (COUNTER.get() > 9999) {
            COUNTER.set(-1);
        }

        if (index == 0) {
            set(DBTypeEnum.SLAVE1);
            System.out.println("切换到从数据库，执行查询操作");
            log.info("切换到从数据库，执行查询操作");
        } else {
            set(DBTypeEnum.SLAVE2);
            System.out.println("切换到从数据库，执行查询操作");
            log.info("切换到从数据库，执行查询操作");
        }

    }


}
