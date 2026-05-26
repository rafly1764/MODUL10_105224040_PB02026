import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Main  {
    public static void main(String[] args) {

        Map<String, Buku> katalog = new HashMap<>();

        Buku b1 = new Buku("1934892759", "Maling Kundang");
        Buku b2 = new Buku("2343848748", "Pocong lari dari kubur");
        Buku b3 = new Buku("3454959857", "Upin&Ipin");

        katalog.put(b1.getIsbn(), b1);
        katalog.put(b2.getIsbn(), b2);
        katalog.put(b3.getIsbn(), b3);

        System.out.println("=== Sistem Perpustakaan ===");

        String cariIsbn = "2343848748";

        if (katalog.containsKey(cariIsbn)) {
            System.out.println("Buku ditemukan:");
            katalog.get(cariIsbn).tampilkanInfo();
        } else {
            System.out.println("Buku tidak ditemukan");
        }
         Set<Anggota> anggota = new HashSet<>();

        anggota.add(new Anggota("012", "Rafly", "Mahasiswa"));
        anggota.add(new Anggota("024", "Pak Ade", "Dosen"));
        anggota.add(new Anggota("057", "Mamat", "Mahasiswa"));
        anggota.add(new Anggota("012", "Putri", "Mahasiswa"));
        System.out.println("Jumlah anggota: " + anggota.size());
        for (Anggota a : anggota) {
            a.tampilkanInfo();
        }
        LinkedList<String> antrean = new LinkedList<>();

        tambahAntrean(antrean, "012", "Mahasiswa", "1934892759");
        tambahAntrean(antrean, "024", "Dosen", "2343848748");
        tambahAntrean(antrean, "057", "Mahasiswa", "1934892759");
        tambahAntrean(antrean, "012", "Dosen", "1224u34358");

        System.out.println("Antrean awal: " + antrean);

        Set<String> bukuDipinjam = new HashSet<>();

        System.out.println("Proses peminjaman:");

        while (!antrean.isEmpty()) {
            String data = antrean.removeFirst();
            String[] pecah = data.split("#");

            String idAnggota = pecah[0];
            String isbn = pecah[1];

            if (!anggota.contains(new Anggota(idAnggota, "", ""))) {
                System.out.println(data + " ditolak, anggota tidak terdaftar");
            } else if (!katalog.containsKey(isbn)) {
                System.out.println(data + " ditolak, buku tidak ada di katalog");
            } else if (bukuDipinjam.contains(isbn)) {
                System.out.println(data + " ditolak, buku sedang dipinjam");
            } else {
                bukuDipinjam.add(isbn);
                System.out.println(data + " berhasil meminjam buku");
            }
        }

        System.out.println("Buku sedang dipinjam:");
        System.out.println(bukuDipinjam);
    }
    public static void tambahAntrean(LinkedList<String> antrean, String idAnggota, String tipe, String isbn) {
        String data = idAnggota + "#" + isbn;
        antrean.add(data);
    }
}