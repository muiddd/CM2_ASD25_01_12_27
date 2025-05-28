import java.util.Scanner;

public class KlinikMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLLKlinik antrian = new DLLKlinik();
        DLLTranksaksi riwayat = new DLLTranksaksi();

        Dokter[] dokters = {
                new Dokter("dr01", "Wike Ratanca"),
                new Dokter("dr02", "Santi Runica"),
                new Dokter("dr03", "Aam Antanica"),
                new Dokter("dr04", "Slamet Sugito")
        };

        int pilih;
        do {
            System.out.println("\nSistem Antrian Klinik");
            System.out.println("1. Tambah Pasien ke Antrian");
            System.out.println("2. Lihat Antrian");
            System.out.println("3. Layani Pasien");
            System.out.println("4. Cek Sisa Antrian Pasien");
            System.out.println("5. Lihat Riwayat Transaksi");
            System.out.println("6. Sort Riwayat Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih : ");
            pilih = sc.nextInt();
            sc.nextLine();
            switch (pilih) {
                case 1:
                    Pasien pasien = inputPasien(sc);
                    antrian.addLast(pasien);
                    break;
                case 2:
                    antrian.print();
                    break;
                case 3:
                    layaniPasien(antrian, riwayat, sc, dokters);
                    break;
                case 4:
                    System.out.println("Sisa antrian pasien: " + antrian.size());
                    break;
                case 5:
                    riwayat.printTransaksi();
                    break;
                case 6:
                    riwayat.sortTransaksiByNamaPasien();
                    break;

                case 0:
                    System.out.println("Terima kasih");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
                    break;
            }
        } while (pilih != 0);

    }

    public static Pasien inputPasien(Scanner sc) {
        System.out.print("Input Nama Pasien : ");
        String nama = sc.nextLine();
        System.out.print("NIK : ");
        String nik = sc.nextLine();
        System.out.print("Keluhan : ");
        String keluhan = sc.nextLine();
        return new Pasien(nama, nik, keluhan);
    }

    public static void layaniPasien(DLLKlinik antrian, DLLTranksaksi riwayat, Scanner sc, Dokter[] dokters) {
        if (antrian.isEmpty01()) {
            System.out.println(">> Tidak ada pasien dalam antrian.");
            return;
        }

        Pasien pasienDilayani = antrian.head.data;
        System.out.println("Pasien " + pasienDilayani.nama + " dipanggil");

        System.out.println("Daftar dokter jaga :");
        System.out.printf("%-6s %-20s\n", "Kode", "Nama");
        for (Dokter d : dokters) {
            System.out.printf("%-6s %-20s\n", d.kode, d.nama);
        }

        System.out.print("\nPilih Dokter:\ninput kode dokter: ");
        String kodeDokter = sc.nextLine();
        Dokter dokterDipilih = null;
        for (Dokter d : dokters) {
            if (d.kode.equalsIgnoreCase(kodeDokter)) {
                dokterDipilih = d;
                break;
            }
        }

        if (dokterDipilih == null) {
            System.out.println(">> Kode dokter tidak ditemukan.");
            return;
        }

        System.out.print("input durasi layanan(jam) : ");
        int durasi = sc.nextInt();
        sc.nextLine();
        int total = durasi * 50000;

        riwayat.addTransaksi(pasienDilayani.nama, dokterDipilih.nama, durasi, total);
        antrian.removeFirst(pasienDilayani);
        System.out.println(">> Pasien telah dilayani, transaksi berhasil dicatat");
    }
}
