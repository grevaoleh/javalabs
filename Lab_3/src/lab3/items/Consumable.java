package lab3.items;

import lab3.additional.ItemTypes;

public class Consumable implements Item{
    private final ItemTypes type = ItemTypes.CONSUMABLE;
    private Integer lasting = 1;
    private final Double healing;
    private Integer price = 0;

    public Consumable(Double effect){
        this.healing = effect;
    }

    @Override
    public boolean isValid(){
        return this.lasting != 0;
    }

    @Override
    public Double use() {
        if(this.lasting == 0) {
            return 0.0;
        }
        else {
            this.lasting--;
            return this.healing;
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
        return this.healing;
    }

    @Override
    public ItemTypes getType() {
        return type;
    }

    @Override
    public void print() {
        System.out.printf("\ntype: %s \nhealing: %f \nlasting: %d\n",this.type,this.healing,this.lasting);
    }
}
