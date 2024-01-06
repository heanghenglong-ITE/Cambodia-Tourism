package kh.edu.rupp.ite.cambodiatourism.model.Domain;

public class CategoryDomain {
    private int id;
    private String name;
    private String location;
    private String description;
    private String imageUrl;
    private String detailUrl;
    private String category;
    private String map;
    private String area;
    private String season;
    private String road;
    private String facity;
    private String fabuilding;
    private String link;


    public CategoryDomain(int id, String name, String location, String description, String imageUrl, String detailUrl, String category, String map, String area, String season, String road, String facity, String fabuilding, String link) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.description = description;
        this.imageUrl = imageUrl;
        this.detailUrl = detailUrl;
        this.category = category;
        this.map = map;
        this.area = area;
        this.season = season;
        this.road = road;
        this.facity = facity;
        this.fabuilding = fabuilding;
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getFacity() {
        return facity;
    }

    public void setFacity(String facity) {
        this.facity = facity;
    }

    public String getFabuilding() {
        return fabuilding;
    }

    public void setFabuilding(String fabuilding) {
        this.fabuilding = fabuilding;
    }

    public String getMap() {
        return map;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setMap(String map) {
        this.map = map;
    }
}
