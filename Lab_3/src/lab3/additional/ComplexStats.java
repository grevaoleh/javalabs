package lab3.additional;

public class ComplexStats {

    public static Double healthUpgradeValue(DroidTypes droidType) {
        double upgradeValue;

        switch (droidType) {
            case DAMAGE_DEALER:
                upgradeValue = (Stats.DAMAGE_DEALER_MAX_HP - Stats.DAMAGE_DEALER_START_HP) / Stats.MAX_LEVEL;
                break;
            case DEFENDER:
                upgradeValue = (Stats.DEFENDER_MAX_HP - Stats.DEFENDER_START_HP) / Stats.MAX_LEVEL;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + droidType);
        }
        return upgradeValue;
    }

    public static Double strengthUpgradeValue(DroidTypes droidType) {
        double upgradeValue;

        switch (droidType) {
            case DAMAGE_DEALER:
                upgradeValue = (Stats.DAMAGE_DEALER_MAX_STRENGTH - Stats.DAMAGE_DEALER_START_STRENGTH) / Stats.MAX_LEVEL;
                break;
            case DEFENDER:
                upgradeValue = (Stats.DEFENDER_MAX_STRENGTH - Stats.DEFENDER_START_STRENGTH) / Stats.MAX_LEVEL;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + droidType);
        }
        return upgradeValue;
    }

    public static Double defenceUpgradeValue(DroidTypes droidType) {
        double upgradeValue;

        switch (droidType) {
            case DAMAGE_DEALER:
                upgradeValue = (Stats.DAMAGE_DEALER_MAX_DEFENCE - Stats.DAMAGE_DEALER_START_DEFENCE) / Stats.MAX_LEVEL;
                break;
            case DEFENDER:
                upgradeValue = (Stats.DEFENDER_MAX_DEFENCE - Stats.DEFENDER_START_DEFENCE) / Stats.MAX_LEVEL;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + droidType);
        }
        return upgradeValue;
    }

    public static Double itemAttackUpgradeValue() {
        return (Stats.ATTACK_ITEM_MAX_ATTACK - Stats.ATTACK_ITEM_START_ATTACK) / Stats.MAX_LEVEL;
    }

    public static Double itemDefenceUpgradeValue() {
        return (Stats.DEFENCE_ITEM_MAX_DEFENCE - Stats.DEFENCE_ITEM_START_DEFENCE) / Stats.MAX_LEVEL;
    }

    public static Double consumableHealUpgradeVale() {
        return (Stats.CONSUMABLE_MAX_HEAL - Stats.CONSUMABLE_START_HEAL) / Stats.MAX_LEVEL;
    }
}