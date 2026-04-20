package thigk2.VoCongGiang;

public class DiaDiem {
    private String tenAnh;
    private String tenDiaDiem;
    private String diaChi;

    public DiaDiem(String tenAnh, String tenDiaDiem, String diaChi) {
        this.tenAnh = tenAnh;
        this.tenDiaDiem = tenDiaDiem;
        this.diaChi = diaChi;
    }

    public String getTenAnh() {
        return tenAnh;
    }

    public String getTenDiaDiem() {
        return tenDiaDiem;
    }

    public String getDiaChi() {
        return diaChi;
    }
}