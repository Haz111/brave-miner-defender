package com.metaminers.game.phases;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.metaminers.game.FieldStatus;
import com.metaminers.game.GameConstants;
import com.metaminers.game.Grid;
import com.metaminers.game.elements.Village;
import com.metaminers.game.objects.buildings.AbstractBuilding;
import com.metaminers.game.objects.buildings.TowerBasic;
import com.metaminers.game.objects.buildings.TowerTank;
import com.metaminers.game.objects.enemies.RiverSnake;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Konrad on 2015-07-24.
 */
public class BuildingPhase extends Phase {
    //TODO: Esc jako wyjscie z ekranu
    //TODO: ZROBIC JAKIEGOS RENDERERA KTORY BY NP. RYSOWAL GUI, OBECNA WERSJA JEST MANROTRAWSTWEM PAMIECI!
    private final String warnString = "You cannot place building here";
    private Texture pane, background;
    private boolean isPickingBuildingFromInventory = false;
    private boolean isPickingBuildingFromMap = false; //Co ja pisze...
    private AbstractBuilding pickedBuilding;
    private Village village;
    long start, stop;

    //!!!!
    RiverSnake p = new RiverSnake();
    RiverSnake p2 = new RiverSnake();
    RiverSnake p3 = new RiverSnake();
    RiverSnake p4 = new RiverSnake();
    RiverSnake p5 = new RiverSnake();
    //!!!!

    TextButton saveButton;

    @Override
    public void start(PlayingInformation info) {
        super.start(info);
        info.setRandomEnemiesForNextRound();
        saveButton = super.makeTextButton("Save", Gdx.graphics.getWidth()/2 - 50, 50, 100, 40);
        batch.begin();
        saveButton.draw(batch, 1.0f);
        batch.end();
        this.village = info.getVillage();
        start = System.currentTimeMillis();
    }

