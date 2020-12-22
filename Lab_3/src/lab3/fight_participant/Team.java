package lab3.fight_participant;

import lab3.items.Item;

import java.util.ArrayList;

public class Team {
    private Integer memberCounter = 0;
    private Integer maxMembers;
    private Integer bank = 0;
    private ArrayList<Droid> members = new ArrayList<>();
    private ArrayList<Item> storage = new ArrayList<>();

    public Team(Integer maxMembers) {
        this.maxMembers = maxMembers;
    }

    public Integer getMemberCounter() {
        return this.memberCounter;
    }

    public Integer getMaxMembers() {
        return this.maxMembers;
    }

    public ArrayList<Item> getStorage() {
        return storage;
    }

    public void setMaxMembers(Integer maxMembers) {
        this.maxMembers = maxMembers;
    }

    public Integer getBank() {
        return this.bank;
    }

    public void setBank(Integer bank) {
        this.bank = bank;
    }

    public ArrayList<Droid> getMembers() {
        return this.members;
    }

    public void setMembers(ArrayList<Droid> members) {
        this.members = members;
    }

    public void addMember(Droid member) {
        this.memberCounter++;
        this.members.add(member);
    }

    public void removeMember(Integer index) {
        this.members.remove(index);
    }

    public void printDroids() {
        for(int i = 0; i < this.maxMembers; i++) {
            System.out.printf("\nDroid #%d\n",i);
            this.members.get(i).print();
        }
    }

    public void printStorage() {
        for(int i = 0; i < this.storage.size(); i++) {
            System.out.printf("\nItem #%d\n",i);
            this.storage.get(i).print();
        }
    }
}
