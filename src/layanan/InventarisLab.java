package layanan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Alat;
import pembanding.UrutStatusLaluNama;

public class InventarisLab {
    
    private List<Alat> daftarAlat = new ArrayList<>();
    private final Map<String, Alat> petaAlat = new HashMap<>();

    public void tambah(Alat alat) {
        daftarAlat.add(alat);
        petaAlat.put(alat.getKodeAlat(), alat);
    }

    public List<Alat> urut(Comparator<Alat> pembanding) {
        List<Alat> salinan = new ArrayList<>(daftarAlat);
        salinan.sort(pembanding);
        return salinan;
    }

    public List<Alat> urutBawaan() {
        return urut(new UrutStatusLaluNama());
    }

    public void hapusYangTidakSiap() {
        daftarAlat.removeIf(a -> !a.siapDipinjam());
    }

    public List<Alat> cari(String kata) {
        String k = kata.toLowerCase();
        List<Alat> hasil = new ArrayList<>();
        for (Alat a : daftarAlat) {
            if (a.getNama().toLowerCase().contains(k) 
                || a.getKodeAlat().toLowerCase().contains(k)) {
                hasil.add(a);
            }
        }
        return hasil;
    }

    public Alat cariKode(String kode) {
        return petaAlat.get(kode);
    }
}