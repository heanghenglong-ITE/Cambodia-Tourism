package kh.edu.rupp.ite.cambodiatourism.Domain;

import java.io.Serializable;

public class DetailDomain implements Serializable {

    private String title;
    private String placeDetail;
    private String location;
    private String season;
    private String showLocation;
    private String pic;

    public DetailDomain(String title, String placeDetail, String location, String season, String showLocation, String pic) {
        this.title = title;
        this.placeDetail = placeDetail;
        this.location = location;
        this.season = season;
        this.showLocation = showLocation;
        this.pic = pic;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
