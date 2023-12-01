package kh.edu.rupp.ite.cambodiatourism.model.Domain;

import com.google.gson.annotations.SerializedName;

public class PopularDomain implements java.io.Serializable {

    @SerializedName("picimg-url")
    private String picImg;
    private String title;
    private String location;

    public PopularDomain(String picImg, String title, String location) {
        this.picImg = picImg;
        this.title = title;
        this.location = location;
    }

    public String getPicImg() {
        return picImg;
    }

    public void setPicImg(String picImg) {
        this.picImg = picImg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
