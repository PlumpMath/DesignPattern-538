package com.xgq.CreationalPattern.BuilderPattern;

/**
 * Created by xiegq on 14-11-12 下午9:27.
 * Macbook Air 2014.
 * Intellij idea 13.
 */
public abstract class ActorBuilder {
    protected Actor actor = new Actor();

    public abstract void buildType();
    public abstract void buildSex();
    public abstract void buildFace();
    public abstract void buildCostume();
    public abstract void buildHairstyle();
    public Actor createActor() {
        return actor;
    }
}
