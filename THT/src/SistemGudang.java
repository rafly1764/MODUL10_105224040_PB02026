import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SistemGudang {
    Map<String, Barang> databaseBarang = new HashMap<>();
    Set<String> kategoriUnik = new HashSet<>();
    List<String> riwayat = new ArrayList<>();
    public void tambahBarangBaru(String id, String nama, String kategori, int stok) {
        Barang barang = new Barang(id, nama, kategori, stok);
        databaseBarang.put(id, barang);
        kategoriUnik.add(kategori);
        riwayat.add("Barang baru: " + id + " stok awal " + stok + " unit");
    }

    public void tambahStok(String id, int jumlah) {
        if (databaseBarang.containsKey(id)) {
            Barang barang = databaseBarang.get(id);
            barang.stok += jumlah;
            riwayat.add("Barang Masuk: " + id + " ditambah " + jumlah + " unit");
        } else{
            riwayat.add("Gagal tambah stok: " + id + " tidak ditemukan");
        }
    }

    public void kurangiStok(String id, int jumlah) {
        if (databaseBarang.containsKey(id)) {
            Barang barang = databaseBarang.get(id);
            if (barang.stok >= jumlah) {
                barang.stok -= jumlah;
                riwayat.add("Barang Keluar: " + id + " dikurangi " + jumlah + " unit");
            } else{
                riwayat.add("Gagal kurangi stok: " + id + " stok tidak cukup");
            }
        } else{
            riwayat.add("Gagal kurangi stok: " + id + " tidak ditemukan");
        }
    }

    public void cetakLaporan() {
        System.out.println("=== LAPORAN GUDANG ===");
        System.out.println("Kategori:");
        for (String kategori : kategoriUnik) {
            System.out.println(kategori);
        }
        System.out.println("Stok Barang:");
        for (Barang barang : databaseBarang.values()) {
            barang.info();
        }
        System.out.println("Riwayat Transaksi:");
        for (String r : riwayat) {
            System.out.println(r);
        }
    }
}