// 20_Pratama Angga Saputra
// SIB 1 G
import java.util.Scanner;
public class tokoMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dataToko data = new dataToko();

        while (true) {
            System.out.println("--- MENU TOKO ABC ---");
            System.out.println("1. Input Data Barang");
            System.out.println("2. Penjualan Barang");
            System.out.println("3. Urutkan Data Berdasarkan Stok Terbanyak");
            System.out.println("4. Tampilkan Barang Terlaris");
            System.out.println("5. Tampilkan Semua Barang");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            int pilih = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (pilih) {
                case 1:
                    System.out.print("Masukkan kode barang: ");
                    String kode = sc.nextLine();
                    System.out.print("Masukkan nama barang: ");
                    String nama = sc.nextLine();
                    System.out.print("Masukkan stok: ");
                    int stok = sc.nextInt();
                    System.out.print("Masukkan harga satuan: ");
                    int harga = sc.nextInt();
                    sc.nextLine();
                    data.tambahBarang(new toko(kode, nama, stok, harga));
                    System.out.println();
                    break;

                case 2:
                    int totalPembayaran = 0;
                    String struk = "\nSTRUK PEMBELIAN\nKode\tNama\tJumlah\tHarga\tTotal\n";
                    data.tampilSemuaBarang();
                    System.out.println();
                    while (true) {
                        System.out.print("Masukkan kode barang yang dibeli: ");
                        String kodeBeli = sc.nextLine();
                        toko barang = data.cariBarang(kodeBeli);

                        if (barang == null) {
                            System.out.println("Barang tidak ditemukan!");
                        } else {
                            System.out.print("Jumlah beli: ");
                            int jumlah = sc.nextInt();
                            sc.nextLine();
                            if (jumlah > barang.stok) {
                                System.out.println("Stok tidak mencukupi!");
                            } else {
                                int total = jumlah * barang.hargaSatuan;
                                totalPembayaran += total;
                                barang.stok -= jumlah;
                                barang.totalTerjual += jumlah;

                                struk += barang.kode + "\t" + barang.namaBarang + "\t" +
                                         jumlah + "\t" + barang.hargaSatuan + "\t" + total + "\n";
                            }
                        }

                        System.out.print("Tambah pembelian lain? (y/n): ");
                        char lagi = sc.nextLine().charAt(0);
                        if (lagi != 'y' && lagi != 'Y') break;
                    }

                    struk += "Total Bayar: Rp" + totalPembayaran + "\n";
                    System.out.println(struk);
                    break;

                case 3:
                    data.urutkanStokDesc();
                    data.tampilSemuaBarang();
                    System.out.println();
                    break;

                case 4:
                    data.tampilBarangTerlaris();
                    System.out.println();
                    break;

                case 5:
                    data.tampilSemuaBarang();
                    System.out.println();
                    break;

                case 6:
                    System.out.println("Terima kasih! Keluar program.");
                    sc.close();
                    return;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
