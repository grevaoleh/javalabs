package lab4.user.userMenu.menuElements;

import lab4.commandHandlers.Chief;
import lab4.food.prepared.Salad;
import lab4.user.userMenu.Command;

import java.util.Scanner;

public class FindByCaloriesCommand implements Command {
    private final Salad salad;

    public FindByCaloriesCommand(Salad salad) {
        this.salad = salad;
    }

    @Override
    public void execute() {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter interval in which to search : ");
        double lowerBorder = in.nextDouble();
        double upperBorder = in.nextDouble();
        try {
            System.out.println(Chief.findByCalories(lowerBorder, upperBorder, salad));
        }
        catch(IllegalStateException exception) {
            System.out.println(exception.toString());
            System.out.println("Returning to main menu");
        }
    }
}
