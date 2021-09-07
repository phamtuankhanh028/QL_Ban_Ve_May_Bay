package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.CTHoaDonDTO;
import DTO.HoaDonDTO;

public class CTHoaDonDAO {
	public CTHoaDonDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<CTHoaDonDTO> getcthd(){
		ArrayList<CTHoaDonDTO> cthd = new ArrayList<CTHoaDonDTO>();
		try {
			String sql = "select * from ct_hoa_don ";
			Connection conn = MyConnect.getKn();
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				CTHoaDonDTO ct = new CTHoaDonDTO();
				ct.setMacthd(rs.getInt("macthd"));
				ct.setMahd(rs.getInt("ma_hoa_don"));
				ct.setMave(rs.getString("ma_ve"));
				ct.setDongia(rs.getInt("don_gia"));
				ct.setSoluong(rs.getInt("sl"));
				ct.setThanhtien(rs.getInt("thanh_tien"));
				cthd.add(ct);
			}
			conn.close();
			return cthd;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	public int themhd(CTHoaDonDTO hd) {
		int i = -1;
		try {
			String sql = "insert into ct_hoa_don (ma_hoa_don,ma_ve,don_gia,sl,thanh_tien) values (?,?,?,?,?)";
			Connection conn = MyConnect.getKn();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, hd.getMahd());
			pstm.setString(2, hd.getMave());
			pstm.setInt(3, hd.getDongia());
			pstm.setInt(4, hd.getSoluong());
			pstm.setInt(5, hd.getThanhtien());
			i = pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return i;
	}

	public int suahd(CTHoaDonDTO hd) {
		int i = -1;
		try {
			String sql = "update ct_hoa_don set ma_hoa_don =? , ma_ve = ?, don_gia	 = ? , sl =? , thanh_tien =? where   macthd =? ";
			Connection conn = MyConnect.getKn();
			PreparedStatement pstm = conn.prepareStatement(sql);

			pstm.setInt(1, hd.getMahd());
			pstm.setString(2, hd.getMave());
			pstm.setInt(3, hd.getDongia());
			pstm.setInt(4, hd.getSoluong());
			pstm.setInt(5, hd.getThanhtien());
			pstm.setInt(6, hd.getMacthd());
			i = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public int xoahd(int Macthd) {
		int i = -1;
		try {
			String sql = "DELETE FROM ct_hoa_don WHERE macthd = ?";
			Connection conn = MyConnect.getKn();
			PreparedStatement pstm = conn.prepareStatement(sql);

			pstm.setInt(1, Macthd);
			i = pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return i;
	}

	
}
