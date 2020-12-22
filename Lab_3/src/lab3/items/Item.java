package lab3.items;

import lab3.additional.ItemTypes;

public interface Item {
    boolean isValid();
    Double use();
    void setPrice(Integer price);
    Integer getPrice();
    Double getPower();
    ItemTypes getType();
    void print();
}
