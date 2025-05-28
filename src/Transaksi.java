public class Transaksi {
    String namaPasien, namaDokter;
    int durasi, total;
    Transaksi next; 
    Transaksi prev;

    public Transaksi(String namaPasien, String namaDokter, int durasi, int total) {
        this.namaPasien = namaPasien;
        this.namaDokter = namaDokter;
        this.durasi = durasi;
        this.total = total;
    }
}