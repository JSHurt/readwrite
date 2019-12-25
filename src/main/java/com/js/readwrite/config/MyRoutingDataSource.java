package com.js.readwrite.config;

import com.js.readwrite.utils.DBContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.validation.constraints.NotNull;

/**
 * @Description:
 * @Author: JS
 * @Date: Created in 2019-7-9 10:00
 */
public class MyRoutingDataSource extends AbstractRoutingDataSource {

    @NotNull
    @Override
    protected Object determineCurrentLookupKey() {
        return DBContextHolder.get();
    }
}

