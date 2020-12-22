package lab3.game;

import lab3.additional.Prices;
import lab3.additional.UserChoices;
import lab3.fight_participant.Droid;
import lab3.items.Item;
import lab3.player.Player;

import java.util.ArrayList;

public class RestAbilities {
    private final UserChoices userChoice;

    RestAbilities(UserChoices userChoice) {
        this.userChoice = userChoice;
    }

    public void droidsUpgrade(Player player) {
        Integer choice;
        int doMore = 1;

        while(doMore != 0) {
            player.getTeam().printDroids();

            choice = userChoice.chooseDroid(player.getTeam().getMembers());

            upgradeDroid(player.getTeam().getMembers().get(choice),player);

            doMore = userChoice.finish();
        }
    }

    private void upgradeDroid(Droid droid, Player player) {

        Integer input = userChoice.chooseDroidUpgrade();

        switch(input) {
            case 1:
                player.getImprovementCenter().levelUp(droid);
                break;
            case 2:
                player.getImprovementCenter().improveHealth(droid);
                break;
            case 3:
                player.getImprovementCenter().improveStrength(droid);
                break;
            case 4:
                player.getImprovementCenter().improveDefence(droid);
                break;
            default:
                System.out.println("Entered wrong input");
                break;
        }
    }

    public void manageEquipment(Player player) {
        int doMore = 1;

        while(doMore != 0) {
            player.getTeam().printStorage();

            Integer itemChoice = userChoice.chooseItem(player.getTeam().getStorage());

            player.getTeam().printDroids();

            Integer droidChoice = userChoice.chooseDroid(player.getTeam().getMembers());

            equipItem(player.getTeam().getStorage().get(itemChoice),player.getTeam().getMembers().get(droidChoice));
            player.getTeam().getStorage().remove(itemChoice);

            doMore = userChoice.finish();
        }
    }

    private void equipItem(Item item, Droid droid) {
        switch(item.getType()) {
            case CONSUMABLE:
                droid.gainConsumable(item);
                break;
            case ATTACK_ITEM:
                droid.setAttackItem(item);
                break;
            case DEFENCE_ITEM:
                if(droid.getUnActiveSlot() == null) {
                    droid.setDefenceItem(item);
                }
                else {
                    droid.setUnActiveSlot(item);
                }
                break;
        }
    }

    public void shop(Player player) {
        int doMore = 1;

        while(doMore != 0) {

            Integer input = userChoice.chooseShopAction();

            switch(input) {
                case 1:
                    buyConsumable(player);
                    break;
                case 2:
                    buyAttackItem(player);
                    break;
                case 3:
                    buyDefenceItem(player);
                    break;
                default:
                    System.out.println("Entered wrong input");
                    break;
            }

            doMore = userChoice.finish();
        }
    }

    private void buyDefenceItem(Player player) {
        printItems(player.getShop().getDefenceItems());

        int choice = userChoice.chooseToBuy(player.getShop().getDefenceItems(),player.getTeam().getBank());
        if(choice == -1) {
            return;
        }

        player.getTeam().setBank(player.getTeam().getBank() - player.getShop().getDefenceItems().get(choice).getPrice());
        player.getTeam().getStorage().add(player.getShop().sellDefenceItem(choice));
    }

    private void buyAttackItem(Player player) {
        printItems(player.getShop().getAttackItems());

        int choice = userChoice.chooseToBuy(player.getShop().getAttackItems(),player.getTeam().getBank());
        if(choice == -1) {
            return;
        }

        player.getTeam().setBank(player.getTeam().getBank() - player.getShop().getAttackItems().get(choice).getPrice());
        player.getTeam().getStorage().add(player.getShop().sellAttackItem(choice));
    }

    private void buyConsumable(Player player) {
        printItems(player.getShop().getConsumables());

        int choice = userChoice.chooseToBuy(player.getShop().getConsumables(),player.getTeam().getBank());
        if(choice == -1) {
            return;
        }

        player.getTeam().setBank(player.getTeam().getBank() - player.getShop().getConsumables().get(choice).getPrice());
        player.getTeam().getStorage().add(player.getShop().sellConsumable(choice));
    }

    private void printItems(ArrayList<Item> items) {
        for(int i = 0; i < items.size(); i++) {
            System.out.printf("\nItem #%d\nPrice: %d\n",i,items.get(i).getPrice());
            items.get(i).print();
        }
    }

    public void upgradeFactory(Player player) {
        Integer upgradePrice = Prices.FACTORY_LEVEL_UP_START_PRICE + Prices.FACTORY_LEVEL_UP_START_PRICE * player.getSupplyingFactory().getLevel();
        System.out.printf("\nUpgrade cost: %d\n", upgradePrice);

        if(player.getTeam().getBank() < upgradePrice) {
            System.out.println("Not enough money");
            return;
        }

        player.getTeam().setBank(player.getTeam().getBank() - upgradePrice);
        player.getSupplyingFactory().upgradeUtility();
    }
}
