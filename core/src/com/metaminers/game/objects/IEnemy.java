package com.metaminers.game.objects;

/**
 * Created by Tymoteusz on 2015-07-25.
 */
public interface IEnemy {
    int hp = 0;
    void attack(IBuilding building);
    void takehp(int hp);
}
