public class DLLTranksaksi {
    TransaksiNode transaksiHead;
    int transaksiSize;

    public DLLTranksaksi() {
        transaksiHead = null;
        transaksiSize = 0;
    }

    public void addTransaksi(String namaPasien, String namaDokter, int durasi, int total) {
        Transaksi transaksi = new Transaksi(namaPasien, namaDokter, durasi, total);
        TransaksiNode newNode = new TransaksiNode(transaksi);

        if (transaksiHead == null) {
            transaksiHead = newNode;
        } else {
            TransaksiNode tmp = transaksiHead;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = newNode;
            newNode.prev = tmp;
        }
        transaksiSize++;
    }

    public void printTransaksi() {
        if (transaksiHead == null) {
            System.out.println(">> Belum ada transaksi");
            return;
        }

        System.out.println("-- Riwayat Transaksi --");
        System.out.printf("%-15s %-20s %-10s %-10s\n", "Nama Pasien", "Dokter", "Durasi", "Total");
        TransaksiNode tmp = transaksiHead;
        while (tmp != null) {
            Transaksi t = tmp.data;
            System.out.printf("%-15s %-20s %-10d %-10d\n", t.namaPasien, t.namaDokter, t.durasi, t.total);
            tmp = tmp.next;
        }
    }

    public void sortTransaksiByNamaPasien() {
        if (transaksiHead == null || transaksiHead.next == null)
            return;

        for (TransaksiNode i = transaksiHead; i != null; i = i.next) {
            for (TransaksiNode j = i.next; j != null; j = j.next) {
                if (i.data.namaPasien.compareToIgnoreCase(j.data.namaPasien) < 0) {
                    Transaksi tmp = i.data;
                    i.data = j.data;
                    j.data = tmp;
                }
            }
        }

        System.out.println(">> Riwayat transaksi berhasil diurutkan berdasarkan nama pasien (Z - A).");
    }

}
