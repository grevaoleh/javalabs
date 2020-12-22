package lab3.items;

import lab3.additional.ItemTypes;

public class DefenceItem implements Item{
    private final ItemTypes type = ItemTypes.DEFENCE_ITEM;
    private final Double defence;
    private Integer lasting;
    private Integer price = 0;

    public DefenceItem(Double attack,Integer lasting){
        this.defence = attack;
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
            return this.defence;
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
        return this.defence;
    }

    @Override
    public ItemTypes getType() {
        return type;
    }

    @Override
    public void print() {
        System.out.printf("\ntype: %s \ndefence: %f \nlasting: %d\n",this.type,this.defence,this.lasting);
    }
}
