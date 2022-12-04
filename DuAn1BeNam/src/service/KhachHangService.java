package service;

import java.util.ArrayList;
import model.MaKhachHang;
import repository.KhachHangRepository;

public class KhachHangService {

    KhachHangRepository khRepo;

    public KhachHangService() {
        this.khRepo = new KhachHangRepository();
    }

    public ArrayList<MaKhachHang> getListKhachHang() {
        return khRepo.getListKhachHang();
    }
}
