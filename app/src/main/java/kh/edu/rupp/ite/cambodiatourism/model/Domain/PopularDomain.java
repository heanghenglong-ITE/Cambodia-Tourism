package kh.edu.rupp.ite.cambodiatourism.model.Domain;

import com.google.gson.annotations.SerializedName;

public class PopularDomain implements java.io.Serializable {

    private int id;
    @SerializedName("image-url")
    private String imageUrl;
    private String title;
    private String location;

    public PopularDomain(int id, String imageUrl, String title, String location) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
