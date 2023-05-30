package Tugas.latihanUTS;
import java.util.ArrayList;


import java.util.Scanner;

public class driver {
    Scanner input = new Scanner(System.in);
    ArrayList<lomba> lomba_lomba = new ArrayList<>();
    ArrayList<uiux> uiux = new ArrayList<>();
    ArrayList<algoritma> algoritma = new ArrayList<>();
    ArrayList<dataProcesing> dataProcesing = new ArrayList<>();

    public static void main(String[] args) {
        
        driver object_driver = new driver();

        

        boolean isRunning = true;
        System.out.println("=======================================");
        do{
            int pilih = object_driver.menu();
            switch(pilih){
                case 1:
                    object_driver.tambahKelompok();
                    break;
                case 2:
                    object_driver.CariKelompok();
                    break;
                case 3:
                    object_driver.nilai_rata_rata_kelompok();
                    break;
                case 4:
                    object_driver.pemenang();
                    break;
                case 5:
                    System.out.println("Terima Kasih");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia");
                    System.out.println("=======================================");
                    isRunning = true;
                    break;
            }
        }while(isRunning == true);
    }
        public int menu(){
            System.out.println("Selamat Datang di Aplikasi Penilaian Lomba");
            System.out.println("=======================================");
            System.out.println("1. Tambah Kelompok");
            System.out.println("2. Cari Kelompok");
            System.out.println("3. Nilai Rata-rata Kelompok");
            System.out.println("4. Pemenang");
            System.out.println("5. Exit");
            System.out.println("=======================================");
            System.out.print("Pilih Menu : ");
            
            String pilihan = input.nextLine();
            //convert string to int
            int pilih = Integer.parseInt(pilihan);
            return pilih;
    }   
        public void tambahKelompok(){

            System.out.println( " masukan nama kelompok : ");
            String nama_kelompok = input.nextLine();
            System.out.println( " masukan nama anggota : ");
            String nama_anggota = input.nextLine();


            //auto generate id
            String id = "K"+(lomba_lomba.size()+1);

            //cheack apakah nama kelompok sudah ada
            boolean isExist = false;
            for (lomba lomba : lomba_lomba) { // for each 
                if(lomba.getNama_kelompok().equals(nama_kelompok)){
                    isExist = true;//jika ada
                    break;
                }
            }
            if(isExist){
                System.out.println("Nama Kelompok sudah ada");
            }else{
                Boolean isTidak = true;
                //input ke arraylist lomba
                
                do{
                
                //input jenis lomba
                System.out.println("Jenis Lomba");
                System.out.println("1. UI/UX");
                System.out.println("2. Algoritma");
                System.out.println("3. Data Processing");
                System.out.println("=======================================");
                System.out.print("Pilih Menu : ");
                String pilihan = input.nextLine();
                //convert string to int
                int pilih = Integer.parseInt(pilihan);

                switch (pilih){

                    case 1:
                        lomba object_lomba1 = new lomba(id, nama_kelompok, nama_anggota, "1");
                        lomba_lomba.add(object_lomba1);
                        System.out.println("Nilai Penjelasan : ");
                        String penjelasan = input.nextLine();
                        System.out.println("Nilai Sekenario : ");
                        String sekenario = input.nextLine();
                        System.out.println("Nilai Desain : ");
                        String desain = input.nextLine();
                        System.out.println("Nilai Konsistensi : ");
                        String konsistensi = input.nextLine();
                        uiux object_uiux = new uiux(id, nama_kelompok, nama_anggota ,"1",  Integer.parseInt(penjelasan), Integer.parseInt(sekenario), Integer.parseInt(desain), Integer.parseInt(konsistensi));
                        uiux.add(object_uiux);
                        isTidak = false;
                        break;
                    case 2:
                        lomba object_lomba2 = new lomba(id, nama_kelompok, nama_anggota, "2");
                        lomba_lomba.add(object_lomba2);
                        System.out.println("Nilai Ketepatan Hasil : ");
                        String ketepatan_hasil = input.nextLine();
                        System.out.println("Nilai Waktu Eksekusi : ");
                        String waktu_eksekusi = input.nextLine();
                        System.out.println("Nilai Pemanfaatan : ");
                        String pemanfaatan = input.nextLine();
                        algoritma object_algoritma = new algoritma(id, nama_kelompok, nama_anggota,"2", Integer.parseInt(ketepatan_hasil), Integer.parseInt(waktu_eksekusi), Integer.parseInt(pemanfaatan));
                        algoritma.add(object_algoritma);
                        isTidak = false;
                        break;
                    case 3:
                        lomba object_lomba3 = new lomba(id, nama_kelompok, nama_anggota, "3");
                        lomba_lomba.add(object_lomba3);
                        System.out.println("Nilai Ketepatan Hasil : ");
                        String ketepatan_hasil1 = input.nextLine();
                        System.out.println("Nilai Waktu Eksekusi : ");
                        String waktu_eksekusi1 = input.nextLine();
                        System.out.println("Nilai Pemanfaatan : ");
                        String pemanfaatan1 = input.nextLine();
                        dataProcesing object_dataProcesing = new dataProcesing(id, nama_kelompok, nama_anggota,"3",Integer.parseInt(ketepatan_hasil1), Integer.parseInt(waktu_eksekusi1), Integer.parseInt(pemanfaatan1));
                        dataProcesing.add(object_dataProcesing);
                        isTidak = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak tersedia");
                        System.out.println("=======================================");
                        isTidak = true;
                        break;

                }
            }while(isTidak == true);
            }
            
        }
        public void CariKelompok(){
            //cari kelompok berdasarkan nama dengan contains
            System.out.println("Masukan nama kelompok : ");
            String nama_kelompok = input.nextLine();

            for (lomba lomba : lomba_lomba) {
                if(lomba.getNama_kelompok().contains(nama_kelompok)){
                    lomba.viewData();
                    break;
                }else{
                    System.out.println("Nama Kelompok tidak ditemukan");
                }
            }

        }
        public void nilai_rata_rata_kelompok(){ 
            // Menampilkan keseluruhan kelompok dan nilai rata-rata yang dihasilkan
             
            // UI/UX
            for (uiux uiux : uiux) { // for each
                uiux.viewData();
                uiux.hitung_rata_rata();
                System.out.println();
            }
            // Algoritma
            for (algoritma algoritma : algoritma) { // for each
                algoritma.viewData();
                algoritma.hitung_rata_rata();
                System.out.println();
            }
            // Data Processing
            for (dataProcesing dataProcesing : dataProcesing) { // for each
                dataProcesing.viewData();
                dataProcesing.hitung_rata_rata();
                System.out.println();
            }
        }
        public void pemenang(){
            // Menampilkan pemenang dari setiap kategori lomba
            // UI/UX
            int max = 0;
            String nama_kelompok = "";
            for (uiux uiux : uiux) { // for each
                if((uiux.penjelsan+uiux.sekenario+uiux.desain+uiux.konsistensi)/4 > max){
                    max = (uiux.penjelsan+uiux.sekenario+uiux.desain+uiux.konsistensi)/4;
                    nama_kelompok = uiux.nama_kelompok;
                }
            }
            System.out.println("Pemenang Lomba UI/UX adalah : "+nama_kelompok);
            // Algoritma
            int max1 = 0;
            String nama_kelompok1 = "";
            for (algoritma algoritma : algoritma) { // for each
                if((algoritma.ketepatan+algoritma.waktu+algoritma.pemanfaatan)/3 > max1){
                    max1 = (algoritma.ketepatan+algoritma.waktu+algoritma.pemanfaatan)/3;
                    nama_kelompok1 = algoritma.nama_kelompok;
                }
            }
            System.out.println("Pemenang Lomba Algoritma adalah : "+nama_kelompok1);
            // Data Processing
            int max2 = 0;
            String nama_kelompok2 = "";
            for (dataProcesing dataProcesing : dataProcesing) { // for each
                if((dataProcesing.ketepatan_hasil+dataProcesing.waktu_eksekusi+dataProcesing.pemanfaatan)/3 > max2){
                    max2 = (dataProcesing.ketepatan_hasil+dataProcesing.waktu_eksekusi+dataProcesing.pemanfaatan)/3;
                    nama_kelompok2 = dataProcesing.nama_kelompok;
                }
            }
            System.out.println("Pemenang Lomba Data Processing adalah : "+nama_kelompok2);

        }
    }
  


