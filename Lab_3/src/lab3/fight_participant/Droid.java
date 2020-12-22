package lab3.fight_participant;

import lab3.additional.DroidTypes;
import lab3.additional.Prices;
import lab3.items.Item;
import java.util.ArrayList;

public class Droid implements Actor{
    protected String name;
    protected DroidTypes type = null;

    protected Double maxHealth;

    protected Integer team;

    protected Double health;
    protected Double strength;
    protected Double defence;
    private boolean alive = true;

    protected Integer maxActionPoints;
    protected Integer actionPoints = 0;
    protected Integer skillPoints = 0;
    protected Double experience = 0.0;
    protected Integer level;

    protected Item attackItem;
    protected Item defenceItem = null;
    protected Item unActiveSlot;
    protected ArrayList<Item> consumables = new ArrayList<>();
    protected Integer price = 0;

    public Droid(String name,Double maxHealth,Integer maxActionPoints,
                 Double health, Double strength, Double defence,
                 Item attackItem, Item defenceItem, Integer level) {
        this.name = name;

        this.maxHealth = maxHealth;
        this.maxActionPoints = maxActionPoints;

        this.health = health;
        this.strength = strength;
        this.defence = defence;

        this.attackItem = attackItem;
        this.unActiveSlot = defenceItem;

        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxHealth(Double maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setHealth(Double value) {
        this.health = value;
    }

    public void setStrength(Double value) {
        this.strength = value;
    }

    public void setDefence(Double value) {
        this.defence = value;
    }

    public void setAlive() {
        this.alive = this.health > 0;
    }

    public void setActionPoints(Integer points) {
        this.actionPoints = points;
    }

    public void setSkillPoints(Integer skillPoints) {
        this.skillPoints = skillPoints;
    }

    public void setExperience(Double experience) {
        this.experience = experience;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setDefenceItem(Item item) {
        this.defenceItem = item;
    }

    public void setUnActiveSlot(Item unActiveSlot) {
        this.unActiveSlot = unActiveSlot;
    }

    public void setAttackItem(Item item) {
        this.attackItem = item;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setTeam(Integer team) {
        this.team = team;
    }


    public String getName() {
        return name;
    }

    public DroidTypes getType() {
        return this.type;
    }


   public Double getMaxHealth() {
        return this.maxHealth;
    }

    public Double getHealth() {
        return this.health;
    }

    public Integer getActionPoints() {
        return this.actionPoints;
    }

    public Double getExperience() {
        return experience;
    }

    public Integer getLevel() {
        return level;
    }

    public Item getAttackItem() {
        return this.attackItem;
    }

    public Item getDefenceItem() {
        return this.defenceItem;
    }

    public Double getStrength() {
        return this.strength;
    }

    public Double getDefence() {
        return this.defence;
    }

    public Integer getSkillPoints() {
        return this.skillPoints;
    }

    public ArrayList<Item> getConsumables() {
        return new ArrayList<>(consumables);
    }

    public Item getUnActiveSlot() {
        return unActiveSlot;
    }

    public boolean isAlive() {
        return this.alive;
    }

    public Integer getPrice() {
        return this.price;
    }

    public Integer getTeam() {
        return team;
    }

    @Override
    public void attack(Droid target) {
        if(this.attackItem == null) {
            target.takeDamage(this.strength);
        }
        else {
            target.takeDamage(this.strength * attackItem.use());
        }
    }

    @Override
    public void takeDamage(Double damage){
        if(this.defenceItem == null) {
            this.health -= damage * (1 / this.defence);
        }
        else {
            this.health -= (1 / defenceItem.use()) * (1 / this.defence) * damage;
            this.unActiveSlot = this.defenceItem;
            this.defenceItem = null;
        }
        this.setAlive();
    }

    @Override
    public void defenceSelf() {
        if(this.defenceItem == null) {
            this.defenceItem = this.unActiveSlot;
            this.unActiveSlot = null;
        }
    }

    public void useConsumable(int consumableNumber) {
        this.health += this.consumables.get(consumableNumber).use();
        this.consumables.remove(consumableNumber);

        if(this.health > this.maxHealth) {
            this.health = this.maxHealth;
        }
    }

    public void gainConsumable(Item consumable) {
        this.consumables.add(consumable);
    }

    public void gainExperience(Double experience) {
        this.experience += experience;
    }

    public void levelUp() {
        this.level++;
        this.skillPoints += Prices.LEVEL_UP_SKILL_POINTS;
    }

    public void print() {
        System.out.printf("\n Type: %s\n Name: %s\n Level: %d\n Max health: %f\n Health: %f\n Strength: %f\n Defence: %f\n Action Points: %d\n Experience: %f\n Skill points: %d\n",this.type,this.name,this.level,this.maxHealth,this.health,this.strength,this.defence,this.actionPoints,this.experience,this.skillPoints);
        this.attackItem.print();
        if(this.defenceItem != null) {
            this.defenceItem.print();
        } else if(this.unActiveSlot != null) {
            this.unActiveSlot.print();
        }
    }

    public void printConsumables() {
        for(int i = 0; i < this.consumables.size(); i++) {
            System.out.printf("\nConsumable #%d\n",i);
            this.consumables.get(i).print();
        }
    }
}