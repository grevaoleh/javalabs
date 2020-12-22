package lab3.fight_participant;

public interface Actor {
    void attack(Droid target);
    void takeDamage(Double damage);
    void defenceSelf();
}
