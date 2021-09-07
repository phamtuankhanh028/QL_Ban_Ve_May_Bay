package presentationLayer;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JDesktopPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Label;

import javax.swing.ImageIcon;
import java.awt.Font;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JLocaleChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.github.lgooddatepicker.components.TimePicker;
import com.toedter.components.JSpinField;

import BUS.ChuyenBayBUS;
import BUS.MayBayBUS;
import BUS.TuyenBayBUS;
import DAO.MayBayDAO;
import DTO.ChuyenBayDTO;
import DTO.NhanVienDTO;
import DTO.TuyenBayDTO;
import Export.ExportExcel;
import Export.XuatPDF;
import custom.MyTable;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class ChuyenBayJPanel extends JPanel {
	private JPanel panel;
	private JTextField txtChuyenBay;
	private JTextField txtHang1;
	private JDateChooser txtNgayDi;
	private JTable tblChuyenBay;
	private DefaultTableModel dtm;

	public static ChuyenBayBUS BUScb = new ChuyenBayBUS();
	private static TuyenBayBUS BUStb = new TuyenBayBUS();
	private static MayBayBUS BUSmb = new MayBayBUS();

	public static List<ChuyenBayDTO> dscb = BUScb.getTn();
	public static List<TuyenBayDTO> dstb;
	public static HashMap<String, String> dsmb = BUSmb.getDsmb();

	public static List<ChuyenBayDTO> dscbtn;
	public static List<ChuyenBayDTO> dscbqt;
	private DefaultComboBoxModel dcbx;
	private JTextField txtTimDiemDi;
	private JTextField txtHang2;
	private JComboBox cbxTuyenBay;
	private JComboBox cbxMayBay;
	private JButton btnThmChuynBay;
	private JDateChooser txtNgayDen;
	private TimePicker txtGioDi;
	private TimePicker txtGioDen;
	private JSpinField txtSoGioBay;

	private java.util.Date ngayDi;
	private java.util.Date ngayDen;
	private JTextField txtDiemDi;
	private JTextField txtDiemDen;

	/**
	 * 
	 * Create the panel.
	 */
	public ChuyenBayJPanel() {
		setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		panel.setPreferredSize(new Dimension(0, 0));
		;
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JDesktopPane desktopPane = new JDesktopPane();
		panel.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_AnhBia = new JPanel();
		panel_AnhBia.setPreferredSize(new Dimension(0, 150));
		desktopPane.add(panel_AnhBia, BorderLayout.NORTH);
		panel_AnhBia.setLayout(new BorderLayout(0, 0));

		JLabel lblAnhBia = new JLabel("");
		lblAnhBia.setPreferredSize(new Dimension(1220, 150));
		lblAnhBia.setSize(1220, 150);
		ImageIcon icon = new ImageIcon("../QL_Ban_Ve_May_Bay/src/images/biaNV.png");
		icon.setImage(icon.getImage().getScaledInstance(lblAnhBia.getWidth(), lblAnhBia.getHeight(),
				Image.SCALE_AREA_AVERAGING));
		lblAnhBia.setIcon(icon);
		panel_AnhBia.add(lblAnhBia, BorderLayout.CENTER);

		JPanel panel_table = new JPanel();
		panel_table.setPreferredSize(new Dimension(0, 390));
		desktopPane.add(panel_table, BorderLayout.SOUTH);
		panel_table.setLayout(new BorderLayout(0, 0));

		JPanel panel_chucNang = new JPanel();
		panel_chucNang.setBackground(new Color(240, 240, 240));
		panel_chucNang.setPreferredSize(new Dimension(0, 100));
		panel_table.add(panel_chucNang, BorderLayout.NORTH);
		panel_chucNang.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 102, 153));
		panel_2.setForeground(new Color(135, 206, 235));
		panel_2.setPreferredSize(new Dimension(20, 0));
		panel_chucNang.add(panel_2, BorderLayout.WEST);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 102, 153));
		panel_3.setPreferredSize(new Dimension(20, 0));
		panel_chucNang.add(panel_3, BorderLayout.EAST);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(211, 211, 211));
		panel_chucNang.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(null);

		txtTimDiemDi = new JTextField();
		txtTimDiemDi.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				getTimDiemDi();

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				getTimDiemDi();

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				getTimDiemDi();

			}
		});
		txtTimDiemDi.setBounds(125, 61, 138, 29);
		panel_4.add(txtTimDiemDi);
		txtTimDiemDi.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Bạn Muốn Đi Đến ?");
		lblNewLabel_7.setForeground(new Color(0, 128, 128));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(125, 27, 138, 29);
		panel_4.add(lblNewLabel_7);

		JButton btnTimKiem = new JButton("");
		btnTimKiem.setIcon(new ImageIcon("../QL_Ban_Ve_May_Bay/src/images/Search.png"));
		btnTimKiem.setBounds(30, 27, 85, 63);
		panel_4.add(btnTimKiem);

		btnThmChuynBay = new JButton(" Thêm");
		btnThmChuynBay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ChuyenBayDTO cb = new ChuyenBayDTO();
				cb.setBayDen(txtDiemDen.getText());
				// JOptionPane.showMessageDialog(null, cbxDiemDen.getSelectedItem().toString());
				cb.setBayTu(txtDiemDi.getText());
				cb.setGioDen(txtGioDen.getText());
				cb.setGioDi(txtGioDi.getText());

				Date ngayDi = new Date(txtNgayDi.getDate().getTime());
				// JOptionPane.showMessageDialog(null, ngayDi);
				cb.setNgayDi(ngayDi);

				Date ngayDen = new Date(txtNgayDen.getDate().getTime());
				// JOptionPane.showMessageDialog(null, ngayDen);
				cb.setNgayDen(ngayDen);

				cb.setMaChuyenBay(txtChuyenBay.getText());
				String maMayBay = dsmb.get(cbxMayBay.getSelectedItem().toString());
				cb.setMaMayBay(maMayBay);
				cb.setMaTuyenBay(cbxTuyenBay.getSelectedItem().toString());

				cb.setSgh1cl(Integer.parseInt(txtHang1.getText()));
				cb.setSgh2cl(Integer.parseInt(txtHang2.getText()));
				cb.setSoGioBay(txtSoGioBay.getValue());

				int i = BUScb.BUSThemChuyenBay(cb);
				ChuyenBayDTO cbkt = BUScb.getCBTheoMa(cb.getMaChuyenBay());
				if (i > 0) {
					if (cb != null) {
						if (cb.getMaChuyenBay().contains("CB")) {
							getDTM();
							JOptionPane.showMessageDialog(null, "Đã thêm 1 chuyến bay trong nước");
							txtDiemDen.setText("");
							txtDiemDi.setText("");
							txtGioDen.setText("");
							txtGioDi.setText("");
							txtNgayDi.setDate(null);
							txtNgayDen.setDate(null);
							txtChuyenBay.setText("");
							cbxMayBay.setSelectedIndex(0);
							cbxTuyenBay.setSelectedIndex(0);
							txtHang1.setText("");
							txtHang2.setText("");
							txtSoGioBay.setValue(0);
						} else {
							if (cb.getMaChuyenBay().contains("QT")) {

								JOptionPane.showMessageDialog(null, "Đã thêm 1 chuyến bay quốc tế");
								txtDiemDen.setText("");
								txtDiemDi.setText("");
								txtGioDen.setText("");
								txtGioDi.setText("");
								txtNgayDi.setDate(null);
								txtNgayDen.setDate(null);
								txtChuyenBay.setText("");
								cbxMayBay.setSelectedIndex(0);
								cbxTuyenBay.setSelectedIndex(0);
								txtHang1.setText("");
								txtHang2.setText("");
								txtSoGioBay.setValue(0);
							} else {

								JOptionPane.showMessageDialog(null,
										"Mã chuyên bay bắt đầu:" + "\nCB - Trong nước" + "\nQT - Quốc tế");

							}
						}
					}
				}else {
					JOptionPane.showMessageDialog(null, "Trùng mã rồi");
				}
			}
		});
		btnThmChuynBay.setForeground(new Color(0, 139, 139));
		btnThmChuynBay.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnThmChuynBay.setHorizontalAlignment(SwingConstants.LEADING);
		btnThmChuynBay.setIcon(new ImageIcon("../QL_Ban_Ve_May_Bay/src/images/Add Property.png"));
		btnThmChuynBay.setBounds(317, 27, 145, 63);
		panel_4.add(btnThmChuynBay);

		JButton btnHuy = new JButton(" Hủy");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tblChuyenBay.getSelectedRow();
				if (i >= 0) {
					String maChuyen = tblChuyenBay.getModel().getValueAt(i, 0).toString();
					int j = BUScb.BUSXoaChuyenBay(maChuyen);
					if (j > 0) {
						JOptionPane.showMessageDialog(null, "Đã Xóa");
						getDTM();
						txtDiemDen.setText("");
						txtDiemDi.setText("");
						txtGioDen.setText("");
						txtGioDi.setText("");
						txtNgayDi.setDate(null);
						txtNgayDen.setDate(null);
						txtChuyenBay.setText("");
						cbxMayBay.setSelectedIndex(0);
						cbxTuyenBay.setSelectedIndex(0);
						txtHang1.setText("");
						txtHang2.setText("");
						txtSoGioBay.setValue(0);
						txtChuyenBay.setEditable(true);
					} else {
						JOptionPane.showMessageDialog(null, "Lỗi Xóa");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn dữ liệu xóa!");
				}

			}
		});
		btnHuy.setIcon(new ImageIcon("../QL_Ban_Ve_May_Bay/src/images/Cancel Subscription.png"));
		btnHuy.setHorizontalAlignment(SwingConstants.LEADING);
		btnHuy.setForeground(new Color(0, 139, 139));
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHuy.setBounds(501, 27, 138, 63);
		panel_4.add(btnHuy);

		JButton btnSa = new JButton(" Sửa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChuyenBayDTO cb = new ChuyenBayDTO();
				cb.setBayDen(txtDiemDen.getText());
				// JOptionPane.showMessageDialog(null, cbxDiemDen.getSelectedItem().toString());
				cb.setBayTu(txtDiemDi.getText());
				cb.setGioDen(txtGioDen.getText());
				cb.setGioDi(txtGioDi.getText());

				Date ngayDi = new Date(txtNgayDi.getDate().getTime());
				// JOptionPane.showMessageDialog(null, ngayDi);
				cb.setNgayDi(ngayDi);

				Date ngayDen = new Date(txtNgayDen.getDate().getTime());
				// JOptionPane.showMessageDialog(null, ngayDen);
				cb.setNgayDen(ngayDen);

				cb.setMaChuyenBay(txtChuyenBay.getText());
				String maMayBay = dsmb.get(cbxMayBay.getSelectedItem().toString());
				cb.setMaMayBay(maMayBay);
				cb.setMaTuyenBay(cbxTuyenBay.getSelectedItem().toString());

				cb.setSgh1cl(Integer.parseInt(txtHang1.getText()));
				cb.setSgh2cl(Integer.parseInt(txtHang2.getText()));
				cb.setSoGioBay(txtSoGioBay.getValue());

				int i = BUScb.BUSSuaChuyenBay(cb);

				if (i > 0) {
					JOptionPane.showMessageDialog(null, "Đã sửa");
					getDTM();
					txtDiemDen.setText("");
					txtDiemDi.setText("");
					txtGioDen.setText("");
					txtGioDi.setText("");
					txtNgayDi.setDate(null);
					txtNgayDen.setDate(null);
					txtChuyenBay.setText("");
					cbxMayBay.setSelectedIndex(0);
					cbxTuyenBay.setSelectedIndex(0);
					txtHang1.setText("");
					txtHang2.setText("");
					txtSoGioBay.setValue(0);
					txtChuyenBay.setEditable(true);
				} else {
					JOptionPane.showMessageDialog(null, "Sửa không thành công");
				}

			}
		});
		btnSa.setIcon(new ImageIcon("../QL_Ban_Ve_May_Bay/src/images/Store Setting.png"));
		btnSa.setHorizontalAlignment(SwingConstants.LEADING);
		btnSa.setForeground(new Color(0, 139, 139));
		btnSa.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSa.setBounds(678, 27, 129, 63);
		panel_4.add(btnSa);

		JButton btnNewButton_1 = new JButton("PDF");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XuatPDF PDF = new XuatPDF();
				PDF.xuatPDF(tblChuyenBay);
			}
		});
		btnNewButton_1.setBounds(845, 27, 107, 63);
		panel_4.add(btnNewButton_1);

		JPanel panel_lt = new JPanel();
		panel_lt.setBackground(new Color(51, 102, 153));
		panel_lt.setPreferredSize(new Dimension(20, 0));
		panel_table.add(panel_lt, BorderLayout.WEST);

		JPanel panel_rt = new JPanel();
		panel_rt.setBackground(new Color(51, 102, 153));
		panel_rt.setPreferredSize(new Dimension(20, 0));
		panel_table.add(panel_rt, BorderLayout.EAST);

		JPanel panel_ut = new JPanel();
		panel_ut.setBackground(new Color(51, 102, 153));
		panel_ut.setPreferredSize(new Dimension(0, 20));
		panel_table.add(panel_ut, BorderLayout.SOUTH);

		JScrollPane scrollPane_4 = new JScrollPane();
		panel_ut.add(scrollPane_4);

		JPanel panel_dscb = new JPanel();
		panel_table.add(panel_dscb, BorderLayout.CENTER);
		panel_dscb.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_2 = new JScrollPane();
		panel_dscb.add(scrollPane_2, BorderLayout.CENTER);

		JMenuBar menuBar = new JMenuBar();
		scrollPane_2.setColumnHeaderView(menuBar);

		JMenu mnNewMenu = new JMenu("Trong nước");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dtm = (DefaultTableModel) tblChuyenBay.getModel();
				dtm.setRowCount(0);
				dscb = null;
				dscb = BUScb.getTn();

				for (ChuyenBayDTO cb : dscb) {
					String[] data = { cb.getMaChuyenBay(), cb.getBayTu(), cb.getNgayDi().toString(), cb.getBayDen(),
							cb.getNgayDen().toString(), cb.getGioDi(), cb.getGioDen() };
					dtm = (DefaultTableModel) tblChuyenBay.getModel();
					dtm.addRow(data);
				}

			}
		});
		menuBar.add(mnNewMenu);

		JMenu mnNewMenu_1 = new JMenu("Quốc tế");
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dtm = (DefaultTableModel) tblChuyenBay.getModel();
				dtm.setRowCount(0);
				dscb = null;

				dscb = BUScb.getQt();
				for (ChuyenBayDTO cb : dscb) {
					String[] data = { cb.getMaChuyenBay(), cb.getBayTu(), cb.getNgayDi().toString(), cb.getBayDen(),
							cb.getNgayDen().toString(), cb.getGioDi(), cb.getGioDen() };
					dtm = (DefaultTableModel) tblChuyenBay.getModel();
					dtm.addRow(data);
				}

			}
		});

		menuBar.add(mnNewMenu_1);

		JMenuBar menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);

		JPanel panel_1 = new JPanel();
		scrollPane_2.setViewportView(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_3 = new JScrollPane();
		panel_1.add(scrollPane_3, BorderLayout.CENTER);
		Main.giaodienwindows();

		tblChuyenBay = new MyTable();
		tblChuyenBay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tblChuyenBay.getSelectedRow();

				if (i >= 0) {
					txtChuyenBay.setText(tblChuyenBay.getModel().getValueAt(i, 0).toString());
					
					txtDiemDi.setText(tblChuyenBay.getModel().getValueAt(i, 1).toString());
					txtDiemDen.setText(tblChuyenBay.getModel().getValueAt(i, 3).toString());

					txtGioDi.setText(tblChuyenBay.getModel().getValueAt(i, 5).toString());
					txtGioDen.setText(tblChuyenBay.getModel().getValueAt(i, 6).toString());
					try {
						ngayDi = new SimpleDateFormat("yyyy-MM-dd")
								.parse(tblChuyenBay.getModel().getValueAt(i, 2).toString());
						txtNgayDi.setDate(ngayDi);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					try {
						ngayDen = new SimpleDateFormat("yyyy-MM-dd")
								.parse(tblChuyenBay.getModel().getValueAt(i, 4).toString());
						txtNgayDen.setDate(ngayDen);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					ChuyenBayDTO cb = BUScb.getCBTheoMa(tblChuyenBay.getModel().getValueAt(i, 0).toString());
					cbxTuyenBay.setSelectedItem(cb.getMaTuyenBay());
					txtSoGioBay.setValue(cb.getSoGioBay());
					cbxMayBay.setSelectedItem(cb.getMaMayBay());
					txtHang1.setText(cb.getSgh1cl() + "");
					txtHang2.setText(cb.getSgh2cl() + "");
				}
			}
		});
		tblChuyenBay.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Chuy\u1EBFn Bay", "Bay T\u1EEB", "Ng\u00E0y \u0110i", "Bay \u0110\u1EBFn",
						"Ng\u00E0y \u0111\u1EBFn", "C\u1EA5t C\u00E1nh", "H\u1EA1 C\u00E1nh" }));

		scrollPane_3.setViewportView(tblChuyenBay);

		JPopupMenu popupMenu = new JPopupMenu();
		JMenuItem mntmNewMenuItem = new JMenuItem("ChiTietChuyenBay");
		mntmNewMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				int i = tblChuyenBay.getSelectedRow();
				if (i >= 0) {
					ChiTietChuyenBay ctcb = new ChiTietChuyenBay();
					String macb = txtChuyenBay.getText();
					ChuyenBayDTO cb = BUScb.getCBTheoMa(macb);
					ctcb.lblDiemDen.setText(cb.getBayDen());
					ctcb.lblDiemDi.setText(cb.getBayTu());
					ctcb.lblGioDen.setText(cb.getGioDi());
					ctcb.lblGioDi.setText(cb.getGioDi());
					ctcb.lblGioDen2.setText(cb.getGioDi());
					ctcb.lblGioDi2.setText(cb.getGioDi());
					ctcb.lblNgayDen.setText(cb.getNgayDen().toString());
					ctcb.lblNgayDi.setText(cb.getNgayDen().toString());
					ctcb.lblMB.setText(cb.getMaMayBay());
					ctcb.lblTGB.setText(cb.getSoGioBay() + "");
					ctcb.lblTuyenbay.setText(cb.getMaTuyenBay());
					ctcb.setVisible(true);
				}
			}
		});
		popupMenu.add(mntmNewMenuItem);
		addPopup(tblChuyenBay, popupMenu);

		Main.giaodiennimbus();

		JPanel panel_lef = new JPanel();
		panel_lef.setPreferredSize(new Dimension(20, 0));
		panel_lef.setBackground(new Color(51, 102, 153));
		desktopPane.add(panel_lef, BorderLayout.WEST);

		JPanel panel_right = new JPanel();
		panel_right.setPreferredSize(new Dimension(20, 0));
		panel_right.setBackground(new Color(51, 102, 153));
		desktopPane.add(panel_right, BorderLayout.EAST);

		JPanel panel_center = new JPanel();
		desktopPane.add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(new BorderLayout(0, 0));

		JPanel panel_tt1 = new JPanel();
		panel_tt1.setBackground(new Color(220, 220, 220));
		panel_tt1.setPreferredSize(new Dimension(810, 0));
		panel_center.add(panel_tt1, BorderLayout.CENTER);
		panel_tt1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Chuyến bay: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(33, 20, 96, 31);
		panel_tt1.add(lblNewLabel);

		txtChuyenBay = new JTextField();
		txtChuyenBay.setBounds(139, 21, 116, 31);
		/*
		 * txtChuyenBay.setEditable(false); txtChuyenBay.setText("Hello");
		 * txtChuyenBay.setEnabled(false);
		 */
		panel_tt1.add(txtChuyenBay);
		txtChuyenBay.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Điểm đi");
		lblNewLabel_1.setIcon(new ImageIcon("../QL_Ban_Ve_May_Bay/src/images/outline_location_on_black_24dp.png"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(33, 72, 96, 31);
		panel_tt1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_2 = new JLabel("Ngày đi");
		lblNewLabel_1_2.setIcon(new ImageIcon("../QL_Ban_Ve_May_Bay/src/images/iconfinder_Calendar_132395.png"));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(33, 125, 96, 31);
		panel_tt1.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_2_2 = new JLabel("Cất cánh");
		lblNewLabel_1_2_2
				.setIcon(new ImageIcon("../QL_Ban_Ve_May_Bay/src/images/baseline_flight_takeoff_black_24dp.png"));
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_2.setBounds(33, 176, 96, 31);
		panel_tt1.add(lblNewLabel_1_2_2);

		JLabel lblNewLabel_1_1 = new JLabel("Điểm đến");
		lblNewLabel_1_1.setIcon(new ImageIcon("../QL_Ban_Ve_May_Bay/src/images/outline_where_to_vote_black_24dp.png"));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(458, 72, 96, 31);
		panel_tt1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_3 = new JLabel("Ngày đến");
		lblNewLabel_1_3.setIcon(new ImageIcon("../QL_Ban_Ve_May_Bay/src/images/iconfinder_Calendar_132395.png"));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_3.setBounds(458, 125, 96, 31);
		panel_tt1.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Hạ cánh");
		lblNewLabel_1_4.setIcon(new ImageIcon("../QL_Ban_Ve_May_Bay/src/images/baseline_flight_land_black_24dp.png"));
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_4.setBounds(458, 176, 96, 31);
		panel_tt1.add(lblNewLabel_1_4);

		txtNgayDi = new JDateChooser();
		txtNgayDi.setDateFormatString("yyyy-MM-dd");
		txtNgayDi.setBounds(139, 125, 176, 31);
		panel_tt1.add(txtNgayDi);

		txtNgayDen = new JDateChooser();
		txtNgayDen.setDateFormatString("yyyy-MM-dd");
		txtNgayDen.setBounds(564, 125, 176, 31);
		panel_tt1.add(txtNgayDen);

		txtGioDi = new TimePicker();
		txtGioDi.setBounds(140, 176, 115, 31);
		panel_tt1.add(txtGioDi);

		txtGioDen = new TimePicker();
		txtGioDen.setBounds(564, 176, 115, 31);
		panel_tt1.add(txtGioDen);

		txtDiemDi = new JTextField();
		txtDiemDi.setColumns(10);
		txtDiemDi.setBounds(139, 73, 176, 31);
		panel_tt1.add(txtDiemDi);

		txtDiemDen = new JTextField();
		txtDiemDen.setColumns(10);
		txtDiemDen.setBounds(564, 72, 176, 31);
		panel_tt1.add(txtDiemDen);

		JPanel panel_tt2 = new JPanel();
		panel_tt2.setBackground(new Color(220, 220, 220));
		panel_tt2.setPreferredSize(new Dimension(410, 0));
		panel_center.add(panel_tt2, BorderLayout.EAST);
		panel_tt2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Tuyến bay");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(99, 27, 96, 31);
		panel_tt2.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Số giờ bay");
		lblNewLabel_3.setIcon(new ImageIcon("../QL_Ban_Ve_May_Bay/src/images/iconfinder_Clock_132512.png"));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(101, 79, 96, 31);
		panel_tt2.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Máy bay");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(99, 132, 96, 31);
		panel_tt2.add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("Hạng ghế 1");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1.setBounds(99, 179, 83, 31);
		panel_tt2.add(lblNewLabel_4_1);

		txtHang1 = new JTextField();
		txtHang1.setBounds(192, 181, 42, 30);
		panel_tt2.add(txtHang1);
		txtHang1.setColumns(10);

		txtSoGioBay = new JSpinField();
		txtSoGioBay.getSpinner().setFont(new Font("Tahoma", Font.BOLD, 15));
		txtSoGioBay.setBounds(207, 79, 64, 31);
		panel_tt2.add(txtSoGioBay);

		JLabel lblNewLabel_4_1_1 = new JLabel("Hạng ghế 2");
		lblNewLabel_4_1_1.setBounds(256, 179, 83, 31);
		panel_tt2.add(lblNewLabel_4_1_1);
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));

		txtHang2 = new JTextField();
		txtHang2.setBounds(337, 181, 42, 30);
		panel_tt2.add(txtHang2);
		txtHang2.setColumns(10);

		cbxTuyenBay = new JComboBox();
		cbxTuyenBay.setBounds(205, 27, 114, 31);
		panel_tt2.add(cbxTuyenBay);

		cbxMayBay = new JComboBox();
		cbxMayBay.setBounds(205, 128, 114, 31);
		panel_tt2.add(cbxMayBay);

		JPanel panel_tieuDe = new JPanel();
		panel_tieuDe.setBackground(new Color(220, 220, 220));
		panel_tieuDe.setPreferredSize(new Dimension(0, 45));

		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("../QL_Ban_Ve_May_Bay/src/images/departures (1).png"));
		lblNewLabel_5.setPreferredSize(new Dimension(30, 30));
		lblNewLabel_5.setSize(new Dimension(24, 24));
		panel_tieuDe.add(lblNewLabel_5);
		Label lbTieuDe = new Label("Chuyến bay VietnamAirline");
		lbTieuDe.setForeground(new Color(255, 140, 0));
		lbTieuDe.setFont(new Font("Arial", Font.BOLD, 28));
		panel_tieuDe.add(lbTieuDe);
		panel_center.add(panel_tieuDe, BorderLayout.NORTH);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setPreferredSize(new Dimension(30, 30));
		panel_tieuDe.add(lblNewLabel_6);

		getDTM();

		getTuyenBay();
		getMayBay();
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}

		});
	}

	public void getDTM() {
		dscb = null;
		dtm = (DefaultTableModel) tblChuyenBay.getModel();
		dtm.setRowCount(0);
		dscb = BUScb.getTn();
		for (ChuyenBayDTO cb : dscb) {
			String[] data = { cb.getMaChuyenBay(), cb.getBayTu(), cb.getNgayDi().toString(), cb.getBayDen(),
					cb.getNgayDen().toString(), cb.getGioDi(), cb.getGioDen() };

			dtm.addRow(data);
		}
	}

	public void getTimDiemDi() {
		String tenTim = txtTimDiemDi.getText();
		dtm.setRowCount(0);
		for (ChuyenBayDTO cb : dscb) {
			if (cb.getBayDen().toLowerCase().contains(tenTim.toLowerCase())) {
				String[] data = { cb.getMaChuyenBay(), cb.getBayTu(), cb.getNgayDi().toString(), cb.getBayDen(),
						cb.getNgayDen().toString(), cb.getGioDi(), cb.getGioDen() };
				dtm = (DefaultTableModel) tblChuyenBay.getModel();
				dtm.addRow(data);
			}
		}
	}

	public void getTuyenBay() {
		dstb = null;
		dcbx = new DefaultComboBoxModel();
		dcbx = (DefaultComboBoxModel) cbxTuyenBay.getModel();
		dstb = BUStb.getDstb();
		for (TuyenBayDTO tb : dstb) {
			dcbx.addElement(tb.getMaTuyenBay());
		}
	}

	public void getMayBay() {
		dcbx = new DefaultComboBoxModel();
		dcbx = (DefaultComboBoxModel) cbxMayBay.getModel();
		for (String mb : dsmb.keySet()) {
			dcbx.addElement(mb);
		}
	}
}
//setenel
//tai 2 cai panel xong goi xu kien menu
//compare
