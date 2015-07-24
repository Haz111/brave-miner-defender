package com.metaminers.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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

    Texture buttonTexture;
    TextureRegion buttonTextureRegion;

    TextButtonStyle style;
    Skin skin;
    BitmapFont font;

    TextButton playButton;
//    TextButton level;
    TextButton optionsButton;
    TextButton aboutAuthorsButton;
    TextButton exitButton;


    public MenuScreen(Game game) {
        this.game = game;
        font = new BitmapFont();
        skin = new Skin();

        buttonTexture = new Texture(Gdx.files.internal("buttons/exampleButton.png"));
        buttonTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

        buttonTextureRegion = new TextureRegion(buttonTexture);

        style = new TextButtonStyle();
        style.up = new TextureRegionDrawable(buttonTextureRegion);
        style.down = new TextureRegionDrawable(buttonTextureRegion);
        style.font = font;
        playButton = new TextButton("Play", style);
        playButton.setBounds(Gdx.graphics.getWidth()/2 - 50, Gdx.graphics.getHeight()/2 + 100, 100, 40);
        optionsButton = new TextButton("Options", style);
        optionsButton.setBounds(Gdx.graphics.getWidth()/2 - 50, Gdx.graphics.getHeight()/2, 100, 40);
        aboutAuthorsButton = new TextButton("About Authors", style);
        aboutAuthorsButton.setBounds(Gdx.graphics.getWidth()/2 - 50, Gdx.graphics.getHeight()/2 - 100, 100, 40);
        exitButton = new TextButton("Exit", style);
        exitButton.setBounds(Gdx.graphics.getWidth()/2 - 50, Gdx.graphics.getHeight()/2 - 200, 100, 40);

//        TextButton level = new TextButton("Start game", style);
        //TextButton options = new TextButton("Options", new Skin());
        //TextButton aboutAuthors = new TextButton("About Authors", new Skin());
        //TextButton exit = new TextButton("Exit", new Skin());\

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        stage.addActor(playButton);
        stage.addActor(optionsButton);
        stage.addActor(aboutAuthorsButton);
        stage.addActor(exitButton);
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

//        TODO: uncomment when this will be done
//        optionsButton.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
////                super.clicked(event, x, y);
//                MenuScreen.this.game.setScreen(new OptionsScreen(game));
//            }
//        });
//
        //        TODO: uncomment when this will be done
//        aboutAuthorsButton.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
////                super.clicked(event, x, y);
//                MenuScreen.this.game.setScreen(new AboutScreen(game));
//            }
//        });

        exitButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
//                super.clicked(event, x, y);
                Gdx.app.exit();
            }
        });

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
