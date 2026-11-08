package Prak1BangunDatar;

public class Uji
{
    public static void main(String[] args)
    {
        int x;
        bujurSangkar bujur=new bujurSangkar();
        x=bujur.hitungLuas(4);
        System.out.println("Luas bujur sangkar : "+x);

        x=bujur.hitungKeliling(5);
        System.out.println("Keliling bujur sangkar : "+x);

        Persegi persegipanjang=new Persegi();

        x=persegipanjang.hitungLuas(6, 4);
        System.out.println("Luas persegi : "+x);

        x=persegipanjang.hitungKeliling(6, 4);
        System.out.println("Keliling persegi : "+x);
    }
}
