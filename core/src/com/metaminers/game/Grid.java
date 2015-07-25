package com.metaminers.game;

/**
 * Created by Konrad on 2015-07-25.
 */
public class Grid {

    private int cellWidth, cellHeight, width, height;
    private boolean [][] grid; //false - wolny
    public Grid() {
        cellWidth = GameConstants.CELL_WIDTH;
        cellHeight = GameConstants.CELL_HEIGHT;
        width = GameConstants.WIDTH;
        height = GameConstants.HEIGHT;
        grid = new boolean[width / cellWidth][height / cellHeight];

    }

    public boolean isFree(int x, int y, int width, int height) {
        try {
            for (int i = x; i < x + width; i++) {
                for (int j = y; j < y + height; j++) {
                    if (grid[i][j])
                        return false;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }

        return true;
    }

    public void mark(int x, int y, int width, int height) {
        //TODO: Sprawdzic czy wszystkie parametry sa ok
        for (int i = x; i < x + width; i++) {
            for (int j = y; j < y + height; j++) {
                grid[i][j] = true;
            }
        }
    }

    public void unmark(int x, int y, int width, int height) {
        for (int i = x; i < x + width; i++) {
            for (int j = y; j < y + height; j++) {
                grid[i][j] = false;
            }
        }
    }


    //Przyciagamy do grida do lewego dolnego roku!
    public static Pair mapToGrid(float x, float y) {
        float cellWidth = GameConstants.CELL_WIDTH;
        float cellHeight = GameConstants.CELL_HEIGHT;
        return new Pair((int) (x / cellWidth) , (int) (y / cellHeight + cellHeight));
    }
}
