package layanan;

import java.util.ArrayList;
import java.util.List;
import model.*; // Tambahan import biar Laptop dkk terbaca

public class Inventaris {
    // Bantuan AI (Gemini): Membantu menuliskan kerangka kelas InventarisLab 
    // sesuai panduan Job Sheet 3 langkah E.1
    private final List<Alat> daftarAlat = new ArrayList<>();

    public void tambah(Alat alat) {
        daftarAlat.add(alat);
    }

    public List<Alat> semuaAlat() {
        return daftarAlat;
    } // <--- Tadi kurang kurung kurawal ini wak!

    // Bantuan AI (Gemini): Menambahkan method cetakStatusBercabang 
    // sesuai instruksi Job Sheet 3 Langkah E.2 (sengaja ditulis buruk untuk pembelajaran).
    public void cetakStatusBercabang() {
        for (Alat a : daftarAlat) {
            if (a instanceof Laptop) {
                Laptop l = (Laptop) a;
                System.out.println(l.getNama() + " " + l.siapDipinjam());
            } else if (a instanceof Proyektor) {
                Proyektor p = (Proyektor) a;
                System.out.println(p.getNama() + " " + p.siapDipinjam());
            } else if (a instanceof AlatUkur) {
                AlatUkur u = (AlatUkur) a;
                System.out.println(u.getNama() + " " + u.siapDipinjam());
            }
        }
    }
}