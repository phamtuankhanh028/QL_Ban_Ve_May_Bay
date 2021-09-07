package presentationLayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.prefs.Preferences;

import javax.swing.border.MatteBorder;

import BUS.NhanVienBUS;
import DAO.NhanVienDAO;
import DTO.NhanVienDTO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JCheckBox;

public class DangNhapJPanel extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private int x_mouse;
	private int y_mouse;
	public static boolean kt = false;
	private JPanel panel;
	private JLabel lblThongBaoLoi;
	private JPasswordField txtPassword;
	private int ktLoiSoLanDangNhap = 0;
	public static NhanVienDTO nvdn;

	/**
	 * Launch the application.
	 */
	public Preferences pref = Preferences.userRoot().node("Rememberme");
	private JCheckBox checkboxlogin;
	
	
	public static void main(String[] args) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {

		} catch (InstantiationException ex) {

		} catch (IllegalAccessException ex) {

		} catch (javax.swing.UnsupportedLookAndFeelException ex) {

		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhapJPanel frame = new DangNhapJPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DangNhapJPanel() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 748, 529);
		contentPane.add(panel);
		panel.setLayout(null);
		setBackground(new Color(0, 0, 0, 0));
		panel.setBackground(new Color(0, 0, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setForeground(new Color(70, 130, 180));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(197, 259, 96, 42);
		panel.add(lblNewLabel_1);

		txtEmail = new JTextField();
		txtEmail.setFont(
				new Font("Consolas", txtEmail.getFont().getStyle() | Font.BOLD, txtEmail.getFont().getSize() + 7));
		txtEmail.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		txtEmail.setBackground(new Color(214, 225, 226));
		txtEmail.setForeground(new Color(255, 255, 255));
		txtEmail.setBounds(317, 264, 244, 41);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		txtPassword = new JPasswordField();
		
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setFont(new Font("Consolas", txtPassword.getFont().getStyle() | Font.BOLD,
				txtPassword.getFont().getSize() + 7));
		txtPassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		txtPassword.setBackground(new Color(214, 225, 226));
		txtPassword.setForeground(new Color(255, 255, 255));
		txtPassword.setBounds(317, 264, 244, 41);
		txtPassword.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				/*
				 * if(e.VK_ENTER == KeyEvent.VK_ENTER) { String email = txtEmail.getText();
				 * String password = new String(txtPassword.getPassword()); nvdn =
				 * NhanVienBUS.getNVDN(email, password); if (nvdn != null) { kt = true; } else {
				 * lblThongBaoLoi.setText("Đăng Nhập Thất Bại"); ktLoiSoLanDangNhap++; if
				 * (ktLoiSoLanDangNhap == 3) { System.exit(0); } kt = false; } }
				 */
				
			}
		});
		txtPassword.setBounds(317, 320, 244, 33);
		panel.add(txtPassword);

		JLabel lblNewLabel_1_1 = new JLabel("Mật Khẩu");
		lblNewLabel_1_1.setForeground(new Color(70, 130, 180));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(197, 320, 96, 42);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2 = new JLabel("ĐĂNG NHẬP");
		lblNewLabel_2.setForeground(new Color(255, 165, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setBounds(197, 184, 364, 65);
		panel.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new Color(255, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new Color(240, 240, 240));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int n = JOptionPane.showConfirmDialog(panel, "Bạn có chắc muốn thoát khỏi?", "Thoát",
						JOptionPane.YES_NO_OPTION);
				if (n == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		btnNewButton.setIcon(new ImageIcon(
				"../QL_Ban_Ve_May_Bay/src/images/outline_cancel_presentation_black_24dp.png"));
		btnNewButton.setBounds(647, 62, 33, 28);
		panel.add(btnNewButton);

		JButton btnDangNhap = new JButton("ĐĂNG NHẬP");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnDangNhap.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				/*
				 * String email = txtEmail.getText(); String password = new
				 * String(txtPassword.getPassword());
				 * 
				 * nvdn = NhanVienBUS.getNVDN(email, password); if (nvdn != null) { kt = true; }
				 * else { lblThongBaoLoi.setText("Đăng Nhập Thất Bại"); ktLoiSoLanDangNhap++; if
				 * (ktLoiSoLanDangNhap == 3) { System.exit(0); } kt = false; }
				 */
			}
		});
		 checkboxlogin = new JCheckBox("Nhớ tài khoản");
			checkboxlogin.setBounds(197, 379, 93, 21);
			panel.add(checkboxlogin);
			
		btnDangNhap.setForeground(new Color(25, 25, 112));
		btnDangNhap.setBackground(new Color(210, 105, 30));
		btnDangNhap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDangNhap.setBackground(new Color(25, 25, 112));
				btnDangNhap.setForeground(new Color(210, 105, 30));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnDangNhap.setBackground(new Color(210, 105, 30));
				btnDangNhap.setForeground(new Color(25, 25, 112));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				String email = txtEmail.getText();
				String password = new String(txtPassword.getPassword());
				nvdn = NhanVienBUS.getNVDN(email, password);
				if (nvdn != null) {
					kt = true;
					if (checkboxlogin.isSelected()) {
						pref.put("Email", txtEmail.getText());

						pref.put("Password", txtPassword.getText());
					}
				} else {
					JOptionPane.showMessageDialog(null,"Đăng Nhập Thất Bại");
					ktLoiSoLanDangNhap++;
					if (ktLoiSoLanDangNhap == 3) {
						JOptionPane.showMessageDialog(null, "Phát Hiện Nghi Vấn Hack!!! Thoát");
						System.exit(0);
					}
					kt = false;
				}
			}
		});

		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDangNhap.setBounds(197, 424, 364, 54);
		panel.add(btnDangNhap);

		lblThongBaoLoi = new JLabel("");
		lblThongBaoLoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongBaoLoi.setBackground(new Color(240, 240, 240));
		lblThongBaoLoi.setForeground(Color.RED);
		lblThongBaoLoi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThongBaoLoi.setBounds(220, 448, 327, 28);
		panel.add(lblThongBaoLoi);
		
	
				JLabel lblNewLabel = new JLabel("New label");
				lblNewLabel.setIcon(new ImageIcon("../QL_Ban_Ve_May_Bay/src/images/anh_dang_nhap.png"));
				lblNewLabel.setBounds(0, 0, 748, 529);
				
						panel.add(lblNewLabel);
		addEvent();
		//
		String usr = null;
		usr = pref.get("Email", usr);
		String pass = null;
		pass = pref.get("Password", pass);
		txtEmail.setText(usr);
		txtPassword.setText(pass);
		//

	}

	private void moveFrame(int x, int y) {
		// TODO Auto-generated method stub
		this.setLocation(x - x_mouse, y - y_mouse);
	}
	
	//
	public void savenmailpass(String Email, String Pass) {
		if (Email == null || Pass == null) {
			System.out.println("Loi khong luu duoc email passs");

		} else {
			String user = Email;
			pref.put("Email", Email);
			String pass = Pass;
			pref.put("Password", pass);

		}
	}
	//
	public void checked(boolean remember) {
		if (remember) {
			savenmailpass(txtEmail.getText(), txtPassword.getText());
		} else {
			System.out.println("null");
		}
	}

	public void addEvent() {

		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				x_mouse = arg0.getX();
				y_mouse = arg0.getY();

			}

			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
				moveFrame(arg0.getXOnScreen(), arg0.getYOnScreen());

			}

		});

	}
}
