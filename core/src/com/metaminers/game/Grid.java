package com.metaminers.game;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Konrad on 2015-07-25.
 */
public class Grid {

    private int cellWidth, cellHeight, width, height;
    private boolean [][] grid; //false - wolny
    private ArrayList<HandleInfo> handlers;
    public Grid() {
        cellWidth = GameConstants.CELL_WIDTH;
        cellHeight = GameConstants.CELL_HEIGHT;
        width = GameConstants.WIDTH;
        height = GameConstants.HEIGHT;
        grid = new boolean[width / cellWidth][height / cellHeight];
        handlers = new ArrayList<>();
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
        handlers.add(new HandleInfo(x, y, width, height));
    }

    public void unmark(int x, int y, int width, int height) {
        for (int i = x; i < x + width; i++) {
            for (int j = y; j < y + height; j++) {
                grid[i][j] = false;
            }
        }
        //Jeszcze handleInfo
        Iterator<HandleInfo> it = handlers.iterator();
        while (it.hasNext()) {
            HandleInfo i =it.next();
            if(i.x == x && i.y == y) {
                it.remove();
                break;
            }
        }
    }


    //Przyciagamy do grida do lewego dolnego roku!
    public static Pair mapToGrid(float x, float y) {
        float cellWidth = GameConstants.CELL_WIDTH;
        float cellHeight = GameConstants.CELL_HEIGHT;
        return new Pair((int) (x / cellWidth) , (int) (y / cellHeight + cellHeight));
    }

    public Pair getInfoHandler(int px, int py) {
        for(HandleInfo e : handlers) {
            if(e.x == px && e.y == py)
                return new Pair(e.x, e.y);
        }
        return null;
    }

    public void markPixel(int x, int y, int width, int height) {
        
    }
}
