import model.*; 
import layanan.InventarisLab;
import layanan.LayananPeminjaman;
import layanan.ValidatorAlat;
import transaksi.*;
import pembanding.*;
import eksepsi.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== PENGUJIAN LENGKAP SISTEM SIPALAB (JS 3, 4, 5, & 6 + TUGAS MANDIRI) ===");
        
        // 1. Pengujian Job Sheet 3 & 5 (Inventaris, List, Map, Alat)
        InventarisLab inventaris = new InventarisLab();
        Laptop lap = new Laptop("LP-001", "Asus ROG", 2022, 16, true);
        Proyektor pro = new Proyektor("PJ-001", "Epson EB-X51", 2022, 3300, 1500);
        
        inventaris.tambah(lap);
        inventaris.tambah(pro);

        // Uji Pencarian Map O(1) - Job Sheet 5
        System.out.println("\n--- UJI PENCARIAN MAP (JS 5) ---");
        Alat hasilMap = inventaris.cariKode("LP-001");
        if (hasilMap != null) {
            System.out.println("Ketemu via Map: " + hasilMap.getNama() + " (" + hasilMap.getTahunPerolehan() + ")");
        }

        // Uji Pengurutan Comparator (Urut Tahun) - Job Sheet 5
        System.out.println("\n--- UJI PENGURUTAN BERDASARKAN TAHUN (JS 5) ---");
        for (Alat a : inventaris.urut(new UrutTahun())) {
            System.out.println("- " + a.getNama() + " (Tahun: " + a.getTahunPerolehan() + ")");
        }

        // 2. Pengujian Job Sheet 4 (Relasi Asosiasi, Agregasi, Komposisi)
        System.out.println("\n--- UJI RELASI & PEMINJAMAN (JS 4 & 5) ---");
        Mahasiswa mhs = new Mahasiswa("2505181099", "Glenn Kristian", "TRPL");
        Petugas ptg = new Petugas("198701012015041002", "Bapak Sutrisno");
        
        // Agregasi Laboratorium
        Laboratorium lab = new Laboratorium("LAB-RPL", "Laboratorium Rekayasa PL");
        lab.tambahAlat(lap);
        lab.tambahAlat(pro);
        System.out.println("Jumlah alat di lab: " + lab.jumlahAlat());

        // Peminjaman menggunakan Layanan & Eksepsi - Job Sheet 5 & 6
        LayananPeminjaman layananPeminjaman = new LayananPeminjaman();
        Peminjaman pinjamAktif = null;
        try {
            pinjamAktif = layananPeminjaman.pinjam(mhs, ptg, lap, 1);
            System.out.println("Sukses! Nomor Peminjaman: " + pinjamAktif.getNomorPeminjaman());
            System.out.println("Total item dipinjam: " + pinjamAktif.totalItem());
            
            for (DetailPeminjaman d : pinjamAktif.getDetail()) {
                System.out.println("- " + d.baris());
            }
        } catch (SipalabException e) {
            System.out.println("Tertangkap Exception: " + e.getMessage());
        }

        // 3. Pengujian Job Sheet 6 (Custom Exception & Aturan Bisnis)
        System.out.println("\n--- UJI ATURAN BISNIS & EKSEPSI (JS 6) ---");
        Laptop lap2 = new Laptop("LP-002", "HP ProBook 450", 2022, 8, false); // Contoh alat belum siap
        cobaPinjam(layananPeminjaman, mhs, ptg, lap2);

        // 4. Pengujian Job Sheet 6 - Validasi Masukan dengan ValidatorAlat (Langkah E.4)
        System.out.println("\n--- UJI VALIDASI MASUKAN / VALIDATOR ALAT (JS 6) ---");
        Laptop alatInvalid = new Laptop("LP-999", "Laptop Invalid", 1850, 8, true);
        cobaValidasiAlat(alatInvalid);

        // 5. Pengujian Tugas Mandiri Job Sheet 6 (PeminjamanSudahDitutupException & Hitung Denda)
        System.out.println("\n--- UJI TUGAS MANDIRI (JS 6: PENGEMBALIAN & DENDA) ---");
        if (pinjamAktif != null) {
            try {
                // Pengembalian pertama (Harus Sukses)
                pinjamAktif.kembalikan();
                System.out.println(" BERHASIL mengembalikan peminjaman " + pinjamAktif.getNomorPeminjaman());
                System.out.println("Total Denda: Rp " + pinjamAktif.hitungDenda());

                // Pengembalian kedua (Harus memicu PeminjamanSudahDitutupException)
                System.out.println("Mencoba mengembalikan untuk kedua kalinya...");
                pinjamAktif.kembalikan(); 
            } catch (PeminjamanSudahDitutupException e) {
                System.out.println(" DITOLAK SESUAI ATURAN: " + e.getMessage());
            }
        }

        // Uji Tangguh Input Tahun (Langkah E.4)
        System.out.println("\n--- UJI TANGGUH INPUT TAHUN (JS 6) ---");
        // Uncomment baris di bawah ini kalau mau menguji input interaktif tahun di terminal:
        // ujiTangguh();
        
        System.out.println("\n=== PENGUJIAN SELESAI ===");
    }

    private static void cobaPinjam(LayananPeminjaman layanan, Mahasiswa mhs, Petugas ptg, Alat alat) {
        try {
            Peminjaman p = layanan.pinjam(mhs, ptg, alat, 1);
            System.out.println(" BERHASIL " + p.getNomorPeminjaman());
        } catch (SipalabException e) {
            System.out.println(" DITOLAK " + e.getMessage());
        }
    }

    private static void cobaValidasiAlat(Alat alat) {
        ValidatorAlat validator = new ValidatorAlat();
        try {
            validator.periksa(alat);
            System.out.println(" VALID: Data alat " + alat.getKodeAlat() + " sah.");
        } catch (DataTidakValidException e) {
            System.out.println(" INVALID [" + e.getNamaKolom() + "]: " + e.getMessage());
        }
    }

    public static void ujiTangguh() {
        Scanner masukan = new Scanner(System.in);
        System.out.print("Masukkan tahun perolehan: ");
        try {
            int tahun = Integer.parseInt(masukan.nextLine());
            System.out.println("Tahun tercatat: " + tahun);
        } catch (NumberFormatException e) {
            System.out.println("Tahun harus berupa angka, contoh 2024.");
        }
    }
}