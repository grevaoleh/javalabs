package lab3.fight_participant;

import lab3.additional.DroidTypes;
import lab3.items.Item;

public class DamageDealer extends Droid {

    public DamageDealer(String name, Double maxHealth, Integer maxActionPoints, Double health,
                        Double strength, Double defence, Item attackItem, Item defenceItem, Integer level) {
        super(name, maxHealth, maxActionPoints, health, strength, defence, attackItem, defenceItem, level);
        this.type = DroidTypes.DAMAGE_DEALER;
    }

    @Override
    public void attack(Droid target) {
        if(this.attackItem == null) {
            target.takeDamage(this.strength);
        }
        else {
            target.takeDamage(this.strength * 2 * attackItem.use());
        }
    }
}
