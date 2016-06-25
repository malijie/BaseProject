package com.example.administrator.myapplication;

/**
 * Created by Administrator on 2016/6/9.
 */
public class NaviInfo    {
    private int id;
    private String name;

    NaviInfo(int id,String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
