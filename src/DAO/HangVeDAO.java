
package DAO;

import DTO.HangVeDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class HangVeDAO {
       public static List<HangVeDTO> docTatCa(){
		List<HangVeDTO> dshv = new ArrayList<HangVeDTO>();
		try(Connection kn = MyConnect.getKn()){
			
			String sql = "select * from hang_ve";
			Statement stm = kn.createStatement();
			
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				HangVeDTO hv = new HangVeDTO();
				hv.setMahangve(rs.getInt("ma_hang_ve"));
                                hv.setTenhangve(rs.getString("ten_hang_ve"));
				dshv.add(hv);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dshv;
	}
}
