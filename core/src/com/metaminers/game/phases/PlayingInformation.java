package com.metaminers.game.phases;

import com.metaminers.game.objects.AbstractBuilding;
import com.metaminers.game.objects.AbstractEnemy;
import com.metaminers.game.objects.AbstractHeroClass;

import java.util.LinkedList;

/**
 * Created by Konrad on 2015-07-25.
 */
public class PlayingInformation {

    //lista budynkow, info o graczu
    private LinkedList<AbstractEnemy> enemies;
    private LinkedList<AbstractBuilding> buildings;

    private AbstractHeroClass hero;
    //TODO: Dodac titaj klase na skille

    public PlayingInformation() {
        enemies = new LinkedList<AbstractEnemy>();
        buildings = new LinkedList<AbstractBuilding>();
    }

    public LinkedList<AbstractEnemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(LinkedList<AbstractEnemy> enemies) {
        this.enemies = enemies;
    }

    public LinkedList<AbstractBuilding> getBuildings() {
        return buildings;
    }

    public void setBuildings(LinkedList<AbstractBuilding> buildings) {
        this.buildings = buildings;
    }

    public AbstractHeroClass getHero() {
        return hero;
    }

    public void setHero(AbstractHeroClass hero) {
        this.hero = hero;
    }

    public void addBuilding(AbstractBuilding building) {
        buildings.add(building);
    }


}
