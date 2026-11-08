package Prak4B2;

public class mobil
{
    private String Merek;
    private int roda;
    private int kursi;
    private int transmisi;

    public mobil(String Merek, int roda, int kursi, int transmisi)
    {
        this.Merek = Merek;
        this.roda = roda;
        this.kursi = kursi;
        this.transmisi = transmisi;
    }

    public String getMerek()
    {
        return Merek;
    }

    public void setMerek(String Merek)
    {
        this.Merek = Merek;
    }

    public int getKursi()
    {
        return kursi;
    }

    public void setKursi(int kursi)
    {
        this.kursi = kursi;
    }

    public int getRoda()
    {
        return roda;
    }

    public void setRoda(int roda)
    {
        this.roda = roda;
    }

    public int getTransmisi()
    {
        return transmisi;
    }

    public void setTransmisi(int transmisi)
    {
        this.transmisi = transmisi;
    }
}
