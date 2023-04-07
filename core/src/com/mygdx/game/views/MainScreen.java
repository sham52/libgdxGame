package com.mygdx.game.views;

import com.badlogic.gdx.Screen;
import com.mygdx.game.MyGdxGame;

public class MainScreen implements Screen{

    private MyGdxGame parent;

    public MainScreen(MyGdxGame myGdxGame){
        parent = myGdxGame;
    }

    @Override
    public void show() {
        System.out.println("Main Screen");
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
}
