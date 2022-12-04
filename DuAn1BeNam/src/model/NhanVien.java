package model;

public class NhanVien {
    private String ma;
    private String sdt;
    private String diaChi;
    private String tenNV;
    private String matKhau;

    public NhanVien() {
    }

    public NhanVien(String ma, String sdt, String diaChi, String tenNV, String matKhau) {
        this.ma = ma;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.tenNV = tenNV;
        this.matKhau = matKhau;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    
    
}
