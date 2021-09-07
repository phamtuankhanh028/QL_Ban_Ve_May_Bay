package Export;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xslf.usermodel.XSLFFontData;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;

public class ExportExcel {

	public void exportExcel(JTable table) {

		JFileChooser chooser = new JFileChooser();
		int i = chooser.showSaveDialog(chooser);
		if (i == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			try {
				
				FileWriter out = new FileWriter(file + ".xls");
				BufferedWriter bwrite = new BufferedWriter(out);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				// ten Cot
				for (int j = 0; j < table.getColumnCount(); j++) {
					bwrite.write(model.getColumnName(j) + "\t");
				}
				bwrite.write("\n");
				// Lay du lieu dong
				for (int j = 0; j < table.getRowCount(); j++) {
					for (int k = 0; k < table.getColumnCount(); k++) {
						bwrite.write(model.getValueAt(j, k) + "\t");
					}
					bwrite.write("\n");
				}
				bwrite.close();
				JOptionPane.showMessageDialog(null, "Lưu file thành công!");
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!");
			}
		}
	}
	
	
	
}