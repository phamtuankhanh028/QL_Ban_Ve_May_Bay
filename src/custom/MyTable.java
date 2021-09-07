package custom;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class MyTable extends JTable {

    public MyTable() {
        //======CUSTOM TABLE=======
        this.setFocusable(false);
        this.setIntercellSpacing(new Dimension(0, 0));
        this.setRowHeight(25);
        this.setSelectionBackground(new Color(50, 154, 114));
        this.setSelectionForeground(Color.white);
        this.setFont(new Font("Arial", Font.PLAIN, 14));

        JTableHeader header = this.getTableHeader();
        header.setBackground(new Color(242, 153, 74));
        header.setFont(new Font("Arial", Font.BOLD, 14));
        header.setOpaque(false);
        header.setForeground(Color.BLACK);
        header.setReorderingAllowed(false);
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        //======/CUSTOM TABLE/=======
    }
    
    public MyTable(DefaultTableModel dtm) {
        this();
        this.setModel(dtm);
    }
}