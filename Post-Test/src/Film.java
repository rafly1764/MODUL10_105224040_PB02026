public class Film {
    String judul;
    int harga;
    public Film(String judul, int harga) {
        this.judul = judul;
        this.harga = harga;
    }
    public void info() {
        System.out.println(judul + " - Rp" + harga);
    }
}