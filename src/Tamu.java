package com.mycompany.manajemenreservasihotel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 
 * Faishal Anwar Hasyim
 * NIM = 32602300021
 */

/**
 * Kelas Tamu untuk merepresentasikan tamu yang melakukan reservasi.
 */

public class Tamu {
    private String nama; // Nama tamu
    private String nomorIdentitas; // Nomor identitas tamu
    private String kontak; // Kontak tamu
    private List<Reservasi> daftarReservasi; // Daftar reservasi yang dimiliki tamu

    public Tamu(String nama, String nomorIdentitas, String kontak) {
        this.nama = nama;
        this.nomorIdentitas = nomorIdentitas;
        this.kontak = kontak;
        this.daftarReservasi = new ArrayList<>();
    }

    // Menambahkan reservasi ke daftar reservasi
    public void tambahReservasi(Reservasi reservasi) {
        daftarReservasi.add(reservasi);
    }

    // Getter untuk nomor identitas
    public String getNomorIdentitas() {
        return nomorIdentitas;
    }

    // Menampilkan informasi tamu dan reservasi aktif
    public void tampilkanInfoTamu() {
        System.out.printf("Nama: %s\nNomor Identitas: %s\nKontak: %s\n", nama, nomorIdentitas, kontak);
        System.out.println("Reservasi Aktif:");
        System.out.println("+-------------+------------+------------------+-------------------+--------------------+---------+");
        System.out.println("| Nomor Kamar | Tipe Kamar | Tanggal Check-In | Tanggal Check-Out | Durasi Menginap    | Status  |");
        System.out.println("+-------------+------------+------------------+-------------------+--------------------+---------+");
        for (Reservasi reservasi : daftarReservasi) {
            reservasi.tampilkanInfoReservasi();
        }
        System.out.println("+-------------+------------+------------------+-------------------+--------------------+---------+");
    }

    // Mengembalikan daftar reservasi
    public List<Reservasi> getDaftarReservasi() {
        return daftarReservasi;
    }
}