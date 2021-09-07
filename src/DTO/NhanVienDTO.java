package DTO;

import java.sql.Date;

public class NhanVienDTO {

	private String ma_nv;
	private String email;
	private String password;
	private String ho_nv;
	private String ten_nv;
	private Date ngay_sinh;
	private boolean gioi_tinh;
	private String que_quan;
	private String hinh;
	private int nam_vao_lam;
	
	
	public int getNam_vao_lam() {
		return nam_vao_lam;
	}
	public void setNam_vao_lam(int nam_vao_lam) {
		this.nam_vao_lam = nam_vao_lam;
	}
	public String getMa_nv() {
		return ma_nv;
	}
	public void setMa_nv(String ma_nv) {
		this.ma_nv = ma_nv;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHo_nv() {
		return ho_nv;
	}
	public void setHo_nv(String ho_nv) {
		this.ho_nv = ho_nv;
	}
	public String getTen_nv() {
		return ten_nv;
	}
	public void setTen_nv(String ten_nv) {
		this.ten_nv = ten_nv;
	}
	public Date getNgay_sinh() {
		return ngay_sinh;
	}
	public void setNgay_sinh(Date ngay_sinh) {
		this.ngay_sinh = ngay_sinh;
	}
	public boolean isGioi_tinh() {
		return gioi_tinh;
	}
	public void setGioi_tinh(boolean gioi_tinh) {
		this.gioi_tinh = gioi_tinh;
	}
	public String getQue_quan() {
		return que_quan;
	}
	public void setQue_quan(String que_quan) {
		this.que_quan = que_quan;
	}
	
	
	public String getHinh() {
		return hinh;
	}
	public void setHinh(String hinh) {
		this.hinh = hinh;
	}
	public NhanVienDTO() {
		
	}
	
}
