package com.mycompany.manajemenreservasihotel;

/**
 * @author 
 * Faishal Anwar Hasyim
 * NIM = 32602300021
 */

/**
 * Kelas KamarDeluxe yang merupakan subclass dari Kamar.
 * Menambahkan fasilitas tambahan untuk kamar deluxe.
 */

public class KamarDeluxe extends Kamar {
    private String fasilitasTambahan; // Fasilitas tambahan untuk kamar deluxe

    public KamarDeluxe(String nomorKamar, double hargaPerMalam, String fasilitasTambahan) {
        super(nomorKamar, "Deluxe", hargaPerMalam);
        this.fasilitasTambahan = fasilitasTambahan;
    }

    // Menampilkan informasi kamar deluxe, termasuk fasilitas tambahan
    @Override
    public void tampilkanInfoKamar() {
        super.tampilkanInfoKamar();
        System.out.printf("Fasilitas Tambahan: %s\n", fasilitasTambahan);
    }
}