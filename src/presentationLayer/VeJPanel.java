/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import BUS.ChuyenBayBUS;
import BUS.HangVeBUS;
import BUS.KhachHangBUS;
import static BUS.KhachHangBUS.dskh;
import BUS.VeBayBUS;
//import static BUS.VeBayBUS.dscb;
import DAO.MyConnect;
import DTO.ChuyenBayDTO;
import DTO.HangVeDTO;
import DTO.KhachHangDTO;
import DTO.VeBayDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static presentationLayer.ChuyenBayJPanel.BUScb;
import static presentationLayer.ChuyenBayJPanel.dscb;

/**
 *
 * @author NguyenDinhTri
 */
public class VeJPanel extends javax.swing.JPanel {

    static VeBayBUS BUSvb = new VeBayBUS();
    static KhachHangBUS BUSkh = new KhachHangBUS();
    static ChuyenBayBUS BUScb = new ChuyenBayBUS();
    static HangVeBUS BUShv = new HangVeBUS();
    
    DefaultTableModel dtm;
    
    public static List<VeBayDTO> dsvb = BUSvb.getDsvb();
    public static List<ChuyenBayDTO> dscb = BUScb.getDscb();
    public static List<KhachHangDTO> dskh = BUSkh.getDskh();
    public static List<HangVeDTO> dshv = BUShv.getDshv();
    
    
    private DefaultComboBoxModel dcbx;

    public VeJPanel() {
        initComponents();
       getMaCB();
        getMaKH();
        getMaHV();
        getDTM();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jDialog1 = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVeBay = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxMaChuyenBay = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxMaHangVe = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jComboBoxMaKhachHang = new javax.swing.JComboBox<>();
        jTextFieldMaVe = new javax.swing.JTextField();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jTableVeBay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã vé", "Mã tuyến bay", "Mã khách hàng", "Mã hạng vé"
            }
        ));
        jTableVeBay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableVeBayMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableVeBay);

        jLabel2.setText("Mã vé");

        jLabel3.setText("Mã chuyến bay");

        jLabel4.setText("Mã khách hàng");

        jComboBoxMaChuyenBay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMaChuyenBayActionPerformed(evt);
            }
        });

        jLabel1.setText("Mã hạng vé");

        jComboBoxMaHangVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMaHangVeActionPerformed(evt);
            }
        });

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Sửa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Xóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Xóa tất cả");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jComboBoxMaKhachHang.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jButton1)
                        .addGap(87, 87, 87)
                        .addComponent(jButton2)
                        .addGap(59, 59, 59)
                        .addComponent(jButton3)
                        .addGap(68, 68, 68)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldMaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxMaChuyenBay, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxMaHangVe, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(416, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxMaChuyenBay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMaVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxMaHangVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(44, 44, 44)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(0, 348, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxMaChuyenBayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMaChuyenBayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMaChuyenBayActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        VeBayDTO vb=new VeBayDTO();
        vb.setMave(jTextFieldMaVe.getText());
        vb.setMachuyenbay(jComboBoxMaChuyenBay.getSelectedItem().toString());
	vb.setMakhachhang(jComboBoxMaKhachHang.getSelectedItem().toString());
	vb.setMahangve(jComboBoxMaHangVe.getSelectedItem().toString());
	
            int i=BUSvb.BUSThemVe(vb);
            if(i > 0) {
                getDTM();
                JOptionPane.showMessageDialog(null, "Đã thêm 1 vé bay");
            
            }
            else {
                JOptionPane.showMessageDialog(null, "fails");
            }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTableVeBayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVeBayMouseClicked
        // TODO add your handling code here:
        int i=jTableVeBay.getSelectedRow();
            jTextFieldMaVe.setText(jTableVeBay.getModel().getValueAt(i, 0).toString());				
            jComboBoxMaChuyenBay.setSelectedItem(jTableVeBay.getModel().getValueAt(i,1).toString());
            jComboBoxMaKhachHang.setSelectedItem(jTableVeBay.getModel().getValueAt(i, 2).toString());
            jComboBoxMaHangVe.setSelectedItem(jTableVeBay.getModel().getValueAt(i, 3).toString());
            
            
          
    }//GEN-LAST:event_jTableVeBayMouseClicked
  
    private void jComboBoxMaHangVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMaHangVeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMaHangVeActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
          
          int i=jTableVeBay.getSelectedRow();
          if(i>=0){
              String mave = jTableVeBay.getModel().getValueAt(i, 0).toString();
              int j=BUSvb.BUSXoaVe(mave);
              if(j>0){
                  JOptionPane.showMessageDialog(null, "Đã Xóa");
                    getDTM();
              }
              else
              {
                  JOptionPane.showMessageDialog(null, "fails");
							
              }
          }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
      VeBayDTO vb=new VeBayDTO();
        vb.setMave(jTextFieldMaVe.getText());
        vb.setMachuyenbay(jComboBoxMaChuyenBay.getSelectedItem().toString());
	vb.setMakhachhang(jComboBoxMaKhachHang.getSelectedItem().toString());
	vb.setMahangve(jComboBoxMaHangVe.getSelectedItem().toString());
	
            int i=BUSvb.BUSSuaVe(vb);
            if(i > 0) {
                getDTM();
                JOptionPane.showMessageDialog(null, "Đã sửa 1 vé bay");
            
            }
            else {
                JOptionPane.showMessageDialog(null, "fails");
            }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int i=BUSvb.BUSXoaVeAll();
        int n= JOptionPane.showConfirmDialog(jButton1,"Bạn muốn xóa","alert",JOptionPane.YES_NO_OPTION);
        if(n == JOptionPane.YES_OPTION)
        {
        if(i>0){
             getDTM();
                JOptionPane.showMessageDialog(null, "Đã xóa toàn bộ vé bay");
            
        }
           else {
               // JOptionPane.showMessageDialog(null, "fails");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "không xóa thì thôi =((");
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    void getDTM(){
        dsvb=null;
        dsvb=BUSvb.getDsvb();
        dtm = (DefaultTableModel) jTableVeBay.getModel();
	dtm.setRowCount(0);
        for (VeBayDTO vb : dsvb ) {
            
            String[] data = { vb.getMave(), vb.getMachuyenbay(), vb.getMakhachhang(), vb.getMahangve()};
                    dtm.addRow(data);
                    
       // jTableVeBay.setModel(dtm);
        }
        }
    
    public void getMaCB() {
		dcbx = new DefaultComboBoxModel();
		dcbx = (DefaultComboBoxModel) jComboBoxMaChuyenBay.getModel();
        for (ChuyenBayDTO mcb : dscb ) {
            
            dcbx.addElement(mcb.getMaChuyenBay());
        }
	}
    public void getMaKH() {
		dcbx = new DefaultComboBoxModel();
		dcbx = (DefaultComboBoxModel) jComboBoxMaKhachHang.getModel();
        for (KhachHangDTO mkh : dskh ) {
            dcbx.addElement(mkh.getMakhachhang());
        }
	}
    
    public void getMaHV() {
		dcbx = new DefaultComboBoxModel();
		dcbx = (DefaultComboBoxModel) jComboBoxMaHangVe.getModel();
        for (HangVeDTO hv : dshv ) {
            
            dcbx.addElement(hv.getMahangve());
            
                      
        }
	}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBoxMaChuyenBay;
    private javax.swing.JComboBox<String> jComboBoxMaHangVe;
    private javax.swing.JComboBox<String> jComboBoxMaKhachHang;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVeBay;
    private javax.swing.JTextField jTextFieldMaVe;
    // End of variables declaration//GEN-END:variables
}
