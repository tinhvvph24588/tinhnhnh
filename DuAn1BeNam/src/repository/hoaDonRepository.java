package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ChiTietHoaDon;
import model.HoaDon;
import view.maDangNhap;

public class hoaDonRepository {

    public ArrayList<HoaDon> getListHoaDon() {
        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        try {
            Connection conn = jdbcUtil.getConnection();
            String query = "select (HD.Ma) as 'MaHD', HD.NgayTao,(NV.TenNV) as\n"
                    + "'TenNV', (NV.Ma) as 'MaNV',(KH.Ten) as 'TenKH',\n"
                    + "(KH.Ma) 'MaKH', HD.NgayThanhToan, \n"
                    + "HD.TrangThai, HD.DiaChi, HD.SDT,(HDCT.SoLuong *\n"
                    + "HDCT.DonGia) as 'TongTienHang',(Select GiaTri from \n"
                    + "KhuyenMai as km2 inner join HoaDon as hd2 on\n"
                    + "hd2.IdKhuyenMai = km2.Id where hd2.id = HD.id) as \n"
                    + "'GiamGia' from HoaDon as HD inner join KhachHang as KH\n"
                    + "on HD.IdKhachHang = KH.Id inner join NhanVien as NV on\n"
                    + "HD.IdNhanVien = NV.Id inner join HoaDonChiTiet as HDCT \n"
                    + "on HDCT.IdHoaDon = HD.Id\n"
                    + "order by HD.Ma asc";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString("MaHD"));
                hd.setNgayTao(rs.getString("NgayTao"));
                hd.setTenNV(rs.getString("TenNV"));
                hd.setMaNV(rs.getString("MaNV"));
                hd.setTenKH(rs.getString("TenKH"));
                hd.setMaKH(rs.getString("MaKH"));
                hd.setNgayThanhToan(rs.getString("NgayThanhToan"));
                hd.setTrangThai(rs.getInt("TrangThai"));
                hd.setDiaChi(rs.getString("DiaChi"));
                hd.setSdt(rs.getString("SDT"));
                hd.setTongTienHang(rs.getDouble("TongTienHang"));
                hd.setTongTienHang(rs.getDouble("TongTienHang"));
                hd.setGiamGia(rs.getDouble("GiamGia"));
                listHoaDon.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public ArrayList<HoaDon> getListHoaDonTimKiem(String mahd) {
        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        try {
            Connection conn = jdbcUtil.getConnection();
            String query = "select (HD.Ma) as 'MaHD', HD.NgayTao,(NV.TenNV) as\n"
                    + "'TenNV', (NV.Ma) as 'MaNV',(KH.Ten) as 'TenKH',\n"
                    + "(KH.Ma) 'MaKH', HD.NgayThanhToan, \n"
                    + "HD.TrangThai, HD.DiaChi, HD.SDT,(HDCT.SoLuong *\n"
                    + "HDCT.DonGia) as 'TongTienHang',(Select GiaTri from \n"
                    + "KhuyenMai as km2 inner join HoaDon as hd2 on\n"
                    + "hd2.IdKhuyenMai = km2.Id where hd2.id = HD.id) as \n"
                    + "'GiamGia' from HoaDon as HD inner join KhachHang as KH\n"
                    + "on HD.IdKhachHang = KH.Id inner join NhanVien as NV on\n"
                    + "HD.IdNhanVien = NV.Id inner join HoaDonChiTiet as HDCT \n"
                    + "on HDCT.IdHoaDon = HD.Id where HD.Ma like ?\n"
                    + "order by HD.Ma asc";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, mahd);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString("MaHD"));
                hd.setNgayTao(rs.getString("NgayTao"));
                hd.setTenNV(rs.getString("TenNV"));
                hd.setMaNV(rs.getString("MaNV"));
                hd.setTenKH(rs.getString("TenKH"));
                hd.setMaKH(rs.getString("MaKH"));
                hd.setNgayThanhToan(rs.getString("NgayThanhToan"));
                hd.setTrangThai(rs.getInt("TrangThai"));
                hd.setDiaChi(rs.getString("DiaChi"));
                hd.setSdt(rs.getString("SDT"));
                hd.setTongTienHang(rs.getDouble("TongTienHang"));
                hd.setTongTienHang(rs.getDouble("TongTienHang"));
                hd.setGiamGia(rs.getDouble("GiamGia"));
                listHoaDon.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public ArrayList<HoaDon> getListHoaDonNgayTao(String ngayBatDau, String ngayKetThuc) {
        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        try {
            Connection conn = jdbcUtil.getConnection();
            String query = "select (HD.Ma) as 'MaHD', HD.NgayTao,(NV.TenNV) as \n"
                    + "'TenNV', (NV.Ma) as 'MaNV',(KH.Ten) as 'TenKH', \n"
                    + "(KH.Ma) 'MaKH', HD.NgayThanhToan, \n"
                    + "HD.TrangThai, HD.DiaChi, HD.SDT,(HDCT.SoLuong * \n"
                    + "HDCT.DonGia) as 'TongTienHang',(Select GiaTri from \n"
                    + "KhuyenMai as km2 inner join HoaDon as hd2 on \n"
                    + "hd2.IdKhuyenMai = km2.Id where hd2.id = HD.id) as \n"
                    + "'GiamGia' from HoaDon as HD inner join KhachHang as KH \n"
                    + "on HD.IdKhachHang = KH.Id inner join NhanVien as NV on \n"
                    + "HD.IdNhanVien = NV.Id inner join HoaDonChiTiet as HDCT \n"
                    + "on HDCT.IdHoaDon = HD.Id WHERE HD.NgayTao BETWEEN ? AND ? \n"
                    + "order by HD.Ma asc";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, ngayBatDau);
            ps.setString(2, ngayKetThuc);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString("MaHD"));
                hd.setNgayTao(rs.getString("NgayTao"));
                hd.setTenNV(rs.getString("TenNV"));
                hd.setMaNV(rs.getString("MaNV"));
                hd.setTenKH(rs.getString("TenKH"));
                hd.setMaKH(rs.getString("MaKH"));
                hd.setNgayThanhToan(rs.getString("NgayThanhToan"));
                hd.setTrangThai(rs.getInt("TrangThai"));
                hd.setDiaChi(rs.getString("DiaChi"));
                hd.setSdt(rs.getString("SDT"));
                hd.setTongTienHang(rs.getDouble("TongTienHang"));
                hd.setTongTienHang(rs.getDouble("TongTienHang"));
                hd.setGiamGia(rs.getDouble("GiamGia"));
                listHoaDon.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public ArrayList<ChiTietHoaDon> getListChiTietHoaDon(String mahd) {
        ArrayList<ChiTietHoaDon> listChiTietHoaDon = new ArrayList<>();
        try {
            Connection conn = jdbcUtil.getConnection();
            String query = "select (HD.Ma) as 'MaHD',(S.Ma) as 'MaSach',"
                    + "S.Ten,HDCT.SoLuong,\n"
                    + "HDCT.DonGia,(HDCT.SoLuong * HDCT.DonGia) as 'ThanhTien'\n"
                    + "from HoaDonChiTiet as HDCT \n"
                    + "inner join Sach as S on HDCT.IdSach = S.Id\n"
                    + "inner join HoaDon as HD on HDCT.IdHoaDon = HD.Id\n"
                    + "where HD.Ma = ? order by HD.Ma asc";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, mahd);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                cthd.setMaHoaDon(rs.getString("MaHD"));
                cthd.setMaSach(rs.getString("MaSach"));
                cthd.setTenSach(rs.getString("Ten"));
                cthd.setSoLuong(rs.getInt("SoLuong"));
                cthd.setDonGia(rs.getDouble("DonGia"));
                cthd.setThanhTien(rs.getDouble("ThanhTien"));
                listChiTietHoaDon.add(cthd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listChiTietHoaDon;
    }

    public void updateHoaDon(HoaDon hd) {
        try {
            Connection conn = jdbcUtil.getConnection();
            String query = "UPDATE HoaDon SET IdKhachHang = \n"
                    + "	(SELECT ID FROM KhachHang WHERE KhachHang.Ma = ?), \n"
                    + "	IdNhanVien = (SELECT ID FROM NhanVien "
                    + "WHERE NhanVien.Ma = ?), \n"
                    + "	DiaChi = ?, Sdt = ? WHERE HoaDon.Ma = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, hd.getMaKH());
            ps.setString(2, hd.getMaNV());
            ps.setString(3, hd.getDiaChi());
            ps.setString(4, hd.getSdt());
            ps.setString(5, hd.getMaHD());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
