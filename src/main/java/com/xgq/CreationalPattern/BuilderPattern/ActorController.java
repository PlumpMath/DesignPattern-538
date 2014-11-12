package com.xgq.CreationalPattern.BuilderPattern;

/**
 * Created by xiegq on 14-11-12 下午10:19.
 * Macbook Air 2014.
 * Intellij idea 13.
 */
public class ActorController {
    public Actor construct(ActorBuilder actorBuilder) {
        Actor actor = actorBuilder.createActor();
        actorBuilder.buildCostume();
        actorBuilder.buildFace();
        actorBuilder.buildHairstyle();
        actorBuilder.buildSex();
        actorBuilder.buildType();
        return actor;
    }
}
