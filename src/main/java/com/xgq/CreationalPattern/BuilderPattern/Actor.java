package com.xgq.CreationalPattern.BuilderPattern;

/**
 * Created by xiegq on 14-11-12 下午9:22.
 * Macbook Air 2014.
 * Intellij idea 13.
 */
public class Actor {
    private String type;
    private String sex;
    private String face;
    private String costume;
    private String hairstype;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getCostume() {
        return costume;
    }

    public void setCostume(String costume) {
        this.costume = costume;
    }

    public String getHairstype() {
        return hairstype;
    }

    public void setHairstype(String hairstype) {
        this.hairstype = hairstype;
    }
}
