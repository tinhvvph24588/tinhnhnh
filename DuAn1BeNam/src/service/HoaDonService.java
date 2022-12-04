package service;

import java.util.ArrayList;
import model.ChiTietHoaDon;
import model.HoaDon;
import repository.hoaDonRepository;

public class HoaDonService {

    hoaDonRepository hdRepo;

    public HoaDonService() {
        this.hdRepo = new hoaDonRepository();
    }

    public ArrayList<HoaDon> getListHoaDon() {
        return hdRepo.getListHoaDon();
    }

    public ArrayList<HoaDon> getListHoaDonTimKiem(String mahd) {
        return hdRepo.getListHoaDonTimKiem(mahd);
    }

    public ArrayList<ChiTietHoaDon> getListChiTietHoaDon(String mahd) {
        return hdRepo.getListChiTietHoaDon(mahd);
    }

    public ArrayList<HoaDon> getListHoaDonNgayTao(String ngayBatDau, String ngayKetThuc) {
        return hdRepo.getListHoaDonNgayTao(ngayBatDau, ngayKetThuc);
    }
    
    public void updateHoaDon(HoaDon hd){
        this.hdRepo.updateHoaDon(hd);
    }
    
}
