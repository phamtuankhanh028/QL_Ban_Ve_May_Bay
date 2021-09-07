
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import java.util.ArrayList;
import java.util.List;


public class KhachHangBUS {
    public static List<KhachHangDTO> dskh;
    static KhachHangDAO data = new KhachHangDAO();
    public KhachHangBUS(){
        
    }
    public static List<KhachHangDTO> getDskh(){
			dskh = new ArrayList<KhachHangDTO>();
			dskh = data.docTatCa();
		return dskh;
	}
    public int BUSThemKhachHang(KhachHangDTO kh){
        int i=data.ThemKhachHang(kh);
        return i;
    }
    public int BUSXoaKhachHang(String makh){
        int i=data.XoaKhachHang(makh);
        return i;
    }
    public int BUSSuaKhachHang(KhachHangDTO kh){
        int i=data.SuaKhachHang(kh);
        return i;
    }
}
