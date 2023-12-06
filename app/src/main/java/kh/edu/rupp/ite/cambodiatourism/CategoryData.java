package kh.edu.rupp.ite.cambodiatourism;

public class CategoryData {
    private String dataTitle;
    private int dataImage;
    private Class<?> destinationActivityClass; // Added field for destination activity class

    public String getDataTitle() {
        return dataTitle;
    }

    public int getDataImage() {
        return dataImage;
    }

    public Class<?> getDestinationActivityClass() {
        return destinationActivityClass; // Getter for destination activity class
    }

    public CategoryData(String dataTitle, int dataImage, Class<?> destinationActivityClass) {
        this.dataTitle = dataTitle;
        this.dataImage = dataImage;
        this.destinationActivityClass = destinationActivityClass;
    }
}

