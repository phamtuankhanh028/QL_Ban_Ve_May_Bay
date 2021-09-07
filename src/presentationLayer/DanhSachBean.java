package presentationLayer;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DanhSachBean {

	private String kind;
	private JPanel jpn;
	private JLabel llb;
	public DanhSachBean() {
		super();
	}
	public DanhSachBean(String kind, JPanel jpn, JLabel llb) {
		super();
		this.kind = kind;
		this.jpn = jpn;
		this.llb = llb;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public JPanel getJpn() {
		return jpn;
	}
	public void setJpn(JPanel jpn) {
		this.jpn = jpn;
	}
	public JLabel getLlb() {
		return llb;
	}
	public void setLlb(JLabel llb) {
		this.llb = llb;
	}
	
	
}
