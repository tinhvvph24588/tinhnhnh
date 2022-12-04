package service;

import java.util.ArrayList;
import model.MaKhuyenMai;
import repository.KhuyenMaiRepository;

public class KhuyenMaiService {

    KhuyenMaiRepository kmRepo;

    public KhuyenMaiService() {
        this.kmRepo = new KhuyenMaiRepository();
    }

    public ArrayList<MaKhuyenMai> getListKhuyenMai() {
        return kmRepo.getListKhuyenMai();
    }
}
