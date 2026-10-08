package layanan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.*; 
import pembanding.UrutTahun;

public class InventarisLab {
    // Bantuan AI (Gemini): Membantu menuliskan kerangka kelas InventarisLab 
    // sesuai panduan Job Sheet 3 langkah E.1
    private final List<Alat> daftarAlat = new ArrayList<>();

    public void tambah(Alat alat) {
        daftarAlat.add(alat);
    }

    public List<Alat> semuaAlat() {
        return daftarAlat;
    }

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

    // Bantuan AI (Gemini): Menambahkan method polimorfik murni tanpa percabangan 
    // sesuai instruksi Job Sheet 3 Langkah E.3.
    public void cetakDaftarPolimorfik() {
        for (Alat a : daftarAlat) {
            System.out.println(a.deskripsi());
        }
    }

    // Bantuan AI (Gemini): Menambahkan method penggunaan instanceof yang tepat 
    // untuk menyaring interface/kemampuan khusus, sesuai Langkah E.5.
    public void cetakLokasiPelacakan() {
        for (Alat a : daftarAlat) {
            if (a instanceof Terlacak) {
                Terlacak t = (Terlacak) a;
                System.out.println("Bisa dilacak: " + t.nomorSeri() + " lokasinya di " + t.lokasiTerakhir());
            }
        }
    }

    // Bantuan AI (Gemini): Tugas Mandiri F - Menghitung dan mendaftar alat 
    // secara dinamis tanpa menggunakan instanceof sama sekali.
    public void rekapInventaris() {
        System.out.println("--- Rekapitulasi Jumlah Alat ---");
        
        Map<String, Integer> rekap = new HashMap<>();
        
        for (Alat a : daftarAlat) {
            String jenis = a.getClass().getSimpleName(); 
            rekap.put(jenis, rekap.getOrDefault(jenis, 0) + 1);
        }
        
        for (Map.Entry<String, Integer> entry : rekap.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue() + " unit");
        }
        
        System.out.println("Total Keseluruhan: " + daftarAlat.size() + " unit");
    }

    public Iterable<Alat> urut(UrutTahun urutTahun) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Alat cariKode(String lP001) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}