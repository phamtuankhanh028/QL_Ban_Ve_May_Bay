package presentationLayer;

import java.awt.Component;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.SystemColor;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TrangChuJPanel extends JPanel {
	private static DefaultTableModel dtm;

	/**
	 * Create the panel.
	 */
	public TrangChuJPanel() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel pnHinhAnh = new JPanel();
		pnHinhAnh.setPreferredSize(new Dimension(0, 150));
		panel.add(pnHinhAnh, BorderLayout.NORTH);
		pnHinhAnh.setLayout(new BorderLayout(0, 0));

		JLabel lblAnhBia = new JLabel("");
		lblAnhBia.setPreferredSize(new Dimension(1220, 150));
		lblAnhBia.setSize(1220, 150);
		ImageIcon icon = new ImageIcon("../QL_Ban_Ve_May_Bay/src/images/biaNV.png");
		icon.setImage(icon.getImage().getScaledInstance(lblAnhBia.getWidth(), lblAnhBia.getHeight(),Image.SCALE_AREA_AVERAGING));
		lblAnhBia.setIcon(icon);
		pnHinhAnh.add(lblAnhBia, BorderLayout.CENTER);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 102, 153));
		panel_2.setPreferredSize(new Dimension(30, 0));
		panel.add(panel_2, BorderLayout.WEST);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 102, 153));
		panel_3.setPreferredSize(new Dimension(30, 0));
		panel.add(panel_3, BorderLayout.EAST);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(51, 102, 153));
		panel_4.setPreferredSize(new Dimension(0, 30));
		panel.add(panel_4, BorderLayout.SOUTH);

		JPanel panel_5 = new JPanel();
		panel.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHÀO MỪNG BẠN ĐẾN VỚI VIỆT NAM AIRLINES");
		lblNewLabel.setForeground(new Color(255, 140, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setBounds(0, 0, 1160, 138);
		panel_5.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("../QL_Ban_Ve_May_Bay/bin/images/okok.gif"));
		lblNewLabel_1.setBounds(42, 148, 259, 127);
		panel_5.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("../QL_Ban_Ve_May_Bay/bin/images/okok.gif"));
		lblNewLabel_1_1.setBounds(431, 148, 259, 127);
		panel_5.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon("../QL_Ban_Ve_May_Bay/bin/images/okok.gif"));
		lblNewLabel_1_2.setBounds(821, 148, 259, 127);
		panel_5.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("Các Mục Quản Lý:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_2.setForeground(new Color(255, 140, 0));
		lblNewLabel_2.setBounds(202, 302, 573, 57);
		panel_5.add(lblNewLabel_2);
		
		JLabel jlbChuyenBay = new JLabel("Quản Lý Chuyến Bay");
		jlbChuyenBay.setBackground(new Color(60, 179, 113));
		jlbChuyenBay.setForeground(new Color(51, 102, 153));
		jlbChuyenBay.setFont(new Font("Arial", Font.PLAIN, 23));
		jlbChuyenBay.setBounds(202, 369, 280, 48);
		panel_5.add(jlbChuyenBay);
		
		JLabel jlbVe = new JLabel("Quản Lý Vé Bay");
		jlbVe.setBackground(new Color(60, 179, 113));
		jlbVe.setForeground(new Color(51, 102, 153));
		jlbVe.setFont(new Font("Arial", Font.PLAIN, 23));
		jlbVe.setBounds(202, 427, 280, 48);
		panel_5.add(jlbVe);
		
		JLabel jlbHoaDon = new JLabel("Hóa Đơn");
		jlbHoaDon.setBackground(new Color(60, 179, 113));
		jlbHoaDon.setForeground(new Color(51, 102, 153));
		jlbHoaDon.setFont(new Font("Arial", Font.PLAIN, 23));
		jlbHoaDon.setBounds(202, 485, 280, 48);
		panel_5.add(jlbHoaDon);
		
		JLabel jblTuyenBay = new JLabel("Tuyến Bay");
		jblTuyenBay.setBackground(new Color(60, 179, 113));
		jblTuyenBay.setForeground(new Color(51, 102, 153));
		jblTuyenBay.setFont(new Font("Arial", Font.PLAIN, 23));
		jblTuyenBay.setBounds(622, 369, 280, 48);
		panel_5.add(jblTuyenBay);
		
		JLabel jlbNhanVien = new JLabel("Nhân Viên");
		jlbNhanVien.setBackground(new Color(60, 179, 113));
		jlbNhanVien.setForeground(new Color(51, 102, 153));
		jlbNhanVien.setFont(new Font("Arial", Font.PLAIN, 23));
		jlbNhanVien.setBounds(622, 427, 280, 48);
		panel_5.add(jlbNhanVien);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Sân Bay - Máy Bay");
		lblNewLabel_1_3_1.setBackground(new Color(60, 179, 113));
		lblNewLabel_1_3_1.setForeground(new Color(51, 102, 153));
		lblNewLabel_1_3_1.setFont(new Font("Arial", Font.PLAIN, 23));
		lblNewLabel_1_3_1.setBounds(622, 485, 280, 48);
		panel_5.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_3 = new JLabel("Địa chỉ : 273 An Dương Vương, phường 3, quận 5");
		lblNewLabel_3.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_3.setBounds(860, 588, 269, 28);
		panel_5.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sđt: 0123456789     Email: sgu@gmail.com");
		lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_4.setBounds(860, 627, 259, 28);
		panel_5.add(lblNewLabel_4);

	}

	private void addInternalFrameListener(InternalFrameAdapter internalFrameAdapter) {
		// TODO Auto-generated method stub

	}
}
