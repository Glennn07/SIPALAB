package eksepsi;

public class AlatSedangDipinjamException extends SipalabException {
    public AlatSedangDipinjamException(String kodeAlat) {
        super("Alat dengan kode " + kodeAlat + " sedang dipinjam.");
    }
}