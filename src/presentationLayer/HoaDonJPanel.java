package presentationLayer;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.CTHoaDonBUS;
import BUS.HoaDonBUS;
import DTO.CTHoaDonDTO;
import DTO.HoaDonDTO;
import Export.XuatPDF;
import custom.MyTable;

public class HoaDonJPanel extends JPanel {
	private JLabel lblAnhBia;
	private JTextField txtMaHoaDon;
	private JTextField txtTongTien;
	private JTextField txtMaNhanVien;
	private JTextField txtNgayLap;
	private JTextField txtMaHoaDonCT;
	private JTextField txtMaVe;
	private JTextField txtSoLuong;
	private JTextField txtDonGia;
	private JTextField txtThanhTien;
	private JTable tblHD;
	private JTable tblCTHD;
	private DefaultTableModel dtmhoadon;
	private DefaultTableModel dtmcthd;
	private JTextField txtmakhachhang;
	private JTextField txtmakh;

	/**
	 * Create the panel.
	 */
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public HoaDonJPanel() {
		setLayout(new BorderLayout(0, 0));
		JPanel pnBia = new JPanel();
		pnBia.setPreferredSize(new Dimension(1220, 150));
		add(pnBia, BorderLayout.NORTH);
		pnBia.setLayout(new BorderLayout(0, 0));

		lblAnhBia = new JLabel("");
		lblAnhBia.setPreferredSize(new Dimension(1220, 150));
		lblAnhBia.setSize(1220, 150);
		ImageIcon ic = new ImageIcon("../QL_Ban_Ve_May_Bay/images/biaNV.png");
		ic.setImage(ic.getImage().getScaledInstance(lblAnhBia.getWidth(), lblAnhBia.getHeight(),
				Image.SCALE_AREA_AVERAGING));
		lblAnhBia.setIcon(ic);
		pnBia.add(lblAnhBia, BorderLayout.CENTER);

		JPanel pnTrai = new JPanel();
		pnTrai.setBackground(new Color(0, 102, 153));
		pnTrai.setPreferredSize(new Dimension(20, 0));
		add(pnTrai, BorderLayout.WEST);

		JPanel pnPhai = new JPanel();
		pnPhai.setBackground(new Color(0, 102, 153));
		pnPhai.setPreferredSize(new Dimension(20, 0));
		add(pnPhai, BorderLayout.EAST);

		JPanel pnDuoi = new JPanel();
		pnDuoi.setBackground(new Color(0, 102, 153));
		pnDuoi.setPreferredSize(new Dimension(0, 20));
		add(pnDuoi, BorderLayout.SOUTH);

		JPanel pnChinh = new JPanel();
		add(pnChinh, BorderLayout.CENTER);
		pnChinh.setLayout(new BorderLayout(0, 0));

		JPanel pnDuLieu = new JPanel();
		pnDuLieu.setBackground(new Color(240, 240, 240));
		pnDuLieu.setPreferredSize(new Dimension(0, 310));
		pnChinh.add(pnDuLieu, BorderLayout.NORTH);
		pnDuLieu.setLayout(new BorderLayout(0, 0));

		JPanel pnHoaDon = new JPanel();
		pnHoaDon.setPreferredSize(new Dimension(580, 0));
		pnDuLieu.add(pnHoaDon, BorderLayout.WEST);
		pnHoaDon.setLayout(null);

		JLabel lblNewLabel = new JLabel("Hoá Đơn");
		lblNewLabel.setForeground(new Color(210, 105, 30));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(176, 0, 192, 44);
		pnHoaDon.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mã Hoá Đơn");
		lblNewLabel_1.setBounds(10, 79, 113, 30);
		pnHoaDon.add(lblNewLabel_1);

		txtMaHoaDon = new JTextField();
		txtMaHoaDon.setBounds(133, 79, 140, 30);
		pnHoaDon.add(txtMaHoaDon);
		txtMaHoaDon.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Tổng Tiền");
		lblNewLabel_1_1.setBounds(317, 79, 113, 30);
		pnHoaDon.add(lblNewLabel_1_1);

		txtTongTien = new JTextField();
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(440, 79, 140, 30);
		pnHoaDon.add(txtTongTien);

		JLabel lblNewLabel_1_2 = new JLabel("Mã Nhân Viên");
		lblNewLabel_1_2.setBounds(10, 150, 113, 30);
		pnHoaDon.add(lblNewLabel_1_2);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(133, 150, 140, 30);
		pnHoaDon.add(txtMaNhanVien);

		JLabel lblsa = new JLabel("Mã Khách Hàng");
		lblsa.setBounds(10, 193, 113, 30);
		pnHoaDon.add(lblsa);

		txtmakh = new JTextField();
		txtmakh.setColumns(10);
		txtmakh.setBounds(133, 193, 140, 30);
		pnHoaDon.add(txtmakh);

		JLabel lblNewLabel_1_3 = new JLabel("Ngày Lập");
		lblNewLabel_1_3.setBounds(317, 150, 113, 30);
		pnHoaDon.add(lblNewLabel_1_3);

		txtNgayLap = new JTextField();
		txtNgayLap.setColumns(10);
		txtNgayLap.setBounds(440, 150, 140, 30);
		pnHoaDon.add(txtNgayLap);

		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(227, 242, 85, 58);
		btnThem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					HoaDonDTO hd = new HoaDonDTO();
					hd.setMahd(Integer.parseInt(txtMaHoaDon.getText()));
					hd.setMakh(txtmakh.getText());
					hd.setManv(txtMaNhanVien.getText());
					hd.setTongtien(0);
					java.sql.Date ngaylap = convertUtilToSql(sdf.parse(txtNgayLap.getText()));
					hd.setNgaylap(ngaylap);
					if (new HoaDonBUS().themhoadon(hd) > 0) {
						JOptionPane.showMessageDialog(null, "Thêm Thành Công");
						loadhoadon();
					} else {
						JOptionPane.showMessageDialog(null, "Thêm Thất Bại");
					}

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
		pnHoaDon.add(btnThem);

		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(359, 242, 85, 58);
		btnSua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					HoaDonDTO hd = new HoaDonDTO();
					hd.setMahd(Integer.parseInt(txtMaHoaDon.getText()));
					hd.setMakh(txtmakh.getText());
					hd.setManv(txtMaNhanVien.getText());
					// hd.setTongtien(Integer.parseInt(txtTongTien.getText()));
					java.sql.Date ngaylap = convertUtilToSql(sdf.parse(txtNgayLap.getText()));
					hd.setNgaylap(ngaylap);
					if (new HoaDonBUS().suahd(hd) > 0) {
						JOptionPane.showMessageDialog(null, "Sửa Thành Công");
						loadhoadon();
					} else {
						JOptionPane.showMessageDialog(null, "Sửa Thất Bại");
					}

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
		pnHoaDon.add(btnSua);

		JButton btnXoa = new JButton("Xoá");
		btnXoa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					HoaDonDTO hd = new HoaDonDTO();
					hd.setMahd(Integer.parseInt(txtMaHoaDon.getText()));
					hd.setMakh(txtmakh.getText());
					hd.setManv(txtMaNhanVien.getText());
					// hd.setTongtien(Integer.parseInt(txtTongTien.getText()));
					java.sql.Date ngaylap = convertUtilToSql(sdf.parse(txtNgayLap.getText()));
					hd.setNgaylap(ngaylap);
					if (new HoaDonBUS().xoahd(hd) > 0) {
						JOptionPane.showMessageDialog(null, "Xoá Thành Công");
						loadhoadon();
					} else {
						JOptionPane.showMessageDialog(null, "Xoá Thất Bại");
					}

				} catch (Exception e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}

			}
		});

		btnXoa.setBounds(485, 242, 85, 58);
		pnHoaDon.add(btnXoa);

		JPanel pnCTHoaDon = new JPanel();
		pnCTHoaDon.setPreferredSize(new Dimension(580, 0));
		pnDuLieu.add(pnCTHoaDon, BorderLayout.CENTER);
		pnCTHoaDon.setLayout(null);

		JLabel lblChiTitHa = new JLabel("Chi Tiết Hoá Đơn");
		lblChiTitHa.setForeground(new Color(210, 105, 30));
		lblChiTitHa.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblChiTitHa.setBounds(257, 0, 209, 44);
		pnCTHoaDon.add(lblChiTitHa);

		JLabel lblNewLabel_1_2_1 = new JLabel("Mã Hoá Đơn");
		lblNewLabel_1_2_1.setBounds(58, 79, 102, 30);
		pnCTHoaDon.add(lblNewLabel_1_2_1);

		txtMaHoaDonCT = new JTextField();
		txtMaHoaDonCT.setColumns(10);
		txtMaHoaDonCT.setBounds(170, 79, 129, 30);
		pnCTHoaDon.add(txtMaHoaDonCT);

		JLabel lblNewLabel_1_3_1 = new JLabel("Mã Vé");
		lblNewLabel_1_3_1.setBounds(365, 79, 102, 30);
		pnCTHoaDon.add(lblNewLabel_1_3_1);

		txtMaVe = new JTextField();
		txtMaVe.setColumns(10);
		txtMaVe.setBounds(477, 79, 113, 30);
		pnCTHoaDon.add(txtMaVe);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Số Lượng");
		lblNewLabel_1_2_1_1.setBounds(58, 133, 102, 30);
		pnCTHoaDon.add(lblNewLabel_1_2_1_1);

		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(170, 133, 129, 30);
		pnCTHoaDon.add(txtSoLuong);

		txtDonGia = new JTextField();
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(477, 133, 113, 30);
		pnCTHoaDon.add(txtDonGia);

		JLabel lblNewLabel_1_3_1_1 = new JLabel("Đơn Giá");
		lblNewLabel_1_3_1_1.setBounds(365, 133, 102, 30);
		pnCTHoaDon.add(lblNewLabel_1_3_1_1);

		/*
		 * JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Thành Tiền");
		 * lblNewLabel_1_2_1_1_1.setBounds(58, 187, 102, 30);
		 * pnCTHoaDon.add(lblNewLabel_1_2_1_1_1);
		 * 
		 * txtThanhTien = new JTextField(); txtThanhTien.setColumns(10);
		 * txtThanhTien.setBounds(170, 187, 129, 30); pnCTHoaDon.add(txtThanhTien);
		 */

		JButton btnXuatHD = new JButton("Xuất");
		btnXuatHD.setBounds(170, 187, 129, 30);
		btnXuatHD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int i = tblHD.getSelectedRow();
				if (i >= 0) {
					int mahd = Integer.parseInt(tblHD.getValueAt(i, 0)+"");
					Export.XuatPDF xuat = new XuatPDF();
					xuat.xuatPDFPhieuNhap(tblCTHD, mahd);
				}
				else {
					JOptionPane.showMessageDialog(null, "Đã chọn hoá đơn đâu mà in");
				}

			}
		});
		pnCTHoaDon.add(btnXuatHD);

		JButton btnThemCT = new JButton("Thêm");
		btnThemCT.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					CTHoaDonDTO ct = new CTHoaDonDTO();
					ct.setMahd(Integer.parseInt(txtMaHoaDonCT.getText()));
					ct.setMave(txtMaVe.getText());
					ct.setDongia(Integer.parseInt(txtDonGia.getText()));
					ct.setSoluong(Integer.parseInt(txtSoLuong.getText()));
					ct.setThanhtien(Integer.parseInt(txtDonGia.getText()) * Integer.parseInt(txtSoLuong.getText()));
					if (new CTHoaDonBUS().themhoadon(ct) > 0) {
						new HoaDonBUS().updatetongtien(ct.mahd);
						loadhoadon();
						loadcthoadon();

						JOptionPane.showMessageDialog(null, "Thêm Thành Công");

					} else {
						JOptionPane.showMessageDialog(null, "Thêm Thất Bại");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}

			}
		});
		btnThemCT.setBounds(158, 242, 85, 58);
		pnCTHoaDon.add(btnThemCT);

		JButton btnSuaCT = new JButton("Sửa");
		btnSuaCT.setBounds(290, 242, 85, 58);
		btnSuaCT.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int i = tblCTHD.getSelectedRow();
				if (i > -1) {
					try {
						CTHoaDonDTO ct = new CTHoaDonDTO();
						ct.setMacthd(Integer.parseInt(dtmcthd.getValueAt(i, 0).toString()));
						ct.setMahd(Integer.parseInt(txtMaHoaDonCT.getText()));
						ct.setMave(txtMaVe.getText());
						ct.setDongia(Integer.parseInt(txtDonGia.getText()));
						ct.setSoluong(Integer.parseInt(txtSoLuong.getText()));
						ct.setThanhtien(Integer.parseInt(txtDonGia.getText()) * Integer.parseInt(txtSoLuong.getText()));
						if (new CTHoaDonBUS().suahd(ct) > 0) {
							new HoaDonBUS().updatetongtien(ct.mahd);
							loadcthoadon();
							loadhoadon();
							JOptionPane.showMessageDialog(null, "Sửa Thành Công");
						} else {
							JOptionPane.showMessageDialog(null, "Sửa Thất Bại");
						}
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Bạn Chưa Click vào table");
				}

			}
		});
		pnCTHoaDon.add(btnSuaCT);

		JButton btnXoaCT = new JButton("Xoá");
		btnXoaCT.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = tblCTHD.getSelectedRow();
				if (i > -1) {
					try {
						int macthd = Integer.parseInt(dtmcthd.getValueAt(i, 0).toString());
						int mahd = Integer.parseInt(dtmcthd.getValueAt(i, 1).toString());
						if (new CTHoaDonBUS().xoahd(macthd) > 0) {
							new HoaDonBUS().updatetongtien(mahd);
							loadhoadon();
							loadcthoadon();
							JOptionPane.showMessageDialog(null, "Xoá Thành Công");
						} else {
							JOptionPane.showMessageDialog(null, "Xoá Thất Bại");
						}
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Bạn Chưa Click vào table");
				}

			}
		});
		btnXoaCT.setBounds(416, 242, 85, 58);
		pnCTHoaDon.add(btnXoaCT);

		JPanel pnTable = new JPanel();
		pnTable.setBackground(new Color(240, 240, 240));
		pnTable.setPreferredSize(new Dimension(0, 320));
		pnChinh.add(pnTable, BorderLayout.SOUTH);
		pnTable.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(580, 0));
		pnTable.add(panel, BorderLayout.WEST);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 580, 320);
		panel.add(scrollPane);
		dtmhoadon = new DefaultTableModel();
		dtmhoadon.addColumn("Mã Hoá Đơn");

		dtmhoadon.addColumn("Mã KH");
		dtmhoadon.addColumn("Mã Nhân Viên");
		dtmhoadon.addColumn("Ngày Lập");
		dtmhoadon.addColumn("Tổng Tiền");
		tblHD = new MyTable(dtmhoadon);
		tblHD.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				int i = tblHD.getSelectedRow();
				if (i >= 0) {
					txtMaHoaDon.setText(dtmhoadon.getValueAt(i, 0) + "");
					txtmakh.setText(dtmhoadon.getValueAt(i, 1) + "");
					txtMaNhanVien.setText(dtmhoadon.getValueAt(i, 2) + "");
					txtNgayLap.setText(dtmhoadon.getValueAt(i, 3) + "");
					txtTongTien.setText(dtmhoadon.getValueAt(i, 4) +"");
					int mahd = Integer.parseInt(txtMaHoaDon.getText());
					loadcthoadontheoma(mahd);

				}

			}
		});

		scrollPane.setViewportView(tblHD);

		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(580, 0));
		pnTable.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 580, 320);
		panel_1.add(scrollPane_2);
		dtmcthd = new DefaultTableModel();
		dtmcthd.addColumn("Mã CTHD");
		dtmcthd.addColumn("Mã HĐ");
		dtmcthd.addColumn("Mã Vé");
		dtmcthd.addColumn("Số Lượng");
		dtmcthd.addColumn("Đơn Giá");
		dtmcthd.addColumn("Thành Tiền");
		tblCTHD = new MyTable(dtmcthd);
		tblCTHD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int i = tblCTHD.getSelectedRow();
				if (i >= 0) {
					txtMaHoaDonCT.setText(dtmcthd.getValueAt(i, 1) + "");
					txtMaVe.setText(dtmcthd.getValueAt(i, 2) + "");
					txtSoLuong.setText(dtmcthd.getValueAt(i, 3) + "");
					txtDonGia.setText(dtmcthd.getValueAt(i, 4) + "");
					txtThanhTien.setText(dtmcthd.getValueAt(i, 5) + "");

				}
			}
		});

		scrollPane_2.setViewportView(tblCTHD);
		loadhoadon();
		loadcthoadon();
	}

	public static ArrayList<HoaDonDTO> hoadon = new ArrayList<HoaDonDTO>();

	public void loadhoadon() {
		hoadon = null;
		hoadon = new HoaDonBUS().gethoadon();
		dtmhoadon.setRowCount(0);
		for (HoaDonDTO hd : hoadon) {
			Vector vec = new Vector();
			vec.add(hd.getMahd());
			vec.add(hd.getMakh());
			vec.add(hd.getManv());

			vec.add(hd.getNgaylap());
			vec.add(hd.getTongtien());
			dtmhoadon.addRow(vec);
		}
	}

	public static ArrayList<CTHoaDonDTO> cthoadon = new ArrayList<CTHoaDonDTO>();

	public void loadcthoadon() {
		cthoadon = null;
		cthoadon = new CTHoaDonBUS().getcthd();
		dtmcthd.setRowCount(0);
		for (CTHoaDonDTO hd : cthoadon) {
			Vector vec = new Vector();
			vec.add(hd.getMacthd());
			vec.add(hd.getMahd());
			vec.add(hd.getMave());
			vec.add(hd.getSoluong());
			vec.add(hd.getDongia());
			vec.add(hd.getThanhtien());
			dtmcthd.addRow(vec);
		}
	}

	public void loadcthoadontheoma(int mahd) {
		cthoadon = null;
		cthoadon = new CTHoaDonBUS().getcthd();
		dtmcthd.setRowCount(0);
		for (CTHoaDonDTO hd : cthoadon) {
			if (hd.getMahd() == mahd) {
				Vector vec = new Vector();
				vec.add(hd.getMacthd());
				vec.add(hd.getMahd());
				vec.add(hd.getMave());
				vec.add(hd.getSoluong());
				vec.add(hd.getDongia());
				vec.add(hd.getThanhtien());
				System.out.println(hd);
				dtmcthd.addRow(vec);
			}
		}
	}

	private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
		java.sql.Date sDate = new java.sql.Date(uDate.getTime());
		return sDate;
	}
}
