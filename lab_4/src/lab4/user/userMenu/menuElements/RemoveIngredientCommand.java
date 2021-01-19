package lab4.user.userMenu.menuElements;

import lab4.commandHandlers.Chief;
import lab4.food.prepared.Salad;
import lab4.user.userMenu.Command;
import java.util.Scanner;

public class RemoveIngredientCommand implements Command {
    private final Salad salad;

    public RemoveIngredientCommand(Salad salad) {
        this.salad = salad;
    }

    @Override
    public void execute() {

            if(salad.getIngredients().isEmpty()) {
                System.out.println("No ingredients in salad");
                return;
            }
            System.out.println("Deleting ingredient from salad");
            System.out.println(salad.getIngredients());

            String name = getName();

            try {
                Chief.removeIngredient(name,salad);
            }
            catch(IllegalStateException exception) {
                System.out.println(exception.toString());
                System.out.println("Returning to main menu");
            }

    }

    public String getName() {
        System.out.println("Enter name of ingredient to delete");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
