package com.mycompany.manajemenreservasihotel;

/**
 * @author 
 * Faishal Anwar Hasyim
 * NIM = 32602300021
 */

/**
 * Kelas Kamar untuk merepresentasikan kamar hotel.
 */

public class Kamar {
    private String nomorKamar; // Nomor kamar
    private String tipeKamar; // Tipe kamar (Single, Double, Suite, dll.)
    private double harga; // Harga per malam
    private boolean status; // Status kamar (true jika tersedia, false jika dipesan)

    public Kamar(String nomorKamar, String tipeKamar, double harga) {
        this.nomorKamar = nomorKamar;
        this.tipeKamar = tipeKamar;
        this.harga = harga;
        this.status = true; // Kamar baru tersedia
    }

    // Getter untuk nomor kamar
    public String getNomorKamar() {
        return nomorKamar;
    }

    // Getter untuk tipe kamar
    public String getTipeKamar() {
        return tipeKamar;
    }

    // Getter untuk harga
    public double getHarga() {
        return harga;
    }

    // Getter untuk status
    public boolean isStatus() {
        return status;
    }

    // Setter untuk status
    public void setStatus(boolean status) {
        this.status = status;
    }

    // Mengembalikan status kamar dalam bentuk string
    public String getStatusString() {
        return status ? "Tersedia" : "Dipesan";
    }

    // Menampilkan informasi kamar
    public void tampilkanInfoKamar() {
        System.out.printf("| %-12s | %-10s | %-15.2f | %-10s |\n", nomorKamar, tipeKamar, harga, getStatusString());
    }
}