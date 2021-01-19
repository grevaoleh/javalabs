package lab4.user.userMenu.menuElements;

import lab4.food.prepared.Salad;
import lab4.user.userMenu.Command;
import java.util.Scanner;

public class SortByCriteriaCommand implements Command {
    private final Salad salad;

    public SortByCriteriaCommand(Salad salad) {
        this.salad = salad;
    }

    @Override
    public void execute() {
        System.out.println("Enter criteria for sort : ");
        showCriteria();
        Scanner in = new Scanner(System.in);
        String criteria = in.nextLine();

        while (true) {

            try {
                sortBy(criteria);
            }
            catch(IllegalStateException exception) {
                System.out.println(exception.toString());
                continue;
            }
            System.out.println("Sorting completed");
            break;
        }
    }

    private void sortBy(String criteria) {
        switch (criteria) {
            case "calories": {
                System.out.println("Sorting by calories");
                salad.getIngredients().sort((obj1, obj2) -> (int) (obj1.getCaloriesPerGram() - obj2.getCaloriesPerGram()));
                break;
            }
            case "name": {
                System.out.println("Sorting by names");
                salad.getIngredients().sort((obj1, obj2) -> obj1.getName().compareTo(obj2.getName()));
                break;
            }
            default: {
                System.out.println("Wrong input");
                System.out.println("Returning to main menu");
            }
        }
    }

    private void showCriteria() {
        System.out.println("'calories'\n" +
                "'name'\n");
    }
}