class lomba{
    String id, nama_kelompok,nama_anggota, jenis_lomba;
    int nilai_rata_rata;

    public lomba(String id,String nama_kelompok,String nama_anggota, String jenis_lomba){
        this.id = id;
        this.nama_kelompok = nama_kelompok;
        this.nama_anggota = nama_anggota;
        this.jenis_lomba = jenis_lomba;
    }


    public void viewData(){
        System.out.println("ID Koleksi : "+this.id);
        System.out.println("Nama Kelompok : "+this.nama_kelompok);
        System.out.println("Nama Anggota : "+this.nama_anggota);
        System.out.println("Jenis Lomba : "+this.jenis_lomba);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama_kelompok() {
        return this.nama_kelompok;
    }

    public void setNama_kelompok(String nama_kelompok) {
        this.nama_kelompok = nama_kelompok;
    }

    public String getNama_anggota() {
        return this.nama_anggota;
    }

    public void setNama_anggota(String nama_anggota) {
        this.nama_anggota = nama_anggota;
    }

    public String getJenis_lomba() {
        return this.jenis_lomba;
    }

    public void setJenis_lomba(String jenis_lomba) {
        this.jenis_lomba = jenis_lomba;
    }

    public int getNilai_rata_rata() {
        return this.nilai_rata_rata;
    }

    public void setNilai_rata_rata(int nilai_rata_rata) {
        this.nilai_rata_rata = nilai_rata_rata;
    }

    public void hitung_rata_rata(){
        System.out.println("Nilai Rata-rata : "+this.nilai_rata_rata);
    }

}
class uiux extends lomba{
    int penjelsan,sekenario,desain,konsistensi;

