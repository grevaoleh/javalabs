package lab3.utilities;

import lab3.additional.DroidTypes;
import lab3.additional.ComplexStats;
import lab3.additional.Stats;
import lab3.fight_participant.DamageDealer;
import lab3.fight_participant.Defender;
import lab3.fight_participant.Droid;
import lab3.items.AttackItem;
import lab3.items.Consumable;
import lab3.items.DefenceItem;

import java.util.Random;

public class Factory {
    private final Integer team;
    private Integer level = 0;
    private final Random rand = new Random();

    public Factory(Integer team) {
        this.team = team;
    }

    public Droid createDroid(String name, DroidTypes type) {
        Droid toCreate;

        switch(type){
            case DAMAGE_DEALER:
                toCreate = createDamageDealer(name);
                break;
            case DEFENDER:
                toCreate = createDefender(name);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }

        toCreate.setTeam(this.team);
        toCreate.setActionPoints(Stats.MAX_ACTION_POINTS);
        return toCreate;
    }

    private DamageDealer createDamageDealer(String name) {
        Double health;
        Integer actionPoints;
        double strength;
        double defence;

        AttackItem attackItem;
        DefenceItem defenceItem;

        actionPoints = Stats.MAX_ACTION_POINTS;

        health = Stats.DAMAGE_DEALER_START_HP + ComplexStats.healthUpgradeValue(DroidTypes.DAMAGE_DEALER) * level;
        strength = Stats.DAMAGE_DEALER_START_STRENGTH + ComplexStats.strengthUpgradeValue(DroidTypes.DAMAGE_DEALER) * level;
        defence = Stats.DAMAGE_DEALER_START_DEFENCE + ComplexStats.defenceUpgradeValue(DroidTypes.DAMAGE_DEALER) * level;

        attackItem = createAttackItem();
        defenceItem = createDefenceItem();

        return new DamageDealer(name,health,actionPoints,health,strength,defence,attackItem,defenceItem,level);
    }

    private Defender createDefender(String name) {
        Double health;
        Integer actionPoints;
        double strength;
        double defence;

        AttackItem attackItem;
        DefenceItem defenceItem;

        actionPoints = Stats.MAX_ACTION_POINTS;

        health = Stats.DEFENDER_START_HP + ComplexStats.healthUpgradeValue(DroidTypes.DEFENDER) * level;
        strength = Stats.DEFENDER_START_STRENGTH + ComplexStats.strengthUpgradeValue(DroidTypes.DEFENDER) * level;
        defence = Stats.DEFENDER_START_DEFENCE + ComplexStats.defenceUpgradeValue(DroidTypes.DEFENDER) * level;

        attackItem = createAttackItem();
        defenceItem = createDefenceItem();

        return new Defender(name,health,actionPoints,health,strength,defence,attackItem,defenceItem,level);
    }

    public AttackItem createAttackItem() {
        int lasting;
        double attack;

        lasting = rand.nextInt(10) + 6;
        attack = Stats.ATTACK_ITEM_START_ATTACK + ComplexStats.itemAttackUpgradeValue() * level;
        return new AttackItem(attack,lasting);
    }

    public DefenceItem createDefenceItem() {
        int lasting;
        double defence;

        lasting = rand.nextInt(10) + 6;
        defence = Stats.DEFENCE_ITEM_START_DEFENCE + ComplexStats.itemDefenceUpgradeValue() * level;
        return new DefenceItem(defence,lasting);
    }

    public Consumable createConsumable() {
        double heal;
        heal = Stats.CONSUMABLE_START_HEAL + ComplexStats.consumableHealUpgradeVale() * level;
        return new Consumable(heal);
    }

    public void upgradeUtility() {
        level++;
    }

    public Integer getLevel() {
        return level;
    }
}
