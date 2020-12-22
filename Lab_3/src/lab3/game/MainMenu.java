package lab3.game;

import java.util.Scanner;

import static lab3.additional.InputValidation.validateInput;

public class MainMenu {
    private final Scanner userInput;

    public MainMenu(Scanner userInput) {
        this.userInput = userInput;
    }

    public void callMenu() {
        System.out.println("Start (1) quit game (0)");
        Integer input = userInput.nextInt();

        input = validateInput(0,1,input);

        if(input == 0) {
            System.exit(0);
        }
    }
}
