package com.metaminers.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.metaminers.game.GameConstants;


/**
 * Created by Hubert on 2015-07-24.
 */
public class BeforeGameScreen implements Screen {
    Stage stage;
    Game game;

    TextureRegion playButtonTextureRegion;
    TextureRegion leftButtonTextureRegion;
    TextureRegion rightButtonTextureRegion;

    Texture playButtonTexture;
    Texture leftButtonTexture;
    Texture rightButtonTexture;

    TextButtonStyle style;
    ButtonStyle leftArrowStyle;
    ButtonStyle rightArrowStyle;
    LabelStyle labelStyle;
    TextFieldStyle nameTextFieldStyle;

    Label labelName;
    Label labelCharacter;
    Label labelVillage;
    Label labelDifficulty;

    TextField nameTextField;

    BitmapFont font;

    Button[] arrowButtons;
    TextButton playButton;

    Texture cursorTexture;
    TextureRegion cursorTextureRegion;
    TextButtonStyle cursorStyle;

    int selectedCharacter;
    int selectVillage;
    int selectDifficulty;


    public BeforeGameScreen(Game game) {
        this.game = game;
        font = new BitmapFont();
//        skin = new Skin();
//        leftArrowSkin = new Skin();
//        rightArrowSkin = new Skin();

        playButtonTexture = new Texture(Gdx.files.internal("buttons/exampleButton.png"));
        playButtonTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        leftButtonTexture = new Texture(Gdx.files.internal("buttons/leftButton.png"));
        leftButtonTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        rightButtonTexture = new Texture(Gdx.files.internal("buttons/rightButton.png"));
        rightButtonTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        playButtonTextureRegion = new TextureRegion(playButtonTexture);
        leftButtonTextureRegion = new TextureRegion(leftButtonTexture);
        rightButtonTextureRegion = new TextureRegion(rightButtonTexture);

        style = new TextButton.TextButtonStyle();
        style.up = new TextureRegionDrawable(playButtonTextureRegion);
        style.down = new TextureRegionDrawable(playButtonTextureRegion);
        style.font = font;
        playButton = new TextButton("Play", style);
        playButton.setBounds(Gdx.graphics.getWidth() / 2 - 50, 80, 100, 40);

        leftArrowStyle = new ButtonStyle();
        leftArrowStyle.up = new TextureRegionDrawable(leftButtonTextureRegion);
        leftArrowStyle.down = new TextureRegionDrawable(leftButtonTextureRegion);

        rightArrowStyle = new ButtonStyle();
        rightArrowStyle.up = new TextureRegionDrawable(rightButtonTextureRegion);
        rightArrowStyle.down = new TextureRegionDrawable(rightButtonTextureRegion);

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        arrowButtons = new Button[6];
        int i = 0;
        for (; i < 3; i++){
            arrowButtons[i] = new Button(leftArrowStyle);
            stage.addActor(arrowButtons[i]);
        }
        for (; i<6; i++) {
            arrowButtons[i] = new Button(rightArrowStyle);
            stage.addActor(arrowButtons[i]);
        }
        arrowButtons[0].setBounds(Gdx.graphics.getWidth() / 2 - 400, 550, 20, 20);
        arrowButtons[1].setBounds(Gdx.graphics.getWidth() / 2 - 400, 350, 20, 20);
        arrowButtons[2].setBounds(Gdx.graphics.getWidth() / 2 - 400, 150, 20, 20);
        arrowButtons[3].setBounds(Gdx.graphics.getWidth() / 2 + 400, 550, 20, 20);
        arrowButtons[4].setBounds(Gdx.graphics.getWidth() / 2 + 400, 350, 20, 20);
        arrowButtons[5].setBounds(Gdx.graphics.getWidth() / 2 + 400, 150, 20, 20);

        labelStyle = new LabelStyle(font, Color.WHITE);
        labelName = new Label("Choose your name", labelStyle);
        labelCharacter = new Label("Choose your character", labelStyle);
        labelVillage = new Label("Choose your village", labelStyle);
        labelDifficulty = new Label("Choose difficulty", labelStyle);

        cursorTexture = new Texture(Gdx.files.internal("cursors/editCursor.png"));
        cursorTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        cursorTextureRegion = new TextureRegion(cursorTexture);

        cursorStyle = new TextButtonStyle();
        cursorStyle.up = new TextureRegionDrawable(cursorTextureRegion);

//        TODO: zrobic ladny kursor
        nameTextFieldStyle = new TextFieldStyle(font, Color.WHITE, cursorStyle.up, style.up, style.up);
        nameTextField = new TextField("", nameTextFieldStyle);

        labelName.setBounds(200, 700, 100, 20);
        labelCharacter.setBounds(200, 600,100,20);
        labelVillage.setBounds(200, 400, 100, 20);
        labelDifficulty.setBounds(200, 200, 100, 20);
        nameTextField.setBounds(400, 700, 300, 30);

        stage.addActor(playButton);
        stage.addActor(labelName);
        stage.addActor(labelCharacter);
        stage.addActor(labelVillage);
        stage.addActor(labelDifficulty);
        stage.addActor(nameTextField);

//        characterSprites = new Sprite[GameConstants.HEROES];
// Create empty POT-sized Pixmap with 8 bit RGBA pixel data

//        Texture texture = new Texture("assets/characters/character1.png");
//// Create new sprites using the just created texture
//        for (int i = 0; i < testSprites.length; i++) {
//            Sprite spr = new Sprite(texture);
//// Define sprite size to be 1m x 1m in game world
//            spr.setSize(1, 1);
//// Set origin to sprite's center
//            spr.setOrigin(spr.getWidth() / 2.0f, spr.getHeight() / 2.0f);
//// Calculate random position for sprite
//            float randomX = MathUtils.random(-2.0f, 2.0f);
//            float randomY = MathUtils.random(-2.0f, 2.0f);
//            spr.setPosition(randomX, randomY);
//// Put new sprite into array
//            testSprites[i] = spr;
//        }
// Set first sprite as selected one
//        selectedSprite = 0;
    }

    @Override
    public void show() {
        playButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
//                super.clicked(event, x, y);
                BeforeGameScreen.this.game.setScreen(new BeforeGameScreen(game));
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

    }
}
