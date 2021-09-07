package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import DTO.MayBayDTO;

public class MayBayDAO {

	public HashMap<String, String> docMap(){
		HashMap<String, String> dsmb = new HashMap<String, String>();
		
		try(Connection kn = MyConnect.getKn()){
			
			String sql = "select * from may_bay";
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				MayBayDTO mb = new MayBayDTO();
				mb.setLoaiMayBay(rs.getString("loai_mb"));
				mb.setMaMayBay(rs.getString("ma_mb"));
				mb.setSoGhe1(rs.getInt("so_ghe_1"));
				mb.setSoGhe2(rs.getInt("so_ghe_2"));
				mb.setTenMaybay(rs.getString("ten_mb"));
				dsmb.put(mb.getTenMaybay(), mb.getMaMayBay());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsmb;
	}
	
	public static void main(String[] args) {
		MayBayDAO DAOmb = new MayBayDAO();
		HashMap<String, String> dsmb = DAOmb.docMap();
		System.out.println(dsmb.get("Boeing 787"));
	}
}
