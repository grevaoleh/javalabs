package lab4.user.userMenu.menuElements;

import lab4.commandHandlers.Chief;
import lab4.food.prepared.Salad;
import lab4.user.userMenu.Command;


public class CountCaloriesCommand implements Command {
    private final Salad salad;

    public CountCaloriesCommand(Salad salad) {
        this.salad = salad;
    }

    public void execute() {
        System.out.println("Calories in salad : " + Chief.countCalories(salad));
    }
}
