package Responsi;

public class payment {
    private patient pasien;
    private medicine obat;
    private int amount;

    public payment(patient pasien, medicine obat) {
        this.pasien = pasien;
        this.obat = obat;
        this.amount = obat.getPrice();
    }

    public boolean processPayment() {
        System.out.println("\n=== PEMBAYARAN ===");
        System.out.println("Total : " + amount + " koin");

        if (pasien.payCoins(amount)) {
            System.out.println("Pembayaran berhasil.");
            return true;
        }

        System.out.println("Koin pasien tidak mencukupi.");
        return false;
    }

    public void displayReceipt() {
        System.out.println("\n=== STRUK PEMBAYARAN ===");
        System.out.println("Pasien : " + pasien.getName());
        System.out.println("Obat   : " + obat.getName());
        System.out.println("Total  : " + amount + " koin");
        System.out.println("Status : Lunas");
    }

    public int getAmount() {
        return amount;
    }
}
