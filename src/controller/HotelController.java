package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import model.DetailKamar;
import model.Kamar;
import model.Penyewaan;
import model.Reservasi;
import model.Tamu;

public class HotelController {
    HashMap<String, Kamar> kamars = new HashMap();
    HashMap<String, Tamu> tamus = new HashMap();
    HashMap<String, Reservasi> reservasis = new HashMap();
    ArrayList<Penyewaan>penyewaans = new ArrayList<>();

    public void setUp() {
        Kamar kamar1 = new Kamar();
        Kamar kamar2 = new Kamar();
        Kamar kamar3 = new Kamar();
	    Kamar kamar4 = new Kamar();
	    Kamar kamar5 = new Kamar();
	    Kamar kamar6 = new Kamar();
	    Kamar kamar7 = new Kamar();
        
        kamar1
                .setNoKamar("01")
                .setJenisKamar("Standar Room")
                .setHargaSewa(750000)
                .setIsAvailable(true);

        kamar2
                .setNoKamar("02")
                .setJenisKamar("Deluxe Room")
                .setHargaSewa(1250000)
                .setIsAvailable(true);

        kamar3
                .setNoKamar("03")
                .setJenisKamar("Suite room")
                .setHargaSewa(27500000)
                .setIsAvailable(true);

        kamar4
                .setNoKamar("04")
                .setJenisKamar("Connecting room")
                .setHargaSewa(5450000)
                .setIsAvailable(true);

        kamar5
                .setNoKamar("05")
                .setJenisKamar("Family room")
                .setHargaSewa(7500000)
                .setIsAvailable(true);

        kamar6
                .setNoKamar("06")
                .setJenisKamar("Cabana room")
                .setHargaSewa(15000000)
                .setIsAvailable(true);

        kamar7
                .setNoKamar("07")
                .setJenisKamar("Presintial Suite")
                .setHargaSewa(18000000)
                .setIsAvailable(true);

        kamars.put(kamar1.getNoKamar(), kamar1);
        kamars.put(kamar2.getNoKamar(), kamar2);
        kamars.put(kamar3.getNoKamar(), kamar3);
        kamars.put(kamar4.getNoKamar(), kamar4);
        kamars.put(kamar5.getNoKamar(), kamar5);
        kamars.put(kamar6.getNoKamar(), kamar6);
        kamars.put(kamar7.getNoKamar(), kamar7);
        
        Tamu tamu1 = new Tamu();
        Tamu tamu2 = new Tamu();

        tamu1   
                .setIdTamu("A1")
                .setNama("Castan")
                .setJenisKelamin("Pria")
                .setAlamat("Singapura")
                .setEmail("castan@gmail.com");

        tamu2
                .setIdTamu("A2")
                .setNama("Jenner")
                .setJenisKelamin("Wanita")
                .setAlamat("Kanada")
                .setEmail("jenner@gmail.com");

        tamus.put(tamu1.getIdTamu(), tamu1);
        tamus.put(tamu2.getIdTamu(), tamu2);

        Reservasi reservasi1 = new Reservasi();

        reservasi1
                .setIdReservasi("R1")
                .setNama("Mason")
                .setJenisKelamin("Pria")
                .setAlamat("Indonesia")
                .setEmail("mason@gmail.com");

        reservasis.put(reservasi1.getIdReservasi(), reservasi1);
    }

    public void logReser() {
        Scanner input = new Scanner(System.in);
        boolean ulang = true;
        while (ulang) {
            System.out.println("=========== Login Reservasi ===========");
            System.out.print("Masukan Nama : ");
            String nama = input.nextLine();
            System.out.println("");
            

            for(Reservasi reservasi : reservasis.values()) {
                if(reservasi.getIdNama().equals(nama)) {
                    System.out.println("Selamat Datang, " + reservasi.getIdNama());
                    System.out.println("");
                    ulang = false;
                    return;
                }

                System.out.println("Nama salah!");
                System.out.println("Masukkan nama anda kembali!");
            }
            input.close();
        }
    }

    public void dataTamu() {
        Scanner input = new Scanner(System.in);

        System.out.println("Masukkan Data Tamu\t : ");
        System.out.println("Masukkan ID Tamu\t : ");
        String idTamu = input.nextLine();

        System.out.print("Masukkan Nama\t : ");
        String nama = input.nextLine();

        System.out.print("Masukkan Jenis Kelamin\t : ");
        String jenisKelamin = input.nextLine();

        System.out.print("Masukan Alamat\t : ");
        String alamat = input.nextLine();

        System.out.print("Masukan Email\t : ");
        String email = input.nextLine();

        //System.out.print("Masukan No Telp\t : ");
        //String noTelp = input.nextLine();
        
        Tamu tamuDatang = new Tamu();

        tamuDatang
                .setIdTamu(idTamu)
                .setNama(nama)
                .setJenisKelamin(jenisKelamin)
                .setAlamat(alamat)
                .setEmail(email);
                
        tamus.put(tamuDatang.getIdTamu(), tamuDatang);
    }

