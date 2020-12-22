package lab3.game;

import lab3.additional.UserChoices;
import lab3.player.Player;

import java.util.Scanner;


public class GameProcess {
    private Player firstPlayer;
    private Player secondPlayer;

    private final Scanner userInput = new Scanner(System.in);

    private final UserChoices userChoice = new UserChoices(userInput);

    private final MainMenu mainMenu = new MainMenu(userInput);

    private final Fight fight = new Fight(userChoice);

    private final Rest rest = new Rest(userInput,userChoice);

    private final PlayerCreator creator = new PlayerCreator(userChoice,userInput);

    public void startGame() {
        mainMenu.callMenu();

        creator.createPlayers(firstPlayer,secondPlayer);

        int currentRound = 1;
        int roundsNumber = 5;

        while (currentRound < roundsNumber) {
            System.out.printf("\nCurrent round : %d\n", currentRound);

            fight.startFight(firstPlayer, secondPlayer);
            rest.upgradeDroids(firstPlayer, secondPlayer);

            Checks.checkDroids(firstPlayer.getTeam());
            Checks.checkDroids(secondPlayer.getTeam());

            if (Checks.preTimeEndCheck(firstPlayer.getTeam(),secondPlayer.getTeam())) {
                return;
            }

            Checks.checkInventory(firstPlayer.getTeam());
            Checks.checkInventory(secondPlayer.getTeam());

            System.out.println("Continue - (1)\nquit - (0)");
            int choice = userInput.nextInt();
            if (choice == 0) {
                return;
            }
            currentRound++;
        }

        System.out.println("Winner is player#");
        System.out.println(findWinner().getTeamNumber());
    }

    private Player findWinner() {
        if(firstPlayer.getSupplyingFactory().getLevel() < secondPlayer.getSupplyingFactory().getLevel()) {
            return secondPlayer;
        }
        return firstPlayer;
    }
}
