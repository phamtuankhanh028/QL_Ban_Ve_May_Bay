package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.HoaDonDTO;
import DTO.NhanVienDTO;

public class HoaDonDAO {
	public ArrayList gethoadon() {
		ArrayList list = new ArrayList<HoaDonDTO>();
		try {
			Connection conn = MyConnect.getKn();
			String sql = "select * from hoa_don";
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				HoaDonDTO hd = new HoaDonDTO();
				hd.setMahd(rs.getInt("ma_hoa_don"));
				hd.setMakh(rs.getString("ma_kh"));
				hd.setManv(rs.getString("ma_nv"));
				hd.setTongtien(rs.getInt("tong_tien"));
				hd.setNgaylap(rs.getDate("ngay_lap"));

				list.add(hd);
				System.out.println(hd);
			}
			conn.close();
			return list;

		} catch (Exception e) {
			System.out.println("Loi o gethoadon DAO");
		}

		return null;
	}

	public int themhd(HoaDonDTO hd) {
		int i = -1;
		try {
			String sql = "insert into hoa_don (ma_hoa_don,ma_kh,ma_nv,tong_tien,ngay_lap) values (?,?,?,?,?)";
			Connection conn = MyConnect.getKn();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, hd.getMahd());
			pstm.setString(2, hd.getMakh());
			pstm.setString(3, hd.getManv());
			pstm.setInt(4, hd.getTongtien());
			pstm.setDate(5, hd.getNgaylap());
			i = pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return i;
	}

	public int suahd(HoaDonDTO hd) {
		int i = -1;
		try {
			String sql = "update hoa_don set ma_kh =? , ma_nv = ?, tong_tien = ? , ngay_lap =? where   ma_hoa_don =? ";
			Connection conn = MyConnect.getKn();
			PreparedStatement pstm = conn.prepareStatement(sql);

			pstm.setString(1, hd.getMakh());
			pstm.setString(2, hd.getManv());
			pstm.setInt(3, hd.getTongtien());
			pstm.setDate(4, hd.getNgaylap());
			pstm.setInt(5, hd.getMahd());
			i = pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return i;
	}
	public void updatetongtien(int mahd) {
		try {
			int tongtien = 0 ;
			String sql = "SELECT SUM(thanh_tien) as tongtien FROM ct_hoa_don WHERE ma_hoa_don = ?";
			Connection conn = MyConnect.getKn();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, mahd);
			
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				tongtien = rs.getInt("tongtien");
				    System.out.println("Tổng tiền" + tongtien);
					
					String sql2 ="UPDATE hoa_don set tong_tien = ? WHERE ma_hoa_don = ?";
					PreparedStatement pstm2 = conn.prepareStatement(sql2);
					pstm2.setInt(1, tongtien);
					pstm2.setInt(2, mahd);
					pstm2.executeUpdate();
			}
			conn.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public int xoahd(HoaDonDTO hd) {
		int i = -1;
		try {
			String sql = "DELETE FROM hoa_don WHERE ma_hoa_don = ?";
			Connection conn = MyConnect.getKn();
			PreparedStatement pstm = conn.prepareStatement(sql);

			pstm.setInt(1, hd.getMahd());
			i = pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return i;
	}
	public static NhanVienDTO getnhanvien(String manv) {
		try {
			NhanVienDTO nv = new NhanVienDTO();
			String sql = "select * from nhan_vien where ma_nv = ?";
			Connection conn = MyConnect.getKn();
			PreparedStatement ptsm = conn.prepareStatement(sql);
			ptsm.setString(1, manv);
			ResultSet rs = ptsm.executeQuery();
			if(rs.next()) {
				nv.setTen_nv(rs.getString("ten_nv"));
				nv.setMa_nv(rs.getString("ma_nv"));
			}
			return nv;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null ;
	}
	
	public static HoaDonDTO getmahoadon(int mahd) {
		HoaDonDTO hd = new HoaDonDTO();
		try {
			Connection conn = MyConnect.getKn();
			String sql = "select * from hoa_don where ma_hoa_don = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, mahd);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				
				hd.setMahd(rs.getInt("ma_hoa_don"));
				hd.setMakh(rs.getString("ma_kh"));
				hd.setManv(rs.getString("ma_nv"));
				hd.setTongtien(rs.getInt("tong_tien"));
				hd.setNgaylap(rs.getDate("ngay_lap"));

				
			}
			
			conn.close();
			return hd;

		} catch (Exception e) {
			System.out.println("Loi o gethoadon DAO");
		}

		return null;
	}
	
	
	public HoaDonDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
