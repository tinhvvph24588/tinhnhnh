package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.NhanVien;

public class NhanVienrepository {

    public NhanVien getNhanVienDangNhap(String maNhanVien) {
        NhanVien nv = new NhanVien();
        try {
            Connection conn = jdbcUtil.getConnection();
            String query = "Select * from NhanVien where ma = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maNhanVien);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                nv.setMa(rs.getString("Ma"));
                nv.setSdt(rs.getString("SDT"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setMatKhau(rs.getString("MatKhau"));
                return nv;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<NhanVien> getListNhanVien() {
        ArrayList<NhanVien> listNhanVien = new ArrayList<>();
        try {
            Connection conn = jdbcUtil.getConnection();
            String query = "SELECT MA FROM NhanVien ORDER BY MA ASC";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                NhanVien nv = new NhanVien();
                nv.setMa(rs.getString("MA"));
                listNhanVien.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listNhanVien;
    }
}
