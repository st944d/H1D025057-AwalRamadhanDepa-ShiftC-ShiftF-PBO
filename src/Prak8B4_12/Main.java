package Prak8B4_12;

public class Main {
    public static void main(String[] args) {
        televisi GoogleTv = new televisi("Google");
        GoogleTv.hidupkan(true);
        GoogleTv.konekInternet(true);
        GoogleTv.keraskanVolume(10);
        GoogleTv.hidupkan(false);
    }
}