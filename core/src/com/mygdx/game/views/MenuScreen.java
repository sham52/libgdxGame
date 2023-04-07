package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;

import javax.swing.event.ChangeEvent;


public class MenuScreen implements Screen {

    private MyGdxGame parent;
    private Stage stage;
    private Skin skin;

    public MenuScreen(MyGdxGame myGdxGame) {
        parent = myGdxGame;
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void show() {
        //Create a table to hold buttons
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);
        System.out.println("Ana Menü");
        skin = parent.getSkin();
        //Add buttons to the table
        TextButton newGame = new TextButton("Yeni Oyun", skin);
        TextButton preferences = new TextButton("Ayarlar", skin);
        TextButton exit = new TextButton("CIKIS", skin);

        table.setDebug(false);
        table.add(newGame).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(preferences).fillX().uniformX();
        table.row();
        table.add(exit).fillX().uniformX();

        //exit button
        exit.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });
        //newGame button
        newGame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(MyGdxGame.APPLICATION);
            }
        });
        preferences.addListener(new ClickListener(){
             @Override
            public void clicked(InputEvent event, float x, float y){
                 parent.changeScreen(MyGdxGame.PREFERENCES);
             }
        });

    }

        @Override
        public void render ( float delta){
            Gdx.gl.glClearColor(0f, 0f, 0f, 01);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
            stage.draw();
        }

        @Override
        public void resize ( int width, int height){
            stage.getViewport().update(width, height, true);
        }

        @Override
        public void pause () {

        }

        @Override
        public void resume () {

        }

        @Override
        public void hide () {

        }

        @Override
        public void dispose () {
            stage.dispose();
        }
    }
