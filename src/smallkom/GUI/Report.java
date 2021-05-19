package smallkom.GUI;

import smallkom.Proses.JConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Report extends javax.swing.JFrame {
    Connection con = null;
    public static String idRuangan;
    
    public Report() {
        initComponents();
        con = JConnection.ConnectDb();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        report2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        id_ruangan = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        id_alat = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jenis_kerusakan = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        deskripsi = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        report2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 122, 255));
        jLabel10.setText("LOKASI RUANGAN");

        id_ruangan.setBackground(new java.awt.Color(0, 122, 255));
        id_ruangan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        id_ruangan.setForeground(new java.awt.Color(0, 122, 255));
        id_ruangan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Lokasi -", "Lab TPB Gedung C", "Lab Prodi Gedung C", "Lab TPB LABTEK", "Lab Prodi LABTEK" }));
        id_ruangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_ruanganActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 122, 255));
        jLabel11.setText("NOMOR ALAT");

        id_alat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        id_alat.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 122, 255)));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 122, 255));
        jLabel12.setText("JENIS KERUSAKAN");

        jenis_kerusakan.setBackground(new java.awt.Color(0, 122, 255));
        jenis_kerusakan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jenis_kerusakan.setForeground(new java.awt.Color(0, 122, 255));
        jenis_kerusakan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Jenis Kerusakan -", "Alat tidak hidup", "Perangkat lunak rusak", "Kurang perangkat lunak", "Alat error" }));
        jenis_kerusakan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenis_kerusakanActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 122, 255));
        jLabel13.setText("DESKRIPSI");

        jButton5.setBackground(new java.awt.Color(0, 122, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("LAPOR");
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        deskripsi.setColumns(20);
        deskripsi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deskripsi.setRows(5);
        deskripsi.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 122, 255)));
        jScrollPane1.setViewportView(deskripsi);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smallkom/Image/icons8-go-back-48.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 122, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("CLEAR");
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout report2Layout = new javax.swing.GroupLayout(report2);
        report2.setLayout(report2Layout);
        report2Layout.setHorizontalGroup(
            report2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(report2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(98, 98, 98)
                .addGroup(report2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jenis_kerusakan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id_alat, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id_ruangan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(report2Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 279, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(264, Short.MAX_VALUE))
        );
        report2Layout.setVerticalGroup(
            report2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(report2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(report2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(report2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(id_ruangan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addGap(28, 28, 28)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(id_alat, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jenis_kerusakan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(report2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(report2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(report2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Smallkom objek = new Smallkom();
        objek.setLocationRelativeTo(null);
        objek.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void id_ruanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_ruanganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_ruanganActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            if("- Pilih Jenis Kerusakan -".equals(jenis_kerusakan.getSelectedItem().toString()) || "- Pilih Lokasi -".equals(id_ruangan.getSelectedItem().toString()) || "".equals(id_alat.getText())){
                JOptionPane.showMessageDialog(null, "Harap lengkapi semua data", "Tidak Bisa Lapor", JOptionPane.ERROR_MESSAGE);
            }else{
                int x=0;
                try{
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("select * from lapor");
                    while(rs.next()){
                        x++;
                    }
                }catch(SQLException ex){
                    Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
                }

                if("Lab TPB Gedung C".equals(id_ruangan.getSelectedItem().toString())){
                    //id_ruangan = labgdc_1
                    idRuangan = "labgdc_1";
                }else if("Lab Prodi Gedung C".equals(id_ruangan.getSelectedItem().toString())){
                    //id_ruangan = labgdc_2
                    idRuangan = "labgdc_2";
                }else if("Lab TPB LABTEK".equals(id_ruangan.getSelectedItem().toString())){
                    //id_ruangan = labtek_1
                    idRuangan = "labtek_1";
                }else if("Lab Prodi LABTEK".equals(id_ruangan.getSelectedItem().toString())){
                    //id_ruangan = labtek_2
                    idRuangan = "labtek_2";
                }

                String sql = "insert into lapor values (?, ?, ?, ?, ?, ?)";
                PreparedStatement ps;
                ps = con.prepareStatement(sql);
                ps.setInt(1, x+1);
                ps.setString(2, id_alat.getText());
                ps.setString(3, idRuangan);
                ps.setString(4, jenis_kerusakan.getSelectedItem().toString());
                ps.setString(5, deskripsi.getText());
                ps.setString(6, "Belum Dikerjakan");
                ps.executeUpdate();
            
                String sql1 = "update alat set kondisi = ? where id_alat = ?";
                PreparedStatement ps1= con.prepareStatement(sql1);
                ps1.setString(1, jenis_kerusakan.getSelectedItem().toString());
                ps1.setString(2, id_alat.getText());
                ps1.executeUpdate();
            
                id_alat.setText("");
                deskripsi.setText("");
            }
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Inputan ada yang salah", "Tidak Bisa Lapor", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jenis_kerusakanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenis_kerusakanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jenis_kerusakanActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        id_alat.setText("");
        deskripsi.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea deskripsi;
    private javax.swing.JTextField id_alat;
    private javax.swing.JComboBox<String> id_ruangan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jenis_kerusakan;
    private javax.swing.JPanel report2;
    // End of variables declaration//GEN-END:variables
}
