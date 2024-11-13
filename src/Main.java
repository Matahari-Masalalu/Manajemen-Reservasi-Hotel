package com.mycompany.manajemenreservasihotel;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author 
 * Faishal Anwar Hasyim
 * NIM = 32602300021
 */

/**
 * Kelas Main untuk menjalankan aplikasi manajemen reservasi hotel.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel(); // Membuat objek hotel
        boolean running = true; // Flag untuk menjalankan menu

        while (running) {
            // Menampilkan menu
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Kamar");
            System.out.println("2. Tambah Tamu");
            System.out.println("3. Buat Reservasi");
            System.out.println("4. Batalkan Reservasi");
            System.out.println("5. Daftar Kamar Tersedia");
            System.out.println("6. Tampilkan Informasi Tamu");
            System.out.println("7. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (pilihan) {
                case 1:
                    // Menambahkan kamar baru
                    System.out.print("Masukkan nomor kamar: ");
                    String nomorKamar = scanner.nextLine();
                    System.out.print("Masukkan tipe kamar (Single/Double/Suite): ");
                    String tipeKamar = scanner.nextLine();
                    System.out.print("Masukkan harga per malam: ");
                    double harga = scanner.nextDouble();
                    hotel.tambahKamar(new Kamar(nomorKamar, tipeKamar, harga));
                    System.out.println("Kamar berhasil ditambahkan.");
                    break;
                case 2:
                    // Menambahkan tamu baru
                    System.out.print("Masukkan nama tamu: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan nomor identitas: ");
                    String nomorIdentitas = scanner.nextLine();
                    System.out.print("Masukkan kontak: ");
                    String kontak = scanner.nextLine();
                    hotel.tambahTamu(new Tamu(nama, nomorIdentitas, kontak));
                    System.out.println("Tamu berhasil ditambahkan.");
                    break;
                case 3:
                    // Membuat reservasi baru
                    System.out.print("Masukkan nomor identitas tamu: ");
                    String idTamu = scanner.nextLine();
                    Tamu tamuReservasi = null;
                    for (Tamu tamu : hotel.getDaftarTamu()) {
                        if (tamu.getNomorIdentitas().equals(idTamu)) {
                            tamuReservasi = tamu;
                            break;
                        }
                    }
                    if (tamuReservasi == null) {
                        System.out.println("Tamu tidak ditemukan!");
                        break;
                    }
                    System.out.print("Masukkan nomor kamar: ");
                    String nomorKamarReservasi = scanner.nextLine();
                    Kamar kamarReservasi = null;
                    for (Kamar kamar : hotel.getDaftarKamar()) {
                        if (kamar.getNomorKamar().equals(nomorKamarReservasi)) {
                            kamarReservasi = kamar;
                            break;
                        }
                    }
                    if (kamarReservasi == null || !kamarReservasi.isStatus()) {
                        System.out.println("Kamar tidak tersedia!");
                        break;
                    }
                    System.out.print("Masukkan tanggal check-in (yyyy-mm-dd): ");
                    LocalDate checkIn = LocalDate.parse(scanner.nextLine());
                    System.out.print("Masukkan tanggal check-out (yyyy-mm-dd): ");
                    LocalDate checkOut = LocalDate.parse(scanner.nextLine());
                    hotel.buatReservasi(tamuReservasi, kamarReservasi, checkIn, checkOut);
                    System.out.println("Reservasi berhasil dibuat.");
                    break;
                case 4:
                    // Membatalkan reservasi
                    System.out.print("Masukkan nomor identitas tamu untuk membatalkan reservasi: ");
                    String idTamuBatalkan = scanner.nextLine();
                    Tamu tamuBatalkan = null;
                    for (Tamu tamu : hotel.getDaftarTamu()) {
                        if (tamu.getNomorIdentitas().equals(idTamuBatalkan)) {
                            tamuBatalkan = tamu;
                            break;
                        }
                    }
                    if (tamuBatalkan== null) {
                        System.out.println("Tamu tidak ditemukan!");
                        break;
                    }
                    System.out.print("Masukkan nomor kamar untuk membatalkan reservasi: ");
                    String nomorKamarBatalkan = scanner.nextLine();
                    Reservasi reservasiBatalkan = null; // Pastikan penamaan variabel benar
                    for (Reservasi reservasi : tamuBatalkan.getDaftarReservasi()) {
                        if (reservasi.getKamar().getNomorKamar().equals(nomorKamarBatalkan)) {
                            reservasiBatalkan = reservasi;
                            break;
                        }
                    }
                    if (reservasiBatalkan == null) {
                        System.out.println("Reservasi tidak ditemukan!");
                        break;
                    }
                    hotel.batalkanReservasi(reservasiBatalkan);
                    System.out.println("Reservasi berhasil dibatalkan.");
                    break;
                case 5:
                    // Menampilkan daftar kamar yang tersedia
                    hotel.daftarKamarTersedia();
                    break;
                case 6:
                    // Menampilkan informasi tamu
                    System.out.print("Masukkan nomor identitas tamu untuk menampilkan informasi: ");
                    String idTamuInfo = scanner.nextLine();
                    Tamu tamuInfo = null;
                    for (Tamu tamu : hotel.getDaftarTamu()) {
                        if (tamu.getNomorIdentitas().equals(idTamuInfo)) {
                            tamuInfo = tamu;
                            break;
                        }
                    }
                    if (tamuInfo != null) {
                        tamuInfo.tampilkanInfoTamu();
                    } else {
                        System.out.println("Tamu tidak ditemukan!");
                    }
                    break;
                case 7:
                    // Keluar dari program
                    running = false;
                    System.out.println("Terima kasih telah menggunakan aplikasi manajemen reservasi hotel.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    continue; // Skip the prompt to continue
            }

            // Setelah aksi dieksekusi, kita akan meminta feedback
            boolean validInput = false; // Flag untuk validasi input
            while (!validInput) {
                System.out.print("Apakah Anda ingin melanjutkan ke menu? (y/n): ");
                String lanjut = scanner.nextLine();

                if (lanjut.equalsIgnoreCase("y")) {
                    validInput = true; // Input valid, keluar dari loop
                } else if (lanjut.equalsIgnoreCase("n")) {
                    running = false; // Jika 'n', keluar dari program
                    validInput = true; // Keluar dari loop
                    System.out.println("Terima kasih telah menggunakan aplikasi manajemen reservasi hotel.");
                } else {
                    // Jika input tidak valid, tampilkan pesan kesalahan dan coba lagi
                    System.out.println("Silakan masukkan 'y' untuk melanjutkan atau 'n' untuk keluar.");
                }
            }
        }
        scanner.close(); // Menutup scanner
    }
}