package com.metaminers.game.objects;

/**
 * Created by Tymoteusz on 2015-07-25.
 */
public abstract class AbstractEnemy extends GameObject {
    int hp = 0;
    void attack(AbstractBuilding building) {}
    void takehp(int hp) {}
}
