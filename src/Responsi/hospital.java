
package Responsi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class hospital {
    public static final String namaRumahSakit = "ARD Hospital";

    private List<patient> patients;
    private List<doctor> doctors;
    private List<ingredient> ingredients;
    private Map<patient, doctor> assignments;
    private Map<patient, medicine> prescribedMedicines;
    private int totalIncome;

    public hospital() {
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        ingredients = new ArrayList<>();
        assignments = new HashMap<>();
        prescribedMedicines = new HashMap<>();
        totalIncome = 0;

        // Dokter
        doctors.add(new doctor("Andrew", 35));
        doctors.add(new doctor("William", 40));

        // Bahan obat
        ingredients.add(new ingredient("Air", "Base"));
        ingredients.add(new ingredient("Green Herb", "Herbal"));
        ingredients.add(new ingredient("Red Herb", "Herbal"));
        ingredients.add(new ingredient("Yellow Herb", "Herbal"));
    }

    public void registerPatient(patient pasien) {
        patients.add(pasien);

        System.out.println("\nPasien berhasil didaftarkan.");
        pasien.processState();
    }

    public doctor assignDoctor(patient pasien) {
        if (!pasien.getPosition().equals("Ruang Tunggu")) {
            System.out.println("Pasien harus berada di ruang tunggu.");
            return null;
        }

        for (doctor dokter : doctors) {
            if (dokter.getAvailable()) {
                dokter.setAvailable(false);
                pasien.moveTo("Ruang Dokter");
                assignments.put(pasien, dokter);

                System.out.println("Pasien diarahkan ke Dr. "
                        + dokter.getName());

                return dokter;
            }
        }

        System.out.println("Semua dokter sedang menangani pasien.");
        return null;
    }

    public void treatPatient(patient pasien, String jenisObat) {
        // Mengambil dokter yang menangani pasien
        doctor dokter = assignments.get(pasien);

        if (dokter == null) {
            System.out.println("Dokter tidak ditemukan.");
            return;
        }

        // Interface polymorphism: meracik obat
        herbalist peracik = dokter;
        medicine obat = peracik.mixMedicine(jenisObat, ingredients);

        if (obat == null) {
            return;
        }

        System.out.println("\n=== OBAT YANG DIRACIK ===");
        obat.displayMedicine();

        // Memulai pemeriksaan pasien
        examination hasil = dokter.examinePatient(pasien);

        if (hasil == null) {
            return;
        }

        // Interface polymorphism: memberikan obat
        medicalLicense pemberiIzin = dokter;

        if (pemberiIzin.giveMedicine(pasien, obat)) {
            pasien.markTreated();

            hasil.finishExamination();
            hasil.displayResult();

            prescribedMedicines.put(pasien, obat);

            System.out.println("\nPasien selesai ditangani.");
            System.out.println("Silakan arahkan pasien ke kasir.");
        } else {
            System.out.println("Pemberian obat gagal.");
        }
    }

    public void sendToCashier(patient pasien) {
        medicine obat = prescribedMedicines.get(pasien);

        if (!pasien.getSudahDitangani() || obat == null) {
            System.out.println("Pasien harus ditangani dokter terlebih dahulu.");
            return;
        }

        if (!pasien.getPosition().equals("Ruang Dokter") &&
                !pasien.getPosition().equals("Kasir")) {
            System.out.println("Posisi pasien tidak valid.");
            return;
        }

        // Pasien masuk kasir
        pasien.moveTo("Kasir");

        // Pembayaran otomatis
        payment pembayaran = new payment(pasien, obat);

        if (pembayaran.processPayment()) {
            pembayaran.displayReceipt();

            updateIncome(pembayaran.getAmount());

            // Pasien otomatis keluar
            pasien.processState();

            // Dokter kembali tersedia
            doctor dokter = assignments.get(pasien);

            if (dokter != null) {
                dokter.setAvailable(true);
                dokter.processState();
            }

            assignments.remove(pasien);
            prescribedMedicines.remove(pasien);

            System.out.println("Pasien telah meninggalkan rumah sakit.");
        } else {
            System.out.println("Pasien tetap berada di kasir.");
        }
    }

    public void updateIncome(int amount) {
        totalIncome += amount;
    }

    public void displayHospitalInfo() {
        System.out.println("\n=== INFORMASI RUMAH SAKIT ===");
        System.out.println("Nama Rumah Sakit : " + namaRumahSakit);
        System.out.println("Jumlah Pasien    : " + patients.size());
        System.out.println("Jumlah Dokter    : " + doctors.size());
        System.out.println("Pendapatan       : " + totalIncome + " koin");
    }

    public void displayPatients() {
        System.out.println("\n=== DAFTAR PASIEN ===");

        if (patients.isEmpty()) {
            System.out.println("Belum ada pasien.");
            return;
        }

        for (int i = 0; i < patients.size(); i++) {
            System.out.println("\nNomor: " + (i + 1));
            patients.get(i).checkStatus();
        }
    }

    public void displayDoctors() {
        System.out.println("\n=== DAFTAR DOKTER ===");

        for (int i = 0; i < doctors.size(); i++) {
            System.out.println("\nNomor: " + (i + 1));
            doctors.get(i).checkStatus();
        }
    }

    public List<patient> getPatients() {
        return new ArrayList<>(patients);
    }

    public List<doctor> getDoctors() {
        return new ArrayList<>(doctors);
    }
}
