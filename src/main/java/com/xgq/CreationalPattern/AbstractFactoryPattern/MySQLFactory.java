package com.xgq.CreationalPattern.AbstractFactoryPattern;

/**
 * Created by xiegq on 14-11-10 下午10:24.
 * Macbook Air 2014.
 * Intellij idea 13.
 */
public class MySQLFactory implements DBFactory {
    @Override
    public Connection createConnection() {
        return new MySQLConnection();
    }

    @Override
    public Statement createStatement() {
        return new MySQLStatement();
    }
}
