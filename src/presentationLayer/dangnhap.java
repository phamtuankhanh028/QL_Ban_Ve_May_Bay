package presentationLayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dangnhap extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private int x_mouse;
	private int y_mouse;
	public static boolean kt = false;

	/**
	 * Launch the application.
	 */
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
					dangnhap frame = new dangnhap();
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
	public dangnhap() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0,0,0,0));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 748, 529);
		contentPane.add(panel);
		panel.setLayout(null);
		setBackground(new Color(0,0,0,0));
		panel.setBackground(new Color(0,0,0,0));
		
		JLabel lblNewLabel_1 = new JLabel("USER");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(192, 267, 71, 42);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Consolas", textField.getFont().getStyle() | Font.BOLD, textField.getFont().getSize() + 7));
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField.setBackground(new Color(214,225,226));
		textField.setForeground(new Color(255, 255, 255));
		textField.setBounds(310, 267, 190, 41);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASS");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(192, 330, 71, 42);
		panel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setColumns(10);
		textField_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_1.setBackground(new Color(214, 225, 226));
		textField_1.setBounds(310, 318, 190, 41);
		panel.add(textField_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kt = true;
			}
		});
		btnNewButton.setBounds(320, 397, 119, 42);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(345, 160, 119, 72);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\LapTrinhJava\\QL_Ban_Ve_May_Bay\\src\\images\\anh_dang_nhap.png"));
		lblNewLabel.setBounds(0, 0, 748, 529);
		
		panel.add(lblNewLabel);
		addEvent();
		
	}
	
	private void moveFrame(int x, int y) {
		// TODO Auto-generated method stub
		this.setLocation(x - x_mouse, y - y_mouse);
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
