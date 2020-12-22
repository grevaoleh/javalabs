package lab3.game;

import lab3.fight_participant.Team;

public class Checks {

    public static boolean preTimeEndCheck(Team first, Team second) {
        if(first.getMembers().isEmpty()) {
            System.out.println("Winner is second player, first player has no allies");
            return true;
        }
        if(second.getMembers().isEmpty()) {
            System.out.println("Winner is first player, second player has no allies");
            return true;
        }
        return false;
    }

    public static void checkDroids(Team droids) {
        for(int i = 0;i < droids.getMembers().size();i++) {
            if(!droids.getMembers().get(i).isAlive()) {
                droids.getMembers().remove(i);
            }
        }
    }

    public static void checkInventory(Team droids) {
        for(int i = 0; i < droids.getMaxMembers(); i++) {
            if(droids.getMembers().get(i).getAttackItem() != null) {
                if (!droids.getMembers().get(i).getAttackItem().isValid()) {
                    droids.getMembers().get(i).setAttackItem(null);
                }
            }
            if(droids.getMembers().get(i).getDefenceItem() != null) {
                if (!droids.getMembers().get(i).getDefenceItem().isValid()) {
                    droids.getMembers().get(i).setDefenceItem(null);
                }
            }
            if(droids.getMembers().get(i).getUnActiveSlot() != null) {
                if (!droids.getMembers().get(i).getUnActiveSlot().isValid()) {
                    droids.getMembers().get(i).setDefenceItem(null);
                }
            }
            for(int j = 0; j < droids.getMembers().get(i).getConsumables().size(); j++) {
                if(!droids.getMembers().get(i).getConsumables().get(j).isValid()) {
                    droids.getMembers().get(i).getConsumables().remove(j);
                }
            }
        }
    }
}
