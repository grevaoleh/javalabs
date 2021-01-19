package lab4.tests;

import lab4.commandHandlers.Chief;
import lab4.food.prepared.Salad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ChiefTest {

    @Test
    void addUnExistingIngredient() {

        Salad salad = new Salad();
        Assertions.assertThrows(IllegalStateException.class ,() -> {
            Chief.addIngredient("peanut",salad);
        });
    }

    @Test
    void addIngredientAlreadyInSalad() {

        Salad salad = new Salad();
        Chief.addIngredient("carrot",salad);
        Assertions.assertThrows(IllegalStateException.class ,() -> {
            Chief.addIngredient("carrot",salad);
        });
    }


    @Test
    void removeIngredientNotInSalad() {
        Salad salad = new Salad();

        Assertions.assertThrows(IllegalStateException.class ,() -> {
            Chief.removeIngredient("carrot",salad);
        });
    }


    @Test
    void findByCaloriesSwappedBorders() {

        Salad salad = new Salad();
        Assertions.assertThrows(IllegalStateException.class ,() -> {
            Chief.findByCalories(12,10,salad);
        });
    }

    @Test
    void countCaloriesInEmptySaladReturnZero() {

        Salad salad = new Salad();
        double result = Chief.countCalories(salad);
        Assertions.assertEquals(0,result);
    }
}