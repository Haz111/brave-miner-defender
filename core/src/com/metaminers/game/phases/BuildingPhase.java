package com.metaminers.game.phases;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.metaminers.game.GameConstants;
import com.metaminers.game.Grid;
import com.metaminers.game.Pair;
import com.metaminers.game.elements.Village;
import com.metaminers.game.objects.GameObject;
import com.metaminers.game.objects.buildings.AbstractBuilding;

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
<<<<<<< HEAD
    private Grid grid;
=======

    //!!!!
    RiverSnake p = new RiverSnake(400,600);
    //!!!!
>>>>>>> 1fd737b99942fff3a4df057bac80a07b061b6af4

    TextButton saveButton;

    @Override
    public void start(PlayingInformation info) {
        super.start(info);
        System.out.println("start building phase");
        grid = info.getGrid();
        info.setRandomEnemiesForNextRound();
        saveButton = super.makeTextButton("Save", Gdx.graphics.getWidth()/2 - 50, 50, 100, 40);
        this.village = info.getVillage();
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
                System.out.println("SaveButton clicked");
                BuildingPhase.this.markEnded(true);
            }
        });
    }


    @Override
    public void render(float delta) {

//        TODO: w renderze - najpierw odswiezenie, potem render
        batch.begin();
        village.drawAll();
        drawGUI();
        drawEnemiesOnPane();
        setUpBuildings();
        batch.end();
        handleInput();
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
        Pair p = Grid.mapToGrid(x, y);
        int px = p.x;
        int py = p.y;
        //TODO: Jak nie zadziaa ponizsza wersja to to trzeba dodac getGridWIdth i getGridHeight
        if(pickedBuilding != null) {
            //Czyli ze cos mamy
            if(grid.isFree(px, py, pickedBuilding.getTexture().getWidth()/ GameConstants.CELL_WIDTH, pickedBuilding.getTexture().getHeight()/ GameConstants.CELL_HEIGHT)) {
                grid.mark(px, py, pickedBuilding.getTexture().getWidth() / GameConstants.CELL_WIDTH, pickedBuilding.getTexture().getHeight() / GameConstants.CELL_HEIGHT);
                pickedBuilding.setPosX(px);
                pickedBuilding.setPosY(py);
                info.addBuilding(pickedBuilding);
                pickedBuilding = null;
                isPickingBuildingFromInventory = isPickingBuildingFromMap = false;
            }
            //Nie mamy nic, nie mamy nic, uohoohoouoooooouooooouoooooooooo...

        }
        else {
            //Nie mamy wybranego budynku, wiec albo go stad wybieramy, albo po prostu bylo to klikniecie tak po prostu :P
            if(!grid.isFree(px, py, 1, 1)) {
                Gdx.app.debug("MyTag", "my debug message");
                //Cos tam jest, zatem zostalo wybrane
                Pair building = grid.getInfoHandler(px, py);
                if(building != null) { //W razie czego
                    //Szuakmy teraz na liscie budynkow obiektu z takimi parametrami
                    for(AbstractBuilding e: info.getBuildings()) {
                        if(px == (int)e.getPosX() && py == (int)e.getPosY()) {
                            //Super, teraz go trzeba wziac
                            pickedBuilding = e;
                            info.removeBuilding(e);
                            isPickingBuildingFromMap =  true;
                        }
                    }
                }
            }
        }



        /*
        GameObject buildingOnMap = null;

        //TODO: Zrobic to lepiej!
        //Algos: jedziemy teraz po liscie z budynkow i sprawdzamy czy tam mozemy postawic budynek
        for(GameObject e : info.getBuildings()) {
            if(e.getPosX() == x && e.getPosY() == y) {
                buildingOnMap = e;
                break;
            }
        }

        //TODO: SIATKA
        if(isPickingBuildingFromInventory && buildingOnMap == null) {
            //Mozna
            info.addBuilding((AbstractBuilding) pickedBuilding);
            isPickingBuildingFromInventory = isPickingBuildingFromMap = false;
        }
        else if(buildingOnMap != null && !isPickingBuildingFromInventory && !isPickingBuildingFromMap) {
            pickedBuilding = buildingOnMap;
            info.removeBuilding(pickedBuilding);
        }
        */
    }

    @Override
    protected void handleMovementInventory(float x, float y) {
        //TODO: Obsluga pieniedzy
        //Cale zyccie da sie rozwiazac na ifach

        //Wzielismy budynek z mapy (albo sie rozmyslilismy), wiec trzeba go oddac, przykro mi
        if(isPickingBuildingFromMap || isPickingBuildingFromInventory) {
            this.info.buildingsToBuild.replace(pickedBuilding, this.info.buildingsToBuild.get(pickedBuilding), this.info.buildingsToBuild.get(pickedBuilding) + 1);
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

            Texture ico = o[i].getTexture();
            Rectangle r = new Rectangle(o[i].getPosX(), o[i].getPosY(), ico.getWidth(), ico.getHeight());
            if(r.contains(x,y)) {
                info.buildingsToBuild.replace( o[i], info.buildingsToBuild.get(o[i]), info.buildingsToBuild.get(o[i]) - 1); //TODO: Co jak <= 0?
                pickedBuilding = o[i];
                isPickingBuildingFromInventory = true;
                break;
            }
            /*
            if(o[i].getSprite().getBoundingRectangle().contains(x, y)) {
                info.buildingsToBuild.replace((AbstractBuilding) o[i], info.buildingsToBuild.get(o[i]), info.buildingsToBuild.get(o[i]) - 1); //TODO: Co jak <= 0?
                pickedBuilding = (AbstractBuilding)o[i];
                isPickingBuildingFromInventory = true;
                break;
            }
            */
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
        //A teraz ryoswanie budynkow na mapie
        for(AbstractBuilding b: info.getBuildings()) {
            b.setSprite(b.getTexture());
            b.getSprite().setPosition(b.getPosX() * GameConstants.CELL_WIDTH, b.getPosY() * GameConstants.CELL_HEIGHT);
            b.drawSprite(b.getPosX() * GameConstants.CELL_WIDTH, b.getPosY() * GameConstants.CELL_HEIGHT);
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
    }
}
