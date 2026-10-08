package layanan;

import java.util.ArrayList;
import java.util.List;
import eksepsi.*;
import model.*; // Pastikan m kecil
import transaksi.Peminjaman;

public class LayananPeminjaman {
    private final List<Peminjaman> riwayat = new ArrayList<>();
    private int nomorUrut = 1;

    public Peminjaman pinjam(Mahasiswa mhs, Petugas ptg, Alat alat, int jumlah)
            throws AlatSedangDipinjamException,
            KuotaPeminjamanHabisException,
            AlatBelumSiapException {

        if (!alat.siapDipinjam()) {
            throw new AlatBelumSiapException(alat.getKodeAlat(),
                    "Periksa kondisi alat pada kolom keterangan.");
        }

        if (hitungPinjamanAktif(mhs) >= Mahasiswa.KUOTA_PEMINJAMAN) {
            throw new KuotaPeminjamanHabisException(mhs.getNama(),
                    Mahasiswa.KUOTA_PEMINJAMAN);
        }

        String nomor = String.format("PJM-%04d", nomorUrut++);
        Peminjaman p = new Peminjaman(nomor, mhs, ptg);
        p.tambahDetail(alat, jumlah);
        riwayat.add(p);
        return p;
    }

    public int hitungPinjamanAktif(Mahasiswa mhs) {
        int n = 0;
        for (Peminjaman p : riwayat) {
            if (!p.sudahKembali() && p.getPeminjam().getNim().equals(mhs.getNim())) {
                n += p.totalItem();
            }
        }
        return n;
    }
}