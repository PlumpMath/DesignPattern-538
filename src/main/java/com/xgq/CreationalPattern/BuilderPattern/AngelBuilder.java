package com.xgq.CreationalPattern.BuilderPattern;

/**
 * Created by xiegq on 14-11-12 下午10:04.
 * Macbook Air 2014.
 * Intellij idea 13.
 */
public class AngelBuilder extends ActorBuilder {
    @Override
    public void buildType() {
        actor.setType("天使");
    }

    @Override
    public void buildSex() {
        actor.setSex("女");
    }

    @Override
    public void buildFace() {
        actor.setFace("漂亮");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("白裙");
    }

    @Override
    public void buildHairstyle() {
        actor.setHairstype("长发");
    }
}
