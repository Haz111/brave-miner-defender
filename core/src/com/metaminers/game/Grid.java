package com.metaminers.game;

/**
 * Created by Konrad on 2015-07-25.
 */
public class Grid {

    //Przyciagamy do grida do lewego dolnego roku!
    public static Pair mapToGrid(float x, float y) {
        float cellWidth = GameConstants.CELL_WIDTH;
        float cellHeight = GameConstants.CELL_HEIGHT;
        return new Pair((int) (x / cellWidth) , (int) (y / cellHeight + cellHeight));
    }
}
