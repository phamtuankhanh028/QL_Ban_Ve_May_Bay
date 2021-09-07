package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import BUS.ChuyenBayBUS;
import DTO.ChuyenBayDTO;

public class ChuyenBayDAO {

	public static List<ChuyenBayDTO> docTatCa(){
		List<ChuyenBayDTO> dscb = new ArrayList<ChuyenBayDTO>();
		try(Connection kn = MyConnect.getKn()){
			
			String sql = "select * from chuyen_bay";
			Statement stm = kn.createStatement();
			
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				ChuyenBayDTO cb = new ChuyenBayDTO();
				cb.setBayDen(rs.getString("bay_den"));
				cb.setBayTu(rs.getString("bay_tu"));
				cb.setGioDen(rs.getString("gio_den"));
				cb.setGioDi(rs.getString("gio_di"));
				cb.setMaChuyenBay(rs.getString("ma_chuyen_bay"));
				cb.setMaMayBay(rs.getString("ma_mb"));
				cb.setMaTuyenBay(rs.getString("ma_tuyen_bay"));
				cb.setNgayDen(rs.getDate("ngay_den"));
				cb.setNgayDi(rs.getDate("ngay_di"));
				cb.setSgh1cl(rs.getInt("sgh1cl"));
				cb.setSgh2cl(rs.getInt("sgh2cl"));
				cb.setSoGioBay(rs.getInt("so_gio_bay"));
				dscb.add(cb);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dscb;
	}
	
	public static ChuyenBayDTO docTheoMaChuyen(String macb){
		ChuyenBayDTO cb = null;
		try(Connection kn = MyConnect.getKn()){
			
			String sql = "select * from chuyen_bay where ma_chuyen_bay='"+macb+"'";
			Statement stm = kn.createStatement();
			
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()) {
				cb = new ChuyenBayDTO();
				cb.setBayDen(rs.getString("bay_den"));
				cb.setBayTu(rs.getString("bay_tu"));
				cb.setGioDen(rs.getString("gio_den"));
				cb.setGioDi(rs.getString("gio_di"));
				cb.setMaChuyenBay(rs.getString("ma_chuyen_bay"));
				cb.setMaMayBay(rs.getString("ma_mb"));
				cb.setMaTuyenBay(rs.getString("ma_tuyen_bay"));
				cb.setNgayDen(rs.getDate("ngay_den"));
				cb.setNgayDi(rs.getDate("ngay_di"));
				cb.setSgh1cl(rs.getInt("sgh1cl"));
				cb.setSgh2cl(rs.getInt("sgh2cl"));
				cb.setSoGioBay(rs.getInt("so_gio_bay"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cb;
	}
	
	
	//Hàm phục vụ cho tuyến bay
	
	
	public static List<ChuyenBayDTO> docCBTheoMT(String maTuyen){
		List<ChuyenBayDTO> dscb = new ArrayList<ChuyenBayDTO>();
		try(Connection kn = MyConnect.getKn()){
			
			String sql = "select * from chuyen_bay where ma_tuyen_bay='"+maTuyen+"'";
			Statement stm = kn.createStatement();
			
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				ChuyenBayDTO cb = new ChuyenBayDTO();
				cb.setBayDen(rs.getString("bay_den"));
				cb.setBayTu(rs.getString("bay_tu"));
				cb.setGioDen(rs.getString("gio_den"));
				cb.setGioDi(rs.getString("gio_di"));
				cb.setMaChuyenBay(rs.getString("ma_chuyen_bay"));
				cb.setMaMayBay(rs.getString("ma_mb"));
				cb.setMaTuyenBay(rs.getString("ma_tuyen_bay"));
				cb.setNgayDen(rs.getDate("ngay_den"));
				cb.setNgayDi(rs.getDate("ngay_di"));
				cb.setSgh1cl(rs.getInt("sgh1cl"));
				cb.setSgh2cl(rs.getInt("sgh2cl"));
				cb.setSoGioBay(rs.getInt("so_gio_bay"));
				dscb.add(cb);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dscb;
	}
	
	
	public static ChuyenBayDTO doc1CBTheoMT(String maTuyen){
		ChuyenBayDTO cb = null;
		try(Connection kn = MyConnect.getKn()){
			
			String sql = "select * from chuyen_bay where ma_tuyen_bay='"+maTuyen+"'";
			Statement stm = kn.createStatement();
			
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				cb = new ChuyenBayDTO();
				cb.setBayDen(rs.getString("bay_den"));
				cb.setBayTu(rs.getString("bay_tu"));
				cb.setGioDen(rs.getString("gio_den"));
				cb.setGioDi(rs.getString("gio_di"));
				cb.setMaChuyenBay(rs.getString("ma_chuyen_bay"));
				cb.setMaMayBay(rs.getString("ma_mb"));
				cb.setMaTuyenBay(rs.getString("ma_tuyen_bay"));
				cb.setNgayDen(rs.getDate("ngay_den"));
				cb.setNgayDi(rs.getDate("ngay_di"));
				cb.setSgh1cl(rs.getInt("sgh1cl"));
				cb.setSgh2cl(rs.getInt("sgh2cl"));
				cb.setSoGioBay(rs.getInt("so_gio_bay"));
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cb;
	}
	////************************************
public int ThemChuyenBay(ChuyenBayDTO cb) {
		
		int i=0;
		
		try(Connection kn = MyConnect.getKn()){
			
			String sql = "insert into chuyen_bay(ma_chuyen_bay, ngay_di, ngay_den, gio_di, gio_den, so_gio_bay, ma_tuyen_bay, ma_mb, sgh1cl, sgh2cl, bay_tu, bay_den) values(?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement pstm = kn.prepareStatement(sql);
			pstm.setString(1, cb.getMaChuyenBay());
			pstm.setDate(2, cb.getNgayDi());
			pstm.setDate(3, cb.getNgayDen());
			pstm.setString(4, cb.getGioDi());
			pstm.setString(5, cb.getGioDen());
			pstm.setInt(6, cb.getSoGioBay());
			pstm.setString(7, cb.getMaTuyenBay());
			pstm.setString(8, cb.getMaMayBay());
			pstm.setInt(9, cb.getSgh1cl());
			pstm.setInt(10, cb.getSgh2cl());
			pstm.setString(11, cb.getBayTu());
			pstm.setString(12, cb.getBayDen());
			i = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}

public int Delete(String maChuyen) {
	int i=0;
	try(Connection kn = MyConnect.getKn()){
		
		String sql = "delete from chuyen_bay where chuyen_bay.ma_chuyen_bay = '"+maChuyen+"'";
		
		PreparedStatement pstm = kn.prepareStatement(sql);
		i = pstm.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return i;
	
}

public int suaChuyenBay(ChuyenBayDTO cb) {
	
	int i=0;
	try(Connection kn = MyConnect.getKn()){
		
		String sql = "update chuyen_bay set ngay_di=?, ngay_den=?, gio_di=?, gio_den=?, so_gio_bay=?, ma_tuyen_bay=?, ma_mb=?, "
				+ "sgh1cl=?, sgh2cl=?, bay_tu=?, bay_den=? where ma_chuyen_bay=?" ;
		PreparedStatement pstm = kn.prepareStatement(sql);
		
		pstm.setDate(1, cb.getNgayDi());
		pstm.setDate(2, cb.getNgayDen());
		pstm.setString(3, cb.getGioDi());
		pstm.setString(4, cb.getGioDen());
		pstm.setInt(5, cb.getSoGioBay());
		pstm.setString(6, cb.getMaTuyenBay());
		pstm.setString(7, cb.getMaMayBay());
		pstm.setInt(8, cb.getSgh1cl());
		pstm.setInt(9, cb.getSgh2cl());
		pstm.setString(10, cb.getBayTu());
		pstm.setString(11, cb.getBayDen());
		pstm.setString(12, cb.getMaChuyenBay());
	
		i=pstm.executeUpdate();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return i;
}
	
	public static void main(String[] args) {
		ChuyenBayDTO cb = new ChuyenBayDTO();
		cb.setBayDen("abc");
		
		cb.setBayTu("axv");
		cb.setGioDen("12ls");
		cb.setGioDi("14a");
		
		Date ngayDi = new Date(2020, 2, 1);
		cb.setNgayDi(ngayDi);
		Date ngayDen = new Date(2020, 4, 8);
		cb.setNgayDen(ngayDen);
		
		
		
		
		cb.setMaMayBay("MB4");
		cb.setMaTuyenBay("CM-CT");
		
		
		cb.setSgh1cl(1);
		cb.setSgh2cl(2);
		cb.setSoGioBay(2);
		cb.setMaChuyenBay("CBCM-CT2");
		
		ChuyenBayDAO scb =  new ChuyenBayDAO();
		int i= scb.suaChuyenBay(cb);
		if(i>0) {
			System.out.println("0k");
		}else {
			
			System.out.println("no");
		}
		cb = scb.docTheoMaChuyen("ahdak");
		if(cb!=null) {
			System.out.println("ok");
		}else {
			System.out.println("null");
		}
	}
}
