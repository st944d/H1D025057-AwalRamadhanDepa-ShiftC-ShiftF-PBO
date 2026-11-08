package TelevisiMain;

public class Televisi
{
    public String merek;
    public String harga;
    public String kondisi;
    private int Channel;

    public Televisi(String merek, String harga)
    {
        this.merek = merek;
        this.harga = harga;
    }

    public void hidupkanTv()
    {
        this.kondisi = "hidup";
        System.out.println("Televisi "+kondisi);
    }

    public void matikanTv()
    {
        this.kondisi = "mati";
        System.out.println("Televisi "+kondisi);
    }

    public void setChannel(int channel)
    {
        this.Channel = channel;
    }

    public int getChannel()
    {
        return Channel;
    }

    public void informasiTv()
    {
        System.out.println("Televisi "+merek+" harga "+harga);
    }
}
