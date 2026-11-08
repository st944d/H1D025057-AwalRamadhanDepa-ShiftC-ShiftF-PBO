package Responsi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static hospital rumahSakit = new hospital();

    public static void main(String[] args) {
        int pilihan;

        //ujiSyarat1();
        //ujiSyarat2();
        //ujiSyarat3();
        //ujiSyarat4();
        //ujiSyarat5();
        //ujiSyarat6();
        //ujiSyarat7();
        //ujiSyarat8();
        //ujiSyarat9();
        //ujiSyarat10();

        /**/
        do {
            System.out.println("\n==============================");
            System.out.println("       ARD HOSPITAL");
            System.out.println("==============================");
            System.out.println("1. Daftarkan Pasien");
            System.out.println("2. Lihat Daftar Pasien");
            System.out.println("3. Tangani Pasien");
            System.out.println("4. Arahkan Pasien ke Kasir");
            System.out.println("5. Lihat Daftar Dokter");
            System.out.println("6. Informasi Rumah Sakit");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");

            pilihan = bacaAngka();

            switch (pilihan) {
                case 1:
                    daftarPasien();
                    break;
                case 2:
                    rumahSakit.displayPatients();
                    break;
                case 3:
                    tanganiPasien();
                    break;
                case 4:
                    arahkanKeKasir();
                    break;
                case 5:
                    rumahSakit.displayDoctors();
                    break;
                case 6:
                    rumahSakit.displayHospitalInfo();
                    break;
                case 0:
                    System.out.println("Terima kasih telah bermain.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia.");
            }

        } while (pilihan != 0);

        input.close();/**/
    }

    static void daftarPasien() {
        System.out.print("Nama pasien: ");
        String nama = input.nextLine();

        System.out.print("Umur pasien: ");
        int umur = bacaAngka();

        System.out.print("HP awal pasien: ");
        int hp = bacaAngka();

        patient pasien = new patient(nama, umur, hp);
        rumahSakit.registerPatient(pasien);
    }

    static void tanganiPasien() {
        List<patient> daftar = rumahSakit.getPatients();

        System.out.println("\n=== PASIEN RUANG TUNGGU ===");

        int jumlah = 0;

        for (patient pasien : daftar) {
            if (pasien.getPosition().equals("Ruang Tunggu")) {
                jumlah++;
                System.out.println(jumlah + ". " + pasien.getName());
            }
        }

        if (jumlah == 0) {
            System.out.println("Tidak ada pasien di ruang tunggu.");
            return;
        }

        System.out.print("Nomor pasien: ");
        int nomor = bacaAngka();

        patient terpilih = pilihPasienMenunggu(daftar, nomor);

        if (terpilih == null) {
            System.out.println("Nomor pasien tidak valid.");
            return;
        }

        System.out.println("\nPilih obat:");
        System.out.println("1. Potion (+25 HP, 50 koin)");
        System.out.println("2. High Potion (+50 HP, 100 koin)");
        System.out.println("3. Mega Potion (+100 HP, 200 koin)");
        System.out.print("Pilihan: ");

        int pilihan = bacaAngka();

        String jenisObat;

        if (pilihan == 1) {
            jenisObat = "Potion";
        } else if (pilihan == 2) {
            jenisObat = "High Potion";
        } else if (pilihan == 3) {
            jenisObat = "Mega Potion";
        } else {
            System.out.println("Jenis obat tidak tersedia.");
            return;
        }

        doctor dokter = rumahSakit.assignDoctor(terpilih);

        if (dokter == null) {
            return;
        }

        rumahSakit.treatPatient(terpilih, jenisObat);
    }

    static void arahkanKeKasir() {
        List<patient> daftar = rumahSakit.getPatients();

        System.out.println("\n=== PASIEN SELESAI DITANGANI ===");

        int jumlah = 0;

        for (patient pasien : daftar) {
            if (pasien.getPosition().equals("Ruang Dokter") &&
                    pasien.getSudahDitangani()) {
                jumlah++;
                System.out.println(jumlah + ". " + pasien.getName());
            }
        }

        if (jumlah == 0) {
            System.out.println("Tidak ada pasien yang siap ke kasir.");
            return;
        }

        System.out.print("Nomor pasien: ");
        int nomor = bacaAngka();

        patient terpilih = pilihPasienSelesai(daftar, nomor);

        if (terpilih == null) {
            System.out.println("Nomor pasien tidak valid.");
            return;
        }

        rumahSakit.sendToCashier(terpilih);
    }

    static patient pilihPasienMenunggu(List<patient> daftar, int nomor) {
        int hitung = 0;

        for (patient pasien : daftar) {
            if (pasien.getPosition().equals("Ruang Tunggu")) {
                hitung++;

                if (hitung == nomor) {
                    return pasien;
                }
            }
        }

        return null;
    }

    static patient pilihPasienSelesai(List<patient> daftar, int nomor) {
        int hitung = 0;

        for (patient pasien : daftar) {
            if (pasien.getPosition().equals("Ruang Dokter") &&
                    pasien.getSudahDitangani()) {
                hitung++;

                if (hitung == nomor) {
                    return pasien;
                }
            }
        }

        return null;
    }

    static int bacaAngka() {
        while (true) {
            try {
                int angka = Integer.parseInt(input.nextLine());
                return angka;
            } catch (NumberFormatException e) {
                System.out.print("Masukkan angka yang valid: ");
            }
        }
    }


    static void ujiSyarat1() {
        System.out.println("\n=== PENGUJIAN SYARAT 1 ===");

        patient pasien = new patient("Steve", 20, 75);

        System.out.println("Nama : " + pasien.getName());
        System.out.println("Umur : " + pasien.getAge());
        System.out.println("HP   : " + pasien.getHp());

        pasien.setHp(90);

        System.out.println("\nHP berhasil diperbarui.");
        System.out.println("HP sekarang : " + pasien.getHp());
    }

    static void ujiSyarat2() {
        System.out.println("\n=== PENGUJIAN SYARAT 2 ===");

        patient pasien = new patient("Steve", 20, 75);

        System.out.println("Nama Rumah Sakit : " + hospital.namaRumahSakit);
        System.out.println("Max HP Pasien    : " + pasien.getMaxHp());
    }

    static void ujiSyarat3() {
        System.out.println("\n=== PENGUJIAN SYARAT 3 ===");

        // Constructor pertama
        patient pasien1 = new patient("Steve", 20);

        // Constructor kedua
        patient pasien2 = new patient("Alex", 21, 75);

        System.out.println("Pasien 1: " + pasien1.getName());
        System.out.println("Umur    : " + pasien1.getAge());

        System.out.println("\nPasien 2: " + pasien2.getName());
        System.out.println("Umur    : " + pasien2.getAge());
        System.out.println("HP      : " + pasien2.getHp());

        pasien1.setHp(90);

        System.out.println("\nHP Steve setelah diubah: " + pasien1.getHp());
    }

    static void ujiSyarat4() {
        System.out.println("\n=== PENGUJIAN SYARAT 4 ===");

        patient pasien = new patient("Steve", 20, 75);
        doctor dokter = new doctor("Andrew", 35);

        System.out.println(
                "Patient turunan Person: "
                        + (pasien instanceof person)
        );

        System.out.println(
                "Doctor turunan Person : "
                        + (dokter instanceof person)
        );
    }

    static void ujiSyarat5() {
        System.out.println("\n=== PENGUJIAN SYARAT 5 ===");

        patient pasien = new patient("Steve", 20, 75);

        pasien.checkStatus();
    }

    static void ujiSyarat6() {
        System.out.println("\n=== PENGUJIAN SYARAT 6 ===");

        patient pasien = new patient("Steve", 20, 75);
        doctor dokter = new doctor("Andrew", 35);

        System.out.println("\nStatus Pasien:");
        pasien.checkStatus();

        System.out.println("\nStatus Dokter:");
        dokter.checkStatus();
    }

    static void ujiSyarat7() {
        System.out.println("\n=== PENGUJIAN SYARAT 7 ===");

        patient pasien = new patient("Steve", 20, 75);
        doctor dokter = new doctor("Andrew", 35);

        System.out.println("\nProses Pasien:");
        pasien.processState();

        System.out.println("\nProses Dokter:");
        dokter.processState();
    }

    static void ujiSyarat8() {
        System.out.println("\n=== PENGUJIAN SYARAT 8 ===");

        patient pasien = new patient("Steve", 20, 75);

        System.out.println("Posisi awal: " + pasien.getPosition());

        pasien.processState();

        System.out.println("Posisi sekarang: " + pasien.getPosition());

        pasien.markTreated();
        pasien.moveTo("Kasir");

        System.out.println("\nPasien sudah ditangani.");
        System.out.println("Posisi: " + pasien.getPosition());

        pasien.processState();

        System.out.println("Posisi akhir: " + pasien.getPosition());
    }

    static void ujiSyarat9() {
        System.out.println("\n=== PENGUJIAN SYARAT 9 ===");

        doctor dokter = new doctor("Andrew", 35);

        List<ingredient> bahan = new ArrayList<>();

        herbalist peracik = dokter;

        medicine obat = peracik.mixMedicine("Mega Potion", bahan);

        if (obat != null) {
            System.out.println("Dokter berhasil meracik obat.");
            System.out.println("Nama obat: " + obat.getName());
        }
    }

    static void ujiSyarat10() {
        System.out.println("\n=== PENGUJIAN SYARAT 10 ===");

        doctor dokter = new doctor("Andrew", 35);

        herbalist peracik = dokter;
        medicalLicense pemberiIzin = dokter;

        System.out.println(
                "Herbalist       : " + (peracik != null)
        );

        System.out.println(
                "Medical License : " + (pemberiIzin != null)
        );
    }

}
