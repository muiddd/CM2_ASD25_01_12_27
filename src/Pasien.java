public class Pasien {
    String nama;
    String nik;
    String keluhan;

    public Pasien(String nama, String nik, String keluhan){
        this.nama = nama;
        this.nik = nik;
        this.keluhan = keluhan;
    }

    void tampilInformasi (){
        System.out.println(nama + " - " + nik + " - " + keluhan);
    }
}
