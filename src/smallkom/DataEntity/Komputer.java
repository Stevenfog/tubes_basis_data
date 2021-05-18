package smallkom.DataEntity;

public class Komputer extends Alat{
    
    public Komputer(String idAlat, String ruangan, Spesifikasi spek, String kondisi){
        super(idAlat, ruangan, spek, kondisi);
    }
    
    public void updateKondisi(String kondisi){
        this.kondisi = kondisi;
    }
}
