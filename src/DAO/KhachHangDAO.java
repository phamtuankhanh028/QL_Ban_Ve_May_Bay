
package DAO;

import DTO.KhachHangDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NguyenDinhTri
 */
public class KhachHangDAO {
    public static List<KhachHangDTO> docTatCa(){
		List<KhachHangDTO> dskh = new ArrayList<KhachHangDTO>();
		try(Connection kn = MyConnect.getKn()){
			
			String sql = "select * from khach_hang";
			Statement stm = kn.createStatement();
			
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				KhachHangDTO kh = new KhachHangDTO();
				kh.setMakhachhang(rs.getString("ma_kh"));
				kh.setHokhachhang(rs.getString("ho_kh"));
                                kh.setTenkhachhang(rs.getString("ten_kh"));
                                kh.setSodienthoai(rs.getString("sdt"));
                                kh.setGioitinh(rs.getString("gioi_tinh"));
                                kh.setCmnd(rs.getString("cmnd"));
                                kh.setNgaysinh(rs.getDate("ngay_sinh"));
                                dskh.add(kh);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dskh;
	}
    
    public int ThemKhachHang(KhachHangDTO kh) {
		
		int i=0;
		
		try(Connection kn = MyConnect.getKn()){
			
			String sql = "insert into khach_hang(ma_kh, ho_kh, ten_kh, sdt,gioi_tinh,cmnd,ngay_sinh)"
                                + " values(?,?,?,?,?,?,?)";
			
			PreparedStatement pstm = kn.prepareStatement(sql);
			pstm.setString(1, kh.getMakhachhang());
			pstm.setString(2, kh.getHokhachhang());
			pstm.setString(3, kh.getTenkhachhang());
			pstm.setString(4, kh.getSodienthoai());
			pstm.setString(5, kh.getGioitinh());
			pstm.setString(6, kh.getCmnd());
			pstm.setDate(7, kh.getNgaysinh());
                        i = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}
    
    public int XoaKhachHang(String makh) {
	int i=0;
	try(Connection kn = MyConnect.getKn()){
		
		String sql = "delete from khach_hang where ma_kh = '"+makh+"'";
		
		PreparedStatement pstm = kn.prepareStatement(sql);
		i = pstm.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return i;
	
    }
      public int SuaKhachHang(KhachHangDTO kh) {
		
		int i=0;
		
		try(Connection kn = MyConnect.getKn()){
			
			String sql = "update khach_hang set ma_kh=?,ho_kh=?,ten_kh=?,sdt=?,gioi_tinh=?,cmnd=?,ngay_sinh=?";
			
			PreparedStatement pstm = kn.prepareStatement(sql);
			pstm.setString(1, kh.getMakhachhang());
			pstm.setString(2, kh.getHokhachhang());
			pstm.setString(3, kh.getTenkhachhang());
                        pstm.setString(4, kh.getSodienthoai());
                        pstm.setString(5, kh.getGioitinh());
                        pstm.setString(6, kh.getCmnd());
                        pstm.setDate(7, kh.getNgaysinh());
                        i = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}
    
}
