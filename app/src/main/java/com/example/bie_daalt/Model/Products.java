package com.example.bie_daalt.Model;

public class Products {
    private String category, date, description, image,name, pid,price,time;
    public Products(){

    }

    public Products(String category, String date, String description, String image, String name, String pid, String price, String time) {
        this.name = name;
        this.description = description;
        this.price = price; 
        this.image = image;
        this.category = category;
        this.pid = pid;
        this.date = date;
        this.time = time;
    }

    public String getname() {
        return name;
    }

    public void setPname(String pname) {
        this.name = pname;
    }

    public String getDescription() {
        return description;
    }

    public void setDecription(String decription) {
        this.description = decription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getimage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
