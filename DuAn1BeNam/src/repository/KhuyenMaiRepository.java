package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.MaKhuyenMai;

public class KhuyenMaiRepository {

    public ArrayList<MaKhuyenMai> getListKhuyenMai() {
        ArrayList<MaKhuyenMai> listKhuyenMai = new ArrayList<>();
        try {
            Connection conn = jdbcUtil.getConnection();
            String query = "SELECT MA FROM KhuyenMai ORDER BY MA ASC";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                MaKhuyenMai km = new MaKhuyenMai();
                km.setMa(rs.getString("MA"));
                listKhuyenMai.add(km);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listKhuyenMai;
    }
}
