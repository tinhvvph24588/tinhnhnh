package model;

public class HoaDon {

    private String maHD;
    private String ngayTao;
    private String tenNV;
    private String maNV;
    private String tenKH;
    private String maKH;
    private String ngayThanhToan;
    private int trangThai;
    private String diaChi;
    private String sdt;
    private double tongTienHang;
    private double giamGia;
    private double tongTienSauGiam;

    public HoaDon() {
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public HoaDon(String maHD, String maNV, String maKH, String diaChi, String sdt) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    public HoaDon(String maHD, String ngayTao, String tenNV, String maNV, String tenKH, String maKH, String ngayThanhToan, int trangThai, String diaChi, String sdt, double tongTienHang, double giamGia, double tongTienSauGiam) {
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.tenNV = tenNV;
        this.maNV = maNV;
        this.tenKH = tenKH;
        this.maKH = maKH;
        this.ngayThanhToan = ngayThanhToan;
        this.trangThai = trangThai;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.tongTienHang = tongTienHang;
        this.giamGia = giamGia;
        this.tongTienSauGiam = tongTienSauGiam;
    }

    public HoaDon(String maHD, String ngayTao, String tenNV, String tenKH, String ngayThanhToan, int trangThai, String diaChi, String sdt, double tongTienHang, double giamGia, double tongTienSauGiam) {
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.tenNV = tenNV;
        this.tenKH = tenKH;
        this.ngayThanhToan = ngayThanhToan;
        this.trangThai = trangThai;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.tongTienHang = tongTienHang;
        this.giamGia = giamGia;
        this.tongTienSauGiam = tongTienSauGiam;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public double getTongTienHang() {
        return tongTienHang;
    }

    public void setTongTienHang(double tongTienHang) {
        this.tongTienHang = tongTienHang;
    }

    public double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }

    public double getTongTienSauGiam() {
        return tongTienSauGiam;
    }

    public void setTongTienSauGiam(double tongTienSauGiam) {
        this.tongTienSauGiam = tongTienSauGiam;
    }

    public String getTrangThaiString() {
        if (this.trangThai == 0) {
            return "Đã Hủy";
        } else {
            return "Đã Thanh Toán";
        }
    }

    public double getTongTienSauGiamAuto() {
        return tongTienHang - giamGia;
    }
}
