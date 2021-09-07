package presentationLayer;

import javax.swing.JPanel;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.toedter.calendar.JYearChooser;

import BUS.NhanVienBUS;
import DTO.NhanVienDTO;
import Export.ExportExcel;
import custom.MyTable;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class NhanVienJPanel extends JPanel {
	private JLabel lblAnhBia;
	private JTextField txtHoTen;
	private JTextField txtEmail;
	private JTextField txtPassword;
	private JTextField txtLuong;
	private JTable tblNhanVien;
	private static List<NhanVienDTO> dsnv;
	private NhanVienBUS nvBUS = new NhanVienBUS();
	private DefaultTableModel dtm;
	static final int luongCB=5000000;
	private JTextField txtMaNV;
	private JComboBox cbxGT;
	private JTextField txtHinhAnh;
	private JTextArea txtQueQuan;
	private JTextField txtTimKiem;

	/**
	 * Create the panel.
	 */
	public NhanVienJPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnAnhBia = new JPanel();
		pnAnhBia.setPreferredSize(new Dimension(1220, 150));
		add(pnAnhBia, BorderLayout.NORTH);
		pnAnhBia.setLayout(new BorderLayout(0, 0));
		
		lblAnhBia = new JLabel("");
		lblAnhBia.setPreferredSize(new Dimension(1220, 150));
		lblAnhBia.setSize(1220, 150);
		ImageIcon ic = new ImageIcon("../QL_Ban_Ve_May_Bay/images/biaNV.png");
		ic.setImage(ic.getImage().getScaledInstance(lblAnhBia.getWidth(), lblAnhBia.getHeight(), Image.SCALE_AREA_AVERAGING));
		lblAnhBia.setIcon(ic);
		pnAnhBia.add(lblAnhBia, BorderLayout.CENTER);
		
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
		pnDuLieu.setFont(new Font("Tahoma", Font.BOLD, 25));
		pnDuLieu.setPreferredSize(new Dimension(0, 340));
		pnChinh.add(pnDuLieu, BorderLayout.NORTH);
		pnDuLieu.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblNewLabel.setForeground(new Color(255, 140, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNewLabel.setBounds(383, 0, 369, 54);
		pnDuLieu.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Họ và Tên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(75, 126, 109, 31);
		pnDuLieu.add(lblNewLabel_1);
		
		txtHoTen = new JTextField();
		txtHoTen.setBounds(197, 126, 160, 31);
		pnDuLieu.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Ngày Sinh");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(75, 184, 109, 31);
		pnDuLieu.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Email");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(456, 184, 109, 31);
		pnDuLieu.add(lblNewLabel_1_3);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(578, 184, 160, 31);
		pnDuLieu.add(txtEmail);
		
		JLabel lblNewLabel_1_4 = new JLabel("Giớ Tính");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(75, 240, 109, 31);
		pnDuLieu.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Password");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_5.setBounds(456, 240, 109, 31);
		pnDuLieu.add(lblNewLabel_1_5);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(578, 240, 160, 31);
		pnDuLieu.add(txtPassword);
		
		JLabel lblNewLabel_1_6 = new JLabel("Quê Quán");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_6.setBounds(456, 71, 84, 31);
		pnDuLieu.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Năm Vào Làm");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_7.setBounds(825, 71, 109, 31);
		pnDuLieu.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("Lương");
		lblNewLabel_1_8.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_8.setBounds(825, 126, 84, 31);
		pnDuLieu.add(lblNewLabel_1_8);
		
		txtLuong = new JTextField();
		txtLuong.setColumns(10);
		txtLuong.setBounds(929, 126, 139, 31);
		pnDuLieu.add(txtLuong);
		
		cbxGT = new JComboBox();
		cbxGT.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cbxGT.setBounds(197, 240, 74, 31);
		pnDuLieu.add(cbxGT);
		
		JDateChooser txtNgaySinh = new JDateChooser();
		txtNgaySinh.setBounds(197, 184, 160, 31);
		pnDuLieu.add(txtNgaySinh);
		
		JYearChooser txtNam = new JYearChooser();
		txtNam.setBounds(931, 71, 93, 36);
		pnDuLieu.add(txtNam);
		
		JLabel lblNewLabel_2 = new JLabel("Vnđ");
		lblNewLabel_2.setBounds(1072, 126, 35, 31);
		pnDuLieu.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã Nhân Viên");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(75, 71, 109, 31);
		pnDuLieu.add(lblNewLabel_1_1);
		
		txtMaNV = new JTextField();
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(197, 71, 84, 31);
		pnDuLieu.add(txtMaNV);
		
		JLabel lblNewLabel_1_9 = new JLabel("Ảnh Đại Diện");
		lblNewLabel_1_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_9.setBounds(825, 184, 101, 31);
		pnDuLieu.add(lblNewLabel_1_9);
		
		JLabel lblHinhAnh = new JLabel("");
		lblHinhAnh.setBounds(929, 225, 199, 105);
		pnDuLieu.add(lblHinhAnh);
		
		txtHinhAnh = new JTextField();
		txtHinhAnh.setColumns(10);
		txtHinhAnh.setBounds(929, 184, 168, 31);
		pnDuLieu.add(txtHinhAnh);
		
		txtQueQuan = new JTextArea();
		txtQueQuan.setBounds(577, 71, 175, 86);
		pnDuLieu.add(txtQueQuan);
		
		JButton btnNewButton = new JButton("...");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser jfc = new JFileChooser("src/images");
				jfc.setDialogTitle("Hay chon mot tap tin hinh anh");
				FileNameExtensionFilter ft1 = new FileNameExtensionFilter("Cac tap tin *.jpg", "jpg");
				FileNameExtensionFilter ft2 = new FileNameExtensionFilter("Cac tap tin *.png", "png");
				jfc.setFileFilter(ft1);
				jfc.setFileFilter(ft2);
				int chon = jfc.showOpenDialog(null);
				if(chon == JFileChooser.APPROVE_OPTION) {
					File file = jfc.getSelectedFile();
					String tt = file.getName();
					txtHinhAnh.setText(tt);
					ImageIcon icon = new ImageIcon("../QL_Ban_Ve_May_Bay/src/images/"+tt);
					icon.setImage(icon.getImage().getScaledInstance(lblHinhAnh.getWidth(),lblHinhAnh.getHeight(), Image.SCALE_DEFAULT));
					lblHinhAnh.setIcon(icon);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(1100, 184, 28, 31);
		pnDuLieu.add(btnNewButton);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setForeground(new Color(51, 102, 153));
		btnThem.setFont(new Font("Dialog", Font.BOLD, 15));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVienDTO nv = new NhanVienDTO();
				nv.setEmail(txtEmail.getText());
				nv.setHinh(txtHinhAnh.getText());
				boolean gt;
				if(cbxGT.getSelectedItem().toString().equals("Nam")) {
					gt=true;
				}else {
					gt=false;
				}
				nv.setGioi_tinh(gt);
				nv.setMa_nv(txtMaNV.getText());
				nv.setNam_vao_lam(txtNam.getYear());
				Date ns = new Date(txtNgaySinh.getDate().getTime());
				nv.setNgay_sinh(ns);
				nv.setPassword(txtPassword.getText());
				nv.setQue_quan(txtQueQuan.getText());
				
				String string = txtHoTen.getText();
				String[] parts = string.split(" ", 2);
				String part1 = parts[0]; 
				String part2 = parts[1];
				nv.setHo_nv(part1);
				nv.setTen_nv(part2);
				int i=nvBUS.themNhanVien(nv);
				if(i>0) {
					JOptionPane.showMessageDialog(null, "Đã thêm 1 nhân viên");
					getDsnv();
					txtEmail.setText("");
					txtPassword.setText("");
					txtHinhAnh.setText("");
					txtHoTen.setText("");
					txtMaNV.setText("");
					txtQueQuan.setText("");
					txtLuong.setText("");
					lblHinhAnh.setIcon(null);
					cbxGT.setSelectedIndex(2021);
					txtNam.setYear(0);
					txtNgaySinh.setDate(null);
					
				}else {
					JOptionPane.showMessageDialog(null, "Không thể thêm nhân viên này");
				}
			}
		});
		btnThem.setBounds(456, 291, 85, 49);
		pnDuLieu.add(btnThem);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\LapTrinhJava\\QL_Ban_Ve_May_Bay\\bin\\images\\Search.png"));
		btnNewButton_1.setBounds(99, 291, 85, 49);
		pnDuLieu.add(btnNewButton_1);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setForeground(new Color(51, 102, 153));
		btnSua.setFont(new Font("Dialog", Font.BOLD, 15));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tblNhanVien.getRowCount();
				
				if(row>=0) {
				NhanVienDTO nv = new NhanVienDTO();
				nv.setEmail(txtEmail.getText());
				boolean gt;
				if(cbxGT.getSelectedItem().toString().equals("Nam")) {
					gt=true;
				}else {
					gt=false;
				}
				nv.setGioi_tinh(gt);
				
				nv.setHinh(txtHinhAnh.getText());
				String hoTen=txtHoTen.getText();
				String[] parts = hoTen.split(" ", 2);
				String part1 = parts[0];
				String part2 = parts[1];
				nv.setHo_nv(part1);
				nv.setTen_nv(part2);
				nv.setMa_nv(txtMaNV.getText());
				nv.setNam_vao_lam(txtNam.getYear());
				Date ns = new Date(txtNgaySinh.getDate().getTime());
				nv.setNgay_sinh(ns);
				nv.setPassword(txtPassword.getText());
				nv.setQue_quan(txtQueQuan.getText());
				int i = nvBUS.suaNhanVien(nv);
				
				if(i>0) {
					JOptionPane.showMessageDialog(null, "Đã sửa thông tin nhân viên");
					getDsnv();
					txtEmail.setText("");
					txtPassword.setText("");
					txtHinhAnh.setText("");
					txtHoTen.setText("");
					txtMaNV.setText("");
					txtQueQuan.setText("");
					txtLuong.setText("");
					lblHinhAnh.setIcon(null);
					cbxGT.setSelectedIndex(0);
					txtNam.setYear(2021);
					txtNgaySinh.setDate(null);
				}else {
					JOptionPane.showMessageDialog(null, "Không thể sửa thông tin nhân viên này");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Hãy chọn dữ liệu sửa");
			}
				
			}
		});
		btnSua.setBounds(563, 291, 85, 49);
		pnDuLieu.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setForeground(new Color(51, 102, 153));
		btnXoa.setFont(new Font("Dialog", Font.BOLD, 15));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row=tblNhanVien.getSelectedRow();
				
				if(row>=0) {
					String maNV=tblNhanVien.getModel().getValueAt(row, 0).toString();
					int i=nvBUS.xoaNhanVien(maNV);
					if(i>0) {
						JOptionPane.showMessageDialog(null, "Đã xóa 1 nhân viên");
						getDsnv();
						txtEmail.setText("");
						txtPassword.setText("");
						txtHinhAnh.setText("");
						txtHoTen.setText("");
						txtMaNV.setText("");
						txtQueQuan.setText("");
						txtLuong.setText("");
						lblHinhAnh.setIcon(null);
						cbxGT.setSelectedIndex(0);
						txtNam.setYear(2021);
						txtNgaySinh.setDate(null);
					}else {
						JOptionPane.showMessageDialog(null, "Không thể xóa 1 nhân viên này");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Hãy chọn nhân viên muốn xóa");
				}
				
			}
		});
		btnXoa.setBounds(667, 291, 85, 49);
		pnDuLieu.add(btnXoa);
		
		JButton btnExcel = new JButton("Excel");
		btnExcel.setForeground(new Color(51, 102, 153));
		btnExcel.setFont(new Font("Dialog", Font.BOLD, 15));
		btnExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ExportExcel ex = new ExportExcel();
				ex.exportExcel(tblNhanVien);
				
			}
		});
		
		
		btnExcel.setBounds(788, 291, 85, 49);
		pnDuLieu.add(btnExcel);
		
		JLabel lblNewLabel_3 = new JLabel("Tìm theo họ tên");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(197, 291, 121, 25);
		pnDuLieu.add(lblNewLabel_3);
		
		txtTimKiem = new JTextField();
		txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				getTimKiem();				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				getTimKiem();		
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				getTimKiem();		
			}
		});
		txtTimKiem.setBounds(197, 315, 160, 25);
		pnDuLieu.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JPanel pnTable = new JPanel();
		pnTable.setPreferredSize(new Dimension(0, 320));
		pnChinh.add(pnTable, BorderLayout.SOUTH);
		pnTable.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pnTable.add(scrollPane, BorderLayout.CENTER);
		
		tblNhanVien = new MyTable();
		tblNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=tblNhanVien.getSelectedRow();
				
				if(i>=0) {
				try {
					java.util.Date ngaySinh = new SimpleDateFormat("yyyy-MM-dd").parse(tblNhanVien.getValueAt(i, 2).toString());
					txtNgaySinh.setDate(ngaySinh);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				String email = tblNhanVien.getModel().getValueAt(i, 5).toString();
				String password = tblNhanVien.getModel().getValueAt(i, 6).toString();
				NhanVienDTO nv = nvBUS.getNVDN(email, password);
				txtEmail.setText(nv.getEmail());
				txtPassword.setText(nv.getPassword());
				txtHinhAnh.setText(nv.getHinh());
				txtHoTen.setText(tblNhanVien.getModel().getValueAt(i, 1).toString());
				txtMaNV.setText(nv.getMa_nv());
				txtQueQuan.setText(nv.getQue_quan());
				String luong = String.valueOf(nvBUS.tinhLuong(email, password));
				txtLuong.setText(luong);
				int nam=nv.getNam_vao_lam();
				txtNam.setYear(nam);
				ImageIcon icon = new ImageIcon("../QL_Ban_Ve_May_Bay/src/images/"+nv.getHinh());
				icon.setImage(icon.getImage().getScaledInstance(lblHinhAnh.getWidth(),lblHinhAnh.getHeight(), Image.SCALE_DEFAULT));
				lblHinhAnh.setIcon(icon);
				}
				
			}
		});
		tblNhanVien.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 NV", "H\u1ECD v\u00E0 T\u00EAn", "Ng\u00E0y Sinh", "Gi\u1EDBi T\u00EDnh", "Qu\u00EA Qu\u00E1n", "Email", "Password", "L\u01B0\u01A1ng"
			}
		));
		scrollPane.setViewportView(tblNhanVien);
		
		getDsnv();

	}
	
	
	public void getDsnv() {
		dsnv=null;
		dtm = (DefaultTableModel) tblNhanVien.getModel();
		dtm.setRowCount(0);
		dsnv=nvBUS.getDsnv();
		int luong;
		for (NhanVienDTO nv : dsnv) {
			String gt=null;
			if(nv.isGioi_tinh()==true) {
				gt="Nam";
			}else {
				gt="Nữ";
			}
			luong=nvBUS.tinhLuong(nv.getEmail(), nv.getPassword());
			String[] data = {nv.getMa_nv(), nv.getHo_nv()+" "+nv.getTen_nv(), nv.getNgay_sinh().toString(), gt, nv.getQue_quan(), nv.getEmail(), nv.getPassword(),luong+""};
			dtm.addRow(data);
		}
	}
	
	
	public void getTimKiem() {
		dsnv=null;
		dtm = (DefaultTableModel) tblNhanVien.getModel();
		dtm.setRowCount(0);
		dsnv = nvBUS.getDsnv();
		String tenTim = txtTimKiem.getText();
		for (NhanVienDTO nv : dsnv) {
			String tenNV=nv.getHo_nv()+" "+nv.getTen_nv();
			if(tenNV.toLowerCase().contains(tenTim.toLowerCase())) {
				String gt=null;
				if(nv.isGioi_tinh()==true) {
					gt="Nam";
				}else {
					gt="Nữ";
				}
				int luong=nvBUS.tinhLuong(nv.getEmail(), nv.getPassword());
				
				String[] data = {nv.getMa_nv(), nv.getHo_nv()+" "+nv.getTen_nv(), nv.getNgay_sinh().toString(), gt, nv.getQue_quan(), nv.getEmail(), nv.getPassword(),luong+""};
				dtm.addRow(data);
			}
		}
	}
}