    public void lihatDaftarKamar() {
        System.out.println();
        System.out.println("===== Daftar Kamar Tersedia =====");
        for (Map.Entry<String, Kamar> Kamar : kamars.entrySet()) {
            String key = Kamar.getKey();
            Kamar tKamar = Kamar.getValue();
            
            if (tKamar.isIsAvailable()) {
                System.out.println("No Kamar \t :" + key);
                System.out.println("Nama \t\t :" + tKamar.getJenisKamar());
                System.out.println("Harga \t\t :" + tKamar.getHargaSewa() + "/hari");
                System.out.println("");
            }
        }
    }

    public Kamar getKamar(String idKamar) {
        return kamars.get(idKamar);
    }

    public Tamu getTamu(String idTamu) {
        return tamus.get(idTamu);
    }

    public Reservasi getReservasi(String idReservasi) {
        return reservasis.get(idReservasi);
    }

    public void pemesanan() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<DetailKamar> tDetailKamars = new ArrayList<>();
        int increment = 0;
        String lanjut = "";
        try {
            do {
                increment++;
                System.out.println();
                System.out.print("Silahkan masukkan No Kamar yang anda inginkan\t: ");
                String NoKamar = input.readLine();

                System.out.print("Untuk berapa hari?\t: ");
                int jumlah = Integer.valueOf(input.readLine());

                System.out.print("Kembali memesan (Y/N)?\t: ");
                lanjut = input.readLine();


                DetailKamar dk = new DetailKamar();
                Kamar tKamar = getKamar(NoKamar);
                dk.setIdKamar("dk" + increment);
                dk.setKamar(tKamar);
                dk.setHargaSewa(tKamar.getHargaSewa());
                dk.setSubTotal(tKamar.getHargaSewa() * jumlah);
                tDetailKamars.add(dk);

            } while (lanjut.equalsIgnoreCase("Y"));

            System.out.println("");
            System.out.println("==== Berikut Daftar Pesanan Anda ====");
            tampilkanDaftarKamar(tDetailKamars);

            System.out.println("TOTAL: " + hitungTotalKamar(tDetailKamars));
            BufferedReader inputKonfirmasi = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Konfirmasi Pemesanan (Y/N)?");
            String konfirm = "n";
            konfirm = inputKonfirmasi.readLine();

            if (konfirm.equalsIgnoreCase("y")) {
                Penyewaan penyewaan = new Penyewaan();

                penyewaan
                        .setDetailKamars(tDetailKamars)
                        .setIdPenyewaan("A" + penyewaans.size() + 1)
                        .setTamu(getTamu("A1"))
                        .setReservasi(getReservasi("1"))
                        .setTanggal(LocalDate.now())
                        .setTotal(hitungTotalKamar(tDetailKamars));
                penyewaans.add(penyewaan);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void tampilkanDaftarKamar(ArrayList<DetailKamar> dk) {
        for (DetailKamar detailKamar : dk) {
            System.out.println("No Kamar \t :" + detailKamar.getKamar().getNoKamar());
            System.out.println("Jenis Kamar \t :" + detailKamar.getKamar().getJenisKamar());
            System.out.println("Harga \t :" + detailKamar.getHargaSewa()+ "/hari");
            System.out.println("");
        }
    }

    public int hitungTotalKamar(ArrayList<DetailKamar> dk) {
        int total = 0;
        for (DetailKamar detailKamar : dk) {
            total += detailKamar.getSubTotal();
        }
        return total;
    }

    public void tampilkanLaporanPemesanan() {
        for (Penyewaan penyewaan : penyewaans) {
            System.err.println();
            System.out.println("No Pesanan Kamar \t :"+penyewaan.getIdPenyewaan());
            System.out.println("Tanggal transaksi \t :"+penyewaan.getTanggal());
            // Tambahkan pernyataan if untuk memeriksa apakah getreservasi() mengembalikan null
            if (penyewaan.getreservasi() != null) {
                System.out.println("Reservasi \t \t : "+penyewaan.getReservasi().getIdReservasi());
            } else {
                System.out.println("Reservasi \t \t : Tidak ada");
            }
            System.out.println("Tamu \t \t : "+penyewaan.getTamu().getIdTamu());
            System.out.println("=========================");
            ArrayList<DetailKamar> detailKamars = penyewaan.getDetailKamars();
            for (DetailKamar dk : detailKamars) {
                System.out.println("Jenis Kamar \t \t : " + dk.getKamar().getJenisKamar());
                System.out.println("Subtotal \t \t : " + dk.getSubTotal());
            }
            System.out.println("=========================");
            System.out.println("Total \t \t : "+penyewaan.getTotal());
        }
    }
}
