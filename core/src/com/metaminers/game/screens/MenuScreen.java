package com.metaminers.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;

/**
 * Created by Hubert on 2015-07-24.
 */
public class MenuScreen implements Screen {
    Stage stage;
    Game game;

    Texture buttonTexturePlay;
    Texture buttonTextureQuick;
    Texture buttonTextureAbout;
    Texture buttonTextureExit;
    Texture buttonTextureOptions;
    Texture background;

    TextureRegion buttonTextureRegionPlay;
    TextureRegion buttonTextureRegionOptions;
    TextureRegion buttonTextureRegionAbout;
    TextureRegion buttonTextureRegionExit;
    TextureRegion buttonTextureRegionQuick;
    TextureRegion backgroundRegion;

    TextButtonStyle stylePlay;
    TextButtonStyle styleExit;
    TextButtonStyle styleAbout;
    TextButtonStyle styleOptions;
    TextButtonStyle styleQuick;
    Skin skin;
    BitmapFont font;

    TextButton playButton;
//    TextButton level;
    TextButton optionsButton;
    TextButton aboutAuthorsButton;
    TextButton exitButton;
    TextButton quickButton;
    SpriteBatch batch;
    Sprite sprite;


    public MenuScreen(Game game) {
        this.game = game;
        font = new BitmapFont();
        skin = new Skin();

        batch = new SpriteBatch();
        background = new Texture(Gdx.files.internal("homescreen/bg3.png"));
        background.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        sprite = new Sprite(background);



        backgroundRegion = new TextureRegion(background);

        buttonTexturePlay = new Texture(Gdx.files.internal("buttons/play.png"));
        buttonTexturePlay.setFilter(TextureFilter.Linear, TextureFilter.Linear);

        buttonTextureRegionPlay = new TextureRegion(buttonTexturePlay);

        buttonTextureOptions = new Texture(Gdx.files.internal("buttons/options.png"));
        buttonTextureOptions.setFilter(TextureFilter.Linear, TextureFilter.Linear);

        buttonTextureRegionOptions = new TextureRegion(buttonTextureOptions);

        buttonTextureAbout = new Texture(Gdx.files.internal("buttons/about.png"));
        buttonTextureAbout.setFilter(TextureFilter.Linear, TextureFilter.Linear);

        buttonTextureRegionAbout = new TextureRegion(buttonTextureAbout);

        buttonTextureExit = new Texture(Gdx.files.internal("buttons/exit.png"));
        buttonTextureExit.setFilter(TextureFilter.Linear, TextureFilter.Linear);

        buttonTextureRegionExit = new TextureRegion(buttonTextureExit);

        buttonTextureQuick = new Texture(Gdx.files.internal("buttons/quick.png"));
        buttonTextureQuick.setFilter(TextureFilter.Linear, TextureFilter.Linear);

        buttonTextureRegionQuick = new TextureRegion(buttonTextureQuick);

        stylePlay = new TextButtonStyle();
        stylePlay.up = new TextureRegionDrawable(buttonTextureRegionPlay);
        stylePlay.down = new TextureRegionDrawable(buttonTextureRegionPlay);
        stylePlay.font = font;

        styleOptions = new TextButtonStyle();
        styleOptions.up = new TextureRegionDrawable(buttonTextureRegionOptions);
        styleOptions.down = new TextureRegionDrawable(buttonTextureRegionOptions);
        styleOptions.font = font;

        styleAbout = new TextButtonStyle();
        styleAbout.up = new TextureRegionDrawable(buttonTextureRegionAbout);
        styleAbout.down = new TextureRegionDrawable(buttonTextureRegionAbout);
        styleAbout.font = font;

        styleExit = new TextButtonStyle();
        styleExit.up = new TextureRegionDrawable(buttonTextureRegionExit);
        styleExit.down = new TextureRegionDrawable(buttonTextureRegionExit);
        styleExit.font = font;

        styleQuick = new TextButtonStyle();
        styleQuick.up = new TextureRegionDrawable(buttonTextureRegionQuick);
        styleQuick.down = new TextureRegionDrawable(buttonTextureRegionQuick);
        styleQuick.font = font;

        playButton = new TextButton("", stylePlay);
        playButton.setBounds(50, 98, 144, 96);
        optionsButton = new TextButton("", styleOptions);
        optionsButton.setBounds(206,98, 144, 96);
        aboutAuthorsButton = new TextButton("", styleAbout);
        aboutAuthorsButton.setBounds(Gdx.graphics.getWidth()/2 + 159, 98, 144, 96);
        exitButton = new TextButton("", styleExit);
        exitButton.setBounds(Gdx.graphics.getWidth()/2 + 314, 98, 144, 96);
        quickButton = new TextButton("", styleQuick);
        quickButton.setBounds(Gdx.graphics.getWidth()/2 - 144 ,  50, 288, 192);


        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        stage.addActor(playButton);
        stage.addActor(optionsButton);
        stage.addActor(aboutAuthorsButton);
        stage.addActor(exitButton);
        stage.addActor(quickButton);

    }

    @Override
    public void show() {
        playButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
//                super.clicked(event, x, y);
                MenuScreen.this.game.setScreen(new BeforeGameScreen(game));
            }
        });

        optionsButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
//                super.clicked(event, x, y);
                MenuScreen.this.game.setScreen(new OptionsScreen(game));
            }
        });

        aboutAuthorsButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
//                super.clicked(event, x, y);
                MenuScreen.this.game.setScreen(new AboutScreen(game));
            }
        });

        exitButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
//                super.clicked(event, x, y);
                Gdx.app.exit();
            }
        });

        quickButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
//                super.clicked(event, x, y);
                //TODO: szybka gra
            }
        });

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
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
        batch.dispose();
        background.dispose();
    }
}
