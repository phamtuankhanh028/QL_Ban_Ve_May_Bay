package BUS;

import java.util.HashMap;

import DAO.MayBayDAO;

public class MayBayBUS {

	public HashMap<String, String> getDsmb(){
		MayBayDAO data = new MayBayDAO();
		HashMap<String, String> dsmb = data.docMap();
		return dsmb;
	}
}
