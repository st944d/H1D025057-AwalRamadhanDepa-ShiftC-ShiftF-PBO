package Responsi;

import java.util.ArrayList;
import java.util.List;

public class doctor extends person implements herbalist, medicalLicense {
    private boolean isAvailable;

    public doctor(String name, int age) {
        super(name, age);
        this.isAvailable = true;
    }

    @Override
    public void checkStatus() {
        super.checkStatus();

        if (isAvailable) {
            System.out.println("Status : Tersedia");
        } else {
            System.out.println("Status : Sedang menangani pasien");
        }
    }

    @Override
    public void processState() {
        if (isAvailable) {
            System.out.println("Dokter siap menerima pasien.");
        } else {
            System.out.println("Dokter sedang bertugas.");
        }
    }

    public examination examinePatient(patient pasien) {
        if (!isAvailable &&
                pasien.getPosition().equals("Ruang Dokter")) {

            examination hasil = new examination(pasien, this);
            hasil.startExamination();

            System.out.println("Pasien berhasil diperiksa.");
            return hasil;
        }

        System.out.println("Pemeriksaan tidak dapat dilakukan.");
        return null;
    }

    @Override
    public medicine mixMedicine(String jenis, List<ingredient> bahan) {
        List<ingredient> resep = new ArrayList<>();
        String namaObat;
        int recoveryHp;
        int price;

        for (ingredient item : bahan) {
            String nama = item.getName();

            if (nama.equals("Air") || nama.equals("Green Herb")) {
                resep.add(item);
            }

            if (jenis.equalsIgnoreCase("High Potion") &&
                    nama.equals("Yellow Herb")) {
                resep.add(item);
            }

            if (jenis.equalsIgnoreCase("Mega Potion") &&
                    (nama.equals("Red Herb") ||
                            nama.equals("Yellow Herb"))) {
                resep.add(item);
            }
        }

        if (jenis.equalsIgnoreCase("Potion")) {
            namaObat = "Potion";
            recoveryHp = 25;
            price = 50;
        } else if (jenis.equalsIgnoreCase("High Potion")) {
            namaObat = "High Potion";
            recoveryHp = 50;
            price = 100;
        } else if (jenis.equalsIgnoreCase("Mega Potion")) {
            namaObat = "Mega Potion";
            recoveryHp = 100;
            price = 200;
        } else {
            System.out.println("Jenis obat tidak tersedia.");
            return null;
        }

        return new medicine(namaObat, recoveryHp, price, resep);
    }

    @Override
    public boolean giveMedicine(patient pasien, medicine obat) {
        if (!isAvailable &&
                pasien.getPosition().equals("Ruang Dokter") &&
                obat != null) {

            pasien.useMedicine(obat);
            return true;
        }

        return false;
    }

    public boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
}
