package lab3.utilities;

import lab3.additional.Prices;
import lab3.items.AttackItem;
import lab3.items.Consumable;
import lab3.items.DefenceItem;
import lab3.items.Item;

import java.util.ArrayList;

public class Shop {
    private final Factory supplyingFactory;
    private final ArrayList<Item> consumables = new ArrayList<>();
    private final ArrayList<Item> attackItems = new ArrayList<>();
    private final ArrayList<Item> defenceItems = new ArrayList<>();

    private final Integer shopSize;

    public Shop(Integer shopSize, Factory supplier) {
        this.shopSize = shopSize;
        this.supplyingFactory = supplier;
        fillShop();
    }

    private void fillShop() {
        int curCount = 0;
        while(curCount < shopSize) {
            attackItems.add(supplyingFactory.createAttackItem());
            defenceItems.add(supplyingFactory.createDefenceItem());
            consumables.add(supplyingFactory.createConsumable());
            curCount++;
        }
    }

    private void evaluateItem(Item object) {
        Integer price = Prices.ITEM_START_PRICE + Prices.POWER_UNIT_COST * object.getPower().intValue();
        object.setPrice(price);
    }

    private void addDefenceItem() {
        DefenceItem toAdd = supplyingFactory.createDefenceItem();
        evaluateItem(toAdd);
        defenceItems.add(toAdd);
    }

    private void addAttackItem() {
        AttackItem toAdd = supplyingFactory.createAttackItem();
        evaluateItem(toAdd);
        attackItems.add(toAdd);
    }

    private void addConsumable() {
        Consumable toAdd = supplyingFactory.createConsumable();
        evaluateItem(toAdd);
        consumables.add(toAdd);
    }

    public Item sellAttackItem(Integer itemIndex) {
        Item toSell = this.attackItems.get(itemIndex);
        //noinspection SuspiciousMethodCalls
        this.attackItems.remove(itemIndex);
        addAttackItem();
        return toSell;
    }

    public Item sellDefenceItem(Integer itemIndex) {
        Item toSell = this.defenceItems.get(itemIndex);
        this.defenceItems.remove(itemIndex);
        addDefenceItem();
        return toSell;
    }

    public Item sellConsumable(Integer itemIndex) {
        Item toSell = this.consumables.get(itemIndex);
        this.consumables.remove(itemIndex);
        addConsumable();
        return toSell;
    }

    public ArrayList<Item> getConsumables() {
        return consumables;
    }

    public ArrayList<Item> getAttackItems() {
        return attackItems;
    }

    public ArrayList<Item> getDefenceItems() {
        return defenceItems;
    }
}
