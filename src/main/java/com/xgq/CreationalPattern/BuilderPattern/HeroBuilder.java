package com.xgq.CreationalPattern.BuilderPattern;

/**
 * Created by xiegq on 14-11-12 下午10:04.
 * Macbook Air 2014.
 * Intellij idea 13.
 */
public class HeroBuilder extends ActorBuilder {
    @Override
    public void buildType() {
        actor.setType("英雄");
    }

    @Override
    public void buildSex() {
        actor.setSex("男");
    }

    @Override
    public void buildFace() {
        actor.setFace("英俊");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("盔甲");
    }

    @Override
    public void buildHairstyle() {
        actor.setHairstype("飘逸");
    }
}
