package lab3.additional;

import lab3.fight_participant.Droid;
import lab3.items.Item;

import java.util.ArrayList;
import java.util.Scanner;

import static lab3.additional.InputValidation.validateInput;

public class UserChoices {
    private final Scanner userInput;

    public UserChoices(Scanner userInput) {
        this.userInput = userInput;
    }

    public Integer doSomething() {
        System.out.println("Perform actions - (1)\nskip turn - (0)");
        return validateInput(0,1,userInput.nextInt());
    }

    public Integer chooseDroid(ArrayList<Droid> chooseFrom) {

        System.out.println("Choose droid: ");

        return validateInput(0,chooseFrom.size() - 1,userInput.nextInt());
    }

    public Integer chooseAction() {

        System.out.printf("\nCost of action: %d action points\n", Prices.ACTION_COST);
        System.out.println("Choose action :\n(1) - use consumable \n(2) - shield self \n(3) - attack");

        return validateInput(1,3,userInput.nextInt());
    }

    public Integer finish() {
        System.out.println("To finish - (0) , else - any other number");
        return validateInput(0,1,userInput.nextInt());
    }

    public Integer chooseItem(ArrayList<Item> toChoose) {
        if(toChoose.isEmpty()) {
            System.out.println("You do not have any items");
            return -1;
        }
        System.out.println("Choose item");

        return validateInput(0, toChoose.size() - 1, userInput.nextInt());
    }

    public Integer chooseUpgrade() {
        System.out.println("What you want do do? \n(1) - upgrade factory \n(2) - buy in shop \n(3) - upgrade your droids \n(4) - manage equipment");
        return validateInput(1,4,userInput.nextInt());
    }

    public Integer chooseDroidUpgrade() {
        System.out.println("What do you want to upgrade ?\n(1) - level up \n(2) - health\n(3) - strength\n(4) - defence : ");
        return validateInput(1,4,userInput.nextInt());
    }

    public Integer chooseShopAction() {
        System.out.println("Buy (1) - Consumable (2) - Attack item (3) - Defence item : ");
        return validateInput(1,3,userInput.nextInt());
    }

    public Integer chooseToBuy(ArrayList<Item> items, Integer bank) {
        int choice = chooseItem(items);
        if(bank < items.get(choice).getPrice()) {
            System.out.println("Not enough money");
            return -1;
        }

        return choice;
    }

    public Integer chooseDroidType() {
        System.out.println("Enter droid you want to add to your team \n(1) - damage dealer \n(2) - defender : ");
        return validateInput(1,2, userInput.nextInt());
    }
}
