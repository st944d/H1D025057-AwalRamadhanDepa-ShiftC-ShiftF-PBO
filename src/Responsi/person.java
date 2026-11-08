package Responsi;

public abstract class person {
    private String name;
    private int age;
    private final int maxHp = 100;

    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void checkStatus() {
        System.out.println("Nama : " + name);
        System.out.println("Umur : " + age);
    }

    public abstract void processState();

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }
}