    public uiux(String id, String nama_kelompok , String nama_anggota, String jenis_lomba,  int penjelsan, int sekenario, int desain, int konsistensi){
        super(id, nama_kelompok, nama_anggota, jenis_lomba);
        this.penjelsan = penjelsan;
        this.sekenario = sekenario;
        this.desain = desain;
        this.konsistensi = konsistensi;

    }

    @Override
    public void hitung_rata_rata(){
        System.out.println("Nilai Rata-rata : "+(this.penjelsan+this.sekenario+this.desain+this.konsistensi)/4);
        
    }


    public int getPenjelsan() {
        return this.penjelsan;
    }

    public void setPenjelsan(int penjelsan) {
        this.penjelsan = penjelsan;
    }

    public int getSekenario() {
        return this.sekenario;
    }

    public void setSekenario(int sekenario) {
        this.sekenario = sekenario;
    }

    public int getDesain() {
        return this.desain;
    }

    public void setDesain(int desain) {
        this.desain = desain;
    }

    public int getKonsistensi() {
        return this.konsistensi;
    }

    public void setKonsistensi(int konsistensi) {
        this.konsistensi = konsistensi;
    }
    @Override
    public void viewData(){
        System.out.println("ID Koleksi : "+this.id);
        System.out.println("Nama Kelompok : "+this.nama_kelompok);
        System.out.println("Nilai Penjelasan : "+this.penjelsan);
        System.out.println("Nilai Sekenario : "+this.sekenario);
        System.out.println("Nilai Desain : "+this.desain);
        System.out.println("Nilai Konsistensi : "+this.konsistensi);
    }

}
class algoritma extends lomba{
    int ketepatan,waktu,pemanfaatan;

    public algoritma(String id, String nama_kelompok, String nama_anggota,String jenis_lomba ,int ketepatan, int waktu, int pemanfaatan){
        super(id, nama_kelompok, nama_anggota, jenis_lomba);
        this.ketepatan = ketepatan;
        this.waktu = waktu;
        this.pemanfaatan = pemanfaatan;

    }

    @Override
    public void hitung_rata_rata(){
        System.out.println("Nilai Rata-rata : "+(this.ketepatan+this.waktu+this.pemanfaatan)/3);
        
    }
    @Override
    public void viewData(){
        System.out.println("ID Koleksi : "+this.id);
        System.out.println("Nama Kelompok : "+this.nama_kelompok);
        System.out.println("Nilai Ketepatan : "+this.ketepatan);
        System.out.println("Nilai Waktu : "+this.waktu);
        System.out.println("Nilai Pemanfaatan : "+this.pemanfaatan);
    }


    public int getKetepatan() {
        return this.ketepatan;
    }

    public void setKetepatan(int ketepatan) {
        this.ketepatan = ketepatan;
    }

    public int getWaktu() {
        return this.waktu;
    }

    public void setWaktu(int waktu) {
        this.waktu = waktu;
    }

    public int getPemanfaatan() {
        return this.pemanfaatan;
    }

    public void setPemanfaatan(int pemanfaatan) {
        this.pemanfaatan = pemanfaatan;
    }


}
class dataProcesing extends lomba{

    int ketepatan_hasil,waktu_eksekusi,pemanfaatan;

    public dataProcesing(String id, String nama_kelompok,String nama_anggota,String jenis_lomba,  int ketepatan_hasil, int waktu_eksekusi, int pemanfaatan){
        super(id, nama_kelompok, nama_anggota, jenis_lomba);
        this.ketepatan_hasil = ketepatan_hasil;
        this.waktu_eksekusi = waktu_eksekusi;
        this.pemanfaatan = pemanfaatan;
    }

    @Override
    public void hitung_rata_rata(){
        System.out.println("Nilai Rata-rata : "+(this.ketepatan_hasil+this.waktu_eksekusi+this.pemanfaatan)/3);
        
    }
    @Override
    public void viewData(){
        System.out.println("ID Koleksi : "+this.id);
        System.out.println("Nama Kelompok : "+this.nama_kelompok);
        System.out.println("Nilai Ketepatan Hasil : "+this.ketepatan_hasil);
        System.out.println("Nilai Waktu Eksekusi : "+this.waktu_eksekusi);
        System.out.println("Nilai Pemanfaatan : "+this.pemanfaatan);
    }


    public int getKetepatan_hasil() {
        return this.ketepatan_hasil;
    }

    public void setKetepatan_hasil(int ketepatan_hasil) {
        this.ketepatan_hasil = ketepatan_hasil;
    }

    public int getWaktu_eksekusi() {
        return this.waktu_eksekusi;
    }

    public void setWaktu_eksekusi(int waktu_eksekusi) {
        this.waktu_eksekusi = waktu_eksekusi;
    }

    public int getPemanfaatan() {
        return this.pemanfaatan;
    }

    public void setPemanfaatan(int pemanfaatan) {
        this.pemanfaatan = pemanfaatan;
    }


}