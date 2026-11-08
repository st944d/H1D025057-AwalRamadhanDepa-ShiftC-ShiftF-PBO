package Prak5B3_9;

public class Main {
    public static void main(String[] args) {
        bujurSangkar kotak = new bujurSangkar(4);
        persegiPanjang kotakPanjang = new persegiPanjang(4, 2);
        kotak.cetakLuas();
        kotak.cetakKeliling();
        kotakPanjang.cetakLuas();
        kotakPanjang.cetakKeliling();
    }
}
