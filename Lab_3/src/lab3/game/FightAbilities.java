package lab3.game;

import lab3.additional.Prices;
import lab3.additional.UserChoices;
import lab3.fight_participant.Droid;
import lab3.fight_participant.Team;

public class FightAbilities {

    private final UserChoices userChoice;

    FightAbilities(UserChoices userChoice) {
        this.userChoice = userChoice;
    }

    public void defence(Droid performer) {
        if (performer.getActionPoints() < Prices.ACTION_COST) {
            System.out.println("Not enough action points");
            return;
        }

        performer.setActionPoints(performer.getActionPoints() - Prices.ACTION_COST);

        performer.defenceSelf();
    }

    public void attack(Droid attacker, Team targets, Team toEarnMoney) {
        if (attacker.getActionPoints() < Prices.ACTION_COST) {
            System.out.println("Not enough action points");
            return;
        }
        Integer choice;

        targets.printDroids();

        choice = userChoice.chooseDroid(targets.getMembers());

        attacker.setActionPoints(attacker.getActionPoints() - Prices.ACTION_COST);

        attacker.attack(targets.getMembers().get(choice));

        fightResults( choice, attacker, targets, toEarnMoney);
    }

    private void fightResults(int choice,Droid attacker, Team targets, Team toEarnMoney) {
        if (targets.getMembers().get(choice).isAlive()) {
            attacker.gainExperience(Prices.KILL_EXPERIENCE);
        } else {
            attacker.gainExperience(Prices.ATTACK_EXPERIENCE);
        }
        toEarnMoney.setBank(toEarnMoney.getBank() + Prices.ATTACK_COST);
    }

    public void useConsumable(Droid user) {
        if (user.getActionPoints() < Prices.ACTION_COST) {
            System.out.println("Not enough action points");
            return;
        }
        Integer choice;

        user.printConsumables();

        choice = userChoice.chooseItem(user.getConsumables());

        if(choice == -1) {
            return;
        }

        user.setActionPoints(user.getActionPoints() - Prices.ACTION_COST);

        user.useConsumable(choice);
    }
}
