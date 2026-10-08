package eksepsi;

import java.time.LocalDate;

public class PeminjamanSudahDitutupException extends SipalabException {
    public PeminjamanSudahDitutupException(String nomorPeminjaman, LocalDate tanggalKembaliPertama) {
        super("Peminjaman " + nomorPeminjaman + " sudah ditutup dan dikembalikan pada " + tanggalKembaliPertama + ".");
    }
}