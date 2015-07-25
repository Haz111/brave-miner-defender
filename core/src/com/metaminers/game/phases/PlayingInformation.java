package com.metaminers.game.phases;


import com.metaminers.game.elements.Village;
import com.metaminers.game.objects.buildings.AbstractBuilding;
import com.metaminers.game.objects.buildings.TowerBasic;
import com.metaminers.game.objects.enemies.AbstractEnemy;
import com.metaminers.game.objects.hero_classes.AbstractHeroClass;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Konrad on 2015-07-25.
 */
public class PlayingInformation {

    //lista budynkow, info o graczu
    private LinkedList<AbstractEnemy> enemies;
    private LinkedList<AbstractBuilding> buildings;
    public HashMap<AbstractBuilding, Integer> buildingsToBuild; //TODO: FIX ME
    private AbstractHeroClass hero;
    private Village village;
    private int lvl = 0;
    //TODO: Dodac titaj klase na skille (LinkedList czy cos)

    public PlayingInformation() {
        enemies = new LinkedList<>();
        buildings = new LinkedList<>();
        buildings.add(new TowerBasic(100f,100f));
        buildingsToBuild = new HashMap<>();
        buildingsToBuild.put(new TowerBasic(150f,150f), 2);
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


    public int getLvl() {
        return lvl;
    }

    public void nextLvl() {
        lvl++;
    }
}
