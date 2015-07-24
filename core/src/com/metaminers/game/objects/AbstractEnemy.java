package com.metaminers.game.objects;

/**
 * Created by Tymoteusz on 2015-07-25.
 */
public abstract class AbstractEnemy extends GameObject {
    int hp = 0;
    int damage = 0;
    void attack(AbstractBuilding building) { building.takeHp(damage); }
    void takehp(int hp) {}
}
