package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import DTO.VeBayDTO;

public class VeBayDAO {

	

	
	
	 public static List<VeBayDTO> docTatCaVB(){
			List<VeBayDTO> dsvb = new ArrayList<VeBayDTO>();
			try(Connection kn = MyConnect.getKn()){
				
				String sql = "select * from ve_bay";
				Statement stm = kn.createStatement();
				
				ResultSet rs = stm.executeQuery(sql);
				while(rs.next()) {
					VeBayDTO cb = new VeBayDTO();
					cb.setMave(rs.getString("ma_ve"));
	                                cb.setMachuyenbay(rs.getString("ma_chuyen_bay"));
	                                cb.setMakhachhang(rs.getString("ma_kh"));
	                                cb.setMahangve(rs.getString("ma_hang_ve"));
					dsvb.add(cb);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dsvb;
		}
	    
	    public static VeBayDTO docTheoMaVe(String mave){
			VeBayDTO vb = null;
			try(Connection kn = MyConnect.getKn()){
				
				String sql = "select * from ve_bay where ma_ve='"+mave+"'";
				Statement stm = kn.createStatement();
				
				ResultSet rs = stm.executeQuery(sql);
				if(rs.next()) {
					vb = new VeBayDTO();
					vb.setMave(rs.getString("ma_ve"));
					vb.setMachuyenbay(rs.getString("ma_chuyen_bay"));
					vb.setMakhachhang(rs.getString("ma_khach_hang"));
					vb.setMahangve(rs.getString("ma_hang_ve"));
	               
	                                
					}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return vb;
		}
	    public static List<VeBayDTO> docTheoMaChuyenBay(String machuyenbay){
			List<VeBayDTO> dsvb = new ArrayList<VeBayDTO>();
			try(Connection kn = MyConnect.getKn()){
				
				String sql = "select * from ve_bay where ma_chuyen_bay='"+machuyenbay+"'";
				Statement stm = kn.createStatement();
				
				ResultSet rs = stm.executeQuery(sql);
				while(rs.next()) {
					VeBayDTO cb = new VeBayDTO();
					cb.setMave(rs.getString("ma_ve"));
	                                cb.setMachuyenbay(rs.getString("ma_chuyen_bay"));
	                                cb.setMakhachhang(rs.getString("ma_kh"));
	                                cb.setMahangve(rs.getString("ma_hang_ve"));
	                                dsvb.add(cb);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dsvb;
		}
	    
	    public static List<VeBayDTO> docTheoMaKhachHang(String makhachhang){
			List<VeBayDTO> dsvb = new ArrayList<VeBayDTO>();
			try(Connection kn = MyConnect.getKn()){
				
				String sql = "select * from ve_bay where ma_chuyen_bay='"+makhachhang+"'";
				Statement stm = kn.createStatement();
				
				ResultSet rs = stm.executeQuery(sql);
				while(rs.next()) {
					VeBayDTO cb = new VeBayDTO();
					cb.setMave(rs.getString("ma_ve"));
	                                cb.setMachuyenbay(rs.getString("ma_chuyen_bay"));
	                                cb.setMakhachhang(rs.getString("ma_kh"));
	                                cb.setMahangve(rs.getString("ma_hang_ve"));
	                                dsvb.add(cb);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dsvb;
		}
	    
	    public static List<VeBayDTO> docTheoMaHangVe(String mahangve){
			List<VeBayDTO> dsvb = new ArrayList<VeBayDTO>();
			try(Connection kn = MyConnect.getKn()){
				
				String sql = "select * from ve_bay where ma_chuyen_bay='"+mahangve+"'";
				Statement stm = kn.createStatement();
				
				ResultSet rs = stm.executeQuery(sql);
				while(rs.next()) {
					VeBayDTO cb = new VeBayDTO();
					cb.setMave(rs.getString("ma_ve"));
	                                cb.setMachuyenbay(rs.getString("ma_chuyen_bay"));
	                                cb.setMakhachhang(rs.getString("ma_kh"));
	                                cb.setMahangve(rs.getString("ma_hang_ve"));
					dsvb.add(cb);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dsvb;
		}
	    
	   
	    
	    public int ThemVe(VeBayDTO vb) {
			
			int i=0;
			
			try(Connection kn = MyConnect.getKn()){
				
				String sql = "insert into ve_bay(ma_ve,ma_chuyen_bay,ma_kh,ma_hang_ve) values(?,?,?,?)";
	                 
				PreparedStatement pstm = kn.prepareStatement(sql);
				pstm.setString(1, vb.getMave());
				pstm.setString(2, vb.getMachuyenbay());
				pstm.setString(3, vb.getMakhachhang());
	                        pstm.setString(4, vb.getMahangve());
	                        i=pstm.executeUpdate();
	                        
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return i;
		}
	    
	public int XoaVe(String mave) {
		int i=0;
		try(Connection kn = MyConnect.getKn()){
			
			String sql = "delete from ve_bay where ma_ve = '"+mave+"'";
			
			PreparedStatement pstm = kn.prepareStatement(sql);
			i = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return i;
		
	}
	    public int XoaVeAll() {
		int i=0;
		try(Connection kn = MyConnect.getKn()){
			
			String sql = "delete from ve_bay";
			
			PreparedStatement pstm = kn.prepareStatement(sql);
			i = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return i;
		
	}

	     public int SuaVe(VeBayDTO vb) {
			
			int i=0;
			
			try(Connection kn = MyConnect.getKn()){
				
				String sql = "update ve_bay set ma_ve=?,ma_chuyen_bay=?,ma_kh=?,ma_hang_ve=?";
				
				PreparedStatement pstm = kn.prepareStatement(sql);
				pstm.setString(1, vb.getMave());
				pstm.setString(2, vb.getMachuyenbay());
				pstm.setString(3, vb.getMakhachhang());
	                        pstm.setString(4, vb.getMahangve());
	                        
				i = pstm.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return i;
		}

}
