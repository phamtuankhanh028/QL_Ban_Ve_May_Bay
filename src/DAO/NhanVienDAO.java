package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.NhanVienDTO;

public class NhanVienDAO {

	public static NhanVienDTO dangNhap(String email, String password) {
		NhanVienDTO nv = null;
		try (Connection kn = MyConnect.getKn()) {

			String sql = "select * from nhan_vien where email='" + email + "' and password='" + password + "'";
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			if (rs.next()) {
				nv = new NhanVienDTO();
				nv.setEmail(rs.getString("email"));
				nv.setGioi_tinh(rs.getBoolean("gioi_tinh"));
				nv.setHo_nv(rs.getString("ho_nv"));
				nv.setMa_nv(rs.getString("ma_nv"));
				nv.setNgay_sinh(rs.getDate("ngay_sinh"));
				nv.setPassword(rs.getString("password"));
				nv.setQue_quan(rs.getString("que_quan"));
				nv.setTen_nv(rs.getString("ten_nv"));
				nv.setHinh(rs.getString("hinh"));
				nv.setNam_vao_lam(rs.getInt("nam_vao_lam"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return nv;
	}
	
	
	public List<NhanVienDTO> docTatCa(){
		List<NhanVienDTO> dsnv = new ArrayList<NhanVienDTO>();
		
		try(Connection kn = MyConnect.getKn()){
			
			String sql="select * from nhan_vien";
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				
				NhanVienDTO nv = new NhanVienDTO();
				nv.setMa_nv(rs.getString("ma_nv"));
				nv.setEmail(rs.getString("email"));
				nv.setGioi_tinh(rs.getBoolean("gioi_tinh"));
				nv.setHinh(rs.getString("hinh"));
				nv.setHo_nv(rs.getString("ho_nv"));
				nv.setNgay_sinh(rs.getDate("ngay_sinh"));
				nv.setPassword(rs.getString("password"));
				nv.setQue_quan(rs.getString("que_quan"));
				nv.setTen_nv(rs.getString("ten_nv"));
				nv.setNam_vao_lam(rs.getInt("nam_vao_lam"));
				dsnv.add(nv);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsnv;
	}
	
	
	public int themNhanVien(NhanVienDTO nv) {
		int i=0;
		
		try(Connection kn = MyConnect.getKn()){
			
			String sql="insert into nhan_vien(ma_nv,email,password,ho_nv,ten_nv,ngay_sinh,gioi_tinh,que_quan,hinh,nam_vao_lam) values (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstm = kn.prepareStatement(sql);
			pstm.setString(1, nv.getMa_nv());
			pstm.setString(2, nv.getEmail());
			pstm.setString(3, nv.getPassword());
			pstm.setString(4, nv.getHo_nv());
			pstm.setString(5, nv.getTen_nv());
			pstm.setDate(6, nv.getNgay_sinh());
			pstm.setBoolean(7, nv.isGioi_tinh());
			pstm.setString(8, nv.getQue_quan());
			pstm.setString(9, nv.getHinh());
			pstm.setInt(10, nv.getNam_vao_lam());
			i=pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}
	
	public int suaNhanVien(NhanVienDTO nv) {
		
		int i=0;
		try(Connection kn = MyConnect.getKn()){
			
			String sql="update nhan_vien set email=?, password=?, ho_nv=?, ten_nv=?, ngay_sinh=?, gioi_tinh=?, que_quan=?, hinh=?, nam_vao_lam=? where ma_nv=?";
			PreparedStatement pstm = kn.prepareStatement(sql);
			pstm.setString(1, nv.getEmail());
			pstm.setString(2, nv.getPassword());
			pstm.setString(3, nv.getHo_nv());
			pstm.setString(4, nv.getTen_nv());
			pstm.setDate(5, nv.getNgay_sinh());
			pstm.setBoolean(6, nv.isGioi_tinh());
			pstm.setString(7, nv.getQue_quan());
			pstm.setString(8, nv.getHinh());
			pstm.setInt(9, nv.getNam_vao_lam());
			pstm.setString(10, nv.getMa_nv());
			i=pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int xoaNhanVien(String maNV) {
		int i=0;
		try(Connection kn = MyConnect.getKn()){
			
			String sql="delete from nhan_vien where ma_nv='"+maNV+"'";
			Statement stm = kn.createStatement();
			 i = stm.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
}
