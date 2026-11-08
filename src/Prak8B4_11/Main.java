package Prak8B4_11;

public class Main {
    public static void main(String[] args) {
        kontrolTv tvku = new televisi("SHARP");
        tvku.hidupkan(true);
        tvku.keraskanVolume(10);
        tvku.pelankanVolume(3);
        tvku.pindahChannel(5);
        tvku.hidupkan(false);
    }
}