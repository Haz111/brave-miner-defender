package com.metaminers.game.phases;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.metaminers.game.GameConstants;
import com.metaminers.game.objects.buildings.AbstractBuilding;
import com.metaminers.game.objects.enemies.AbstractEnemy;

/**
 * Created by Konrad on 2015-07-24.
 */
public abstract class Phase implements Screen{
    protected PlayingInformation results;
    protected boolean ended = false;
    protected PlayingInformation info;
    protected final String warnString = "You cannot place building here";
    protected Texture pane, background;
    protected SpriteBatch batch;
    protected Vector3 touchPoint;
    protected OrthographicCamera c;

    protected void markEnded(boolean status) {
        results = info;
        ended = status;
    }

    public boolean isEnded() {
        return ended;
    }

    public PlayingInformation getResults() {
        return results;
    }

    public void start(PlayingInformation info) {
        markEnded(false);
        this.info = info;
        pane = new Texture(Gdx.files.internal("gui/pane.png"));
        background = new Texture(Gdx.files.internal("gui/background.png"));
        batch = new SpriteBatch();
        c = new OrthographicCamera(GameConstants.WIDTH, GameConstants.HEIGHT);
        touchPoint = new Vector3();

    }

    public TextButton makeTextButton(String label, float x, float y, float width, float height) {
        TextButton button;
        Stage stage;

        Texture buttonTexture;
        TextureRegion buttonTextureRegion;
        TextButton.TextButtonStyle style;
        BitmapFont font;

        font = new BitmapFont();

        buttonTexture = new Texture(Gdx.files.internal("buttons/exampleButton.png"));
        buttonTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        buttonTextureRegion = new TextureRegion(buttonTexture);

        style = new TextButton.TextButtonStyle();
        style.up = new TextureRegionDrawable(buttonTextureRegion);
        style.down = new TextureRegionDrawable(buttonTextureRegion);
        style.font = font;

        button = new TextButton(label, style);
        button.setBounds(x, y, width, height);

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        stage.addActor(button);
        return button;
    }

    @Override
    public void render(float delta) {
        batch.begin();
        drawGUI();
        // drawEnemiesOnPane();
        batch.end();
        handleInput();
    }

    protected void handleInput() {
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
            Gdx.app.exit();

        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
            markEnded(true);


        if(Gdx.input.justTouched()) {
            touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            //We could peek a tower
            if(touchPoint.x <= GameConstants.INTERFACE_PANEL_WIDTH || touchPoint.x >= GameConstants.WIDTH - GameConstants.INTERFACE_PANEL_WIDTH)
                handleMovementInventory(touchPoint.x, touchPoint.y);
            else
                handleMovementMap(touchPoint.x, touchPoint.y);
        }
    }

    protected abstract void handleMovementMap(float x, float y);
    protected abstract void handleMovementInventory(float x, float y);

    protected void drawGUI() {
//        batch.draw(pane, 0, 0);
//        batch.draw(pane, GameConstants.WIDTH - GameConstants.INTERFACE_PANEL_WIDTH, 0);
        batch.draw(background, GameConstants.INTERFACE_PANEL_WIDTH, 0);
    }

    protected void drawEnemiesOnPane() {
        float xpos = GameConstants.WIDTH - GameConstants.INTERFACE_PANEL_WIDTH; //xpos - X position to draw
        float ypos = GameConstants.HEIGHT;
        Sprite s;
        AbstractEnemy e;

        for (int i = 0; i < this.info.getEnemiesObjects().size(); i++) {
            e = info.getEnemiesObjects().get(i);
            s = new Sprite(e.getTexture());
            s.setX(xpos);
            s.setY(ypos - i * e.getHeight());
            s.draw(batch);
            e.setSprite(s);
            //e.draw(xpos, ypos - i * e.getHeight());
        }
    }

    protected void drawBuildings() {
        for(AbstractBuilding ab : info.getBuildings()) {
            ab.drawInGui(ab.getPosX(), ab.getPosY(), 1);
        }
    }

}
