package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import DTO.MayBayDTO;
import DTO.SanBayDTO;

public class SanBayDAO {
	
	public HashMap<String, String> docMap(){
		HashMap<String, String> dssb = new HashMap<String, String>();
		
		try(Connection kn = MyConnect.getKn()){
			String sql = "select * from san_bay";
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				SanBayDTO sb = new SanBayDTO();
				sb.setMa_sb(rs.getString("ma_sb"));
				sb.setTen_sb(rs.getString("ten_sb"));
				dssb.put(sb.getTen_sb(), sb.getMa_sb());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dssb;
	}
	
	
	
	public static void main(String[] args) {
		SanBayDAO sbd = new SanBayDAO();
		HashMap<String, String> dssb = sbd.docMap();
		System.out.println(dssb.get("Sân bay Pleiku-GL"));
	}
}
