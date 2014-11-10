package com.xgq.CreationalPattern.AbstractFactoryPattern;

/**
 * Created by xiegq on 14-11-10 下午10:02.
 * Macbook Air 2014.
 * Intellij idea 13.
 */
public class OracleConnection implements Connection {
    @Override
    public void connect() {
        System.out.println("链接Oracle数据库");
    }
}
