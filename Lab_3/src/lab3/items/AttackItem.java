package lab3.items;

import lab3.additional.ItemTypes;

public class AttackItem implements Item{
    private final ItemTypes type = ItemTypes.ATTACK_ITEM;
    private final Double attack;
    private Integer lasting;
    private Integer price = 0;

    public AttackItem(Double attack,Integer lasting){
        this.attack = attack;
        this.lasting = lasting;
    }

    @Override
    public boolean isValid(){
        return this.lasting != 0;
    }

    @Override
    public Double use(){
        if(this.lasting == 0){
            return 0.0;
        }
        else {
            this.lasting--;
            return this.attack;
        }
    }

    @Override
    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public Integer getPrice() {
        return this.price;
    }

    @Override
    public Double getPower() {
        return this.attack;
    }

    @Override
    public ItemTypes getType() {
        return type;
    }

    @Override
    public void print() {
        System.out.printf("\ntype: %s \nattack: %f \nlasting: %d\n",this.type,this.attack,this.lasting);
    }
}
