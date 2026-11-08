package Prak3B1;

public class Sepeda
{
    public int pedal;
    public int gear;
    public int kecepatan;
    private int Standsar;

    public Sepeda()
    {

    }

    public Sepeda(int pedal, int gear, int kecepatan)
    {
        this.pedal = pedal;
        this.gear = gear;
        this.kecepatan = kecepatan;
    }

    public void remSepeda(int nilaiPengereman)
    {
        kecepatan = kecepatan - nilaiPengereman;
    }

    public void tambahKecepatan(int nilaiTambah)
    {
        kecepatan = kecepatan + nilaiTambah;
    }
}
