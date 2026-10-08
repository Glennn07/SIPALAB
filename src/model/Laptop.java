/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Laptop extends Alat implements Terlacak, BawaKeluar {
    private final int ramGB;
    private boolean chargerLengkap;
    // Nilai bawaan supaya tidak error dengan konstruktor lama
    private String noSeri = "-"; 
    private String lokasi = "Lab RPL";

    public Laptop(String kodeAlat, String nama, int tahunPerolehan, 
                  int ramGB, boolean chargerLengkap) {
        super(kodeAlat, nama, tahunPerolehan);
        this.ramGB = ramGB;
        this.chargerLengkap = chargerLengkap;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " RAM " + ramGB + " GB";
    }

    @Override
    public boolean siapDipinjam() {
        return chargerLengkap;
    }

    @Override
    public String nomorSeri() {
        return noSeri;
    }

    @Override
    public String lokasiTerakhir() {
        return lokasi;
    }

    @Override
    public boolean izinBawaKeluar() {
        return true;
    }
}