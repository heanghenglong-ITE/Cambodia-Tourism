package kh.edu.rupp.ite.cambodiatourism.Data;

public class CampsData {
    private String dataTitle;
    private String dataProvince;
    private int dataImage;
    private Class<?> destinationActivityClass; // Added field for destination activity class

    public String getDataTitle() {
        return dataTitle;
    }

    public String getDataName() {
        return dataProvince;
    }

    public int getDataImage() {
        return dataImage;
    }

    public Class<?> getDestinationActivityClass() {
        return destinationActivityClass; // Getter for destination activity class
    }

    public CampsData(String dataTitle,String dataProvince, int dataImage, Class<?> destinationActivityClass) {
        this.dataTitle = dataTitle;
        this.dataProvince = dataProvince;
        this.dataImage = dataImage;
        this.destinationActivityClass = destinationActivityClass;
    }


}
