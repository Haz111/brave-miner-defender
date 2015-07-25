package com.metaminers.game.phases;

import com.metaminers.game.elements.Village;
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
    private int difficulty;
    private AbstractHeroClass hero;
    private Village village;
    //TODO: Dodac titaj klase na skille

    public PlayingInformation() {
        enemies = new LinkedList<>();
        buildings = new LinkedList<>();
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

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void setVillage(Village v) {
        this.village = v;
    }

    public Village getVillage() {
        return this.village;
    }

    public int getDifficulty() {
        return this.difficulty;
    }
}
