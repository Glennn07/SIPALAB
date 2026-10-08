package transaksi;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Kembali pakai huruf kecil sesuai kodingan asli lu wak
import model.Mahasiswa;
import model.Petugas;
import model.Alat;

public class Peminjaman {
    private final String nomorPeminjaman;
    private final LocalDate tanggalPinjam;
    private LocalDate tanggalKembali;

    // ASOSIASI
    private final Mahasiswa peminjam;
    private final Petugas penyetuju;

    // KOMPOSISI
    private final List<DetailPeminjaman> detail = new ArrayList<>();

    public Peminjaman(String nomorPeminjaman, Mahasiswa peminjam, Petugas penyetuju) {
        this.nomorPeminjaman = nomorPeminjaman;
        this.peminjam = peminjam;
        this.penyetuju = penyetuju;
        this.tanggalPinjam = LocalDate.now();
    }

    public void tambahDetail(Alat alat, int jumlah) {
        detail.add(new DetailPeminjaman(alat, jumlah));
    }

    public List<DetailPeminjaman> getDetail() {
        return Collections.unmodifiableList(detail);
    }

    public int totalItem() {
        int total = 0;
        for (DetailPeminjaman d : detail) {
            total += d.getJumlah();
        }
        return total;
    }

    // Bantuan AI (Gemini): Tugas Mandiri F.1 - Mengisi tanggal kembali
    public void kembalikan() {
        this.tanggalKembali = LocalDate.now();
    }

    // Bantuan AI (Gemini): Tugas Mandiri F.2 - Menghitung hari terlambat (lebih dari 7 hari)
    public long hitungHariTerlambat() {
        if (tanggalKembali == null) {
            return 0; // Belum dikembalikan
        }
        
        long selisihHari = ChronoUnit.DAYS.between(tanggalPinjam, tanggalKembali);
        if (selisihHari > 7) {
            return selisihHari - 7;
        }
        return 0; // Tidak terlambat
    }

    // ==========================================
    // TAMBAHAN METHOD BARU BIAR NGGAK ERROR DI LAYANANPEMINJAMAN
    // ==========================================

    public boolean sudahKembali() {
        return tanggalKembali != null;
    }

    public Mahasiswa getPeminjam() {
        return peminjam;
    }

    public String getNomorPeminjaman() {
        return nomorPeminjaman;
    }

    public LocalDate getTanggalKembali() {
        return tanggalKembali;
    }
}