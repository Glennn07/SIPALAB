package pembanding;

import java.util.Comparator;
import model.Alat;

public class UrutTahun implements Comparator<Alat> {
    @Override
    public int compare(Alat a, Alat b) {
        int bandingTahun = Integer.compare(b.getTahunPerolehan(), a.getTahunPerolehan());
        if (bandingTahun != 0) {
            return bandingTahun;
        }
        return a.getNama().compareToIgnoreCase(b.getNama());
    }
}