package com.xgq.CreationalPattern.BuilderPattern;

/**
 * Created by xiegq on 14-11-12 下午10:22.
 * Macbook Air 2014.
 * Intellij idea 13.
 */
public class Client {
    public static void main(String[] args) {
        ActorController actorController = new ActorController();
        ActorBuilder actorBuilder = new AngelBuilder();
        Actor actor1 = actorController.construct(actorBuilder);
        System.out.println(actor1.getType() + "的外观：");
        System.out.println("性别：" + actor1.getSex());
        System.out.println("面容：" + actor1.getFace());
        System.out.println("服装：" + actor1.getCostume());
        System.out.println("发型：" + actor1.getHairstype());
    }
}
