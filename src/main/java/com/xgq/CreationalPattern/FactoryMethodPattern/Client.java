package com.xgq.CreationalPattern.FactoryMethodPattern;

/**
 * Created by xiegq on 14-11-10 下午9:54.
 * Macbook Air 2014.
 * Intellij idea 13.
 * 一个实现类对应一个工厂。
 */
public class Client {
    public static void main(String[] args) {
        LogFactory logFactory = new FileLogFactory();
        Log log = logFactory.createLog();
        log.writeLog();

        logFactory = new DatabaseLogFactory();
        log = logFactory.createLog();
        log.writeLog();
    }
}
