package smallkom.Proses;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import smallkom.DataEntity.Alat;
import smallkom.DataEntity.Komputer;
import smallkom.DataEntity.Laboran;
import smallkom.DataEntity.Spesifikasi;

public class Proses {
    Connection con = JConnection.ConnectDb();
    
    public Laboran logIn (String username, String password){
        String sql = "select * from laboran where id_laboran = ? and password = ?";
        Laboran user;
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String nama = rs.getString("nama");
                String kontak = rs.getString("kontak");
                String ruangan = rs.getString("id_ruangan");
                user = new Laboran(username, password, nama, kontak, ruangan);
                con.close();
                return user;
            }
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
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
    
    
    
}
