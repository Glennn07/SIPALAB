package transaksi;

import eksepsi.PeminjamanSudahDitutupException;
import model.Alat;
import model.Mahasiswa;
import model.Petugas;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Peminjaman {
    private final String nomorPeminjaman;
    private final LocalDate tanggalPinjam;
    private LocalDate tanggalKembali;

    private final Mahasiswa peminjam;
    private final Petugas penyetuju;
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

    // Tugas Mandiri F.2 & F.3: Method kembalikan yang melempar exception jika dipanggil 2 kali
    public void kembalikan() throws PeminjamanSudahDitutupException {
        if (sudahKembali()) {
            throw new PeminjamanSudahDitutupException(nomorPeminjaman, tanggalKembali);
        }
        this.tanggalKembali = LocalDate.now();
    }

    // Tugas Mandiri F.4: Menghitung denda (Rp2.000 per hari keterlambatan, batas peminjaman 7 hari)
    public long hitungDenda() {
        if (tanggalKembali == null) {
            return 0; // Belum dikembalikan
        }
        
        long selisihHari = ChronoUnit.DAYS.between(tanggalPinjam, tanggalKembali);
        if (selisihHari > 7) {
            long hariTerlambat = selisihHari - 7;
            return hariTerlambat * 2000; // Tarif Rp2.000 per hari
        }
        return 0; // Tidak terlambat
    }

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