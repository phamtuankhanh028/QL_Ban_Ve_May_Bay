package presentationLayer;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;

public class ThongKeJPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public ThongKeJPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnAnhBia = new JPanel();
		pnAnhBia.setPreferredSize(new Dimension(0, 150));
		add(pnAnhBia, BorderLayout.NORTH);
		pnAnhBia.setLayout(new BorderLayout(0, 0));
		
		JLabel lblAnhBia = new JLabel("");
		lblAnhBia = new JLabel("");
		lblAnhBia.setPreferredSize(new Dimension(1220, 150));
		lblAnhBia.setSize(1220, 150);
		ImageIcon ic = new ImageIcon("C:\\LapTrinhJava\\QL_Ban_Ve_May_Bay\\images\\biaNV.png");
		ic.setImage(ic.getImage().getScaledInstance(lblAnhBia.getWidth(), lblAnhBia.getHeight(), Image.SCALE_AREA_AVERAGING));
		lblAnhBia.setIcon(ic);
		pnAnhBia.add(lblAnhBia, BorderLayout.CENTER);
		
		JPanel pnTrai = new JPanel();
		pnTrai.setBackground(new Color(51, 102, 204));
		pnTrai.setPreferredSize(new Dimension(20, 0));
		add(pnTrai, BorderLayout.WEST);
		
		JPanel pnPhai = new JPanel();
		pnPhai.setBackground(new Color(51, 102, 204));
		pnPhai.setPreferredSize(new Dimension(20, 0));
		add(pnPhai, BorderLayout.EAST);
		
		JPanel pnDuoi = new JPanel();
		pnDuoi.setBackground(new Color(51, 102, 204));
		pnDuoi.setPreferredSize(new Dimension(0, 20));
		add(pnDuoi, BorderLayout.SOUTH);
		
		JPanel pnChinh = new JPanel();
		add(pnChinh, BorderLayout.CENTER);
		pnChinh.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(570, 10));
		pnChinh.add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(0, 250));
		panel.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(112, 10, 340, 65);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(10, 100, 116, 25);
		panel_2.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(10, 135, 116, 25);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(0, 330));
		panel.add(panel_3, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(570, 0));
		pnChinh.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(0, 250));
		panel_1.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(165, 10, 293, 48);
		panel_4.add(lblNewLabel_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setPreferredSize(new Dimension(0, 330));
		panel_1.add(panel_5, BorderLayout.SOUTH);

	}
}
