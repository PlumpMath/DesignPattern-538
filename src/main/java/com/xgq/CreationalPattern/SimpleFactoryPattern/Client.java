package com.xgq.CreationalPattern.SimpleFactoryPattern;

/**
 * Created by xiegq on 14-11-9 下午2:42.
 * Macbook Air 2014.
 * Intellij idea 13.
 * 所有的实现类在一个工厂中硬编码生成。
 */
public class Client {
    public static void main(String[] args) {
        Shape shape = ShapeFactory.createShape("circle");
        shape.draw();
        shape.erase();

        shape = ShapeFactory.createShape("triangle");
        shape.draw();
        shape.erase();

        shape = ShapeFactory.createShape("Rectangle");
        shape.draw();
        shape.erase();
    }
}
