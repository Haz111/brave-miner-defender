package com.metaminers.game.phases;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.metaminers.game.FieldStatus;
import com.metaminers.game.GameConstants;
import com.metaminers.game.Grid;
import com.metaminers.game.elements.Village;
import com.metaminers.game.objects.buildings.AbstractBuilding;
import com.metaminers.game.objects.buildings.TowerBasic;
import com.metaminers.game.objects.buildings.TowerTank;

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
//    private boolean isPickingBuildingFromMap = false; //Co ja pisze...
    private AbstractBuilding pickedBuilding;
    private Village village;
    long start, stop;

    TextButton saveButton;
    private Stage s;


    @Override
    public void start(PlayingInformation info) {
        super.start(info);
        info.setRandomEnemiesForNextRound();
        saveButton = super.makeTextButton("Save", Gdx.graphics.getWidth()/2 - 50, 50, 100, 40);
        //batch.begin();
        //saveButton.draw(batch, 1.0f);
        //batch.end();
        this.village = info.getVillage();
        start = System.currentTimeMillis();

        s = new Stage();
        Gdx.input.setInputProcessor(s);
        s.addActor(saveButton);
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
        drawGUI();
        //drawEnemiesOnPane();
        setUpBuildings();
        drawBuildings();
        s.draw();
        batch.end();
        handleInput();
        stop = System.currentTimeMillis();
        if(stop - start > GameConstants.BUILDING_TIME) {
            BuildingPhase.this.markEnded(true);
//            System.out.println("Buidling Phase Ends");
        }
    }



    @Override
    protected void handleMovementMap(float x, float y) {
        System.out.println("BuildingPhase.handleMovementMap - poczatek");
        //Jak klikniemy na pole puste siatki - jest ok
        //Jak nie - no to sorry
        //TODO: Dorobic do budynkow getGridWidth, getGridHeight - abysmy mogli spokojnie przerabiac to na siatke
        if(pickedBuilding == null)
            return;
//        System.out.println("BuildingPhase.handleMovementMap - po pickedBuilding==null");

//        AbstractBuilding buildingOnMap = null;

//        //TODO: Zrobic to lepiej!
//        //Algos: jedziemy teraz po liscie z budynkow i sprawdzamy czy tam mozemy postawic budynek
//        for(AbstractBuilding e : info.getBuildings()) {
//            if(e != null && e.getPosX() == x && e.getPosY() == y) {
//                buildingOnMap = e;
//                break;
//            }
//        }

//        System.out.println("BuildingPhase.handleMovementMap - przed logowanie gx, gy , gwidth, ghight");
        if(isPickingBuildingFromInventory) {
            //Ok, jednak mozna, koles kliknal to niech ma
            pickedBuilding.setPosX((int) x);
            pickedBuilding.setPosY((int) (728 - y));
            Grid grid = info.getGrid();

            int gX = (int)(x / GameConstants.CELL_WIDTH);
//            System.out.println("gX = " + gX);
            int gY = (int)(y / GameConstants.CELL_HEIGHT);
//            System.out.println("gY = " + gY);
            int gWidth = (int) (pickedBuilding.getWidth()/ GameConstants.CELL_WIDTH);
//            System.out.println("gWidth = " + gWidth);
            int gHeight = (int) (pickedBuilding.getHeight()/GameConstants.CELL_HEIGHT);
//            System.out.println("gHeight = " + gHeight);
            if(!grid.isFreeForBuild(gX, gY, gWidth, gHeight)){
                return;
            };
            grid.markPixel((int) x, (int) (y), (int) pickedBuilding.getWidth(), (int) pickedBuilding.getHeight(), FieldStatus.TOWER);
            info.setGrid(grid);
            info.addBuilding(pickedBuilding);//A FUJ!
            System.out.println("Wieza postawiona");
            pickedBuilding = null; //Chyba ok?
            isPickingBuildingFromInventory = false; // isPickingBuildingFromMap = false;
        }
//        else if(buildingOnMap != null) {
//            pickedBuilding = buildingOnMap;
//            info.getBuildings().remove(buildingOnMap); //ok?
//            isPickingBuildingFromMap = true;
//        }

    }

    @Override
    protected void handleMovementInventory(float x, float y) {
        System.out.println("BuildingPhase.handleMovementInventory - poczatek");
        //TODO: Obsluga pieniedzy
        //Cale zyccie da sie rozwiazac na ifach

        //Wzielismy budynek z mapy (albo sie rozmyslilismy), wiec trzeba go oddac, przykro mi
//        if(isPickingBuildingFromMap || isPickingBuildingFromInventory) {
        if(isPickingBuildingFromInventory){
            System.out.println("BuildingPhase.handleMovementInventory - oddaje budynek");
            if(this.info.buildingsToBuild.get(pickedBuilding) != null)
                this.info.buildingsToBuild.put(pickedBuilding, this.info.buildingsToBuild.get(pickedBuilding) + 1);
            pickedBuilding = null;
            isPickingBuildingFromInventory = false;
            return;
        }
//        System.out.println("BuildingPhase.handleMovementInventory - sprawdza czy moze wziac budynek");

//        Pobieram liste budynkow i tworze z nich tablice
        List<AbstractBuilding> lg = new LinkedList<>();
        for(AbstractBuilding o : info.buildingsToBuild.keySet()) {
            lg.add(o);
        }
        AbstractBuilding [] o = new AbstractBuilding[lg.size()];
        for(int i=0; i<lg.size(); i++)
            o[i] = lg.get(i);

        //No, mozna go brac!

        for(int i = 0; i < o.length; i++) {
//            System.out.println("BuildingPhase.handleMovementInventory");
            Rectangle r = o[i].getSprite().getBoundingRectangle();
//            System.out.println("x ="+r.x+" y= "+r.y+" width: "+r.width+" height: "+ r.height);
//            System.out.println("x: "+x+"768-x =" +(768-y));
            if(o[i].getSprite() != null && o[i].getSprite().getBoundingRectangle().contains(x, 728 - y)) {
                if(info.buildingsToBuild.get(o[i]) < 1){
//                    System.out.println("BuildingPhase.handleMovementInventory -> budynek niedotepny");
                    continue;
                }
//                System.out.println("BuildingPhase.handleMovementInventory -> budynek dostepny " + o[i]);
                info.buildingsToBuild.replace(o[i], info.buildingsToBuild.get(o[i]), info.buildingsToBuild.get(o[i]) - 1); //TODO: Co jak <= 0?
                System.out.println(o[i].getPrice());
                if(o[i].getPrice() == 10)
                    pickedBuilding = new TowerBasic((int)x, (int)y);
                else if(o[i].getPrice() == 20)
                    pickedBuilding = new TowerTank((int)x, (int)y);
//                System.out.println(pickedBuilding.getPrice());
                isPickingBuildingFromInventory = true;
                System.out.println("Wieza zaznaczona!");
                break;
            }
        }
    }


    private void setUpBuildings() {
        //// rysowanie budynkow do budowy:
        for(AbstractBuilding b : info.buildingsToBuild.keySet()) {
            if(b.getPrice() == 10)
                b.drawInGui(0, 610, 3);
            else if(b.getPrice() == 20)
                b.drawInGui(8, 500, 1.5f);
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

        s.dispose();
    }
}
