/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Proyektor extends Alat implements Terlacak {
    private int lumen;
    private int jamPakaiLampu;
    // Nilai bawaan
    private String noSeri = "-";
    private String lokasi = "Ruang Kuliah 3";

    public Proyektor(String kodeAlat, String nama, int tahunPerolehan, 
                     int lumen, int jamPakaiLampu) {
        super(kodeAlat, nama, tahunPerolehan);
        this.lumen = lumen;
        this.jamPakaiLampu = jamPakaiLampu;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " " + lumen + " lumen";
    }

    @Override
    public boolean siapDipinjam() {
        return jamPakaiLampu <= 2000;
    }

    @Override
    public String nomorSeri() {
        return noSeri;
    }

    @Override
    public String lokasiTerakhir() {
        return lokasi;
    }
}