/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.busan.manajemenpenjualanmobil;

/**
 *
 * @author budi
 */
import java.util.Scanner;

// Kelas Mobil
class Mobil {
    private String merk;
    private String model;
    private int tahun;
    private double harga;

    // Konstruktor
    public Mobil(String merk, String model, int tahun, double harga) {
        this.merk = merk;
        this.model = model;
        this.tahun = tahun;
        this.harga = harga;
    }

    // Getter dan Setter
    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
}

// Kelas MobilBaru extends Mobil
class MobilBaru extends Mobil {
    public MobilBaru(String merk, String model, int tahun, double harga) {
        super(merk, model, tahun, harga);
    }
}

// Kelas MobilBekas extends Mobil
class MobilBekas extends Mobil {
    private int kilometer;

    public MobilBekas(String merk, String model, int tahun, double harga, int kilometer) {
        super(merk, model, tahun, harga);
        this.kilometer = kilometer;
    }

    public int getKilometer() {
        return kilometer;
    }

    public void setKilometer(int kilometer) {
        this.kilometer = kilometer;
    }
}

public class ManajemenPenjualanMobil {
    private int stokMobilBaru;
    private int stokMobilBekas;
    private double keuangan;

    public ManajemenPenjualanMobil() {
        stokMobilBaru = 0;
        stokMobilBekas = 0;
        keuangan = 0.0;
    }

    public void jualMobilBaru() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan harga jual mobil baru: ");
        double hargaJual = scanner.nextDouble();

        if (stokMobilBaru > 0) {
            stokMobilBaru--;
            keuangan += hargaJual;
            System.out.println("Mobil baru terjual dengan harga: " + hargaJual);
        } else {
            System.out.println("Stok mobil baru kosong. Tidak dapat menjual mobil.");
        }
    }

    public void jualMobilBekas() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan harga jual mobil bekas: ");
        double hargaJual = scanner.nextDouble();

        if (stokMobilBekas > 0) {
            stokMobilBekas--;
            keuangan += hargaJual;
            System.out.println("Mobil bekas terjual dengan harga: " + hargaJual);
        } else {
            System.out.println("Stok mobil bekas kosong. Tidak dapat menjual mobil.");
        }
    }

    public void beliMobilBaru() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan harga beli mobil baru: ");
        double hargaBeli = scanner.nextDouble();

        stokMobilBaru++;
        keuangan -= hargaBeli;
        System.out.println("Mobil baru dibeli dengan harga: " + hargaBeli);
    }

    public void beliMobilBekas() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan harga beli mobil bekas: ");
        double hargaBeli = scanner.nextDouble();

        stokMobilBekas++;
        keuangan -= hargaBeli;
        System.out.println("Mobil bekas dibeli dengan harga: " + hargaBeli);
    }

    public void lihatStok() {
        System.out.println("Stok mobil baru: " + stokMobilBaru);
        System.out.println("Stok mobil bekas: " + stokMobilBekas);
    }

    public void lihatLaporanKeuangan() {
        System.out.println("Keuangan: " + keuangan);
    }

    public static void main(String[] args) {
        ManajemenPenjualanMobil manajemen = new ManajemenPenjualanMobil();
        Scanner scanner = new Scanner(System.in);
        String pilihan;

        do {
            System.out.println("========== Menu ==========");
            System.out.println("1. Jual mobil baru");
            System.out.println("2. Jual mobil bekas");
            System.out.println("3. Beli mobil baru");
            System.out.println("4. Beli mobil bekas");
            System.out.println("5. Lihat stok");
            System.out.println("6. Lihat laporan keuangan");
            System.out.println("7. Exit");
            System.out.print("Pilihan: ");
            pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    manajemen.jualMobilBaru();
                    break;
                case "2":
                    manajemen.jualMobilBekas();
                    break;
                case "3":
                    manajemen.beliMobilBaru();
                    break;
                case "4":
                    manajemen.beliMobilBekas();
                    break;
                case "5":
                    manajemen.lihatStok();
                    break;
                case "6":
                    manajemen.lihatLaporanKeuangan();
                    break;
                case "7":
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }

            System.out.println();
        } while (!pilihan.equals("7"));
    }
}

