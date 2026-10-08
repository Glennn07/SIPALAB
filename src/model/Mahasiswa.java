package model;

public class Mahasiswa {
    // Bantuan AI (Gemini): Membuat kelas Mahasiswa sesuai instruksi Job Sheet 4 Langkah E.3.
    
    // INI YANG KURANG WAK (Batas maksimal peminjaman alat):
    public static final int KUOTA_PEMINJAMAN = 3;

    private final String nim;
    private final String nama;
    private final String programStudi;

    public Mahasiswa(String nim, String nama, String programStudi) {
        this.nim = nim;
        this.nama = nama;
        this.programStudi = programStudi;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getProgramStudi() {
        return programStudi;
    }
}