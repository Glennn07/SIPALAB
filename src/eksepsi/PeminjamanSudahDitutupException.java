package eksepsi;

import java.time.LocalDate;

public class PeminjamanSudahDitutupException extends SipalabException {
    public PeminjamanSudahDitutupException(String nomorPeminjaman, LocalDate tanggalKembali) {
        super("Peminjaman " + nomorPeminjaman + " sudah ditutup pada tanggal " + tanggalKembali + ".");
    }
}