package com.xgq.CreationalPattern.BuilderPattern;

/**
 * Created by xiegq on 14-11-12 下午10:04.
 * Macbook Air 2014.
 * Intellij idea 13.
 */
public class GhostBuilder extends ActorBuilder {
    @Override
    public void buildType() {
        actor.setType("魔鬼");
    }

    @Override
    public void buildSex() {
        actor.setSex("妖");
    }

    @Override
    public void buildFace() {
        actor.setFace("丑陋");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("黑衣");
    }

    @Override
    public void buildHairstyle() {
        actor.setHairstype("光头");
    }
}
