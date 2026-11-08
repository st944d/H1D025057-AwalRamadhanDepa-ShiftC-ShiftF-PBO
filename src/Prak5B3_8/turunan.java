package Prak5B3_8;

public class turunan extends dasar
{
    private int y;

    public turunan(int x, int y)
    {
        super(x);
        this.y = y;
    }

    public void tampilkanInformasi()
    {
        System.out.println("method dari class turunan");
        System.out.println("nilai x= "+getX());
        System.out.println("nilai y= "+y);
    }
}
