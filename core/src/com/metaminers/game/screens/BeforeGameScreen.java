package com.metaminers.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.metaminers.game.GameConstants;
import com.metaminers.game.phases.PlayingInformation;


/**
 * Created by Hubert but picked up by Jacques on 2015-07-24.
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
    TextureRegionDrawable textfieldStyle;

    Label labelName;
    Label labelCharacter;
    Label labelVillage;
    Label labelDifficulty;

    TextField nameTextField;
    Texture textFieldTexture;
    TextureRegion textFieldTextureRegion;
    BitmapFont font;

    Button[] arrowButtons;
    TextButton playButton;

    Texture cursorTexture;
    TextureRegion cursorTextureRegion;
    TextButtonStyle cursorStyle;

    String playerName;
    int selectedCharacter;
    int selectedVillage;
    int selectedDifficulty;

    Image[] characterImages;
    Image[] villagesImages;
    Image[] difficultyLabels;

    Preferences prefs;

    SpriteBatch batch;
    Sprite sprite;
    Texture background;
    TextureRegion backgroundRegion;

    public BeforeGameScreen(Game game) {
        this.game = game;
        font = new BitmapFont();

        batch = new SpriteBatch();
        background = new Texture(Gdx.files.internal("homescreen/drugiebg1.png"));
        background.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        sprite = new Sprite(background);
        backgroundRegion = new TextureRegion(background);

        prefs = Gdx.app.getPreferences("com.meataminers.brave-miner-defender.settings");

            playerName = prefs.getString("playerName", "");
            selectedCharacter = prefs.getInteger("selectedCharacter", 0);
            selectedVillage = prefs.getInteger("selectedVillage", 0);
            selectedDifficulty = prefs.getInteger("selectedDifficulty", 1);

        playButtonTexture = new Texture(Gdx.files.internal("buttons/play.png"));
        playButtonTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        leftButtonTexture = new Texture(Gdx.files.internal("buttons/leftButton.png"));
        leftButtonTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        rightButtonTexture = new Texture(Gdx.files.internal("buttons/rightButton.png"));
        rightButtonTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textFieldTexture = new Texture(Gdx.files.internal("buttons/textField.png"));
        textFieldTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        playButtonTextureRegion = new TextureRegion(playButtonTexture);
        leftButtonTextureRegion = new TextureRegion(leftButtonTexture);
        rightButtonTextureRegion = new TextureRegion(rightButtonTexture);
        textFieldTextureRegion = new TextureRegion(textFieldTexture);

        style = new TextButton.TextButtonStyle();
        style.up = new TextureRegionDrawable(playButtonTextureRegion);
        style.down = new TextureRegionDrawable(playButtonTextureRegion);
        style.font = font;
        textfieldStyle = new TextureRegionDrawable(textFieldTextureRegion);
        playButton = new TextButton("", style);
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
        for (; i < 3; i++) {
            arrowButtons[i] = new Button(leftArrowStyle);
            stage.addActor(arrowButtons[i]);
        }
        for (; i < 6; i++) {
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

        cursorTexture = new Texture(Gdx.files.internal("cursors/editCursor.png"));
        cursorTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        cursorTextureRegion = new TextureRegion(cursorTexture);

        cursorStyle = new TextButtonStyle();
        cursorStyle.up = new TextureRegionDrawable(cursorTextureRegion);

//        TODO: zrobic ladny kursor
        nameTextFieldStyle = new TextFieldStyle(font, Color.WHITE, cursorStyle.up, textfieldStyle, textfieldStyle);
        nameTextField = new TextField(playerName, nameTextFieldStyle);

        nameTextField.setBounds(400, 700, 440, 30);

        stage.addActor(playButton);
        stage.addActor(nameTextField);

        characterImages = new Image[GameConstants.HEROES];
        // Create new sprites using the just created texture
        for (i = 0; i < GameConstants.HEROES; i++) {
            Texture texture = new Texture("buttons/g" + (i + 1) + "icon.png");
            Image img = new Image(texture);
            characterImages[i] = img;
            stage.addActor(characterImages[i]);
        }

        characterImages[getPreviousHeroesNumber(selectedCharacter)].setBounds(10, 60, 64, 64);
        characterImages[selectedCharacter].setBounds(700, 10, 64, 64);
        characterImages[getNextHeroesNumber(selectedCharacter)].setBounds(1, 10, 64, 64);

        villagesImages = new Image[GameConstants.VILLAGES];
        // Create new sprites using the just created texture
        for (i = 0; i < GameConstants.VILLAGES; i++) {
            Texture texture = new Texture("buttons/plicon" + (i + 1) + ".png");
            Image img = new Image(texture);
            villagesImages[i] = img;
            stage.addActor(villagesImages[i]);
        }

        villagesImages[getPreviousVillageNumber(selectedCharacter)].setBounds(Gdx.graphics.getWidth() / 2 - 160, 330, 64, 64);
        villagesImages[selectedCharacter].setBounds(Gdx.graphics.getWidth() / 2 - 32, 330, 64, 64);
        villagesImages[getNextVillageNumber(selectedCharacter)].setBounds(Gdx.graphics.getWidth() / 2 + 96, 330, 64, 64);


        difficultyLabels = new Image[GameConstants.DIFFICULTY_LEVELS];
        // Create new sprites using the just created texture
        for (i = 0; i < GameConstants.DIFFICULTY_LEVELS; i++) {
            Texture texture = new Texture("buttons/level" + (i + 1) + ".png");
            Image img = new Image(texture);
            difficultyLabels[i] = img;
            stage.addActor(difficultyLabels[i]);
        }

        difficultyLabels[getPreviousDifficultyLevel(selectedDifficulty)].setBounds(Gdx.graphics.getWidth() / 2 - 160, 150, 64, 64);
        difficultyLabels[selectedDifficulty].setBounds(Gdx.graphics.getWidth() / 2 - 32, 150, 64, 64);
        difficultyLabels[getNextDifficultyLevel(selectedDifficulty)].setBounds(Gdx.graphics.getWidth() / 2 + 96, 150, 64, 64);
    }

    @Override
    public void show() {
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                BeforeGameScreen.this.prefs.putString("playerName", BeforeGameScreen.this.nameTextField.getText());
                BeforeGameScreen.this.prefs.putInteger("selectedCharacter", BeforeGameScreen.this.selectedCharacter);
                BeforeGameScreen.this.prefs.putInteger("selectedVillage", BeforeGameScreen.this.selectedVillage);
                BeforeGameScreen.this.prefs.putInteger("selectedDifficulty", BeforeGameScreen.this.selectedDifficulty);
                BeforeGameScreen.this.prefs.flush();

                PlayingInformation info = new PlayingInformation();
                //TODO: ODKOMENTOWAC PONIZSZE I UZUPELNIC GAMECONSTANTS ORAZ ABSTRACTHERO (IMPLEMENTACJA)
                info.setHero(BeforeGameScreen.this.selectedCharacter);
//                pierwszy jest do Villages, drugi jest do T�a Village
                info.setVillage(BeforeGameScreen.this.selectedVillage, BeforeGameScreen.this.selectedVillage);
                BeforeGameScreen.this.game.setScreen(new LevelScreen(game, info));
            }
        });

        arrowButtons[0].addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                BeforeGameScreen.this.decrementHeroesNumber();
            }
        });

        arrowButtons[1].addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                BeforeGameScreen.this.decrementVillageNumber();
            }
        });

        arrowButtons[2].addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                BeforeGameScreen.this.decrementDifficultyLevel();
            }
        });

        arrowButtons[3].addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                BeforeGameScreen.this.incrementHeroesNumber();
            }
        });

        arrowButtons[4].addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                BeforeGameScreen.this.incrementVillageNumber();
            }
        });

                arrowButtons[5].addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                BeforeGameScreen.this.incrementDifficultyLevel();
            }
        });

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        characterImages[getPreviousHeroesNumber(selectedCharacter)].setBounds(Gdx.graphics.getWidth() / 2 - 160, 530, 64, 64);
        characterImages[selectedCharacter].setBounds(Gdx.graphics.getWidth() / 2 - 32, 530, 64, 64);
        characterImages[getNextHeroesNumber(selectedCharacter)].setBounds(Gdx.graphics.getWidth() / 2 + 96, 530, 64, 64);
        villagesImages[getPreviousVillageNumber(selectedVillage)].setBounds(Gdx.graphics.getWidth() / 2 - 160, 330, 64, 64);
        villagesImages[selectedVillage].setBounds(Gdx.graphics.getWidth() / 2 - 32, 330, 64, 64);
        villagesImages[getNextVillageNumber(selectedVillage)].setBounds(Gdx.graphics.getWidth() / 2 + 96, 330, 64, 64);
        difficultyLabels[getPreviousDifficultyLevel(selectedDifficulty)].setBounds(Gdx.graphics.getWidth() / 2 - 160, 150, 64, 64);
        difficultyLabels[selectedDifficulty].setBounds(Gdx.graphics.getWidth() / 2 - 32, 150, 64, 64);
        difficultyLabels[getNextDifficultyLevel(selectedDifficulty)].setBounds(Gdx.graphics.getWidth() / 2 + 96, 150, 64, 64);

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

    }

    private void incrementHeroesNumber(){
        selectedCharacter = getNextHeroesNumber(selectedCharacter);
    }

    private void decrementHeroesNumber(){
        selectedCharacter = getPreviousHeroesNumber(selectedCharacter);
    }

    private void incrementVillageNumber(){
        selectedVillage = getNextVillageNumber(selectedVillage);
    }

    private void decrementVillageNumber(){
        selectedVillage = getPreviousVillageNumber(selectedVillage);
    }

    private void incrementDifficultyLevel(){
        selectedDifficulty = getNextDifficultyLevel(selectedDifficulty);
    }

    private void decrementDifficultyLevel(){
        selectedDifficulty = getPreviousDifficultyLevel(selectedDifficulty);
    }

    private int getPreviousHeroesNumber(int current){
        if (current == 0) {
            return (GameConstants.HEROES - 1);
        } else {
            return (current - 1);
        }
    }

    private int getNextHeroesNumber(int current){
        if (current == (GameConstants.HEROES - 1)) {
            return (0);
        } else {
            return (current + 1);
        }
    }

    private int getPreviousVillageNumber(int current){
        if (current == 0) {
            return (GameConstants.VILLAGES - 1);
        } else {
            return (current - 1);
        }
    }

    private int getNextVillageNumber(int current){
        if (current == (GameConstants.VILLAGES - 1)) {
            return (0);
        } else {
            return (current + 1);
        }
    }

    private int getPreviousDifficultyLevel(int current){
        if (current == 0) {
            return (GameConstants.DIFFICULTY_LEVELS - 1);
        } else {
            return (current - 1);
        }
    }

    private int getNextDifficultyLevel(int current){
        if (current == (GameConstants.DIFFICULTY_LEVELS - 1)) {
            return (0);
        } else {
            return (current + 1);
        }
    }
}
