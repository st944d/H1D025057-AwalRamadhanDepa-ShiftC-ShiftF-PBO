package Prak2;

public class Mahasiswa
{
    private String Nama;
    private String NIM;
    private String Alamat;
    private int umur;
    private String Jurusan;

    public Mahasiswa (String Nama, String NIM) {
        this.Nama = Nama;
        this.NIM = NIM;
    }
    public Mahasiswa (String Nama, String NIM, String Alamat) {
        this.Nama = Nama;
        this.NIM = NIM;
        this.Alamat = Alamat;
    }

    public Mahasiswa (String Nama, String NIM, String Alamat, int umur, String Jurusan) {
        this.Nama = Nama;
        this.NIM = NIM;
        this.Alamat = Alamat;
        this.umur = umur;
        this.Jurusan = Jurusan;
    }

    public String getNIM ()
    {
        return NIM;
    }

    public String getNama()
    {
        return Nama;
    }

    public String getAlamat()
    {
        return Alamat;
    }

    public void setAlamat(String Alamat)
    {
        this.Alamat = Alamat;
    }

    public void setNama(String Nama)
    {
        this.Nama = Nama;
    }

    public void setNIM(String NIM){
        this.NIM = NIM;
    }

    void cetakInformasi()
    {
        System.out.print("NIM mahasiswa "+NIM+" adalah "+Nama+ "\n");
    }
}
