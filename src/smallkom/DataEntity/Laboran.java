/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallkom.DataEntity;

/**
 *
 * @author PORTAL
 */
public class Laboran extends User{
    public String nama, kontak, ruangan;
    
    
    public Laboran(String username, String password, String nama, String kontak, String ruangan){
        super(username, password);
        this.nama=nama;
        this.kontak=kontak;
        this.ruangan=ruangan;
    }

    public String getNama() {
        return nama;
    }

    public String getKontak() {
        return kontak;
    }
}
