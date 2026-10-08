package model;

public class Komponen extends Alat {
    // Bantuan AI (Gemini): Membuat kelas baru untuk membuktikan 
    // kode kebal terhadap perubahan sesuai Langkah E.4.
    private String jenisKomponen;

    public Komponen(String kodeAlat, String nama, int tahunPerolehan, String jenisKomponen) {
        super(kodeAlat, nama, tahunPerolehan);
        this.jenisKomponen = jenisKomponen;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " (Jenis: " + jenisKomponen + ")";
    }

    @Override
    public boolean siapDipinjam() {
        return true; 
    }
}