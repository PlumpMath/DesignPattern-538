package com.xgq.CreationalPattern.AbstractFactoryPattern;

/**
 * Created by xiegq on 14-11-10 下午10:26.
 * Macbook Air 2014.
 * Intellij idea 13.
 * 一个工厂对应多个实现类的组合
 */
public class Client {
    public static void main(String[] args) {
        DBFactory factory = new OracleFactory();
        Connection connection = factory.createConnection();
        Statement statement = factory.createStatement();
        connection.connect();
        statement.executeStatement();

        factory = new MySQLFactory();
        connection = factory.createConnection();
        statement = factory.createStatement();
        connection.connect();
        statement.executeStatement();
    }
}
