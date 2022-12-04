package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.MaKhachHang;

public class KhachHangRepository {

    public ArrayList<MaKhachHang> getListKhachHang() {
        ArrayList<MaKhachHang> listKhachHang = new ArrayList<>();
        try {
            Connection conn = jdbcUtil.getConnection();
            String query = "SELECT MA FROM KhachHang ORDER BY MA ASC";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                MaKhachHang kh = new MaKhachHang();
                kh.setMa(rs.getString("MA"));
                listKhachHang.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listKhachHang;
    }
}
