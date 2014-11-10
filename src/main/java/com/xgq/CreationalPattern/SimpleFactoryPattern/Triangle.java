package com.xgq.CreationalPattern.SimpleFactoryPattern;

/**
 * Created by xiegq on 14-11-9 下午2:35.
 * Macbook Air 2014.
 * Intellij idea 13.
 */
public class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("画三角形");
    }

    @Override
    public void erase() {
        System.out.println("删三角形");
    }
}
