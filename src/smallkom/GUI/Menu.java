package smallkom.GUI;

import java.awt.Color;
import smallkom.DataEntity.Spesifikasi;
import smallkom.DataEntity.Laboran;
import smallkom.DataEntity.Alat;
import smallkom.Proses.JConnection;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.print.*;
import java.text.MessageFormat;
import javax.swing.JTable;
import smallkom.DataEntity.Komputer;

public class Menu extends javax.swing.JFrame {
    Connection con = null;
    public DefaultTableModel model;
    public DefaultTableModel model2;
    public int sum;
    
    public Menu(Laboran user) {
        initComponents();
        con = JConnection.ConnectDb();
        this.laboran(user);
        jButton9.setText(user.getNama());
        String[] header1 = {"ALAT","RUANGAN","JENIS","MEREK","HARGA"};
        model = new DefaultTableModel(header1,0);
        rincian_biaya.setModel(model);
        
        String[] header2 = {"NO","ID ALAT","ID RUANGAN","JENIS KERUSAKAN","DESKRIPSI","STATUS"};
        model2 = new DefaultTableModel(header2,0);
        daftar_laporan.setModel(model2);
        
        tampil_rincian_biaya();
        tampil_daftar_laporan();
        tampil_data_alat();
    }
    
    public ArrayList<Alat> alatList(){
        ArrayList<Alat> alatList = new ArrayList<>();
        
        try{
            String query1 = "select * from alat";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1); 
            Alat alat;
            while(rs.next()){
                alat = new Komputer(rs.getString("id_alat"), rs.getString("id_ruangan"), new Spesifikasi(rs.getString("id_spesifikasi")),rs.getString("kondisi"));
                alatList.add(alat);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return alatList;
    }
    
    public void tampil_data_alat(){
        ArrayList<Alat> list = alatList();
        DefaultTableModel model = (DefaultTableModel)data_alat.getModel();
        model.setRowCount(0);
        Object[] baris = new Object[4];
        for(int i=0; i<list.size(); i++){
            
            baris[0]=list.get(i).getID_Alat();
            baris[1]=list.get(i).ruangan;
            baris[2]=list.get(i).spek.idSpek;
            baris[3]=list.get(i).getKondisi();
            model.addRow(baris);
        }
    
    }
    
    public void tampil_rincian_biaya(){
        try{
            String ruangan = null;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select alat.id_alat,alat.id_ruangan,spesifikasi.jenis,spesifikasi.merek,spesifikasi.harga from alat INNER join spesifikasi on alat.id_spesifikasi = spesifikasi.id_spesifikasi");
            sum=0;
            while(rs.next()){
                if("labgdc_1".equals(rs.getString(2))){
                    ruangan = "Lab TPB Gedung C";
                }else if("labgdc_2".equals(rs.getString(2))){
                    ruangan = "Lab Prodi Gedung C";
                }else if("labtek_1".equals(rs.getString(2))){
                    ruangan = "Lab TPB LABTEK";
                }else if("labtek_2".equals(rs.getString(2))){
                    ruangan = "Lab Prodi LABTEK";
                }
                String[] baris = {rs.getString(1),ruangan,rs.getString(3),rs.getString(4),rs.getString(5)}; 
                sum=sum+ rs.getInt(5);
                model.addRow(baris);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void tampil_daftar_laporan(){
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from lapor");
            while(rs.next()){
                String[] baris = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)}; 
                model2.addRow(baris);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void laboran(Laboran user){
        try{
            jLabel7.setText(user.getNama());
            jLabel8.setText(user.getUsername());
            jLabel9.setText(user.getKontak());
            String ruangan = user.ruangan;
            if("labgdc_1".equals(ruangan)){
                jLabel10.setText("Lab TPB Gedung C");
            }else if("labgdc_2".equals(ruangan)){
                jLabel10.setText("Lab Prodi Gedung C");
            }else if("labtek_1".equals(ruangan)){
                jLabel10.setText("Lab TPB LABTEK");
            }else if("labtek_2".equals(ruangan)){
                jLabel10.setText("Lab Prodi LABTEK");
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bodypanel = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        mainpanel = new javax.swing.JPanel();
        datadiri = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        rincianbiaya = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rincian_biaya = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        daftarreport = new javax.swing.JPanel();
        id_alat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        daftar_laporan = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        no_laporan = new javax.swing.JTextField();
        dataalat = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        data_alat = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bodypanel.setBackground(new java.awt.Color(255, 255, 255));

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("Product Sans", 1, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(0, 122, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smallkom/Image/icons8-male-user-48.png"))); // NOI18N
        jButton9.setText("  Data Diri");
        jButton9.setToolTipText("");
        jButton9.setBorder(null);
        jButton9.setBorderPainted(false);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton9.setFocusPainted(false);
        jButton9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton9.setMaximumSize(new java.awt.Dimension(242, 48));
        jButton9.setMinimumSize(new java.awt.Dimension(242, 48));
        jButton9.setPreferredSize(new java.awt.Dimension(242, 70));
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton9MouseExited(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Product Sans", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 122, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smallkom/Image/icons8-money-32.png"))); // NOI18N
        jButton6.setText("  Rincian Biaya");
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setFocusPainted(false);
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton6MouseExited(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Product Sans", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 122, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smallkom/Image/icons8-workstation-32.png"))); // NOI18N
        jButton7.setText("  Data Alat");
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setFocusPainted(false);
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton7MouseExited(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Product Sans", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(0, 122, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smallkom/Image/icons8-system-report-32.png"))); // NOI18N
        jButton8.setText("  Daftar Laporan");
        jButton8.setBorder(null);
        jButton8.setBorderPainted(false);
        jButton8.setFocusPainted(false);
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton8MouseExited(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setFont(new java.awt.Font("Product Sans", 1, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(0, 122, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smallkom/Image/icons8-exit-32.png"))); // NOI18N
        jButton10.setText("  Logout");
        jButton10.setBorder(null);
        jButton10.setBorderPainted(false);
        jButton10.setFocusPainted(false);
        jButton10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton10MouseExited(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        mainpanel.setLayout(new java.awt.CardLayout());

        datadiri.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 122, 255));
        jLabel1.setText(" Nama               :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 122, 255));
        jLabel2.setText("Username         :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 122, 255));
        jLabel3.setText("Kontak              :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 122, 255));
        jLabel7.setText("jLabel7");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 122, 255));
        jLabel8.setText("jLabel8");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 120, 215));
        jLabel9.setText("jLabel9");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 120, 215));
        jLabel10.setText("jLabel10");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 122, 255));
        jLabel11.setText("Ruangan           :");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smallkom/Image/infolaboran_login.png"))); // NOI18N

        javax.swing.GroupLayout datadiriLayout = new javax.swing.GroupLayout(datadiri);
        datadiri.setLayout(datadiriLayout);
        datadiriLayout.setHorizontalGroup(
            datadiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datadiriLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(datadiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(datadiriLayout.createSequentialGroup()
                        .addGroup(datadiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(datadiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)))
                    .addGroup(datadiriLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10))
                    .addGroup(datadiriLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)))
                .addContainerGap(536, Short.MAX_VALUE))
        );
        datadiriLayout.setVerticalGroup(
            datadiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datadiriLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(datadiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addGap(53, 53, 53)
                .addGroup(datadiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8))
                .addGap(63, 63, 63)
                .addGroup(datadiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9))
                .addGap(50, 50, 50)
                .addGroup(datadiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addContainerGap(315, Short.MAX_VALUE))
        );

        mainpanel.add(datadiri, "card2");

        rincianbiaya.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setForeground(new java.awt.Color(0, 122, 255));

        rincian_biaya.setAutoCreateRowSorter(true);
        rincian_biaya.setBackground(new java.awt.Color(254, 254, 254));
        rincian_biaya.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rincian_biaya.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        rincian_biaya.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        rincian_biaya.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rincian_biayaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(rincian_biaya);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 122, 255));
        jButton1.setText("Save");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rincianbiayaLayout = new javax.swing.GroupLayout(rincianbiaya);
        rincianbiaya.setLayout(rincianbiayaLayout);
        rincianbiayaLayout.setHorizontalGroup(
            rincianbiayaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rincianbiayaLayout.createSequentialGroup()
                .addContainerGap(654, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rincianbiayaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        rincianbiayaLayout.setVerticalGroup(
            rincianbiayaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rincianbiayaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainpanel.add(rincianbiaya, "card3");

        daftarreport.setBackground(new java.awt.Color(255, 255, 255));

        id_alat.setForeground(new java.awt.Color(0, 122, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 122, 255));
        jLabel4.setText("Id Alat");

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Status -", "Belum Dikerjakan", "Sedang Dikerjakan", "Selesai" }));
        status.setBorder(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 122, 255));
        jLabel5.setText("Status");

        update.setBackground(new java.awt.Color(255, 255, 255));
        update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        update.setText("Update");
        update.setBorder(null);
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateMouseExited(evt);
            }
        });
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jScrollPane3.setForeground(new java.awt.Color(0, 122, 255));

        daftar_laporan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        daftar_laporan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        daftar_laporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                daftar_laporanMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(daftar_laporan);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 122, 255));
        jLabel12.setText("Nomor Lapor");

        no_laporan.setForeground(new java.awt.Color(0, 122, 255));

        javax.swing.GroupLayout daftarreportLayout = new javax.swing.GroupLayout(daftarreport);
        daftarreport.setLayout(daftarreportLayout);
        daftarreportLayout.setHorizontalGroup(
            daftarreportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(daftarreportLayout.createSequentialGroup()
                .addGroup(daftarreportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(update, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(id_alat)
                    .addComponent(status, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(daftarreportLayout.createSequentialGroup()
                        .addGroup(daftarreportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(no_laporan, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                .addContainerGap())
        );
        daftarreportLayout.setVerticalGroup(
            daftarreportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(daftarreportLayout.createSequentialGroup()
                .addGroup(daftarreportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(daftarreportLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE))
                    .addGroup(daftarreportLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(no_laporan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id_alat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        mainpanel.add(daftarreport, "card5");

        dataalat.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setForeground(new java.awt.Color(0, 122, 255));

        data_alat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        data_alat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Alat", "Ruangan", "Spesifikasi", "Kondisi"
            }
        ));
        jScrollPane2.setViewportView(data_alat);

        javax.swing.GroupLayout dataalatLayout = new javax.swing.GroupLayout(dataalat);
        dataalat.setLayout(dataalatLayout);
        dataalatLayout.setHorizontalGroup(
            dataalatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataalatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                .addContainerGap())
        );
        dataalatLayout.setVerticalGroup(
            dataalatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataalatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainpanel.add(dataalat, "card4");

        javax.swing.GroupLayout bodypanelLayout = new javax.swing.GroupLayout(bodypanel);
        bodypanel.setLayout(bodypanelLayout);
        bodypanelLayout.setHorizontalGroup(
            bodypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodypanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bodypanelLayout.setVerticalGroup(
            bodypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodypanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bodypanelLayout.createSequentialGroup()
                        .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodypanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodypanel, javax.swing.GroupLayout.PREFERRED_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        mainpanel.removeAll();
        mainpanel.repaint();
        mainpanel.revalidate();
        
        mainpanel.add(rincianbiaya);
        mainpanel.repaint();
        mainpanel.revalidate();
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        mainpanel.removeAll();
        mainpanel.repaint();
        mainpanel.revalidate();

        mainpanel.add(dataalat);
        mainpanel.repaint();
        mainpanel.revalidate();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        mainpanel.removeAll();
        mainpanel.repaint();
        mainpanel.revalidate();

        mainpanel.add(datadiri);
        mainpanel.repaint();
        mainpanel.revalidate();

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        mainpanel.removeAll();
        mainpanel.repaint();
        mainpanel.revalidate();

        mainpanel.add(daftarreport);
        mainpanel.repaint();
        mainpanel.revalidate();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        Smallkom objek = new Smallkom();
        objek.setLocationRelativeTo(null);
        objek.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        String kondisi = null;
        if("".equals(id_alat.getText()) || "- Pilih Status -".equals(status.getSelectedItem().toString()) || "".equals(no_laporan.getText())){
            JOptionPane.showMessageDialog(null, "Harap lengkapi semua data", "Tidak Bisa Update", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                if("Selesai".equals(status.getSelectedItem().toString())){
                    String sql2 = "update lapor set status = ? where no_laporan = ?"; 
                    PreparedStatement ps2 = con.prepareStatement(sql2);
                    ps2.setString(1, "Selesai");
                    ps2.setString(2, no_laporan.getText());
                    ps2.executeUpdate();
                }else if("Sedang Dikerjakan".equals(status.getSelectedItem().toString())){
                    String sql2 = "update lapor set status = ? where no_laporan = ?"; 
                    PreparedStatement ps2 = con.prepareStatement(sql2);
                    ps2.setString(1, "Sedang Dikerjakan");
                    ps2.setString(2, no_laporan.getText());
                    ps2.executeUpdate();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Inputan ada yang salah", "Tidak Bisa Lapor", JOptionPane.ERROR_MESSAGE);
            }
            
            try {
                String sql1 = "update alat set kondisi = ? where id_alat = ?";
                PreparedStatement ps1 = con.prepareStatement(sql1);
                if("Selesai".equals(status.getSelectedItem().toString())){
                    kondisi = "baik";
                    ps1.setString(1, kondisi);
                    ps1.setString(2, id_alat.getText());
                    ps1.executeUpdate();
                }
                
                String[] header2 = {"No","Id Alat","Id Ruangan","Jenis Kerusakan","Deskripsi","Status"};
                model2 = new DefaultTableModel(header2,0);
                daftar_laporan.setModel(model2);
                tampil_daftar_laporan();
                
                tampil_data_alat();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Inputan ada yang salah", "Tidak Bisa Lapor", JOptionPane.ERROR_MESSAGE);
            } 
        }
    }//GEN-LAST:event_updateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        MessageFormat header = new MessageFormat("Laporan Rincian Biaya Logistik Laboratorium");
        MessageFormat footer = new MessageFormat("Dengan Total Harga : "+sum);
        
        try{
            rincian_biaya.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            
            JOptionPane.showMessageDialog(null, "File Sudah Disimpan", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rincian_biayaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rincian_biayaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rincian_biayaMouseClicked

    private void daftar_laporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daftar_laporanMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) daftar_laporan.getModel();
        int selectedRow = daftar_laporan.getSelectedRow();
        
        no_laporan.setText(model.getValueAt(selectedRow, 0).toString());
        id_alat.setText(model.getValueAt(selectedRow, 1).toString());
        status.setSelectedItem(model.getValueAt(selectedRow, 5).toString());
    }//GEN-LAST:event_daftar_laporanMouseClicked

    private void jButton9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseEntered
        // TODO add your handling code here:
        jButton9.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_jButton9MouseEntered

    private void jButton9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseExited
        // TODO add your handling code here:
        jButton9.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jButton9MouseExited

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        // TODO add your handling code here:
        jButton6.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseExited
        // TODO add your handling code here:
        jButton6.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jButton6MouseExited

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
        // TODO add your handling code here:
        jButton7.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_jButton7MouseEntered

    private void jButton8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseEntered
        // TODO add your handling code here:
        jButton8.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_jButton8MouseEntered

    private void jButton10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseEntered
        // TODO add your handling code here:
        jButton10.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_jButton10MouseEntered

    private void jButton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseExited
        // TODO add your handling code here:
        jButton7.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jButton7MouseExited

    private void jButton8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseExited
        // TODO add your handling code here:
        jButton8.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jButton8MouseExited

    private void jButton10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseExited
        // TODO add your handling code here:
        jButton10.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jButton10MouseExited

    private void updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseEntered
        // TODO add your handling code here:
        update.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_updateMouseEntered

    private void updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseExited
        // TODO add your handling code here:
        update.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_updateMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodypanel;
    private javax.swing.JTable daftar_laporan;
    private javax.swing.JPanel daftarreport;
    private javax.swing.JTable data_alat;
    private javax.swing.JPanel dataalat;
    private javax.swing.JPanel datadiri;
    private javax.swing.JTextField id_alat;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JTextField no_laporan;
    private javax.swing.JTable rincian_biaya;
    private javax.swing.JPanel rincianbiaya;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
