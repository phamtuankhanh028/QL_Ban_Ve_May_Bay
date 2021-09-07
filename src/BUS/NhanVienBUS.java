package BUS;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Data;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;

public class NhanVienBUS {

	public static final int luongTN=5000000;
	public static final int luongCB=3000000;
	public NhanVienBUS() {
		
	}
	
	
	public static NhanVienDTO getNVDN(String email, String password) {
		NhanVienDTO nv = NhanVienDAO.dangNhap(email, password);
		return nv;
	}
	
	public List<NhanVienDTO> getDsnv(){
		NhanVienDAO nvDAO = new NhanVienDAO();
		List<NhanVienDTO> dsnv = nvDAO.docTatCa();
		return dsnv;
	}
	
	public int tinhLuong(String email, String password) {
		NhanVienDTO nv = NhanVienDAO.dangNhap(email, password);
		int luong;
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		int namHienTai = Integer.parseInt(df.format(date));
		int soNamLam=namHienTai-nv.getNam_vao_lam();
		
			if((soNamLam)>=5) {
				luong=soNamLam*luongTN;
			}else {
				luong=soNamLam*luongCB;
			}
	
		return luong;
	}
	

	public int themNhanVien(NhanVienDTO nv) {
		NhanVienDAO nvDAO = new NhanVienDAO();
		int i = nvDAO.themNhanVien(nv);
		return i;
	}
	
	public int suaNhanVien(NhanVienDTO nv) {
		NhanVienDAO nvDAO = new NhanVienDAO();
		int i = nvDAO.suaNhanVien(nv);
		return i;
	}
	
	public int xoaNhanVien(String maNV) {

		NhanVienDAO nvDAO = new NhanVienDAO();
		int i = nvDAO.xoaNhanVien(maNV);
		return i;
	}
	
	
	
	public int abc(String email, String password) {
		NhanVienDAO nvDao = new NhanVienDAO();
		NhanVienDTO nv = nvDao.dangNhap(email, password);
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		int namHienTai = Integer.parseInt(df.format(date));
		int luong;
		int namVaoLam = nv.getNam_vao_lam();
		int soNamLam = namHienTai-namVaoLam;
		if((soNamLam) >=5) {
			luong=soNamLam*luongTN;
		}else {
			luong=soNamLam*luongCB;
		}
		return luong;
	}
	
	public static void main(String[] args) {
		NhanVienBUS bus = new NhanVienBUS();
		int luong =  bus.abc("phamtuankhanh@gmail.com", "khanhdct1195");
		System.out.println(luong);
	}
}
