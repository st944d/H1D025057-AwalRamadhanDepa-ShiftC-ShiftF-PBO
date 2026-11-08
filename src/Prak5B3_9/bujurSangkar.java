package Prak5B3_9;

public class bujurSangkar extends bentuk2D{
    private int sisi;
    private int luas;
    private int keliling;

    public bujurSangkar(int sisi){
        this.sisi=sisi;
    }

    public void cetakLuas(){
        luas = sisi*sisi;
        System.out.println("Luas bujur sangkar adalah: "+luas);
    }

    public void cetakKeliling(){
        keliling = 4*sisi;
        System.out.println("Keliling bujur sangkar adalah: "+keliling);
    }
}
