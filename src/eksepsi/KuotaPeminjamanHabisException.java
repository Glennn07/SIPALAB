package eksepsi;

public class KuotaPeminjamanHabisException extends SipalabException {
    public KuotaPeminjamanHabisException(String namaMahasiswa, int kuota) {
        super("Mahasiswa " + namaMahasiswa + " telah mencapai batas kuota peminjaman (" + kuota + ").");
    }
}