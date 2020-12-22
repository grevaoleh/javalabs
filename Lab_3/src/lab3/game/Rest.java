package lab3.game;

import lab3.additional.UserChoices;
import lab3.player.Player;

import java.util.Scanner;

public class Rest {

    private final UserChoices userChoice;
    private final RestAbilities userAbilities;

    public Rest(Scanner userInput, UserChoices userChoice) {
        this.userAbilities = new RestAbilities(userChoice);
        this.userChoice = userChoice;
    }

    public void upgradeDroids(Player firstPlayer, Player secondPlayer) {
        upgrade(firstPlayer);
        upgrade(secondPlayer);
    }

    private void upgrade(Player player) {
        int doMore = 1;

        while (doMore != 0) {
            System.out.printf("Player %d \nYou have %d money in your bank\n",player.getTeamNumber(),player.getTeam().getBank());

            if(userChoice.doSomething() == 0) {
                return;
            }

            Integer input = userChoice.chooseUpgrade();

            performChosenAction(input, player);

            doMore = userChoice.finish();
        }
    }

    private void performChosenAction(int input, Player player) {
        switch (input) {
            case 1:
                userAbilities.upgradeFactory(player);
                break;
            case 2:
                userAbilities.shop(player);
                break;
            case 3:
                userAbilities.droidsUpgrade(player);
                break;
            case 4:
                userAbilities.manageEquipment(player);
                break;
            default:
                System.out.println("Wrong input");
                break;
        }
    }
}
