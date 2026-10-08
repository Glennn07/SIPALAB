package model;

public class Petugas {
    // Bantuan AI (Gemini): Membuat kelas Petugas sesuai instruksi Job Sheet 4 Langkah E.3.
    private final String nip;
    private final String nama;

    public Petugas(String nip, String nama) {
        this.nip = nip;
        this.nama = nama;
    }

    public String getNip() {
        return nip;
    }

    public String getNama() {
        return nama;
    }
}   