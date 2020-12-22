package lab3.fight_participant;

import lab3.additional.DroidTypes;
import lab3.items.Item;

public class Defender extends Droid{

    public Defender(String name, Double maxHealth, Integer maxActionPoints, Double health,
                    Double strength, Double defence, Item attackItem, Item defenceItem, Integer level) {
        super(name, maxHealth, maxActionPoints, health, strength, defence, attackItem, defenceItem, level);
    this.type = DroidTypes.DEFENDER;
    }

    @Override
    public void takeDamage(Double damage) {
        if(this.defenceItem == null) {
            this.health -= damage * 1 / this.defence;
        }
        else {
            this.health -= defenceItem.use() * 1 / this.defence * damage * 0.5;
            this.unActiveSlot = this.defenceItem;
            this.defenceItem = null;
        }
        this.setAlive();
    }
}
