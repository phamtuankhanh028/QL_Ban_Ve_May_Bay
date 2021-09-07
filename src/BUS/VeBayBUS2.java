package BUS;

import java.util.List;

import DAO.VeBayDAO;
import DTO.VeBayDTO;

public class VeBayBUS2 {
	private VeBayDAO vbDAO = new VeBayDAO();
	public List<VeBayDTO> khanh(){
		
		List<VeBayDTO> dsvb = vbDAO.docTatCaVB();
		return dsvb;
	}
	
        public static List<VeBayDTO> dsvb;

}
