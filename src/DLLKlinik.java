public class DLLKlinik {
    Node head;
    int size;

    public DLLKlinik() {
        head = null;
        size = 0;
    }

    public boolean isEmpty01() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void addLast(Pasien data) {
        if (isEmpty01()) {
            head = new Node(null, data, null);
            size++;
        } else {
            Node tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            Node newNode = new Node(tmp, data, null);
            tmp.next = newNode;
            size++;
        }
    }

    public void removeFirst(Pasien data) {
        if (isEmpty01()) {
            System.out.println("Antrian kosong!");
        } else if (size == 1) {
            System.out.println(head.data.nama + " telah selesai divaksinasi");
            head = null;
            size--;
        } else {
            System.out.println(head.data.nama + " telah selesai divaksinasi");
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void print() {
        if (isEmpty01()) {
            System.out.println("Antrian kosong!");
        } else {
            System.out.println("-- Antrian Pasien --");
            System.out.printf("%-10s %-10s %-15s\n", "Nama", "NIK", "Keluhan");
            Node tmp = head;
            while (tmp != null) {
                tmp.data.tampilInformasi();
                tmp = tmp.next;
            }
        }
    }
}
