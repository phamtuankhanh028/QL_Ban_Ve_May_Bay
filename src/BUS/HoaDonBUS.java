package BUS;

import java.util.ArrayList;

import DAO.HoaDonDAO;
import DTO.HoaDonDTO;

public class HoaDonBUS {
	public ArrayList<HoaDonDTO> gethoadon() {
		return new HoaDonDAO().gethoadon();

	}
	
	public int themhoadon(HoaDonDTO hd) {
		return new HoaDonDAO().themhd(hd); 
	}
	public int suahd(HoaDonDTO hd) {
		return new HoaDonDAO().suahd(hd)  ;
	}
	public int xoahd(HoaDonDTO hd) {
		return new HoaDonDAO().xoahd(hd)  ;
	}
	
	public void updatetongtien(int mahd) {
		new HoaDonDAO().updatetongtien(mahd);
	}
}
