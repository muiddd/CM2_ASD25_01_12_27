import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLLKlinik antrian = new DLLKlinik();
        DLLKlinik riwayat;

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

                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    
                    break;
                case 6:
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
}
