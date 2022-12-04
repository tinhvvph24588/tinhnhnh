package service;

import java.util.ArrayList;
import model.NhanVien;
import repository.NhanVienrepository;

public class NhanVienService {

    NhanVienrepository nvRepo;

    public NhanVienService() {
        this.nvRepo = new NhanVienrepository();
    }

    public NhanVien getNhanVienDangNhap(String maNhanVien) {
        return nvRepo.getNhanVienDangNhap(maNhanVien);
    }

    public ArrayList<NhanVien> getListNhanVien() {
        return nvRepo.getListNhanVien();
    }
}
