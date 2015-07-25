package com.metaminers.game.phases;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.metaminers.game.GameConstants;
import com.metaminers.game.Grid;
import com.metaminers.game.Pair;
import com.metaminers.game.objects.GameObject;
import com.metaminers.game.objects.buildings.AbstractBuilding;
import com.metaminers.game.objects.enemies.AbstractEnemy;
import com.metaminers.game.objects.hero_classes.AbstractHeroClass;

import java.util.HashMap;

/**
 * Created by Konrad on 2015-07-24.
 */
public class BuildingPhase extends Phase {

    //TODO: ZROBIC JAKIEGOS RENDERERA KTORY BY NP. RYSOWAL GUI, OBECNA WERSJA JEST MANROTRAWSTWEM PAMIECI!
    private HashMap<AbstractBuilding, Integer> buildingsToBuild;
    private PlayingInformation info;
    private final String warnString = "You cannot place building here";
    private Texture pane, background;
    private SpriteBatch batch;
    private Vector3 touchPoint;
    private OrthographicCamera c;
    private boolean isPickingBuildingFromInventory = false;
    private boolean isPickingBuildingFromMap = false; //Co ja pisze...
    private GameObject pickedBuilding;

    @Override
    public void start(PlayingInformation info) {
        markEnded(false);
        pane = new Texture(Gdx.files.internal("gui/pane.png"));
        background = new Texture(Gdx.files.internal("gui/background.png"));
        batch = new SpriteBatch();
        this.info = info;
        c = new OrthographicCamera(GameConstants.WIDTH, GameConstants.HEIGHT);
        touchPoint = new Vector3();
        //renderGUI();
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
    }


    @Override
    public void render(float delta) {
        batch.begin();
        drawGUI();
        drawEnemies();
        setUpBuildings();
        batch.end();
        handleInput();
        if(pickedBuilding != null) {
            //pickedBuilding.getSprite().setPosition(Gdx.input.getX(), Gdx.input.getY()); //TODO: SPRAWDZIC CZY TO JEST OK!
            pickedBuilding.getSprite().setPosition(Gdx.input.getX() - pickedBuilding.getSprite().getWidth()/2,
                    Gdx.graphics.getHeight() - Gdx.input.getY() - pickedBuilding.getSprite().getHeight()/2); //TODO: SPRAWDZIC CZY TO JEST OK!
            //Wyjasnienie do powyzszego: http://www.gamefromscratch.com/post/2013/10/15/LibGDX-Tutorial-4-Handling-the-mouse-and-keyboard.aspx
            pickedBuilding.getSprite().draw(batch);
        }
    }

    private void handleInput() {
        if(Gdx.input.justTouched()) {
            touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            c.unproject(touchPoint);
            //We could peek a tower
            if(touchPoint.x <= GameConstants.INTERFACE_PANEL_WIDTH || touchPoint.x >= GameConstants.WIDTH - GameConstants.INTERFACE_PANEL_WIDTH)
                handleMovementInventory(touchPoint.x, touchPoint.y);
            else
                handleMovementMap(touchPoint.x, touchPoint.y);
        }
    }

    private void handleMovementMap(float x, float y) {
        //Jak klikniemy na pole puste siatki - jest ok
        //Jak nie - no to sorry
        //TODO: Dorobic do budynkow getGridWidth, getGridHeight - abysmy mogli spokojnie przerabiac to na siatke
        Pair p = Grid.mapToGrid(x, y, GameConstants.CELL_WIDTH, GameConstants.CELL_HEIGHT);
        x = p.x;
        y = p.y;
        GameObject buildingOnMap = null;

        //TODO: Zrobic to lepiej!
        //Algos: jedziemy teraz po liscie z budynkow i sprawdzamy czy tam mozemy postawic budynek
        for(GameObject e : info.getBuildings()) {
            if(e.getPosX() == x && e.getPosY() == y) {
                buildingOnMap = e;
                break;
            }
        }


        if(isPickingBuildingFromInventory) {
            //Ok, jednak mozna, koles kliknal to niech ma
            info.addBuilding((AbstractBuilding) pickedBuilding);//A FUJ!
            pickedBuilding = null; //Chyba ok?
            isPickingBuildingFromInventory = isPickingBuildingFromMap = false;
        }
        else if(buildingOnMap != null) {
            pickedBuilding = buildingOnMap;
            info.getBuildings().remove(buildingOnMap);
            isPickingBuildingFromMap = true;
        }

    }

    private void handleMovementInventory(float x, float y) {
        //TODO: Obsluga pieniedzy
        //Cale zyccie da sie rozwiazac na ifach

        //Wzielismy budynek z mapy (albo sie rozmyslilismy), wiec trzeba go oddac, przykro mi
        if(isPickingBuildingFromMap || isPickingBuildingFromInventory) {
            buildingsToBuild.replace((AbstractBuilding)pickedBuilding, buildingsToBuild.get(pickedBuilding), buildingsToBuild.get(pickedBuilding) + 1);
            pickedBuilding = null;
            return;
        }

        //No, mozna go brac!
        GameObject [] o = (GameObject [])buildingsToBuild.keySet().toArray();

        for(int i = 0; i < o.length; i++) {
            if(o[i].getSprite().getBoundingRectangle().contains(x, y))
            buildingsToBuild.replace((AbstractBuilding)o[i], buildingsToBuild.get(o[i]), buildingsToBuild.get(o[i]) - 1); //TODO: Co jak <= 0?
            pickedBuilding = o[i];
            isPickingBuildingFromInventory = true;
            break;
        }
    }

    private void drawGUI() {
        batch.draw(pane, 0, 0);
        batch.draw(pane, GameConstants.WIDTH - GameConstants.INTERFACE_PANEL_WIDTH, 0);
        batch.draw(background, GameConstants.INTERFACE_PANEL_WIDTH, 0);
    }

    private void drawEnemies() {
        float xpos = GameConstants.WIDTH - GameConstants.INTERFACE_PANEL_WIDTH; //xpos - X position to draw
        float ypos = GameConstants.HEIGHT;
        Sprite s;
        AbstractEnemy e;

        for (int i = 0; i < GameConstants.ENEMIES_COUNT; i++) {
            e = info.getEnemies().get(i);
            s = new Sprite(e.getTexture());
            s.setX(xpos);
            s.setY(ypos - i * e.getHeight());
            s.draw(batch);
            e.setSprite(s);
            //e.draw(xpos, ypos - i * e.getHeight());
        }
    }

    private void setUpBuildings() {
        float xpos = 0; //xpos - X position to draw
        float ypos = GameConstants.INTERFACE_PANEL_WIDTH;
        GameObject e;
        Sprite s;
        GameObject [] o = (GameObject[])buildingsToBuild.keySet().toArray();
        for (int i = 0; i < o.length; i++) {
            /*
            e = info.getBuildings().get(i);
            s = new Sprite(e.getTexture());
            s.setX(xpos);
            s.setY(ypos - i * e.getHeight());
            s.draw(batch);
            e.setSprite(s);
            */
            e = o[i];
            s = new Sprite(e.getTexture());
            s.setX(xpos);
            s.setY(ypos - i * e.getHeight());
            s.draw(batch);

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
