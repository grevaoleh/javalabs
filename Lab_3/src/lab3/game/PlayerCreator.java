package lab3.game;

import lab3.additional.DroidTypes;
import lab3.additional.UserChoices;
import lab3.player.Player;

import java.util.Scanner;

import static lab3.additional.InputValidation.validateInput;

public class PlayerCreator {

    private final Scanner userInput;
    private final UserChoices userChoice;

    PlayerCreator( UserChoices userChoice, Scanner userInput) {
        this.userInput = userInput;
        this.userChoice = userChoice;
    }

    public void createPlayers(Player firstPlayer, Player secondPlayer) {
        int reCreate = 1;

        while(reCreate != 0) {
            System.out.println("Enter number of units in each team (1 - 10): ");
            Integer teamsSize = userInput.nextInt();
            teamsSize = validateInput(1,10,teamsSize);

            firstPlayer = new Player(1,teamsSize);
            secondPlayer = new Player(2,teamsSize);

            createTeam(firstPlayer);
            createTeam(secondPlayer);

            reCreate = userChoice.finish();
        }
    }

    private void createTeam(Player player) {
        System.out.printf("Player number : %d\n", player.getTeamNumber());
        int counter = 0;
        while(counter < player.getTeam().getMaxMembers()) {
            counter++;

            Integer choice = userChoice.chooseDroidType();

            System.out.println("Enter name of droid : ");
            String name = userInput.next();

            addDroid(player,choice,name);
        }
    }

    private void addDroid(Player playerBase, Integer choice, String name) {
        switch(choice) {
            case 1:
                playerBase.getTeam().addMember(playerBase.getSupplyingFactory().createDroid(name , DroidTypes.DAMAGE_DEALER));
                break;
            case 2:
                playerBase.getTeam().addMember(playerBase.getSupplyingFactory().createDroid(name , DroidTypes.DEFENDER));
                break;
            default:
                if(choice < 1) {
                    playerBase.getTeam().addMember(playerBase.getSupplyingFactory().createDroid(name , DroidTypes.DAMAGE_DEALER));
                }
                else {
                    playerBase.getTeam().addMember(playerBase.getSupplyingFactory().createDroid(name , DroidTypes.DEFENDER));
                }
                break;
        }
    }
}
