public class Main {
    public static void main(String[] args) {
        SistemGudang gudang = new SistemGudang();

        gudang.tambahBarangBaru("B01", "Beras", "Sembako", 50);
        gudang.tambahBarangBaru("B02", "Sabun", "Kebersihan", 30);
        gudang.tambahBarangBaru("B03", "Minyak Goreng", "Sembako", 20);

        gudang.tambahStok("B01", 10);
        gudang.kurangiStok("B02", 5);
        gudang.kurangiStok("B03", 50);

        gudang.cetakLaporan();
    }
}