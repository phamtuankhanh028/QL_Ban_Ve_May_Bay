package presentationLayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.w3c.dom.events.MouseEvent;

public class ChuyenMangHinh {

	private JPanel root;
	private String kindSelected = "";
	private List<DanhSachBean> listItem= null;

	public ChuyenMangHinh(JPanel jpnRoot) {
		this.root = jpnRoot;
	}

	public void setView(JPanel jpnItem, JLabel jlbItem) {
		kindSelected = "TrangChu";

		jpnItem.setBackground(new Color(102, 102, 153));
		jlbItem.setBackground(new Color(102, 102, 153));

		root.removeAll();
		root.setLayout(new BorderLayout());
		root.add(new TrangChuJPanel());
		root.validate();
		root.repaint();
	}

	public void setEvent(List<DanhSachBean> listItem) {
		this.listItem = listItem;
		for (DanhSachBean  item : listItem) {
			item.getJpn().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getLlb()));
		}
	}
	
	class LabelEvent implements MouseListener{

		private String kind;
		private JPanel node;
		private JPanel jpnItem;
		private JLabel jlbItem;
		
		
		
		public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
			super();
			this.kind = kind;
			this.jpnItem = jpnItem;
			this.jlbItem = jlbItem;
		}

		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {
			
			switch (kind) {
			case  "TrangChu": 
				node = new TrangChuJPanel();
				break;
			case "ChuyenBay":
				node = new ChuyenBayJPanel();
				break;
			case "Ve":
				node = new Ve2JPanel();
				break;
			case "TuyenBay":
				node = new TuyenBayJPanel();
				break;
			case "HoaDon":
				node = new HoaDonJPanel();
				break;
			case "NhanVien":
				node = new NhanVienJPanel();
				break;
			case "ThongKe":
				node = new ThongKeJPanel();
				break;
			default :
				break;
			}
			root.removeAll();
			root.setLayout(new BorderLayout());
			root.add(node);
			root.validate();
			root.repaint();
			setChangBackgroud(kind);
		}

		@Override
		public void mousePressed(java.awt.event.MouseEvent e) {
			
			kindSelected = kind;
			jlbItem.setBackground(new Color(102, 102, 153));
			jpnItem.setBackground(new Color(102, 102, 153));
		}

		@Override
		public void mouseReleased(java.awt.event.MouseEvent e) {
			
			
		}

		@Override
		public void mouseEntered(java.awt.event.MouseEvent e) {
			jlbItem.setBackground(new Color(102, 102, 153));
			jpnItem.setBackground(new Color(102, 102, 153));
			
		}

		@Override
		public void mouseExited(java.awt.event.MouseEvent e) {
			
			if(!kindSelected.equalsIgnoreCase(kind)) {
				jlbItem.setBackground(new Color(46, 139, 87));
				jpnItem.setBackground(new Color(46, 139, 87));
			}
		}
		
	}
	
	
	private void setChangBackgroud(String kind) {
		for(DanhSachBean item : listItem) {
			
			if(item.getKind().equalsIgnoreCase(kind)) {
				item.getJpn().setBackground(new Color(102, 102, 153));
				item.getLlb().setBackground(new Color(102, 102, 153));
			}else {
				item.getJpn().setBackground(new Color(47, 139, 87));
				item.getLlb().setBackground(new Color(46, 139, 87));
			}
		}
	}

}
