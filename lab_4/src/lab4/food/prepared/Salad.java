package lab4.food.prepared;

import lab4.food.ingredients.Vegetable;
import java.util.ArrayList;

public class Salad {

    private final ArrayList<Vegetable> ingredients = new ArrayList<>();

    public ArrayList<Vegetable> getIngredients() {
        return this.ingredients;
    }
}
