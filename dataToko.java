// 20_Pratama Angga Saputra
// SIB 1 G
public class dataToko {
    toko listBarang[] = new toko[20];
    int idx = 0;

    void tambahBarang(toko b) {
        if (idx < listBarang.length) {
            listBarang[idx++] = b;
        } else {
            System.out.println("Data barang penuh!");
        }
    }

    void tampilSemuaBarang() {
        for (int i = 0; i < idx; i++) {
            listBarang[i].tampil();
        }
    }

    toko cariBarang(String kode) {
        for (int i = 0; i < idx; i++) {
            if (listBarang[i].kode.equalsIgnoreCase(kode)) {
                return listBarang[i];
            }
        }
        return null;
    }

    void urutkanStokDesc() {
        for (int i = 0; i < idx - 1; i++) {
            for (int j = 0; j < idx - i - 1; j++) {
                if (listBarang[j].stok < listBarang[j + 1].stok) {
                    toko temp = listBarang[j];
                    listBarang[j] = listBarang[j + 1];
                    listBarang[j + 1] = temp;
                }
            }
        }
        System.out.println("Data berhasil diurutkan berdasarkan stok terbanyak.");
    }

    void tampilBarangTerlaris() {
        if (idx == 0) {
            System.out.println("Belum ada data barang.");
            return;
        }

        toko terlaris = listBarang[0];
        for (int i = 1; i < idx; i++) {
            if (listBarang[i].totalTerjual > terlaris.totalTerjual) {
                terlaris = listBarang[i];
            }
        }

        if (terlaris.totalTerjual == 0) {
            System.out.println("Belum ada barang yang terjual.");
        } else {
            System.out.println("Barang Terlaris:");
            System.out.println("Nama: " + terlaris.namaBarang);
            System.out.println("Jumlah Terjual: " + terlaris.totalTerjual);
        }
    }
}
