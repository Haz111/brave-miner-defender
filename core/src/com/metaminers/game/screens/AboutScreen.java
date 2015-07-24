package com.metaminers.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Created by Jacques on 2015-07-24.
 */
public class AboutScreen implements Screen {
    TextButton exitButton;
    Stage stage;
    Game game;

    Texture buttonTexture;
    TextureRegion buttonTextureRegion;
    TextButtonStyle style;
    Skin skin;
    BitmapFont font;


    public AboutScreen(Game game) {
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
        exitButton = new TextButton("Back", style);
        exitButton.setBounds(Gdx.graphics.getWidth()/2 - 50, 50, 100, 40);


        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        stage.addActor(exitButton);


    }

    @Override
    public void show() {
        exitButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                AboutScreen.this.game.setScreen(new MenuScreen(game));
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
