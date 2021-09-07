package presentationLayer;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class KhachHangJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public KhachHangJPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
	}

}
