package presentationLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUS.ChuyenBayBUS;
import DTO.ChuyenBayDTO;

import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ChiTietChuyenBay extends JFrame {

	
	private JPanel contentPane;
	public static JLabel lblGioDen;
	public static JLabel lblDiemDi;
	public static JLabel lblDiemDen;
	public static JLabel lblGioDi;
	public static JLabel lblGioDi2;
	public static JLabel lblNgayDi;
	public static JLabel lblGioDen2;
	public static JLabel lblNgayDen;
	public static JLabel lblTuyenbay;
	public static JLabel lblTGB;
	public static JLabel lblMB;
	public ChiTietChuyenBay() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 975, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 160, 122));
		panel.setForeground(new Color(0, 0, 0));
		panel.setPreferredSize(new Dimension(10, 50));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHI TIẾT CHUYẾN BAY");
		lblNewLabel.setBounds(0, 0, 965, 50);
		lblNewLabel.setPreferredSize(new Dimension(43, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBackground(new Color(255, 160, 122));
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(250, 128, 114));
		btnNewButton.setIcon(new ImageIcon("C:\\LapTrinhJava\\QL_Ban_Ve_May_Bay\\src\\images\\x.png"));
		btnNewButton.setBounds(941, 0, 24, 26);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		lblGioDi = new JLabel("");
		lblGioDi.setForeground(new Color(139, 0, 0));
		lblGioDi.setHorizontalAlignment(SwingConstants.CENTER);
		lblGioDi.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGioDi.setBounds(124, 24, 129, 41);
		panel_1.add(lblGioDi);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Khởi hành");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1_2.setBounds(47, 156, 206, 28);
		panel_1.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_4 = new JLabel("Cất cánh: ");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(47, 199, 97, 28);
		panel_1.add(lblNewLabel_1_4);
		
		lblGioDi2 = new JLabel("");
		lblGioDi2.setForeground(new Color(139, 0, 0));
		lblGioDi2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGioDi2.setBounds(154, 199, 156, 28);
		panel_1.add(lblGioDi2);
		
		JLabel lblNewLabel_1_5 = new JLabel("Ngày đi:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_5.setBounds(47, 248, 97, 28);
		panel_1.add(lblNewLabel_1_5);
		
		lblNgayDi = new JLabel("");
		lblNgayDi.setForeground(new Color(139, 0, 0));
		lblNgayDi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNgayDi.setBounds(154, 248, 156, 28);
		panel_1.add(lblNgayDi);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Kết thúc");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1_2_1.setBounds(356, 156, 189, 28);
		panel_1.add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Hạ cánh:");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4_1.setBounds(356, 199, 97, 28);
		panel_1.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Ngày đến:");
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_5_1.setBounds(356, 248, 97, 28);
		panel_1.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Tuyến bay:");
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3_1_1.setBounds(686, 156, 97, 28);
		panel_1.add(lblNewLabel_1_3_1_1);
		
		lblTuyenbay = new JLabel("");
		lblTuyenbay.setForeground(new Color(139, 0, 0));
		lblTuyenbay.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTuyenbay.setBounds(793, 156, 140, 28);
		panel_1.add(lblTuyenbay);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("Thời Gian:");
		lblNewLabel_1_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4_1_1.setBounds(686, 199, 97, 28);
		panel_1.add(lblNewLabel_1_4_1_1);
		
		lblTGB = new JLabel("");
		lblTGB.setForeground(new Color(139, 0, 0));
		lblTGB.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTGB.setBounds(793, 199, 140, 28);
		panel_1.add(lblTGB);
		
		JLabel lblNewLabel_1_5_1_1 = new JLabel("Máy bay:");
		lblNewLabel_1_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_5_1_1.setBounds(686, 248, 97, 28);
		panel_1.add(lblNewLabel_1_5_1_1);
		
		lblMB = new JLabel("");
		lblMB.setForeground(new Color(139, 0, 0));
		lblMB.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMB.setBounds(793, 248, 171, 28);
		panel_1.add(lblMB);
		
		lblGioDen = new JLabel("");
		lblGioDen.setForeground(new Color(139, 0, 0));
		lblGioDen.setHorizontalAlignment(SwingConstants.CENTER);
		lblGioDen.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGioDen.setBounds(691, 24, 129, 41);
		panel_1.add(lblGioDen);
		
		lblDiemDi = new JLabel();
		lblDiemDi.setForeground(new Color(139, 0, 0));
		lblDiemDi.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDiemDi.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiemDi.setBounds(67, 75, 220, 28);
		panel_1.add(lblDiemDi);
		
		lblDiemDen = new JLabel("");
		lblDiemDen.setForeground(new Color(139, 0, 0));
		lblDiemDen.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDiemDen.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiemDen.setBounds(660, 75, 220, 28);
		panel_1.add(lblDiemDen);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\LapTrinhJava\\QL_Ban_Ve_May_Bay\\src\\images\\okok.gif"));
		lblNewLabel_2.setBounds(405, 24, 180, 50);
		panel_1.add(lblNewLabel_2);
		
		lblGioDen2 = new JLabel("");
		lblGioDen2.setForeground(new Color(139, 0, 0));
		lblGioDen2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGioDen2.setBounds(463, 199, 156, 28);
		panel_1.add(lblGioDen2);
		
		lblNgayDen = new JLabel("");
		lblNgayDen.setForeground(new Color(139, 0, 0));
		lblNgayDen.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNgayDen.setBounds(463, 248, 156, 28);
		panel_1.add(lblNgayDen);
	}
}
