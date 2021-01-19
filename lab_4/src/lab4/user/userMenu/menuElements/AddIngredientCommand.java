package lab4.user.userMenu.menuElements;

import lab4.commandHandlers.Chief;
import lab4.defaultValues.VegetableValues;
import lab4.food.prepared.Salad;
import lab4.logging.Log;
import lab4.user.userMenu.Command;
import java.util.Scanner;
import java.util.logging.Level;

public class AddIngredientCommand implements Command {
    private final Salad salad;

    public AddIngredientCommand(Salad salad) {
        this.salad = salad;
    }

    @Override
    public void execute() {

        try {
            Log log = new Log("myLog.txt");
            log.getLogger().setLevel(Level.FINEST);
            String name = getIngredient();

            try {
                Chief.addIngredient(name,salad);
            }
            catch (IllegalStateException exception) {
                System.out.println(exception.toString());
                System.out.println("Returning to main menu");
                log.getLogger().warning("error while adding ingredient");
            }
        }
        catch (Exception exception) {
            System.out.println(exception.toString());
        }
    }

    private String getIngredient() {
        System.out.println("Available ingredients :");
        System.out.println(VegetableValues.getNames());
        System.out.println("Enter ingredient name");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
