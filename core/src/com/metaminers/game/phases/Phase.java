package com.metaminers.game.phases;

import com.badlogic.gdx.Screen;

/**
 * Created by Konrad on 2015-07-24.
 */
public abstract class Phase implements Screen{
    protected PlayingInformation results;
    private boolean ended = false;

    private void markEnded() {
        ended = true;
    }

    public boolean isEnded() {
        return ended;
    }

    public PlayingInformation getResults() {
        return results;
    }

    public abstract void start(PlayingInformation info);
}
