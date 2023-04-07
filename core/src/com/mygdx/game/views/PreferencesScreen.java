package com.mygdx.game.views;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.MyGdxGame;


public class PreferencesScreen implements Screen {

    private MyGdxGame parent;
    private Skin skin;
    private Stage stage;
    //Label
    private Label titleLabel;
    private Label volumeMusicLabel;
    private Label volumeSoundLabel;
    private Label musicOnOffLabel;
    private Label soundOnOffLabel;

    private final Slider volumeMusicSlider;
    private final CheckBox musicCheckbox;
    private final TextButton backButton;


    public PreferencesScreen(final MyGdxGame myGdxGame) {
        parent = myGdxGame;
        skin = parent.getSkin();

        //Kaydırıcı
        volumeMusicSlider = new Slider(0f, 1f, 0.1f, false, skin);
        volumeMusicSlider.setValue(parent.getPreferences().getMusicVolume());
        volumeMusicSlider.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                parent.getPreferences().setMusicVolume(volumeMusicSlider.getValue());
                return false;
            }
        });

        // Onay Kutus
        musicCheckbox = new CheckBox(null, skin);
        musicCheckbox.setChecked(parent.getPreferences().isMusicEnabled());
        musicCheckbox.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                boolean enabled = musicCheckbox.isChecked();
                parent.getPreferences().setMusicEnabled(enabled);
                return false;
            }
        });

        //Ana ekrana geri dön
        backButton = new TextButton("Back", skin, "default");
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(MyGdxGame.MENU);
            }
        });

        createUI();
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void show() {
        System.out.println("Preferences Screen");
    }

    @Override
    public void render(float delta) {

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

    public void createUI(){
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(false);

        titleLabel = new Label("Preferences",skin);
        volumeMusicLabel = new Label(null,skin);
        volumeSoundLabel = new Label(null,skin);
        musicOnOffLabel = new Label(null,skin);
        soundOnOffLabel = new Label(null,skin);

        table.add(titleLabel);
        table.row();
        table.add(volumeMusicLabel);
        table.add(volumeMusicSlider);
        table.row();
        table.add(musicOnOffLabel);
        table.add(musicCheckbox);
        table.row();
        table.add(volumeSoundLabel);
//        table.add(soundMusicSlider);
        table.row();
        table.add(soundOnOffLabel);
//        table.add(soundEffectsCheckbox);
        table.row();
        table.add(backButton);
    }



}

