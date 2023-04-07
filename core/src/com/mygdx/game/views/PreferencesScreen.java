package com.mygdx.game.views;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.MyGdxGame;
import com.sun.tools.javac.comp.Check;


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

    private Slider volumeMusicSlider;
    private Slider volumeSoundSlider;
    private CheckBox musicCheckbox;
    private CheckBox soundCheckbox;
    private  TextButton backButton;


    public PreferencesScreen(final MyGdxGame myGdxGame) {
        parent = myGdxGame;

        skin = parent.getSkin();
//        Gdx.input.setInputProcessor(stage);
//        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
//        stage.draw();

    }

    @Override
    public void show() {
        System.out.println("Ayarlar EKRANI");
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        createUI();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
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
    }



    public void createUI(){
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(false);

        // Title label
        titleLabel = new Label("Ayarlar", skin);
        table.add(titleLabel).colspan(2).padBottom(30);
        table.row();

        // Music volume label and slider
        volumeMusicLabel = new Label("MUZIK SESI DUZEYI", skin);
        table.add(volumeMusicLabel).width(150).padRight(20);
        volumeMusicSlider = new Slider(0f, 1f, 0.1f, false, skin);
        volumeMusicSlider.setValue(parent.getPreferences().getMusicVolume());
        volumeMusicSlider.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                parent.getPreferences().setMusicVolume(volumeMusicSlider.getValue());
                return false;
            }
        });
        table.add(volumeMusicSlider).width(200).padBottom(30);
        table.row();

        // Music on/off label and checkbox
        musicOnOffLabel = new Label("MUZIK", skin);
        table.add(musicOnOffLabel).width(150).padRight(20);
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
        table.add(musicCheckbox).width(200).padBottom(30);
        table.row();

        // Sound volume label and slider
        volumeSoundLabel = new Label("Ses DUZEYI", skin);
        table.add(volumeSoundLabel).width(150).padRight(20);
        volumeSoundSlider = new Slider(0f, 1f, 0.1f, false, skin);
        volumeSoundSlider.setValue(parent.getPreferences().getSoundVolume());
        volumeSoundSlider.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                parent.getPreferences().setSoundVolume(volumeSoundSlider.getValue());
                return false;
            }
        });
        table.add(volumeSoundSlider).width(200).padBottom(30);
        table.row();

        // Sound on/off label and checkbox
        soundOnOffLabel = new Label("SES EFEKTLERI", skin);
        table.add(soundOnOffLabel).width(150).padRight(20);
        soundCheckbox = new CheckBox(null, skin);
        soundCheckbox.setChecked(parent.getPreferences().isSoundEffectsEnabled());
        soundCheckbox.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                boolean enabled = soundCheckbox.isChecked();
                parent.getPreferences().setSoundEffectsEnabled(enabled);
                return false;
            }
        });
        table.add(soundCheckbox).width(200).padBottom(30);
        table.row();

        // Back button
        backButton = new TextButton("ANA MENUYE DON", skin, "default");
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(MyGdxGame.MENU);
            }
        });
        table.add(backButton).colspan(2);

        stage.addActor(table);
    }


}

