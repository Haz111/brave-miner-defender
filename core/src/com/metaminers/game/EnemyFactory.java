package com.metaminers.game;

import com.metaminers.game.objects.enemies.AbstractEnemy;
import com.metaminers.game.objects.enemies.RiverSnake;
import com.metaminers.game.objects.enemies.Scavenger;
import com.metaminers.game.objects.enemies.Zombie;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Konrad on 2015-07-25.
 */
public class EnemyFactory {

    private static int[][] enemies;

//    static {
//        enemies = new int[][]{{5, 0, 0},
//                {7, 0, 0},
//                {7, 0, 0},
//                {8, 0, 0}};
//
//        //A fuj!
//    }
    //TODO: Zmienic.
    public static LinkedList<AbstractEnemy> generateEnemies(int lvl) {
        Random rand = new Random();
        LinkedList<AbstractEnemy> enemies = new LinkedList<>();
//        for(int i = 0; i < GameConstants.ENEMIES_COUNT; i++) {
//            for(int j = 0; j < EnemyFactory.enemies[0][0]; j++)

        for(int i=0; i < 4*lvl+2; i++) {
            switch (rand.nextInt(3)) {
                case (0):
                    enemies.add(new RiverSnake());
                    break;
                case (1):
                    enemies.add(new Zombie());
                    break;
                case (2):
                    enemies.add(new Scavenger());
                    break;
                default:
                    enemies.add(new Scavenger());
                    break;
            }
        }
//                }
//        }
        return enemies; //TODO: SHUFFLE
    }
}
