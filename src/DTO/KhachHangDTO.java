package DTO;

import java.sql.Date;

/**
 *
 * @author NguyenDinhTri
 */
public class KhachHangDTO{
    String makhachhang;
    String hokhachhang;
    String tenkhachhang;
    String sodienthoai;
    String gioitinh;
    String cmnd;
    Date ngaysinh;
    public KhachHangDTO(){
        
    }

    public String getMakhachhang() {
        return makhachhang;
    }

    public void setMakhachhang(String makhachhang) {
        this.makhachhang = makhachhang;
    }

    public String getHokhachhang() {
        return hokhachhang;
    }

    public void setHokhachhang(String hokhachhang) {
        this.hokhachhang = hokhachhang;
    }

    public String getTenkhachhang() {
        return tenkhachhang;
    }

    public void setTenkhachhang(String tenkhachhang) {
        this.tenkhachhang = tenkhachhang;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }
}
