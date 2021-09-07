package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Data;

import DTO.ChuyenBayDTO;
import DTO.TuyenBayDTO;

public class TuyenBayDAO {

	
	
	public List<TuyenBayDTO> docTatCa(){
		List<TuyenBayDTO> dstb = new ArrayList<TuyenBayDTO>();
		try(Connection kn = MyConnect.getKn()){
			
			String sql = "select * from tuyen_bay";
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				TuyenBayDTO tb = new TuyenBayDTO();
				tb.setMaSanDen(rs.getString("ma_san_den"));
				tb.setMaSanDi(rs.getString("ma_san_di"));
				tb.setMaTuyenBay(rs.getString("ma_tuyen_bay"));
				tb.setSanBayTG1(rs.getString("san_bay_tg1"));
				tb.setSanBayTG2(rs.getString("san_bay_tg2"));
				tb.setThoiGianDung(rs.getInt("thoi_gian_dung"));
				dstb.add(tb);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dstb;
	}
	
	public int themTuyenBay(TuyenBayDTO tb) {
		int i=0;
		try(Connection kn = MyConnect.getKn()){
			
			String sql= "insert into tuyen_bay(ma_tuyen_bay,ma_san_di,ma_san_den,san_bay_tg1,san_bay_tg2,thoi_gian_dung) values(?,?,?,?,?,?)";
			PreparedStatement pstm = kn.prepareStatement(sql);
			pstm.setString(1, tb.getMaTuyenBay());
			pstm.setString(2, tb.getMaSanDi());
			pstm.setString(3, tb.getMaSanDen());
			pstm.setString(4, tb.getSanBayTG1());
			pstm.setString(5, tb.getSanBayTG2());
			pstm.setInt(6, tb.getThoiGianDung());
			i = pstm.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public TuyenBayDTO docTheoMa(String maTuyen) {
		
		TuyenBayDTO tb = null;
		try(Connection kn = MyConnect.getKn()){
			
			String sql= "select * from tuyen_bay where ma_tuyen_bay='"+maTuyen+"'";
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				tb = new TuyenBayDTO();
				tb.setMaSanDen(rs.getString("ma_san_den"));
				tb.setMaSanDi(rs.getString("ma_san_di"));
				tb.setMaTuyenBay(rs.getString("ma_tuyen_bay"));
				tb.setSanBayTG1(rs.getString("san_bay_tg1"));
				tb.setSanBayTG2(rs.getString("san_bay_tg2"));
				tb.setThoiGianDung(rs.getInt("thoi_gian_dung"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tb;
	}
	
	
	public int suaTuyenBay(TuyenBayDTO tb) {
		int i=0;
		try(Connection kn = MyConnect.getKn()){
			
			String sql="update tuyen_bay set ma_san_di=?, ma_san_den=?, san_bay_tg1=?, san_bay_tg2=?, thoi_gian_dung=? where ma_tuyen_bay=?";
			PreparedStatement pstm = kn.prepareStatement(sql);
			pstm.setString(1, tb.getMaSanDi());
			pstm.setString(2, tb.getMaSanDen());
			pstm.setString(3, tb.getSanBayTG1());
			pstm.setString(4, tb.getSanBayTG2());
			pstm.setInt(5, tb.getThoiGianDung());
			pstm.setString(6, tb.getMaTuyenBay());
			i=pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int xoaTB(String maTuyen) {
		int i=0;
		try(Connection kn = MyConnect.getKn()){
			
			String sql="delete from tuyen_bay where ma_tuyen_bay='"+maTuyen+"'";
			Statement stm = kn.createStatement();
			i = stm.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public static void main(String[] args) {
		TuyenBayDAO tbd = new TuyenBayDAO();
		
		int i = tbd.xoaTB("DB-TH");
		if(i>0) {
			System.out.println("ok");
		}
	}
}
