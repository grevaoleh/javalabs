package lab3.player;

import lab3.additional.Stats;
import lab3.fight_participant.Team;
import lab3.utilities.Factory;
import lab3.utilities.ImprovementCenter;
import lab3.utilities.Shop;

public class Player {
    private final Integer teamNumber;
    private final Team team;
    private final Factory supplyingFactory;
    private final Shop shop;
    private final ImprovementCenter improvementCenter;

    public Player(Integer teamNumber, Integer teamSize) {
        this.teamNumber = teamNumber;
        this.supplyingFactory = new Factory(teamNumber);
        this.shop = new Shop(Stats.SHOP_SIZE,this.supplyingFactory);
        this.improvementCenter = new ImprovementCenter();
        this.team = new Team(teamSize);
    }

    public Integer getTeamNumber() {
        return teamNumber;
    }

    public Team getTeam() {
        return team;
    }

    public Factory getSupplyingFactory() {
        return supplyingFactory;
    }

    public Shop getShop() {
        return shop;
    }

    public ImprovementCenter getImprovementCenter() {
        return improvementCenter;
    }
}
