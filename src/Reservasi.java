package com.mycompany.manajemenreservasihotel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author 
 * Faishal Anwar Hasyim
 * NIM = 32602300021
 */

/**
 * Kelas Reservasi untuk merepresentasikan reservasi yang dibuat oleh tamu.
 */

public class Reservasi {
    private Tamu tamu; // Tamu yang melakukan reservasi
    private Kamar kamar; // Kamar yang dipesan
    private LocalDate checkIn; // Tanggal check-in
    private LocalDate checkOut; // Tanggal check-out
    private long durasiMenginap; // Durasi menginap dalam hari
    private boolean status; // Status reservasi (true untuk aktif, false untuk dibatalkan)

    public Reservasi(Tamu tamu, Kamar kamar, LocalDate checkIn, LocalDate checkOut) {
        this.tamu = tamu;
        this.kamar = kamar;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.durasiMenginap = ChronoUnit.DAYS.between(checkIn, checkOut); // Menghitung durasi menginap
        this.status = true; // Status awal adalah aktif
    }

    // Getter untuk kamar
    public Kamar getKamar() {
        return kamar;
    }

    // Getter untuk durasi menginap
    public long getDurasiMenginap() {
        return durasiMenginap;
    }

    // Getter untuk status
    public boolean isStatus() {
        return status;
    }

    // Membatalkan reservasi
    public void batalkanReservasi() {
        status = false; // Mengubah status menjadi dibatalkan
        kamar.setStatus(true); // Mengubah status kamar menjadi tersedia
        System.out.println("Reservasi dibatalkan untuk kamar: " + kamar.getNomorKamar());
    }

    // Menampilkan informasi reservasi
    public void tampilkanInfoReservasi() {
        System.out.printf("| %-11s | %-10s | %-16s | %-17s | %-18s | %-7s |\n",
                kamar.getNomorKamar(), kamar.getTipeKamar(), checkIn, checkOut, durasiMenginap, status ? "Aktif" : "Dibatalkan");
    }
}