package com.example.administrator.mycheckdemo.entity;

/**
 * Created by Administrator on 2017/3/17.
 */

public class ExpressBean {

    private int img;
    private String name;

    public ExpressBean( String name,int img) {
        this.img = img;
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
