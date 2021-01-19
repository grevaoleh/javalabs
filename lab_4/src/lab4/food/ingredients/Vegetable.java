package lab4.food.ingredients;

import lab4.defaultValues.VegetableValues;

public class Vegetable {

    private final String name;
    private final double caloriesPerGram;

    public Vegetable(String name) {

        this.name = name;
        this.caloriesPerGram = VegetableValues.getCaloriesPerGram(name);
    }

    public String getName() {
        return name;
    }

    public double getCaloriesPerGram() {
        return caloriesPerGram;
    }

    public String toString() {
        return "\nName : " + this.name + "\n" + "Calories : " + this.caloriesPerGram + "\n";
    }
}
