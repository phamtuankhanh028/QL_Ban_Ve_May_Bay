package presentationLayer;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BUS.ChuyenBayBUS;
import BUS.SanBayBUS;
import BUS.TuyenBayBUS;
import DTO.ChuyenBayDTO;
import DTO.SanBayDTO;
import DTO.TuyenBayDTO;
import Export.ExportExcel;
import custom.MyTable;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TuyenBayJPanel extends JPanel {
	private JTextField txtMaTuyen;
	private JTextField txtTGD;
	private JTable tblTB;
	private JTable tblCB;
	private DefaultTableModel dtmTB = new DefaultTableModel();
	private DefaultTableModel dtmCB = new DefaultTableModel();
	private static DefaultComboBoxModel dtmSB;
	private static DefaultComboBoxModel dtmSBDen;
	static List<TuyenBayDTO> dstb = new ArrayList<TuyenBayDTO>();
	private TuyenBayBUS tbBus = new TuyenBayBUS();
	static List<ChuyenBayDTO> dscb = new ArrayList<ChuyenBayDTO>();
	private ChuyenBayBUS cbBus = new ChuyenBayBUS();
	private SanBayBUS sbBus = new SanBayBUS();
	private HashMap<String, String> dssb = sbBus.docMapSB();
	private JComboBox cbxSBD;
	private JComboBox cbxSBDen;
	private JComboBox cbxSBTG1;
	private JComboBox cbxSBTG2;
	private JTextField txtTimKiem;

	/**
	 * Create the panel.
	 */
	public TuyenBayJPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnBia = new JPanel();
		pnBia.setPreferredSize(new Dimension(1, 150));
		add(pnBia, BorderLayout.NORTH);
		pnBia.setLayout(new BorderLayout(0, 0));
		
		JLabel lblAnhBia = new JLabel("");
		lblAnhBia.setPreferredSize(new Dimension(1220, 150));
		lblAnhBia.setSize(1220, 150);
		ImageIcon icon = new ImageIcon("../QL_Ban_Ve_May_Bay/src/images/biaNV.png");
		icon.setImage(icon.getImage().getScaledInstance(lblAnhBia.getWidth(), lblAnhBia.getHeight(),
				Image.SCALE_AREA_AVERAGING));
		lblAnhBia.setIcon(icon);
		pnBia.add(lblAnhBia, BorderLayout.CENTER);
		
		JPanel pnTrai = new JPanel();
		pnTrai.setBackground(new Color(51, 102, 153));
		pnTrai.setPreferredSize(new Dimension(20, 0));
		add(pnTrai, BorderLayout.WEST);
		
		JPanel pnPhai = new JPanel();
		pnPhai.setBackground(new Color(51, 102, 153));
		pnPhai.setPreferredSize(new Dimension(20, 0));
		add(pnPhai, BorderLayout.EAST);
		
		JPanel pnCuoi = new JPanel();
		pnCuoi.setBackground(new Color(51, 102, 153));
		pnCuoi.setPreferredSize(new Dimension(0, 20));
		add(pnCuoi, BorderLayout.SOUTH);
		
		JPanel pnChinh = new JPanel();
		add(pnChinh, BorderLayout.CENTER);
		pnChinh.setLayout(new BorderLayout(0, 0));
		
		JPanel pnChucNang = new JPanel();
		pnChucNang.setBackground(new Color(230, 230, 250));
		pnChucNang.setPreferredSize(new Dimension(0, 300));
		pnChinh.add(pnChucNang, BorderLayout.NORTH);
		pnChucNang.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÍ TUYẾN BAY");
		lblNewLabel.setForeground(new Color(255, 140, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(426, 10, 305, 40);
		pnChucNang.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Tuyến");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setPreferredSize(new Dimension(100, 13));
		lblNewLabel_1.setBounds(107, 85, 100, 30);
		pnChucNang.add(lblNewLabel_1);
		
		txtMaTuyen = new JTextField();
		txtMaTuyen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaTuyen.setBounds(229, 86, 120, 30);
		pnChucNang.add(txtMaTuyen);
		txtMaTuyen.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Sân Bay Đi");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setPreferredSize(new Dimension(100, 13));
		lblNewLabel_1_1.setBounds(426, 85, 100, 30);
		pnChucNang.add(lblNewLabel_1_1);
		
		cbxSBD = new JComboBox();
		cbxSBD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getCBXSanBayDen();
				
			}
		});
		cbxSBD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxSBD.setBounds(534, 85, 193, 30);
		pnChucNang.add(cbxSBD);
		
		cbxSBDen = new JComboBox();
		cbxSBDen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxSBDen.setBounds(946, 85, 193, 30);
		pnChucNang.add(cbxSBDen);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Sân Bay Đến");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setPreferredSize(new Dimension(100, 13));
		lblNewLabel_1_1_1.setBounds(838, 85, 100, 30);
		pnChucNang.add(lblNewLabel_1_1_1);
		
		txtTGD = new JTextField();
		txtTGD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTGD.setColumns(10);
		txtTGD.setBounds(229, 164, 120, 30);
		pnChucNang.add(txtTGD);
		
		JLabel lblNewLabel_1_2 = new JLabel("Thời Gian Dừng");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setPreferredSize(new Dimension(100, 13));
		lblNewLabel_1_2.setBounds(107, 163, 112, 30);
		pnChucNang.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Sân Bay TG 1");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_2.setPreferredSize(new Dimension(100, 13));
		lblNewLabel_1_1_2.setBounds(426, 164, 100, 30);
		pnChucNang.add(lblNewLabel_1_1_2);
		
		cbxSBTG1 = new JComboBox();
		cbxSBTG1.setModel(new DefaultComboBoxModel(new String[] {" "}));
		cbxSBTG1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxSBTG1.setBounds(534, 164, 193, 30);
		pnChucNang.add(cbxSBTG1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Sân Bay TG 2");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setPreferredSize(new Dimension(100, 13));
		lblNewLabel_1_1_1_1.setBounds(838, 164, 100, 30);
		pnChucNang.add(lblNewLabel_1_1_1_1);
		
		cbxSBTG2 = new JComboBox();
		cbxSBTG2.setModel(new DefaultComboBoxModel(new String[] {" "}));
		cbxSBTG2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxSBTG2.setBounds(946, 164, 193, 30);
		pnChucNang.add(cbxSBTG2);
		
	
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaTuyen.setEditable(false);
				TuyenBayDTO tb = new TuyenBayDTO();
				int i=tblTB.getSelectedRow();
				tb.setMaTuyenBay(tblTB.getValueAt(i, 0).toString());
				tb.setMaSanDi(tblTB.getValueAt(i, 1).toString());
				tb.setMaSanDen(tblTB.getValueAt(i, 2).toString());
				tb.setSanBayTG1(cbxSBTG1.getSelectedItem().toString());
				tb.setSanBayTG2(cbxSBTG2.getSelectedItem().toString());
				tb.setThoiGianDung(Integer.parseInt(txtTGD.getText()));
				int j = tbBus.suaTB(tb);
				if(i>=0) {
					
						if(j>0) {
							JOptionPane.showMessageDialog(null, "Đã sửa thành công");
							getDSTB();
							txtMaTuyen.setEditable(true);
							txtMaTuyen.setText("");
							txtTGD.setText("");
							cbxSBD.setSelectedIndex(0);
							cbxSBDen.setSelectedIndex(0);
						}else {
							JOptionPane.showMessageDialog(null, "Không thể sửa do lỗi dữ liệu");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Hãy chọn dữ liệu trong table để sữa");
					}
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSua.setIcon(new ImageIcon("C:\\LapTrinhJava\\QL_Ban_Ve_May_Bay\\src\\images\\Store Setting.png"));
		btnSua.setBounds(615, 237, 120, 53);
		pnChucNang.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=tblTB.getSelectedRow();
				if(i>=0) {
					String maTuyen = txtMaTuyen.getText();
					List<ChuyenBayDTO> dstbXoa = cbBus.getDSCBTheoMaTuyen(maTuyen);
					JOptionPane.showMessageDialog(null, maTuyen);
					for (ChuyenBayDTO cb : dstbXoa) {
						int k=cbBus.BUSXoaChuyenBay(cb.getMaChuyenBay());
					}
					int j = tbBus.xoaTB(maTuyen);
					if(j>0) {
						JOptionPane.showMessageDialog(null, "Đã xóa");
						getDSTB();
						getCBtuTB();
						txtMaTuyen.setText("");
						txtTGD.setText("");
						cbxSBD.setSelectedIndex(0);
						cbxSBDen.setSelectedIndex(0);
					}else {
						JOptionPane.showMessageDialog(null, "Không thể xóa");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Chọn dòng dữ liệu khi xóa");
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoa.setIcon(new ImageIcon("C:\\LapTrinhJava\\QL_Ban_Ve_May_Bay\\src\\images\\Cancel Subscription.png"));
		btnXoa.setBounds(838, 237, 110, 53);
		pnChucNang.add(btnXoa);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TuyenBayDTO tb = new TuyenBayDTO();
				tb.setMaTuyenBay(txtMaTuyen.getText());
				String msbdi = dssb.get(cbxSBD.getSelectedItem());
				tb.setMaSanDi(msbdi);
				String msbden = dssb.get(cbxSBDen.getSelectedItem());
				tb.setMaSanDen(msbden);
				tb.setSanBayTG1(dssb.get(cbxSBTG1.getSelectedItem()));
				tb.setSanBayTG2(dssb.get(cbxSBTG2.getSelectedItem()));
				tb.setThoiGianDung(Integer.parseInt(txtTGD.getText()));
				int i= tbBus.themTB(tb);
				if(i>0) {
					
					JOptionPane.showMessageDialog(null, "Đã thêm 1 tuyến bay");
					getDSTB();
					
					txtMaTuyen.setText("");
					txtTGD.setText("");
					cbxSBD.setSelectedIndex(0);
					cbxSBDen.setSelectedIndex(0);
				}else {
					JOptionPane.showMessageDialog(null, "Không thể thêm, hãy kiểm tra dữ liệu vào");
				}
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThem.setIcon(new ImageIcon("C:\\LapTrinhJava\\QL_Ban_Ve_May_Bay\\src\\images\\Add Property.png"));
		btnThem.setBounds(426, 237, 120, 53);
		pnChucNang.add(btnThem);
		
		JButton btnTimKiem = new JButton("");
		btnTimKiem.setIcon(new ImageIcon("C:\\LapTrinhJava\\QL_Ban_Ve_May_Bay\\bin\\images\\Search.png"));
		btnTimKiem.setBounds(107, 237, 100, 53);
		pnChucNang.add(btnTimKiem);
		
		txtTimKiem = new JTextField();
		txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				timKiemTheoMa();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				timKiemTheoMa();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				timKiemTheoMa();
				
			}
		});
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(217, 260, 120, 30);
		pnChucNang.add(txtTimKiem);
		
		JLabel lblNewLabel_2 = new JLabel("Mã tuyến bay?");
		lblNewLabel_2.setBounds(217, 237, 120, 23);
		pnChucNang.add(lblNewLabel_2);
		
		JPanel pnTable = new JPanel();
		pnTable.setBackground(new Color(240, 240, 240));
		pnTable.setPreferredSize(new Dimension(0, 330));
		pnChinh.add(pnTable, BorderLayout.SOUTH);
		pnTable.setLayout(new BorderLayout(0, 0));
		
		JPanel pnTB = new JPanel();
		pnTB.setPreferredSize(new Dimension(580, 10));
		pnTable.add(pnTB, BorderLayout.WEST);
		pnTB.setLayout(null);
		
		JLabel lblThngTinTuyn = new JLabel("Thông Tin Tuyến Bay");
		lblThngTinTuyn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThngTinTuyn.setBounds(187, 0, 200, 30);
		pnTB.add(lblThngTinTuyn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 36, 580, 294);
		pnTB.add(scrollPane);
		
		tblTB = new MyTable();
		tblTB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tblTB.getSelectedRow();
				
				if(i>=0) {
					txtMaTuyen.setText(tblTB.getModel().getValueAt(i, 0).toString());
					getCBtuTB();
				}
			}
		});
		
		tblTB.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ma\u0303 tuy\u00EA\u0301n", "S\u00E2n bay \u0111i", "S\u00E2n bay \u0111\u00EA\u0301n", "S\u00E2n bay TG1", "S\u00E2n bay TG2", "Th\u01A1\u0300i gian d\u01B0\u0300ng"
			}
		));
		scrollPane.setViewportView(tblTB);
		
		JPanel pnCB = new JPanel();
		pnCB.setPreferredSize(new Dimension(580, 10));
		pnTable.add(pnCB, BorderLayout.EAST);
		pnCB.setLayout(null);
		
		JLabel lblThngTinChuyn = new JLabel("Thông Tin Chuyến Bay");
		lblThngTinChuyn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThngTinChuyn.setBounds(205, 0, 200, 30);
		pnCB.add(lblThngTinChuyn);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 36, 580, 294);
		pnCB.add(scrollPane_1);
		
		tblCB = new MyTable();
		tblCB.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ma\u0303 tuy\u00EA\u0301n", "\u0110i\u00EA\u0301m \u0111i", "\u0110i\u00EA\u0309m \u0111\u00EA\u0301n", "Nga\u0300y \u0111i", "Nga\u0300y \u0111\u00EA\u0301n"
			}
		));
		scrollPane_1.setViewportView(tblCB);
		
		getDSTB();
		getCBXSanBayDi();
		getCBXSanBayDen();
		getCBXSanTG1();
		getCBXSanTG2();

	}

	public void getDSTB() {
		dstb = null;
		dtmTB = (DefaultTableModel) tblTB.getModel();
		dtmTB.setRowCount(0);
		dstb = tbBus.getDstb();
		for (TuyenBayDTO tb : dstb) {
			String[] data = { tb.getMaTuyenBay(), tb.getMaSanDi(), tb.getMaSanDen(), tb.getSanBayTG1(),
					tb.getSanBayTG2(), String.valueOf(tb.getThoiGianDung()) };
			dtmTB.addRow(data);
		}
	}

	public void getCBtuTB() {
		dscb = null;
		dtmCB = (DefaultTableModel) tblCB.getModel();
		dtmCB.setRowCount(0);
		dscb = cbBus.getDSCBTheoMaTuyen(txtMaTuyen.getText());
		for (ChuyenBayDTO cb : dscb) {
			String[] data = { cb.getMaTuyenBay(), cb.getBayTu(), cb.getBayDen(), cb.getNgayDi().toString(),
					cb.getNgayDen().toString() };

			dtmCB.addRow(data);
		}
	}

	public void getCBXSanBayDi() {

		dtmSB = new DefaultComboBoxModel();
		dtmSB = (DefaultComboBoxModel) cbxSBD.getModel();
		for (String tenSb : dssb.keySet()) {
			dtmSB.addElement(tenSb);
		}
	}

	public void getCBXSanBayDen() {
		cbxSBDen.removeAllItems();
		dtmSBDen = new DefaultComboBoxModel();
		dtmSBDen = (DefaultComboBoxModel) cbxSBDen.getModel();
		for (String tenSb : dssb.keySet()) {
			if (!tenSb.equals(cbxSBD.getSelectedItem())) {
				dtmSBDen.addElement(tenSb);
			}

		}
	}

	public void getCBXSanTG1() {
		HashMap<String, String> dssb = sbBus.docMapSB();
		dtmSB = new DefaultComboBoxModel();
		dtmSB = (DefaultComboBoxModel) cbxSBTG1.getModel();
		for (String tenSb : dssb.keySet()) {
			dtmSB.addElement(tenSb);
		}
	}

	public void getCBXSanTG2() {
		HashMap<String, String> dssb = sbBus.docMapSB();
		dtmSB = new DefaultComboBoxModel();
		dtmSB = (DefaultComboBoxModel) cbxSBTG2.getModel();
		for (String tenSb : dssb.keySet()) {
			dtmSB.addElement(tenSb);
		}
	}

	public void timKiemTheoMa() {
		String maTuyen = txtTimKiem.getText();
		dtmTB.setRowCount(0);
		dstb = tbBus.getDstb();
		for (TuyenBayDTO tb : dstb) {
			if (tb.getMaTuyenBay().toLowerCase().contains(maTuyen.toLowerCase())) {
				String[] data = { tb.getMaTuyenBay(), tb.getMaSanDi(), tb.getMaSanDen(), tb.getSanBayTG1(),
						tb.getSanBayTG2(), tb.getThoiGianDung() + "" };
				dtmTB = (DefaultTableModel) tblTB.getModel();
				dtmTB.addRow(data);
			}
		}

	}
}
