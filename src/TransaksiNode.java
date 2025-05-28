public class TransaksiNode {
    Transaksi data;
    TransaksiNode prev, next;

    public TransaksiNode(Transaksi data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
