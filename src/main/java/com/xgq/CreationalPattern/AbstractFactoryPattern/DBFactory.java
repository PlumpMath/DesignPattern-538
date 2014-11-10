package com.xgq.CreationalPattern.AbstractFactoryPattern;

/**
 * Created by xiegq on 14-11-10 下午10:10.
 * Macbook Air 2014.
 * Intellij idea 13.
 */
public interface DBFactory {
    public Connection createConnection();
    public Statement createStatement();
}
