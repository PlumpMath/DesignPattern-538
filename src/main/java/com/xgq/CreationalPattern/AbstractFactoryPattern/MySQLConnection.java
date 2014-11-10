package com.xgq.CreationalPattern.AbstractFactoryPattern;

/**
 * Created by xiegq on 14-11-10 下午10:03.
 * Macbook Air 2014.
 * Intellij idea 13.
 */
public class MySQLConnection implements Connection {
    @Override
    public void connect() {
        System.out.println("链接MySQL数据库");
    }
}
