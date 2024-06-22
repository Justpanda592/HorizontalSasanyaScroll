package com.example.horizontalsasanyascroll;

public class ItemsModel {
    private String name;
    private String cost;
    private int image;
    private String imageString;
    private String ml;
    private String desc;
    public ItemsModel(String name, String cost, int image, String imageString, String ml, String desc) {
        this.name = name;
        this.cost = cost;
        this.image = image;
        this.imageString = imageString;
        this.ml = ml;
        this.desc = desc;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getCost(){
        return cost;
    }
    public void setCost(String cost){
        this.cost = cost;
    }
    public int getImage(){
        return image;
    }
    public void setImage(int image){
        this.image = image;
    }
    public String getImageString(){
        return imageString;
    }
    public void setImageString(String imageString){
        this.imageString = imageString;
    }
    public String getMl(){
        return ml;
    }
    public void setMl(String ml){
        this.ml = ml;
    }
    public String getDesc(){
        return desc;
    }
    public void setDesc(String desc){
        this.desc = desc;
    }
}
