public class Transaksi {
    String namaPemesan;
    Film film;
    String kursi;
    public Transaksi(String namaPemesan, Film film, String kursi) {
        this.namaPemesan = namaPemesan;
        this.film = film;
        this.kursi = kursi;
    }
    public void cetak() {
        System.out.println(namaPemesan + " -- " + film.judul + " -- Kursi " + kursi + " -- Rp" + film.harga);
    }
}