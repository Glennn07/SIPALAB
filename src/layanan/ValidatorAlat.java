package layanan;

import java.time.Year;
import eksepsi.DataTidakValidException;
import model.Alat;

public class ValidatorAlat {
    // Bantuan AI (Gemini): Kelas validasi masukan form (Langkah E.4)[cite: 8]
    public void periksa(Alat alat) throws DataTidakValidException {
        if (alat.getKodeAlat() == null || alat.getKodeAlat().trim().isEmpty()) {
            throw new DataTidakValidException("Kode alat",
                    "Kode alat tidak boleh kosong.");
        }

        if (alat.getNama() == null || alat.getNama().trim().isEmpty()) {
            throw new DataTidakValidException("Nama",
                    "Nama alat tidak boleh kosong.");
        }

        int tahun = alat.getTahunPerolehan();
        if (tahun < 1990 || tahun > Year.now().getValue()) {
            throw new DataTidakValidException("Tahun perolehan",
                    "Tahun perolehan harus di antara 1990 dan tahun berjalan.");
        }
    }
}