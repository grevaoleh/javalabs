package lab4.user.userMenu.menuElements;

import lab4.food.prepared.Salad;
import lab4.user.userMenu.Command;

public class ShowIngredientsCommand implements Command {
    private final Salad salad;

    public ShowIngredientsCommand(Salad salad) {
        this.salad = salad;
    }

    @Override
    public void execute() {
        System.out.println("Ingredients in salad : ");
        System.out.println(salad.getIngredients());
    }
}
