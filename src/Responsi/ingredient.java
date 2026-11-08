package Responsi;

public class ingredient {
    private String name;
    private String type;

    public ingredient(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void displayIngredient() {
        System.out.println(name + " - " + type);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
