package kh.edu.rupp.ite.cambodiatourism.model.Domain;

public class ExploreDomain {

    private String imgPlace;
    private String placeName;
    private String desImg;

    public ExploreDomain(String imgPlace, String placeName, String desImg) {
        this.imgPlace = imgPlace;
        this.placeName = placeName;
        this.desImg = desImg;
    }

    public String getImgPlace() {
        return imgPlace;
    }

    public void setImgPlace(String imgPlace) {
        this.imgPlace = imgPlace;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getDesImg() {
        return desImg;
    }

    public void setDesImg(String desImg) {
        this.desImg = desImg;
    }
}
