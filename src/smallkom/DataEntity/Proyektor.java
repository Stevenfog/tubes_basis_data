package smallkom.DataEntity;

public class Proyektor extends Alat{
    public Proyektor(String idAlat, String ruangan, Spesifikasi spek, String kondisi){
        super(idAlat, ruangan, spek, kondisi);
    }
    
    public void updateKondisi(String kondisi){
        this.kondisi = kondisi;
    }
}
