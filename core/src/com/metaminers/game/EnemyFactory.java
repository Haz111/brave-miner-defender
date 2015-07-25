package com.metaminers.game;

import com.metaminers.game.objects.enemies.AbstractEnemy;
import com.metaminers.game.objects.enemies.RiverSnake;

import java.util.LinkedList;

/**
 * Created by Konrad on 2015-07-25.
 */
public class EnemyFactory {

    private static int[][] enemies;

    static {
        enemies = new int[][]{{5, 0, 0},
                {7, 0, 0},
                {7, 0, 0},
                {8, 0, 0}};

        //A fuj!
    }
    //TODO: Zmienic.
    public static LinkedList<AbstractEnemy> generateEnemies(int lvl) {
        LinkedList<AbstractEnemy> enemies = new LinkedList<>();
        for(int i = 0; i < GameConstants.ENEMIES_COUNT; i++) {
            for(int j = 0; j < EnemyFactory.enemies[lvl][i]; j++)
                enemies.add(new RiverSnake(0, 1));
        }
        return enemies; //TODO: SHUFFLE
    }
}
