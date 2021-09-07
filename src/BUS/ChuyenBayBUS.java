package BUS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import DAO.ChuyenBayDAO;
import DAO.MyConnect;
import DTO.ChuyenBayDTO;

public class ChuyenBayBUS {

	public static List<ChuyenBayDTO> dscb;
	public static List<ChuyenBayDTO> dscbtn;
	static ChuyenBayDAO data = new ChuyenBayDAO();
	public ChuyenBayBUS() {

	}

	public ChuyenBayDTO getCBTheoMa(String maCb) {
			ChuyenBayDTO cb = data.docTheoMaChuyen(maCb);
			return cb;
	}
	
	public List<ChuyenBayDTO> getDSCBTheoMaTuyen(String maTuyen) {
		List<ChuyenBayDTO> dscbtmt =data.docCBTheoMT(maTuyen);
		return dscbtmt;
}
	
	public static List<ChuyenBayDTO> getDscb(){
			dscb = new ArrayList<ChuyenBayDTO>();
			dscb = data.docTatCa();
		return dscb;
	}
	
	public List<ChuyenBayDTO> getTn(){
		dscbtn = new ArrayList<ChuyenBayDTO>();
		for (ChuyenBayDTO cb : getDscb()) {
			if(cb.getMaChuyenBay().contains("CB")) {
				dscbtn.add(cb);
			}
		}
		return dscbtn;
	}
	
	
	public List<ChuyenBayDTO> getQt(){
		dscbtn = new ArrayList<ChuyenBayDTO>();
		for (ChuyenBayDTO cb : getDscb()) {
			if(cb.getMaChuyenBay().contains("QT")) {
				dscbtn.add(cb);
			}
		}
		return dscbtn;
	}
	
	
	public List<String> getDiemDi(){
		List<ChuyenBayDTO> dd = getDscb();
		List<String> str = new ArrayList<String>();
		List<String> strTmp = new ArrayList<String>();
		for(int i=0; i< dd.size(); i++) {
			str.add(dd.get(i).getBayTu());
		}
		
		for(int j=0; j< str.size(); j++) {
			if(!strTmp.contains(str.get(j))) {
				strTmp.add(str.get(j));
			}
		}
		
		return strTmp;
	}
	
	
	
	public List<String> getDiemDen(){
		List<ChuyenBayDTO> dd = getDscb();
		List<String> str = new ArrayList<String>();
		List<String> strTmp = new ArrayList<String>();
		for(int i=0; i< dd.size(); i++) {
			str.add(dd.get(i).getBayDen());
		}
		
		for(int j=0; j< str.size(); j++) {
			if(!strTmp.contains(str.get(j))) {
				strTmp.add(str.get(j));
			}
		}
		
		return strTmp;
	}
	
	public int BUSThemChuyenBay(ChuyenBayDTO cb) {
		int i = data.ThemChuyenBay(cb);
		return i;
	}
	
	
	public static int BUSXoaChuyenBay(String mc) {
		
		int i=data.Delete(mc);
		return i;
	}
	
	public int BUSSuaChuyenBay(ChuyenBayDTO cb) {
		int i=data.suaChuyenBay(cb);
		return i;
	}
	public static void main(String[] args) {
		ChuyenBayBUS b = new ChuyenBayBUS();
		ChuyenBayDTO cb = b.getCBTheoMa("CBCM-CT");
		System.out.println(cb.getBayDen());
	}

}
