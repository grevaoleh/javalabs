package lab4.user;

import lab4.enums.Commands;
import lab4.food.prepared.Salad;
import lab4.logging.Log;
import lab4.user.userMenu.menuElements.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;

public class Menu {

    private Log log;

    {
        try {
            log = new Log("myLog.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private final Scanner userInput = new Scanner(System.in);

    Salad salad = new Salad();
    User user = new User();

    public Menu() {

        user.addCommand("add ingredient",new AddIngredientCommand(salad));
        user.addCommand("count calories",new CountCaloriesCommand(salad));
        user.addCommand("find by calories",new FindByCaloriesCommand(salad));
        user.addCommand("remove ingredient",new RemoveIngredientCommand(salad));
        user.addCommand("show ingredients",new ShowIngredientsCommand(salad));
        user.addCommand("sort by criteria",new SortByCriteriaCommand(salad));
    }

    public void execute() {

        log.getLogger().setLevel(Level.FINEST);

        while(true) {

            showMenu();
            runCommand(getCommand());
        }
    }

    private void runCommand(Commands command) {

        switch(command) {

            case ADD_INGREDIENT: {
                log.getLogger().info("run add ingredient command");
                user.runCommand("add ingredient");
                break;
            }

            case REMOVE_INGREDIENT: {
                log.getLogger().info("run remove ingredient command");
                user.runCommand("remove ingredient");
                break;
            }

            case SHOW_INGREDIENTS: {
                log.getLogger().info("run show ingredients command");
                user.runCommand("show ingredients");
                break;
            }

            case FIND_BY_CALORIES: {
                log.getLogger().info("run find by calories command");
                user.runCommand("find by calories");
                break;
            }

            case SORT_BY_CRITERIA: {
                log.getLogger().info("run sort by criteria command");
                user.runCommand("sort by criteria");
                break;
            }

            case COUNT_CALORIES: {
                log.getLogger().info("run count calories command");
                user.runCommand("count calories");
                break;
            }

            case EXIT: {
                log.getLogger().info("run exit command");
                return;
            }

            default: {
                log.getLogger().warning("given wrong input in main menu");
                System.out.println("Wrong input");
            }
        }
    }

    private void showMenu() {

        System.out.println("'(1) add ingredient'\n" +
                "'(2) remove ingredient'\n" +
                "'(3) show ingredients'\n" +
                "'(4) find by calories'\n" +
                "'(5) sort by criteria'\n" +
                "'(6) count calories'\n" +
                "'(7) exit'\n");
    }

    private Commands getCommand() {

        int command = userInput.nextInt();
        return Commands.values()[command-1];
    }
}
