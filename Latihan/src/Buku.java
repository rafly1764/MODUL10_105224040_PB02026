public class Buku {
    private String isbn;
    private String judul;
    public Buku(String isbn, String judul) {
        this.isbn = isbn;
        this.judul = judul;
    }
    public String getIsbn() {
        return isbn;
    }
    public void tampilkanInfo() {
        System.out.println("ISBN : " + isbn);
        System.out.println("Judul : " + judul);
    }
}