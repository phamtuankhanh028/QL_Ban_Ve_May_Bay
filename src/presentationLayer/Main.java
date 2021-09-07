package presentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;

public class Main {
	private static DangNhapJPanel login;
	public static void giaodiennimbus() {
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
	}
	public static void giaodienwindows() {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
		
		} catch (InstantiationException ex) {
			
		} catch (IllegalAccessException ex) {
			
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			
		}
	}
	public static void main(String[] args) {
		giaodiennimbus();
		 login = new DangNhapJPanel();
		login.setVisible(true);
		Login();
		
	}
	
	public static void Sleep(long j) {
		try {
			Thread.sleep(j);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void Login() {
		
		while(!DangNhapJPanel.kt) {
			Sleep(1000);
		}
		if(DangNhapJPanel.kt) {
			login.setVisible(false);
			MainFrame mf = new MainFrame();
			mf.setExtendedState(JFrame.MAXIMIZED_BOTH);
			mf.setResizable(false);
			mf.setVisible(true);
		}
		
	}
	
	
}
