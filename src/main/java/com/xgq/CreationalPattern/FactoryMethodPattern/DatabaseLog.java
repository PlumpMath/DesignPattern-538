package com.xgq.CreationalPattern.FactoryMethodPattern;

/**
 * Created by xiegq on 14-11-10 下午9:51.
 * Macbook Air 2014.
 * Intellij idea 13.
 */
public class DatabaseLog implements Log {

    @Override
    public void writeLog() {
        System.out.println("数据库日志记录");
    }
}
