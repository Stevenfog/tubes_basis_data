package smallkom.DataEntity;

public abstract class Alat {
    public String idAlat, kondisi;
    public Spesifikasi spek;
    public String ruangan;
    
    public Alat (String idAlat, String ruangan, Spesifikasi spek, String kondisi){
        this.idAlat = idAlat;
        this.ruangan = ruangan;
        this.spek = spek;
        this.kondisi = kondisi;
    }

    public String getID_Alat(){
        return idAlat;
    }

    public String getKondisi(){
        return kondisi;
    }
    
    public abstract void updateKondisi(String kondisi);
}
