package smallkom.DataEntity;

public class Spesifikasi {
    public String idSpek;
    public String merek;
    public int harga;
    
    public Spesifikasi(String idSpek, String merek, int harga){
        this.idSpek = idSpek;
        this.merek = merek;
        this.harga = harga;
    }
    
    public Spesifikasi (String idSpek){
        this.idSpek = idSpek;
    }
}
