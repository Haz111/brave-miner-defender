package com.metaminers.game.phases;

import com.metaminers.game.GameConstants;
import com.metaminers.game.Grid;
import com.metaminers.game.elements.Village;
import com.metaminers.game.objects.GameObject;
import com.metaminers.game.objects.buildings.*;
import com.metaminers.game.objects.enemies.AbstractEnemy;
import com.metaminers.game.objects.hero_classes.AbstractHeroClass;
import com.metaminers.game.objects.hero_classes.MageOfTheWaste;
import com.metaminers.game.objects.hero_classes.Marksman;
import com.metaminers.game.objects.hero_classes.ScorpionNinja;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Konrad on 2015-07-25.
 */
//tworzenie info jest w BeforeScreenInformation
public class PlayingInformation {
    //lista budynkow, info o graczu
    private LinkedList<AbstractEnemy> enemiesObjects;
    private int[] enemies; // zawiera constanty enemiesow ktore sa w biezacym
    private LinkedList<AbstractBuilding> buildings;
    public HashMap<AbstractBuilding, Integer> buildingsToBuild; //TODO: FIX ME
    private AbstractHeroClass hero;
    private Village village;
    private int lvl = 1;
    private Grid grid;
    private int money = 0;

    private boolean gameOver = false;
    //TODO: Dodac titaj klase na skille (LinkedList czy cos)

    public PlayingInformation() {
        enemies = new int[3];
        enemiesObjects = new LinkedList<>();
        buildings = new LinkedList<>();
        //buildings.add(new TowerBasic(100,100));
        buildingsToBuild = new HashMap<>();

        buildingsToBuild.put(new TowerBasic(10,10), 10);
        buildingsToBuild.put(new TowerTank(20,20), 10);
        buildingsToBuild.put(new TowerBunker(20,20), 10);
        buildingsToBuild.put(new TowerDouble(20,20), 10);
        buildingsToBuild.put(new TowerSmallLaser(20,20), 10);
        buildingsToBuild.put(new TowerQuadron(20,20), 10);
        grid = new Grid();
        lvl = 1;
        money = 1000;
    }

    public LinkedList<AbstractEnemy> getEnemiesObjects() {
        return this.enemiesObjects;
    }

    public void setEnemiesObjects(LinkedList<AbstractEnemy> enemiesObjects) {
        this.enemiesObjects = enemiesObjects;
    }

    public int[] getEnemies() {
        return enemies;
    }

    public void setEnemies(int[] enemies) {
        this.enemies = enemies;
    }

    public void setRandomEnemiesForNextRound(){
        Random rand = new Random();
        for (int i = 0; i < enemies.length; i++){
            enemies[i] = rand.nextInt(3);
        }
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

    public void setHero (int heroNumber){ //(AbstractHeroClass hero) {
        switch (heroNumber){
            case 0:
                this.hero = new Marksman();
                break;
            case 1:
                this.hero = new MageOfTheWaste();
                break;
            case 2:
                this.hero = new ScorpionNinja();
                break;
            default:
                this.hero = new Marksman();
                break;
        }
    }

    public void setVillage (int villageHouseNumber, int villageBackgroundNumber) {
        this.village = new Village(GameConstants.VILLAGES_HOUSENAMES[villageHouseNumber], GameConstants.VILLAGES_BACKGROUNDNAMES[villageBackgroundNumber]);
    }

    public Village getVillage (){
        return(village);
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

    public void removeBuilding(GameObject pickedBuilding) {
        buildings.remove(pickedBuilding);
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid g) {
        grid = g;
    }

    public void reduceMoney(int cash) {
        //
        money -= cash;
    }

    public void addBuyedBuilding(AbstractBuilding chosenBuilding) {
        //TODO: To moze nie dzialac, jak zle to zrobic mape ze stringami jako klucze i
        buildingsToBuild.replace(chosenBuilding, buildingsToBuild.get(chosenBuilding), buildingsToBuild.get(chosenBuilding) + 1);
    }
    
    public boolean getGameOver(){
        return gameOver;
    }

    public void setGameOver(boolean gameState){
        gameOver = gameState;
    }
}
