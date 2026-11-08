package Responsi;

import java.util.ArrayList;
import java.util.List;

public class medicine {
    private String name;
    private int recoveryHp;
    private int price;
    private List<ingredient> ingredients;

    public medicine(String name, int recoveryHp, int price,
                    List<ingredient> ingredients) {
        this.name = name;
        this.recoveryHp = recoveryHp;
        this.price = price;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public void displayMedicine() {
        System.out.println("Nama Obat : " + name);
        System.out.println("Pemulihan : +" + recoveryHp + " HP");
        System.out.println("Harga     : " + price + " koin");

        System.out.println("Bahan:");
        for (ingredient item : ingredients) {
            System.out.println("- " + item.getName());
        }
    }

    public String getName() {
        return name;
    }

    public int getRecoveryHp() {
        return recoveryHp;
    }

    public int getPrice() {
        return price;
    }

    public List<ingredient> getIngredients() {
        return new ArrayList<>(ingredients);
    }
}
