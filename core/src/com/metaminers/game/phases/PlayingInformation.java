package com.metaminers.game.phases;

import com.metaminers.game.objects.IBuilding;
import com.metaminers.game.objects.IEnemy;
import com.metaminers.game.objects.IHeroClass;

import java.util.LinkedList;

/**
 * Created by Konrad on 2015-07-25.
 */
public class PlayingInformation {

    //lista budynkow, info o graczu
    private LinkedList<IEnemy> enemies;
    private LinkedList<IBuilding> buildings;
    private IHeroClass hero;
    //TODO: Dodac titaj klase na skille

    public PlayingInformation() {
        enemies = new LinkedList<>();
        buildings = new LinkedList<>();
    }

    public LinkedList<IEnemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(LinkedList<IEnemy> enemies) {
        this.enemies = enemies;
    }

    public LinkedList<IBuilding> getBuildings() {
        return buildings;
    }

    public void setBuildings(LinkedList<IBuilding> buildings) {
        this.buildings = buildings;
    }

    public IHeroClass getHero() {
        return hero;
    }

    public void setHero(IHeroClass hero) {
        this.hero = hero;
    }

}
