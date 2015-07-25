package com.metaminers.game.objects.enemies;

import com.metaminers.game.GameConstants;
import com.metaminers.game.Pair;
import com.metaminers.game.objects.GameObject;
import com.metaminers.game.objects.buildings.AbstractBuilding;

import java.util.Random;

/**
 * Created by Tymoteusz on 2015-07-25.
 */
public abstract class AbstractEnemy extends GameObject {
    int hp = 0;
    int damage = 0;
    public void attack(AbstractBuilding building) { building.takeHp(damage); }
    public void takeHp(int hp) { this.hp -= hp; }

//    it returns array - first element: width, second: heigh, third: direction
    private int[] randomStartingPlace(){
        Random rand = new Random();
        int width;
        int height;
        int direction;
//        losuje sciane - 0 - polnoc, dalej zgodnie ze wskazowkami zegara
        switch(rand.nextInt(4)){
        case (0):
            width = rand.nextInt(GameConstants.WIDTH);
            height = GameConstants.HEIGHT;
            if (width < (GameConstants.WIDTH/3)){
                direction = 7;
            } else if (width < (2*GameConstants.WIDTH/3)){
                direction = 0;
            } else {
                direction = 1;
            }
            break;
        case (1):
            width = GameConstants.WIDTH;
            height = rand.nextInt(GameConstants.HEIGHT);
            if (width > (2*GameConstants.HEIGHT/3)){
                direction = 1;
            } else if (width > (GameConstants.HEIGHT/3)){
                direction = 2;
            } else {
                direction = 3;
            }
            break;
        case (2):
            width = rand.nextInt(GameConstants.WIDTH);
            height = 0;
            if (width < (GameConstants.WIDTH/3)){
                direction = 5;
            } else if (width < (2*GameConstants.WIDTH/3)){
                direction = 4;
            } else {
                direction = 3;
            }
            break;
        case (3):
            width = 0;
            height = rand.nextInt(GameConstants.HEIGHT);
            if (width > (2*GameConstants.HEIGHT/3)){
                direction = 7;
            } else if (width > (GameConstants.HEIGHT/3)){
                direction = 6;
            } else {
                direction = 5;
            }
            break;
        default:
            width = 0;
            height = 0;
            direction = 5;
        }

        int[] toReturn = new int[3];
        toReturn[0] = width;
        toReturn[1] = height;
        toReturn[2] = direction;
        return (toReturn);
    }
}
