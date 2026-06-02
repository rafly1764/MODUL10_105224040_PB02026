public class Barang {
    String idBarang;
    String namaBarang;
    String kategori;
    int stok;

    public Barang(String idBarang, String namaBarang, String kategori, int stok) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.kategori = kategori;
        this.stok = stok;
    }
    public void info() {
        System.out.println(idBarang + " - " + namaBarang + " - " + kategori + " - Stok: " + stok);
    }
}