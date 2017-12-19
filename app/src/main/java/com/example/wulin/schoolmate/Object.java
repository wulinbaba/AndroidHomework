package com.example.wulin.schoolmate;

/**
 * Created by wulin on 2017/12/18.
 */

public class Object {
    private String name;
    private int headimageID;
    private String time;
    private String thing;
    private String price;
    private String description;
    private int pic1ID;
    private int pic2ID;
    private int pic3ID;

    public Object(String name, int headimageID,String time,String thing,String price,String description,int pic1ID,int pic2ID,int pic3ID){
        this.name = name;
        this.headimageID = headimageID;
        this.time = time;
        this.thing = thing;
        this.price = price;
        this.description = description;
        this.pic1ID = pic1ID;
        this.pic2ID = pic2ID;
        this.pic3ID = pic3ID;
    }
    public String getName(){
        return name;
    }
    public int getHeadImageID(){return headimageID;}
    public String getTime(){return time;}
    public String getThing(){return thing;}
    public String getPrice(){return price;}
    public String getDescription(){return description;}
    public int getPic1ID(){return pic1ID;}
    public int getPic2ID(){return pic2ID;}
    public int getPic3ID(){return pic3ID;}

}
