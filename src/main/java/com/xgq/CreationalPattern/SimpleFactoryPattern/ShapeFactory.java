package com.xgq.CreationalPattern.SimpleFactoryPattern;

/**
 * Created by xiegq on 14-11-9 下午2:38.
 * Macbook Air 2014.
 * Intellij idea 13.
 */
public class ShapeFactory {
    //静态工厂方法
    public static Shape createShape(String type) {
        if (type.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (type.equalsIgnoreCase("triangle")) {
            return new Triangle();
        } else {
            return new Rectangle();
        }
    }
}
