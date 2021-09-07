package DTO;

public class CTHoaDonDTO {
	public int macthd;
	public int mahd;
	public String mave;
	public int dongia;
	public int soluong;
	public int thanhtien;

	public int getMacthd() {
		return macthd;
	}

	public void setMacthd(int macthd) {
		this.macthd = macthd;
	}

	public int getMahd() {
		return mahd;
	}

	public void setMahd(int mahd) {
		this.mahd = mahd;
	}

	public String getMave() {
		return mave;
	}

	public void setMave(String mave) {
		this.mave = mave;
	}

	public int getDongia() {
		return dongia;
	}

	public void setDongia(int dongia) {
		this.dongia = dongia;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public int getThanhtien() {
		return thanhtien;
	}

	public void setThanhtien(int thanhtien) {
		this.thanhtien = thanhtien;
	}

	public CTHoaDonDTO(int macthd, int mahd, String mave, int dongia, int soluong, int thanhtien) {
		super();
		this.macthd = macthd;
		this.mahd = mahd;
		this.mave = mave;
		this.dongia = dongia;
		this.soluong = soluong;
		this.thanhtien = thanhtien;
	}

	public CTHoaDonDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CTHoaDonDTO [macthd=" + macthd + ", mahd=" + mahd + ", mave=" + mave + ", dongia=" + dongia
				+ ", soluong=" + soluong + ", thanhtien=" + thanhtien + "]";
	}
}
