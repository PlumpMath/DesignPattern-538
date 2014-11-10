package com.xgq.CreationalPattern.AbstractFactoryPattern;

/**
 * Created by xiegq on 14-11-10 下午10:08.
 * Macbook Air 2014.
 * Intellij idea 13.
 */
public class OracleStatement implements Statement {
    @Override
    public void executeStatement() {
        System.out.println("执行Oracle数据库语句");
    }
}
