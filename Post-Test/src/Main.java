import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<String, Film> jadwalFilm = new HashMap<>();
        jadwalFilm.put("F01", new Film("John Wick", 45000));
        jadwalFilm.put("F02", new Film("Pengabdi Setan", 30000));
        jadwalFilm.put("F03", new Film("Despicable Me 3", 40000));

        Set<String> kursiDipesan = new HashSet<>();
        List<Transaksi> riwayat = new ArrayList<>();

        pesanTiket(jadwalFilm, kursiDipesan, riwayat, "Rafly", "F01", "A1");
        pesanTiket(jadwalFilm, kursiDipesan, riwayat, "Adit", "F01", "A2");
        pesanTiket(jadwalFilm, kursiDipesan, riwayat, "Hiyuki", "F02", "B1");
        pesanTiket(jadwalFilm, kursiDipesan, riwayat, "Aemeth", "F01", "A1");

        System.out.println("Riwayat Transaksi:");
        for (Transaksi t : riwayat) {
            t.cetak();
        }
    }

    public static void pesanTiket(Map<String, Film> jadwalFilm, Set<String> kursiDipesan, List<Transaksi> riwayat, String nama, String kodeFilm, String kursi) {
        if (!jadwalFilm.containsKey(kodeFilm)) {
            System.out.println(nama + " gagal pesan, kode film tidak valid");
        } else if (!kursiDipesan.add(kodeFilm + "-" + kursi)) {
            System.out.println(nama + " gagal pesan, kursi " + kursi + " sudah dipesan");
        } else {
            Film film = jadwalFilm.get(kodeFilm);
            riwayat.add(new Transaksi(nama, film, kursi));
            System.out.println(nama + " berhasil pesan " + film.judul + " kursi " + kursi);
        }
    }
}