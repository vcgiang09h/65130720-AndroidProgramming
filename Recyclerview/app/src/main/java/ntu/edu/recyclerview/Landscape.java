package ntu.edu.recyclerview;

public class Landscape {
    private String imageFileName;
    private String caption;

    // Hàm khởi tạo 2 tham số [2]
    public Landscape(String imageFileName, String caption) {
        this.imageFileName = imageFileName;
        this.caption = caption;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public String getCaption() {
        return caption;
    }
}