package kh.edu.rupp.ite.cambodiatourism.Data;

public class CampsData {
    private int id;
    private String imageUrl;
    private String title;
    private String location;

    public CampsData(int id, String imageUrl, String title, String location) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }
}

