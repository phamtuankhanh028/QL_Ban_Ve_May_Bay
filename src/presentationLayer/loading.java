package presentationLayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class loading extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loading frame = new loading();
					//frame.setBackground(new Color(0,0,0,0));
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
	public loading() {
		setUndecorated(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 842, 589);
		contentPane.add(panel);
		panel.setLayout(null);
		this.setBackground(new Color(0,0,0,0));
		panel.setBackground(new Color(0,0,0,0));
		
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(184, 87, 524, 399);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setIcon(new ImageIcon("C:\\LapTrinhJava\\QL_Ban_Ve_May_Bay\\src\\images\\load.gif"));
		
		panel.add(lblNewLabel);
		
		this.setLocationRelativeTo(null);
		
		
	}

}
