package com.metaminers.game;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Konrad on 2015-07-25.
 */
public class Grid {

    private int cellWidth, cellHeight, width, height;
    private FieldStatus [][] grid; //false - wolny
    private ArrayList<HandleInfo> handlers;
    public Grid() {
        cellWidth = GameConstants.CELL_WIDTH;
        cellHeight = GameConstants.CELL_HEIGHT;
        width = GameConstants.WIDTH;
        height = GameConstants.HEIGHT;
        grid = new FieldStatus[width / cellWidth][height / cellHeight];
        handlers = new ArrayList<>();
        initGrid();
    }

    private void initGrid() {
        for(int i = 0; i < GameConstants.GRID_WIDTH; i++)
            for(int j = 0; j < GameConstants.GRID_HEIGHT; j++)
                grid[i][j] = FieldStatus.FREE_OUT;

        for(int i = GameConstants.GRID_WIDTH/2 - GameConstants.BASE_RADIUS; i < GameConstants.GRID_WIDTH/2 + GameConstants.BASE_RADIUS; i++) {
            for (int j = GameConstants.GRID_HEIGHT/2 - GameConstants.BASE_RADIUS; j < GameConstants.GRID_HEIGHT/2 + GameConstants.BASE_RADIUS; j++) {
                grid[i][j] = FieldStatus.FREE_IN;
            }
        }
    }

    public boolean isFreeForBuild(int x, int y, int width, int height) {
        try {
            for (int i = x; i < x + width; i++) {
                for (int j = y; j < y + height; j++) {
                    if (grid[i][j] == FieldStatus.TOWER || grid[i][j] == FieldStatus.HOUSE ||
                            grid[i][j] == FieldStatus.FREE_OUT)
                        return false;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {

            e.printStackTrace();
            return false;
        }

        return true;
    }
    public boolean isFreeForMove(int x, int y) {
//        for(int i=0; i<grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++)
//                System.out.print(grid[i][j]);
//            System.out.println();
//        }
        try {
            if (grid[x][y] == FieldStatus.FREE_OUT || grid[x][y] == FieldStatus.FREE_IN)
                return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public void mark(int x, int y, int width, int height, FieldStatus fieldStatus) {
        //TODO: Sprawdzic czy wszystkie parametry sa ok
        for (int i = x; i < x + width; i++) {
            for (int j = y; j < y + height; j++) {
                grid[i][j] = fieldStatus;
            }
        }
        handlers.add(new HandleInfo(x, y, width, height));
    }

    public void unmark(int x, int y, int width, int height, FieldStatus fieldStatus) {
        for (int i = x; i < x + width; i++) {
            for (int j = y; j < y + height; j++) {
                grid[i][j] = fieldStatus;
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

    public void markPixel(int x, int y, int width, int height, FieldStatus fs) {
        mark(x / GameConstants.CELL_WIDTH, y / GameConstants.CELL_HEIGHT, width / GameConstants.CELL_WIDTH,
                height / GameConstants.CELL_HEIGHT, fs);
    }
}
