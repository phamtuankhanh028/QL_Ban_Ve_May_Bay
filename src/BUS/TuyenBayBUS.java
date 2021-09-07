package BUS;

import java.util.List;

import DAO.TuyenBayDAO;
import DTO.ChuyenBayDTO;
import DTO.TuyenBayDTO;

public class TuyenBayBUS {

	public static List<TuyenBayDTO> dstb;
	
	public List<TuyenBayDTO> getDstb(){
		TuyenBayDAO tbDAO = new  TuyenBayDAO();
		dstb = tbDAO.docTatCa();
		return dstb;
	}
	
	public int themTB(TuyenBayDTO tb) {
		TuyenBayDAO tbDAO = new  TuyenBayDAO();
		int i = tbDAO.themTuyenBay(tb);
		return i;
	}
	
	public int suaTB(TuyenBayDTO tb) {
		TuyenBayDAO tbDAO = new  TuyenBayDAO();
		int i = tbDAO.suaTuyenBay(tb);
		return i;
	}
	
	public int xoaTB(String tb) {
		TuyenBayDAO tbDAO = new  TuyenBayDAO();
		int i = tbDAO.xoaTB(tb);
		return i;
	}
	
	public TuyenBayDTO getTBTheoMa(String maTuyen) {
		TuyenBayDAO tbDAO = new  TuyenBayDAO();
		TuyenBayDTO tb = tbDAO.docTheoMa(maTuyen);
		return tb;
	}
	public static void main(String[] args) {
		TuyenBayBUS tbb = new TuyenBayBUS();
		int i = tbb.xoaTB("HN-HCM");
		if(i>0) {
			System.out.println("ok");
		}
	}
}
