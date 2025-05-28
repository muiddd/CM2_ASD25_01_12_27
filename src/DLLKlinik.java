public class DLLKlinik {
    NodePasien head;
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
            head = new NodePasien(null, data, null);
            size++;
        } else {
            NodePasien tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            NodePasien newNode = new NodePasien(tmp, data, null);
            tmp.next = newNode;
            size++;
        }
        System.out.println(">>Pasien Masuk kedalan Antrian");
    }

    public void removeFirst(Pasien data) {
        if (isEmpty01()) {
            System.out.println("Antrian kosong!");
        } else if (size == 1) {
            head = null;
            size--;
        } else {
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
            NodePasien tmp = head;
            while (tmp != null) {
                tmp.data.tampilInformasi();
                tmp = tmp.next;
            }
        }
    }
}
