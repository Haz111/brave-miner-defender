package com.metaminers.game.objects;

/**
 * Created by Tymoteusz on 2015-07-24.
 */
public class Player extends GameObject {
    private String name;
    private int level;
    private IHeroClass heroClass;

    public Player(String name, IHeroClass heroClass) {
        this.name = name;
        this.heroClass = heroClass;
        this.level = 1;
    }

}
