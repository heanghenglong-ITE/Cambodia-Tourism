package kh.edu.rupp.ite.cambodiatourism.model.Domain;

import com.google.gson.annotations.SerializedName;

public class MoreDomain implements java.io.Serializable{
    private String title;
    @SerializedName("picpath-url")
    private String picPath;

    public MoreDomain(String title, String picPath) {
        this.title = title;
        this.picPath = picPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }
}
