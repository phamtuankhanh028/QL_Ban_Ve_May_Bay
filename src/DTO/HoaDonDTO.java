package DTO;

import java.sql.Date;

public class HoaDonDTO {
	public int mahd ;
	public String makh;
	public String manv;
	public int tongtien ;
	public Date ngaylap;
	
	public int getMahd() {
		return mahd;
	}
	public void setMahd(int mahd) {
		this.mahd = mahd;
	}
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public int getTongtien() {
		return tongtien;
	}
	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}
	public Date getNgaylap() {
		return ngaylap;
	}
	public void setNgaylap(Date ngaylap) {
		this.ngaylap = ngaylap;
	}
	@Override
	public String toString() {
		return "HoaDonDTO [mahd=" + mahd + ", makh=" + makh + ", manv=" + manv + ", tongtien=" + tongtien + ", ngaylap="
				+ ngaylap + "]";
	}
	
}
