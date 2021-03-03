package penjualan.view;

import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import penjualan.entity.Barang;
import penjualan.implement.barangImplement;
import penjualan.interfc.barangInterface;
import penjualan.koneksi.Koneksi;
import sun.util.logging.PlatformLogger;


public class barangView extends javax.swing.JFrame {
    
    List<Barang> record = new ArrayList<Barang>();
    barangInterface barangServis;
    private int row;
    
    
    /**
     * Creates new form barangView
     */
    public barangView() {
        initComponents();
        
        barangServis = new barangImplement();
        tbl_barang.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                row = tbl_barang.getSelectedRow();
                if (row!=-1) {
                    isiText();
                }
            } 
        });
        this.statusAwal();
    }
    
    private void loadData(){
        try {
            record = barangServis.getAll();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error Load Data");
            e.printStackTrace();
        }
        
    }
    
    private void isiTable(){
        Object data[][] = new Object[record.size()][4];
        int x = 0;
        for (Barang barang : record) {
            data[x][0] = barang.getKodeBarang();
            data[x][1] = barang.getNamaBarang();
            data[x][2] = barang.getJumlahBarang();
            data[x][3] = barang.getHargaBarang();
            x++;
        }
            String judul[] = {"Kode Barang","Nama Barang","Jumlah Barang","Harga Barang"};
            tbl_barang.setModel(new DefaultTableModel(data, judul)); 
    }
    
    private void isiText(){
        Barang barang = record.get(row);
        txt_kodeBarang.setText(barang.getKodeBarang());
        txt_namaBarang.setText(barang.getNamaBarang());
        txt_jumlahBarang.setText(String.valueOf(barang.getJumlahBarang()));
        txt_hargaBarang.setText(String.valueOf(barang.getHargaBarang()));
          
    }
    
    private void kosongkanText(){
        txt_kodeBarang.setText("");
        txt_namaBarang.setText("");
        txt_jumlahBarang.setText("");
        txt_hargaBarang.setText("");     
        
    }  
    
    private void statusAwal() {
        kosongkanText();
        loadData();
        isiTable();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_back = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_namaBarang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_jumlahBarang = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_hargaBarang = new javax.swing.JTextField();
        btn_tambah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_barang = new javax.swing.JTable();
        btn_hapus = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        txt_kodeBarang = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jPanel2.setBackground(new java.awt.Color(53, 53, 53));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-company-64.png"))); // NOI18N
        jLabel1.setText("Input");

        btn_back.setBackground(new java.awt.Color(102, 204, 255));
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-home-40.png"))); // NOI18N
        btn_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_backMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_back)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addComponent(btn_back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Kode Barang");

        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Nama Barang");

        txt_namaBarang.setBackground(new java.awt.Color(53, 53, 53));
        txt_namaBarang.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Jumlah");

        txt_jumlahBarang.setBackground(new java.awt.Color(53, 53, 53));
        txt_jumlahBarang.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Harga");

        txt_hargaBarang.setBackground(new java.awt.Color(53, 53, 53));
        txt_hargaBarang.setForeground(new java.awt.Color(255, 255, 255));

        btn_tambah.setBackground(new java.awt.Color(14, 14, 14));
        btn_tambah.setForeground(new java.awt.Color(204, 204, 204));
        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        tbl_barang.setBackground(new java.awt.Color(53, 53, 53));
        tbl_barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Barang", "Nama Barang", "Jumlah", "Harga"
            }
        ));
        jScrollPane1.setViewportView(tbl_barang);

        btn_hapus.setBackground(new java.awt.Color(14, 14, 14));
        btn_hapus.setForeground(new java.awt.Color(204, 204, 204));
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_ubah.setBackground(new java.awt.Color(14, 14, 14));
        btn_ubah.setForeground(new java.awt.Color(204, 204, 204));
        btn_ubah.setText("Ubah");
        btn_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubahActionPerformed(evt);
            }
        });

        txt_kodeBarang.setBackground(new java.awt.Color(53, 53, 53));
        txt_kodeBarang.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_hargaBarang, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_jumlahBarang, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_namaBarang)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_tambah, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_ubah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_hapus))
                            .addComponent(txt_kodeBarang)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 39, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_kodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_jumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_hargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambah)
                    .addComponent(btn_ubah)
                    .addComponent(btn_hapus))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        try{
            Barang barang = new Barang();
            barang.setKodeBarang(txt_kodeBarang.getText());
            barang.setNamaBarang(txt_namaBarang.getText());
            barang.setJumlahBarang(Integer.valueOf(txt_jumlahBarang.getText()));
            barang.setHargaBarang(Integer.valueOf(txt_hargaBarang.getText()));
            
            barangServis.insert(barang);
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "Data Berhasil Ditambahkan");
        } catch(Exception ex){
            Logger.getLogger(barangView.class).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex);
        }   
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        // TODO add your handling code here:
        try{
            Barang barang = new Barang();
            barang.setKodeBarang(txt_kodeBarang.getText());
            barang.setNamaBarang(txt_namaBarang.getText());
            barang.setJumlahBarang(Integer.valueOf(txt_jumlahBarang.getText()));
            barang.setHargaBarang(Integer.valueOf(txt_hargaBarang.getText()));
            
            barangServis.update(txt_kodeBarang.getText(), barang);
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "Data Berhasil Diubah");
        } catch(Exception ex){
            Logger.getLogger(barangView.class).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex);
        } 
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        Barang barang = new Barang();
         String kode = txt_kodeBarang.getText();
         try{
            barangServis.delete(kode);
         }catch(Exception ex){
           Logger.getLogger(barangView.class).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(this, ex);       
         }
         this.statusAwal();
         JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseClicked
        // TODO add your handling code here:
        masterView master = new masterView();
        master.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_backMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(barangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(barangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(barangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(barangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new barangView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_back;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_barang;
    private javax.swing.JTextField txt_hargaBarang;
    private javax.swing.JTextField txt_jumlahBarang;
    private javax.swing.JTextField txt_kodeBarang;
    private javax.swing.JTextField txt_namaBarang;
    // End of variables declaration//GEN-END:variables

}
