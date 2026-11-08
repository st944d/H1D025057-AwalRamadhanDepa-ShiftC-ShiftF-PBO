package Responsi;

public class examination {
    private patient pasien;
    private doctor dokter;
    private int hpBefore;
    private int hpAfter;

    public examination(patient pasien, doctor dokter) {
        this.pasien = pasien;
        this.dokter = dokter;
    }

    public void startExamination() {
        hpBefore = pasien.getHp();
        System.out.println("Pemeriksaan dimulai oleh Dr. "
                + dokter.getName());
    }

    public void finishExamination() {
        hpAfter = pasien.getHp();
    }

    public void displayResult() {
        System.out.println("\n=== HASIL PEMERIKSAAN ===");
        System.out.println("Pasien       : " + pasien.getName());
        System.out.println("Dokter       : " + dokter.getName());
        System.out.println("HP Sebelum   : " + hpBefore);
        System.out.println("HP Sesudah   : " + hpAfter);
    }
}
