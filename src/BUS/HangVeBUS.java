
package BUS;

import DAO.HangVeDAO;
import DTO.HangVeDTO;
import java.util.ArrayList;
import java.util.List;


public class HangVeBUS {
    public static List<HangVeDTO> dshv;
    static HangVeDAO data = new HangVeDAO();
    
    public static List<HangVeDTO> getDshv(){
			dshv = new ArrayList<HangVeDTO>();
			dshv = data.docTatCa();
		return dshv;
	}
}
