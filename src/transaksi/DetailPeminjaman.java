package transaksi;

import model.Alat;

public class DetailPeminjaman {
    // Bantuan AI (Gemini): Membuat kelas DetailPeminjaman dengan relasi asosiasi ke Alat,
    // serta menempatkan atribut jumlah di sini sesuai Langkah E.3.
    private final Alat alat;
    private final int jumlah;

    public DetailPeminjaman(Alat alat, int jumlah) {
        this.alat = alat;
        this.jumlah = jumlah;
    }

    public Alat getAlat() {
        return alat;
    }

    public int getJumlah() {
        return jumlah;
    }

    public String baris() {
        return jumlah + "x " + alat.getNama();
    }
}