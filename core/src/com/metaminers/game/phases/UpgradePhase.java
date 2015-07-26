package com.metaminers.game.phases;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.metaminers.game.GameConstants;
import com.metaminers.game.objects.buildings.*;

import java.util.LinkedList;

/**
 * Created by Konrad on 2015-07-24.
 */
public class UpgradePhase extends Phase {

    private TextButton buy, fight;
    private Stage stage;
    private AbstractBuilding chosenBuilding;
    private LinkedList<AbstractBuilding> items;

    private static final int RENDER_POS_X = 300;
    private static final int RENDER_POS_Y = 510;

    @Override
    public void start(PlayingInformation info) {
        this.info = info;
        buy = makeTextButton("Buy!", 500, 500, 100, 100);
        fight = makeTextButton("Just do it!", 500, 100, 100, 100); //TODO: Ustawicladnie buttony

        items = new LinkedList<>();
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        buy.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                UpgradePhase.this.info.reduceMoney(UpgradePhase.this.chosenBuilding.getPrice());
                UpgradePhase.this.info.addBuyedBuilding(UpgradePhase.this.chosenBuilding);
            }
        });

        fight.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                UpgradePhase.this.markEnded(true);
            }
        });

        stage.addActor(buy);
        stage.addActor(fight);

        prepareShop();
    }

    private void prepareShop() {
        items.add(new TowerBasic(0,0));
        items.add(new TowerDouble(0,0));
        items.add(new TowerSmallLaser(0,0));
        items.add(new TowerMediumLaser(0,0));
        items.add(new TowerBigLaser(0,0));
        items.add(new TowerTank(0,0));
        items.add(new TowerBunker(0,0));
        items.add(new TowerQuadron(0,0));

        chosenBuilding = items.get(0);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.begin();
        stage.act(delta);
        stage.draw();

        batch.end();
    }

    private void setUpBuildings() {
        //// rysowanie budynkow do budowy:
        float posX =0, posY = GameConstants.HEIGHT - items.get(0).getHeight(), step = items.get(0).getHeight();
        for (AbstractBuilding b : items) {
            b.drawInGui(posX, posY, 1.0f);
            posY += step;
            /*
            if (b.getPrice() == 10)
                b.drawInGui(0, 610, 3);
            else if (b.getPrice() == 20)
                b.drawInGui(8, 500, 1.5f); */
        }
    }

    private void renderCurrentItem() {
        batch.begin();
        chosenBuilding.drawInGui(RENDER_POS_X, RENDER_POS_Y, 1.0f);
        batch.end();
    }
    @Override
    protected void handleMovementMap(float x, float y) {
        //...

    }

    @Override
    protected void handleMovementInventory(float x, float y) {
        //Sprawdzamy co kliknelismy i to ustawiamy w current
        for(AbstractBuilding b : items) {
            if(b.getSprite().getBoundingRectangle().contains(x, GameConstants.HEIGHT - y)) {
                chosenBuilding = b;
                break;
            }
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

    }
}
