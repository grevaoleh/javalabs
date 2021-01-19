package lab4.commandHandlers;

import lab4.defaultValues.VegetableValues;
import lab4.food.ingredients.Vegetable;
import lab4.food.prepared.Salad;
import java.util.ArrayList;

public class Chief {

    public static void addIngredient(String ingredientName, Salad salad) {

        if(findIngredient(ingredientName,salad) != null) {
            throw new IllegalStateException("Ingredient already added");
        }

        if(!VegetableValues.getNames().contains(ingredientName)) {
            throw new IllegalStateException("Do not have such ingredient");
        }

        salad.getIngredients().add(new Vegetable(ingredientName));
        System.out.println("Added ingredient : " + ingredientName);
    }

    public static void removeIngredient(String ingredientName, Salad salad) {
        Vegetable toRemove = findIngredient(ingredientName, salad);

        if(toRemove == null) {
            throw new IllegalStateException("No such ingredient in salad");
        }

        salad.getIngredients().remove(toRemove);
        System.out.println("Removed " + ingredientName);
    }

    public static ArrayList<Vegetable> findByCalories(double lowerBorder, double upperBorder, Salad salad) {

        ArrayList<Vegetable> found = new ArrayList<>();

        if(lowerBorder > upperBorder) {
            throw new IllegalStateException("Wrong border sequence");
        }

        for(int i = 0; i < salad.getIngredients().size(); i++) {

            if(salad.getIngredients().get(i).getCaloriesPerGram() > lowerBorder &&
                    salad.getIngredients().get(i).getCaloriesPerGram() < upperBorder) {
                found.add(salad.getIngredients().get(i));
            }
        }

        return found;
    }

    private static Vegetable findIngredient(String ingredientName, Salad salad) {

        for(int i = 0 ; i < salad.getIngredients().size(); i++ ) {

            if(salad.getIngredients().get(i).getName().equals(ingredientName)) {
                return salad.getIngredients().get(i);
            }
        }

        return null;
    }

    public static double countCalories(Salad salad) {

        double count = 0;

        for(int i = 0 ; i < salad.getIngredients().size(); i++) {

            count += salad.getIngredients().get(i).getCaloriesPerGram();
        }

        return count;
    }
}
