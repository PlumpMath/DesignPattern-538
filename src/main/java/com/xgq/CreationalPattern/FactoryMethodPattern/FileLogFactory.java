package com.xgq.CreationalPattern.FactoryMethodPattern;

/**
 * Created by xiegq on 14-11-10 下午9:53.
 * Macbook Air 2014.
 * Intellij idea 13.
 */
public class FileLogFactory implements LogFactory {
    @Override
    public Log createLog() {
        return new FileLog();
    }
}
