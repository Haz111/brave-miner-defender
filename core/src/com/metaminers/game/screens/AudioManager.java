package com.metaminers.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
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
import com.metaminers.game.phases.PlayingInformation;

/**
 * Created by Kuba on 2015-07-26.
 */
public class AudioManager {
    public static AudioManager instance = null;
    Music music = Gdx.audio.newMusic(Gdx.files.internal("music/menu.wav"));
    Boolean update = false;

    public static AudioManager getInstance(){
        if (instance == null) instance = new AudioManager();
        return instance;
    }

    public void updateMusic(Float volume){
        music.setVolume(volume);
    }

    private AudioManager(){

        if (music.isPlaying()== false) {
            music.play();
            music.setLooping(true);
        }

    }
}