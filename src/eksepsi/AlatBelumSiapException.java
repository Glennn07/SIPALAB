package eksepsi;

public class AlatBelumSiapException extends SipalabException {
    public AlatBelumSiapException(String kodeAlat, String pesan) {
        super("Alat " + kodeAlat + " tidak siap: " + pesan);
    }
}