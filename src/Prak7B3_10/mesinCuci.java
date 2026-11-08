package Prak7B3_10;

public class mesinCuci extends suatuMesin {
    public mesinCuci (String Nama){
        super(Nama);
    }

    public void hidupkanMesin () {
        if (isHidup()) {
            System.out.println(getNama() + " sudah hidup");
        } else {
            setHidup(true);
            System.out.println(getNama() + " dihidupkan");
        }
    }

    public void matikanMesin () {
        if (isHidup()) {
            setHidup(false);
            System.out.println(getNama() + " dimatikan");
        }
        else{
            setHidup(true);
            System.out.println(getNama() + " keadaan mati");
        }
    }

}
