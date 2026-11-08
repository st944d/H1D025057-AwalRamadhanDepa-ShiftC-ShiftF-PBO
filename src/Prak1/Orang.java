package Prak1;

public class Orang
{
    private int tahunUmur = 32;
    public void hitungUmur()
    {
        int hariUmur =tahunUmur * 365;
        long detikUmur = tahunUmur * 365 * 24L * 60 * 60;
        System.out.println("Umur anda adalah :"+hariUmur+" hari");
        System.out.println("Umur anda adalah :"+detikUmur+" detik");
    }
}
