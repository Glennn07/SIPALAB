package eksepsi;

public class DataTidakValidException extends SipalabException {
    public DataTidakValidException(String field, String pesan) {
        super("Data tidak valid pada " + field + ": " + pesan);
    }
}