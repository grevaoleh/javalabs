package lab3.game;

import lab3.additional.Stats;
import lab3.additional.UserChoices;
import lab3.fight_participant.Droid;
import lab3.player.Player;

import java.util.ArrayList;

public class Fight {

    private final FightAbilities userAbilities;
    private final UserChoices userChoice;

    public Fight(UserChoices userChoice) {
        this.userAbilities = new FightAbilities(userChoice);
        this.userChoice = userChoice;
    }

    public void startFight(Player firstPlayer, Player secondPlayer) {

            restoreActionPoints(firstPlayer.getTeam().getMembers());
            restoreActionPoints(secondPlayer.getTeam().getMembers());
            fight(firstPlayer, secondPlayer);
            fight(secondPlayer, firstPlayer);

    }

    private void restoreActionPoints(ArrayList<Droid> droids) {
        for(int i = 0; i < droids.size(); i++) {
            droids.get(i).setActionPoints(Stats.MAX_ACTION_POINTS);
        }
    }

    private void fight(Player playerFirst, Player playerSecond) {
        int doMore = 1;

        while (doMore != 0) {
            System.out.printf("\nPlayer #%d\n",playerFirst.getTeamNumber());
            playerFirst.getTeam().printDroids();

            if(userChoice.doSomething() == 0) {
                return;
            }

            int droidToPerform = userChoice.chooseDroid(playerFirst.getTeam().getMembers());

            int input = userChoice.chooseAction();

            performChosenAction(input,droidToPerform,playerFirst,playerSecond);

            doMore = userChoice.finish();
        }
    }

    private void performChosenAction(int input, int droidToPerform, Player playerFirst, Player playerSecond) {
        switch (input) {
            case 1:
                userAbilities.useConsumable(playerFirst.getTeam().getMembers().get(droidToPerform));
                break;
            case 2:
                userAbilities.defence(playerFirst.getTeam().getMembers().get(droidToPerform));
                break;
            case 3:
                userAbilities.attack(playerFirst.getTeam().getMembers().get(droidToPerform), playerSecond.getTeam(), playerFirst.getTeam());
                break;
            default:
                System.out.println("Wrong input");
                break;
        }
    }

}