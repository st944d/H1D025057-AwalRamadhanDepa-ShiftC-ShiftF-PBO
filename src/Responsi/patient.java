package Responsi;

public class patient extends person {
    private int hp;
    private int coins;
    private String position;
    private boolean sudahDitangani;

    // Constructor overloading
    public patient(String name, int age) {
        this(name, age, 100);
    }

    public patient(String name, int age, int hp) {
        super(name, age);
        setHp(hp);
        this.coins = 500;
        this.position = "Pendaftaran";
        this.sudahDitangani = false;
    }

    @Override
    public void checkStatus() {
        super.checkStatus();

        System.out.println("HP       : " + hp + "/" + getMaxHp());
        System.out.println("Koin     : " + coins);
        System.out.println("Posisi   : " + position);
    }

    @Override
    public void processState() {
        if (hp < 0) {
            hp = 0;
        } else if (hp > getMaxHp()) {
            hp = getMaxHp();
        } else if (position.equals("Pendaftaran")) {
            moveTo("Ruang Tunggu");
        } else if (position.equals("Kasir") && sudahDitangani) {
            moveTo("Keluar");
        } else {
            System.out.println("Pasien masih dalam proses.");
        }
        System.out.println("Memproses kondisi pasien " + getName());
    }

    public void useMedicine(medicine obat) {
        if (obat != null) {
            setHp(hp + obat.getRecoveryHp());
            System.out.println(getName() + " menggunakan " + obat.getName());
        }
    }

    void moveTo(String position) {
        this.position = position;
    }

    void markTreated() {
        this.sudahDitangani = true;
    }

    boolean payCoins(int amount) {
        if (coins >= amount) {
            coins -= amount;
            return true;
        }

        return false;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp < 0) {
            this.hp = 0;
        } else if (hp > getMaxHp()) {
            this.hp = getMaxHp();
        } else {
            this.hp = hp;
        }
    }

    public int getCoins() {
        return coins;
    }

    public String getPosition() {
        return position;
    }

    public boolean getSudahDitangani() {
        return sudahDitangani;
    }
}
