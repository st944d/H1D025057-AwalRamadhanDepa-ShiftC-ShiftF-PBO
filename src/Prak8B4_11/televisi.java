package Prak8B4_11;

public class televisi implements kontrolTv {
    private String merek;
    private boolean hidup;
    private String[] saluran = {"RCTI", "SCTV", "INDOSIAR", "TPI", "ANTV", "TRANSTV", "TRANS7"};
    private int volume = 0;

    public televisi(String merek) {
        this.merek = merek;
    }

    public void hidupkan(boolean hidup) {
        if(hidup) {
            this.hidup = true;
            System.out.println("Televisi dihidupkan");
        } else {
            this.hidup = false;
            System.out.println("Televisi dimatikan");
        }
    }

    public void keraskanVolume(int tambah) {
        if(hidup) {
            volume = volume + tambah;
            System.out.println("volume menjadi " + volume);
        } else {
            System.out.println("Televisi dalam keadaan mati");
        }
    }

    public void pelankanVolume(int kurangi) {
        if(hidup) {
            volume = volume - kurangi;
            System.out.println("volume di set ke " + volume);
        } else {
            System.out.println("Televisi dalam keadaan mati");
        }
    }

    public void pindahChannel(int channel) {
        if(hidup) {
            System.out.println("TV menjadi " + saluran[channel]);
        } else {
            System.out.println("Televisi dalam keadaan mati");
        }
    }
}