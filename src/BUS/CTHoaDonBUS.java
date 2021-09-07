package BUS;

import java.util.ArrayList;

import DAO.CTHoaDonDAO;
import DAO.HoaDonDAO;
import DTO.CTHoaDonDTO;
import DTO.HoaDonDTO;

public class CTHoaDonBUS {
	public ArrayList<CTHoaDonDTO> getcthd() {
		return new CTHoaDonDAO().getcthd();
	}

	public int themhoadon(CTHoaDonDTO hd) {
		return new CTHoaDonDAO().themhd(hd);
	}

	public int suahd(CTHoaDonDTO hd) {
		return new CTHoaDonDAO().suahd(hd);
	}

	public int xoahd(int hd) {
		return new CTHoaDonDAO().xoahd(hd);
	}
}
