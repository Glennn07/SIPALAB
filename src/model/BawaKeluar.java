/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

/**
 * Alasan perancangan interface:
 * Interface BawaKeluar dirancang untuk membedakan alat yang boleh dipinjam hingga ke luar area kampus.
 * Pemilihan interface ini sangat tepat karena tidak semua barang, seperti AlatUkur, diizinkan untuk dibawa pulang oleh mahasiswa.
 * Dengan menerapkan interface ini secara selektif, aturan keamanan peminjaman pada sistem SIPALAB menjadi lebih jelas dan terkendali.
 * 
 * Bantuan AI (Gemini): Membantu merancang struktur interface BawaKeluar dan menyusun ide default method untuk memenuhi syarat Tugas Mandiri F.
 */
public interface BawaKeluar {
    boolean izinBawaKeluar();

    default String aturanKeluarKampus() {
        if (izinBawaKeluar()) {
            return "Status Keluar: Diizinkan dibawa keluar kampus dengan surat persetujuan.";
        }
        return "Status Keluar: Dilarang keras dibawa keluar, hanya untuk area laboratorium.";
    }
}