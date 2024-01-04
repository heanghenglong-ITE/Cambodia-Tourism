package kh.edu.rupp.ite.cambodiatourism.model.Domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DetailDomain implements Serializable {

    private int id;
    private String title;
    @SerializedName("image-url")
    private String imageUrl;
    private String placeDescription;
    private String placeDetail;
    private String location;
    private String season;
    private String showLocation;



    public DetailDomain(int id,String title, String placeDetail, String location, String season, String showLocation, String imageUrl, String placeDescription) {
        this.id = id;
        this.title = title;
        this.placeDetail = placeDetail;
        this.location = location;
        this.season = season;
        this.showLocation = showLocation;
        this.imageUrl = imageUrl;
        this.placeDescription = placeDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlaceDetail() {
        return placeDetail;
    }

    public void setPlaceDetail(String placeDetail) {
        this.placeDetail = placeDetail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getShowLocation() {
        return showLocation;
    }

    public void setShowLocation(String showLocation) {
        this.showLocation = showLocation;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPlaceDescription() {
        return placeDescription;
    }

    public void setPlaceDescription(String placeDescription) {
        this.placeDescription = placeDescription;
    }
}