    @Override
    public void show() {
        /*
        1. Draw interface
        2. Draw buildings, its status and others
        3. Allow player to build sth
        4. Just save and mark ended
         */
        //TODO: Jakis renderer do GUI, cobysmy nie kopiowali kodu
        //TODO: Implementacja siatki!
        saveButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                BuildingPhase.this.markEnded(true);
            }
        });
    }


    @Override
    public void render(float delta) {

//        TODO: w renderze - najpierw odswiezenie, potem render

        village.drawAll();
        batch.begin();
        p.draw(batch, delta);
        p2.draw(batch, delta);
        p3.draw(batch, delta);
        p4.draw(batch, delta);
        p5.draw(batch, delta);
        drawGUI();
        drawEnemiesOnPane();
        setUpBuildings();
        drawBuildings();
        batch.end();
        handleInput();
        stop = System.currentTimeMillis();
        if(stop - start > 5000) {
            BuildingPhase.this.markEnded(true);
            System.out.println("Next Phase Starts");
        }

//        if(pickedBuilding != null) {
//            //pickedBuilding.getSprite().setPosition(Gdx.input.getX(), Gdx.input.getY()); //TODO: SPRAWDZIC CZY TO JEST OK!
//            int x = (int)(Gdx.input.getX() - pickedBuilding.getSprite().getWidth()/2);
//            int y = (int)(Gdx.graphics.getHeight() - Gdx.input.getY() - pickedBuilding.getSprite().getHeight()/2);
//            Pair p = Grid.mapToGrid(x, y);
//            pickedBuilding.getSprite().setPosition(p.x, p.y); //TODO: SPRAWDZIC CZY TO JEST OK!
//            //Wyjasnienie do powyzszego: http://www.gamefromscratch.com/post/2013/10/15/LibGDX-Tutorial-4-Handling-the-mouse-and-keyboard.aspx
//            pickedBuilding.getSprite().draw(batch);
//        }
    }



    @Override
    protected void handleMovementMap(float x, float y) {
        //Jak klikniemy na pole puste siatki - jest ok
        //Jak nie - no to sorry
        //TODO: Dorobic do budynkow getGridWidth, getGridHeight - abysmy mogli spokojnie przerabiac to na siatke
        if(pickedBuilding == null)
            return;

        AbstractBuilding buildingOnMap = null;

        //TODO: Zrobic to lepiej!
        //Algos: jedziemy teraz po liscie z budynkow i sprawdzamy czy tam mozemy postawic budynek
        for(AbstractBuilding e : info.getBuildings()) {
            if(e != null && e.getPosX() == x && e.getPosY() == y) {
                buildingOnMap = e;
                break;
            }
        }


        if(isPickingBuildingFromInventory) {
            //Ok, jednak mozna, koles kliknal to niech ma
            pickedBuilding.setPosX((int) x);
            pickedBuilding.setPosY((int) (728 - y));
            Grid grid = info.getGrid();
            if(!grid.isFreeForBuild((int)x / GameConstants.CELL_WIDTH, (int)y / GameConstants.CELL_HEIGHT,
                    (int) pickedBuilding.getWidth()/ GameConstants.CELL_WIDTH,
                    (int) pickedBuilding.getHeight()/GameConstants.CELL_HEIGHT))
                return;
            grid.markPixel((int) x, (int) (y), (int) pickedBuilding.getWidth(), (int) pickedBuilding.getHeight(), FieldStatus.TOWER);
            info.setGrid(grid);
            info.addBuilding(pickedBuilding);//A FUJ!
            pickedBuilding = null; //Chyba ok?
            isPickingBuildingFromInventory = isPickingBuildingFromMap = false;
        }
        else if(buildingOnMap != null) {
            pickedBuilding = buildingOnMap;
            info.getBuildings().remove(buildingOnMap); //ok?
            isPickingBuildingFromMap = true;
        }

    }

    @Override
    protected void handleMovementInventory(float x, float y) {
        //TODO: Obsluga pieniedzy
        //Cale zyccie da sie rozwiazac na ifach

        //Wzielismy budynek z mapy (albo sie rozmyslilismy), wiec trzeba go oddac, przykro mi
        if(isPickingBuildingFromMap || isPickingBuildingFromInventory) {
            if(this.info.buildingsToBuild.get(pickedBuilding) != null)
                this.info.buildingsToBuild.put(pickedBuilding, this.info.buildingsToBuild.get(pickedBuilding) + 1);
            pickedBuilding = null;
            return;
        }

        List<AbstractBuilding> lg = new LinkedList<>();
        for(AbstractBuilding o : info.buildingsToBuild.keySet()) {
            lg.add(o);
        }
        AbstractBuilding [] o = new AbstractBuilding[lg.size()];
        for(int i=0; i<lg.size(); i++)
            o[i] = lg.get(i);

        //No, mozna go brac!

        for(int i = 0; i < o.length; i++) {
            if(o[i].getSprite() != null && o[i].getSprite().getBoundingRectangle().contains(x, 728-y)) {
                if(info.buildingsToBuild.get(o[i]) < 1)
                    continue;
                info.buildingsToBuild.replace(o[i], info.buildingsToBuild.get(o[i]), info.buildingsToBuild.get(o[i]) - 1); //TODO: Co jak <= 0?
                if(o[i].getPrice() == 10)
                    pickedBuilding = new TowerBasic((int)x, (int)y);
                else if(o[i].getPrice() == 20)
                    pickedBuilding = new TowerTank((int)x, (int)y);
                System.out.println(pickedBuilding.getPrice());
                isPickingBuildingFromInventory = true;
                break;
            }
        }
    }


    private void setUpBuildings() {
        //// rysowanie budynkow do budowy:
        for(AbstractBuilding b : info.buildingsToBuild.keySet()) {
            if(b.getPrice() == 10)
                b.drawInGui(0, 610, 6);
            else if(b.getPrice() == 20)
                b.drawInGui(8, 500, 3);
        }


        /*
        float xpos = 0; //xpos - X position to draw
        float ypos = GameConstants.INTERFACE_PANEL_WIDTH;
        GameObject e;
        Sprite s;
        //TODO: NullPointerException
        /*
        GameObject [] o = (GameObject[])info.buildingsToBuild.keySet().toArray();
        for (int i = 0; i < o.length; i++) {
            e = o[i];
            s = new Sprite(e.getTexture());
            s.setX(xpos);
            s.setY(ypos - i * e.getHeight());
            s.draw(batch);
        }
        */
    }

    private void drawBuildings() {
        for(AbstractBuilding ab : info.getBuildings()) {
            ab.drawInGui(ab.getPosX(), ab.getPosY(), 3);
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        pane.dispose();
        background.dispose();
    }
}
