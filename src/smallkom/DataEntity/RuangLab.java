package smallkom.DataEntity;

import java.util.TreeSet;

public class RuangLab {
    public String idLab;
    public String namaLab;
    public Laboran laboran;
    public TreeSet<Komputer> listKomputer;
    public Proyektor proyektorLab;
    
    public void tambahKomputer(Komputer komputer){
        listKomputer.add(komputer);
    }
}
