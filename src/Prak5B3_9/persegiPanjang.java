package Prak5B3_9;

public class persegiPanjang extends bentuk2D{
    private int panjang;
    private int lebar;
    private double luas;
    private int keliling;

    public persegiPanjang(int panjang, int lebar){
        this.panjang=panjang;
        this.lebar=lebar;
    }

    public void cetakLuas(){
        luas=panjang*lebar;
        System.out.println("Luas persegi panjang adalah: "+luas);
    }

    public void cetakKeliling(){
        keliling=2*(panjang+lebar);
        System.out.println("Keliling persegi panjang: "+keliling);
    }
}
