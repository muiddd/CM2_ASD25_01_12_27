public class NodePasien {
    Pasien data;
    NodePasien prev, next;

    NodePasien(NodePasien prev, Pasien data, NodePasien next){
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}
