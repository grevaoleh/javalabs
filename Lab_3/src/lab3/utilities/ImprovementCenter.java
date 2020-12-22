package lab3.utilities;

import lab3.additional.ComplexStats;
import lab3.additional.Prices;
import lab3.fight_participant.Droid;

public class ImprovementCenter {
    public void levelUp(Droid target) {
        Double price;
        price = Prices.LEVEL_UP_START_PRICE * target.getLevel();
        if(target.getExperience() < price) {
            System.out.println("Not enough experience");
            return;
        }
        target.setExperience(target.getExperience() - price);
        target.levelUp();
    }

    public void improveHealth(Droid target) {
        if(target.getSkillPoints() < Prices.HEALTH_UPGRADE_PRICE) {
            System.out.println("Not enough skill points");
            return;
        }
        target.setSkillPoints(target.getSkillPoints() - Prices.HEALTH_UPGRADE_PRICE);
        target.setMaxHealth(target.getMaxHealth() + ComplexStats.healthUpgradeValue(target.getType()));
    }

    public void improveStrength(Droid target) {
        if(target.getSkillPoints() < Prices.STRENGTH_UPGRADE_PRICE) {
            System.out.println("Not enough skill points");
            return;
        }
        target.setSkillPoints(target.getSkillPoints() - Prices.STRENGTH_UPGRADE_PRICE);
        target.setStrength(target.getStrength() + ComplexStats.strengthUpgradeValue(target.getType()));
    }

    public void improveDefence(Droid target) {
        if(target.getSkillPoints() < Prices.DEFENCE_UPGRADE_PRICE) {
            System.out.println("Not enough skill points");
            return;
        }
        target.setSkillPoints(target.getSkillPoints() - Prices.DEFENCE_UPGRADE_PRICE);
        target.setDefence(target.getDefence() + ComplexStats.defenceUpgradeValue(target.getType()));
    }
}
