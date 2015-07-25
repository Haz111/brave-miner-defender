package com.metaminers.game.objects.enemies;

import com.metaminers.game.objects.GameObject;
import com.metaminers.game.objects.buildings.AbstractBuilding;

/**
 * Created by Tymoteusz on 2015-07-25.
 */
public abstract class AbstractEnemy extends GameObject {
    int hp = 0;
    int damage = 0;
    public void attack(AbstractBuilding building) { building.takeHp(damage); }
    public void takeHp(int hp) { this.hp -= hp; }
}
