// 20_Pratama Angga Saputra
// SIB 1 G
public class toko {
    String kode;
    String namaBarang;
    int stok;
    int hargaSatuan;
    int totalTerjual = 0;

    toko(String kd, String nama, int stok, int harga) {
        this.kode = kd;
        this.namaBarang = nama;
        this.stok = stok;
        this.hargaSatuan = harga;
    }

    void tampil() {
        System.out.println("Kode: " + kode);
        System.out.println("Nama Barang: " + namaBarang);
        System.out.println("Stok: " + stok);
        System.out.println("Harga Satuan: Rp" + hargaSatuan);
        System.out.println("---------------------------");
    }
}