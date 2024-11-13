package com.mycompany.manajemenreservasihotel;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

/**
 * @author 
 * Faishal Anwar Hasyim
 * NIM = 32602300021
 */

/**
 * Kelas Hotel untuk mengelola daftar kamar, tamu, dan reservasi.
 */

public class Hotel {
    private List<Kamar> daftarKamar; // Daftar kamar hotel
    private List<Tamu> daftarTamu; // Daftar tamu hotel
    private List<Reservasi> daftarReservasi; // Daftar reservasi yang dibuat

    public Hotel() {
        daftarKamar = new ArrayList<>();
        daftarTamu = new ArrayList<>();
        daftarReservasi = new ArrayList<>();
    }

    // Menambahkan kamar baru ke daftar kamar
    public void tambahKamar(Kamar kamar) {
        daftarKamar.add(kamar);
    }

    // Menambahkan tamu baru ke daftar tamu
    public void tambahTamu(Tamu tamu) {
        daftarTamu.add(tamu);
    }

    // Mengembalikan daftar tamu
    public List<Tamu> getDaftarTamu() {
        return daftarTamu;
    }

    // Mengembalikan daftar kamar
    public List<Kamar> getDaftarKamar() {
        return daftarKamar;
    }

    // Membuat reservasi baru
    public void buatReservasi(Tamu tamu, Kamar kamar, LocalDate checkIn, LocalDate checkOut) {
        Reservasi reservasi = new Reservasi(tamu, kamar, checkIn, checkOut);
        tamu.tambahReservasi(reservasi);
        daftarReservasi.add(reservasi);
        kamar.setStatus(false); // Mengubah status kamar menjadi tidak tersedia
        System.out.println("Reservasi berhasil dibuat.");
    }

    // Membatalkan reservasi
    public void batalkanReservasi(Reservasi reservasi) {
        reservasi.batalkanReservasi();
        daftarReservasi.remove(reservasi);
        System.out.println("Reservasi berhasil dibatalkan.");
    }

    // Menampilkan daftar kamar yang tersedia
    public void daftarKamarTersedia() {
        System.out.println("Daftar Kamar:");
        System.out.println("+--------------+------------+-----------------+------------+");
        System.out.printf("| Nomor Kamar  | Tipe Kamar | Harga per Malam | Status     |\n");
        System.out.println("+--------------+------------+-----------------+------------+");
        for (Kamar kamar : daftarKamar) {
            kamar.tampilkanInfoKamar();
        }
        System.out.println("+--------------+------------+-----------------+------------+");
    }
}