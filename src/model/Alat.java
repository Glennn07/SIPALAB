package model;

public abstract class Alat {
    protected String kodeAlat;
    protected String nama;
    protected int tahunPerolehan;

    public Alat(String kodeAlat, String nama, int tahunPerolehan) {
        this.kodeAlat = kodeAlat;
        this.nama = nama;
        this.tahunPerolehan = tahunPerolehan;
    }

    public String deskripsi() {
        return kodeAlat + " - " + nama + " (" + tahunPerolehan + ")";
    }

    public abstract boolean siapDipinjam();

    public String getNama() {
        return nama;
    }

    // WAJIB ADA: Biar nggak error di UrutTahun
    public int getTahunPerolehan() {
        return tahunPerolehan;
    }

    // WAJIB ADA: Biar nggak error di InventarisLab (pencarian)
    public String getKodeAlat() {
        return kodeAlat;
    }
}