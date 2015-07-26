package com.metaminers.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.metaminers.game.phases.PlayingInformation;

/**
 * Created by Hubert on 2015-07-26.
 */
public class AfterGameScreen implements Screen {
    TextButton exitButton;
    TextButton playButton;
    Stage stage;
    Game game;

    Texture buttonTexture;
    TextureRegion buttonTextureRegion;
    TextButton.TextButtonStyle style;
    Texture buttonTexturePlay;
    TextureRegion buttonTextureRegionPlay;
    TextButton.TextButtonStyle stylePlay;
    Skin skin;
    BitmapFont font;
    SpriteBatch batch;
    Texture background;
    Sprite sprite;
    TextureRegion backgroundRegion;
    AudioManager audioManager;


    public AfterGameScreen(Game game, AudioManager audioManager) {
        this.game = game;
        font = new BitmapFont();
        skin = new Skin();
        this.audioManager = audioManager;

        batch = new SpriteBatch();
        background = new Texture(Gdx.files.internal("homescreen/deadscene.png"));
        background.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        sprite = new Sprite(background);
        backgroundRegion = new TextureRegion(background);

        buttonTexture = new Texture(Gdx.files.internal("buttons/backmenu.png"));
        buttonTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        buttonTextureRegion = new TextureRegion(buttonTexture);

        buttonTexturePlay = new Texture(Gdx.files.internal("buttons/playagain.png"));
        buttonTexturePlay.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        buttonTextureRegionPlay = new TextureRegion(buttonTexturePlay);

        style = new TextButton.TextButtonStyle();
        style.up = new TextureRegionDrawable(buttonTextureRegion);
        style.down = new TextureRegionDrawable(buttonTextureRegion);
        style.font = font;

        stylePlay = new TextButton.TextButtonStyle();
        stylePlay.up = new TextureRegionDrawable(buttonTextureRegionPlay);
        stylePlay.down = new TextureRegionDrawable(buttonTextureRegionPlay);
        stylePlay.font = font;

        exitButton = new TextButton("", style);
        exitButton.setBounds(Gdx.graphics.getWidth() / 2 - 154, 30, 144, 96);
        playButton = new TextButton("", stylePlay);
        playButton.setBounds(Gdx.graphics.getWidth() / 2 + 10, 30, 144, 96);


        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        stage.addActor(exitButton);
        stage.addActor(playButton);


    }

    @Override
    public void show() {
        exitButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                AfterGameScreen.this.game.setScreen(new MenuScreen(game));
            }
        });

        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Preferences prefs = Gdx.app.getPreferences("com.meataminers.brave-miner-defender.settings");
                String playerName = prefs.getString("playerName", "");
                int selectedCharacter = prefs.getInteger("selectedCharacter", 0);
                int selectedVillage = prefs.getInteger("selectedVillage", 0);
                int selectedDifficulty = prefs.getInteger("selectedDifficulty", 1);

                PlayingInformation info = new PlayingInformation();
                //TODO: ODKOMENTOWAC PONIZSZE I UZUPELNIC GAMECONSTANTS ORAZ ABSTRACTHERO (IMPLEMENTACJA) - todo skopiowane z beforeGameScreena
                info.setHero(selectedCharacter);
//                pierwszy jest do Villages, drugi jest do T³a Village
                info.setVillage(selectedVillage, selectedVillage);
                AfterGameScreen.this.game.setScreen(new LevelScreen(game, info, audioManager));
            }
        });

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        sprite.draw(batch);
        batch.end();
        stage.act();
        stage.draw();
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
        stage.dispose();
        skin.dispose();
    }
}
