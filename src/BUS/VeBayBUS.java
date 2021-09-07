
package BUS;

import DAO.VeBayDAO;
import DTO.VeBayDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NguyenDinhTri
 */
public class VeBayBUS {
    
        public static List<VeBayDTO> dsvb;
	static VeBayDAO data = new VeBayDAO();
	public VeBayBUS() {

	}
    public static List<VeBayDTO> getDsvb(){
			dsvb = new ArrayList<VeBayDTO>();
			dsvb = data.docTatCaVB();
		return dsvb;
	}

    public VeBayDTO getVeBayTheoMaVe(String mavb) {
			VeBayDTO vb = data.docTheoMaVe(mavb);
			return vb;
	}
    public List<VeBayDTO> getDSVBTheoMaChuyenBay(String machuyen) {
		List<VeBayDTO> dsvbtmc =data.docTheoMaChuyenBay(machuyen);
		return dsvbtmc;
        }
    public List<VeBayDTO> getDSVBTheoMaKhachHang(String makhachhang) {
		List<VeBayDTO> dsvbtmkh =data.docTheoMaKhachHang(makhachhang);
		return dsvbtmkh;}
    public List<VeBayDTO> getDSVBTheoMaHangVe(String mahangve) {
		List<VeBayDTO> dsvbtmhv =data.docTheoMaHangVe(mahangve);
		return dsvbtmhv;
    }
  
    public int BUSThemVe(VeBayDTO mv) {
		int i = data.ThemVe(mv);
		return i;
	}
    	
    public static int BUSXoaVe(String mv) {
		
		int i=data.XoaVe(mv);
		return i;
        }
    public static int BUSXoaVeAll(){
        int i=data.XoaVeAll();
        return i;
    }
    	
    public int BUSSuaVe(VeBayDTO vb) {
		
		int i=data.SuaVe(vb);
		return i;
    }    
    	
    public List<String> getMacb(){
        List<VeBayDTO> mcb = getDsvb();
        List<String> str = new ArrayList<String>();
        for(int i=0; i< mcb.size(); i++) {
			str.add(mcb.get(i).getMachuyenbay());
		}
        
        return str;
	}
	
}
