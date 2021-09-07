package BUS;

import java.util.HashMap;

import DAO.SanBayDAO;

public class SanBayBUS {
	private SanBayDAO sbDAO = new SanBayDAO();
	public HashMap<String, String> docMapSB(){
		
		HashMap<String, String> dssb = sbDAO.docMap();
		dssb = sbDAO.docMap();
		return dssb;
	}
 }
