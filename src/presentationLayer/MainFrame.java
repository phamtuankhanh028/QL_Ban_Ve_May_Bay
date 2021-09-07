package presentationLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.JDesktopPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {

	public JPanel jpnRoot;
	private JPanel jpnView;
	private JPanel jpnTrangChu;
	private JLabel jlbTrangChu;
	private JPanel jpnChuyenBay;
	private JLabel jlbChuyenBay;
	
	private JPanel jpnVe;
	private JLabel jlbVe;
	public JDesktopPane desktopPane;
	private JPanel jpnNhanVien;
	private JLabel jlbNhanVien;
	
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1054, 893);

		
		jpnRoot = new JPanel();
		jpnRoot.setBorder(new EmptyBorder(5, 5, 5, 5));
		jpnRoot.setLayout(new BorderLayout(0, 0));
		setContentPane(jpnRoot);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setAlignmentY(0.0f);
		panel.setAlignmentX(0.0f);
		panel.setPreferredSize(new Dimension(310, 10));
		jpnRoot.add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(47, 79, 79));
		panel_4.setPreferredSize(new Dimension(10, 150));
		panel.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(null);
		
		JLabel lblAnhDN = new JLabel("");
		ImageIcon hinh = new ImageIcon(MainFrame.class.getResource("/images/"+DangNhapJPanel.nvdn.getHinh()));
		hinh.setImage(hinh.getImage().getScaledInstance(173, 110, Image.SCALE_AREA_AVERAGING));
		lblAnhDN.setIcon(hinh);
		lblAnhDN.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnhDN.setBounds(78, 10, 173, 110);
		panel_4.add(lblAnhDN);
		
		JLabel lblTenDN = new JLabel("NV: "+DangNhapJPanel.nvdn.getHo_nv() + " "+DangNhapJPanel.nvdn.getTen_nv());
		lblTenDN.setForeground(new Color(255, 165, 0));
		lblTenDN.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenDN.setFont(new Font("Arial", Font.BOLD, 14));
		lblTenDN.setBounds(52, 117, 218, 33);
		panel_4.add(lblTenDN);
		
		JPanel jpnMenu = new JPanel();
		jpnMenu.setBackground(new Color(47, 79, 79));
		panel.add(jpnMenu, BorderLayout.CENTER);
		
		jpnTrangChu = new JPanel();
		jpnTrangChu.setBackground(new Color(46, 139, 87));
		jpnTrangChu.setPreferredSize(new Dimension(300, 80));
		jpnMenu.add(jpnTrangChu);
		jpnTrangChu.setLayout(null);
		
		jlbTrangChu = new JLabel("M\u00E0n H\u00ECnh Ch\u00EDnh");
		jlbTrangChu.setIcon(new ImageIcon(MainFrame.class.getResource("/images/baseline_home_white_24dp.png")));
		jlbTrangChu.setForeground(new Color(255, 153, 51));
		jlbTrangChu.setFont(new Font("Arial", Font.BOLD, 22));
		jlbTrangChu.setBounds(10, 30, 280, 48);
		jpnTrangChu.add(jlbTrangChu);
		
		jpnChuyenBay = new JPanel();
		jpnChuyenBay.setBackground(new Color(46, 139, 87));
		jpnChuyenBay.setPreferredSize(new Dimension(300, 80));
		jpnMenu.add(jpnChuyenBay);
		jpnChuyenBay.setLayout(null);
		
		jlbChuyenBay = new JLabel("Qu\u1EA3n L\u00FD Chuy\u1EBFn Bay");
		jlbChuyenBay.setIcon(new ImageIcon(MainFrame.class.getResource("/images/baseline_airplanemode_active_white_24dp.png")));
		jlbChuyenBay.setForeground(new Color(255, 153, 51));
		jlbChuyenBay.setFont(new Font("Arial", Font.BOLD, 22));
		jlbChuyenBay.setBounds(10, 23, 280, 48);
		jpnChuyenBay.add(jlbChuyenBay);
		
		jpnVe = new JPanel();
		jpnVe.setBackground(new Color(46, 139, 87));
		jpnVe.setPreferredSize(new Dimension(300, 70));
		jpnMenu.add(jpnVe);
		jpnVe.setLayout(null);
		
		jlbVe = new JLabel("Qu\u1EA3n L\u00FD V\u00E9 Bay");
		jlbVe.setIcon(new ImageIcon(MainFrame.class.getResource("/images/baseline_add_shopping_cart_white_24dp.png")));
		jlbVe.setForeground(new Color(255, 153, 51));
		jlbVe.setFont(new Font("Arial", Font.BOLD, 22));
		jlbVe.setBounds(10, 21, 280, 48);
		jpnVe.add(jlbVe);
		
		JPanel jpnHoaDon = new JPanel();
		jpnHoaDon.setBackground(new Color(46, 139, 87));
		jpnHoaDon.setPreferredSize(new Dimension(300, 80));
		jpnMenu.add(jpnHoaDon);
		jpnHoaDon.setLayout(null);
		
		JLabel jlbHoaDon = new JLabel("Hóa Đơn");
		jlbHoaDon.setIcon(new ImageIcon(MainFrame.class.getResource("/images/baseline_contact_page_white_24dp.png")));
		jlbHoaDon.setForeground(new Color(255, 153, 51));
		jlbHoaDon.setFont(new Font("Arial", Font.BOLD, 22));
		jlbHoaDon.setBounds(10, 24, 280, 48);
		jpnHoaDon.add(jlbHoaDon);
		
		JPanel panel_7_1 = new JPanel();
		panel_7_1.setLayout(null);
		panel_7_1.setPreferredSize(new Dimension(300, 80));
		panel_7_1.setBackground(new Color(46, 139, 87));
		jpnMenu.add(panel_7_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Sân Bay - Máy Bay");
		lblNewLabel_1_3_1.setIcon(new ImageIcon("C:\\LapTrinhJava\\QL_Ban_Ve_May_Bay\\bin\\images\\outline_pin_drop_white_24dp.png"));
		lblNewLabel_1_3_1.setForeground(new Color(255, 153, 51));
		lblNewLabel_1_3_1.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel_1_3_1.setBounds(10, 24, 280, 48);
		panel_7_1.add(lblNewLabel_1_3_1);
		

		JPanel jpnTuyenBay = new JPanel();
		jpnTuyenBay.setLayout(null);
		jpnTuyenBay.setPreferredSize(new Dimension(300, 80));
		jpnTuyenBay.setBackground(new Color(46, 139, 87));
		jpnMenu.add(jpnTuyenBay);
		
		JLabel jblTuyenBay = new JLabel("Tuyến Bay");
		jblTuyenBay.setIcon(new ImageIcon("C:\\LapTrinhJava\\QL_Ban_Ve_May_Bay\\bin\\images\\outline_flight_takeoff_white_24dp.png"));
		jblTuyenBay.setForeground(new Color(255, 153, 51));
		jblTuyenBay.setFont(new Font("Arial", Font.BOLD, 22));
		jblTuyenBay.setBounds(10, 24, 280, 48);
		jpnTuyenBay.add(jblTuyenBay);
		
		jpnView = new JPanel();
		jpnRoot.add(jpnView, BorderLayout.CENTER);
		
		
		jpnNhanVien = new JPanel();
		jpnNhanVien.setLayout(null);
		jpnNhanVien.setPreferredSize(new Dimension(300, 80));
		jpnNhanVien.setBackground(new Color(46, 139, 87));
		jpnMenu.add(jpnNhanVien);
		
		jlbNhanVien = new JLabel("Nhân Viên");
		jlbNhanVien.setIcon(new ImageIcon("C:\\LapTrinhJava\\QL_Ban_Ve_May_Bay\\bin\\images\\outline_supervisor_account_white_24dp.png"));
		jlbNhanVien.setForeground(new Color(255, 153, 51));
		jlbNhanVien.setFont(new Font("Arial", Font.BOLD, 22));
		jlbNhanVien.setBounds(10, 24, 280, 48);
		jpnNhanVien.add(jlbNhanVien);
		
		
		desktopPane = new JDesktopPane();
		jpnRoot.add(desktopPane, BorderLayout.NORTH);
		
		
		
		ChuyenMangHinh cmh = new ChuyenMangHinh(jpnView);
		cmh.setView(jpnTrangChu, jlbTrangChu);
		
		List<DanhSachBean> listItem = new ArrayList<>();
		listItem.add(new DanhSachBean("TrangChu", jpnTrangChu, jlbTrangChu));
		listItem.add(new DanhSachBean("ChuyenBay", jpnChuyenBay, jlbChuyenBay));
		listItem.add(new DanhSachBean("Ve", jpnVe, jlbVe));
		listItem.add(new DanhSachBean("TuyenBay", jpnTuyenBay, jblTuyenBay));
		listItem.add(new DanhSachBean("HoaDon", jpnHoaDon, jlbHoaDon));
		listItem.add(new DanhSachBean("NhanVien", jpnNhanVien, jlbNhanVien));
		
		cmh.setEvent(listItem);
	}
}
