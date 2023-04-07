package com.mygdx.game.views;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Interpolation;
import com.mygdx.game.MyGdxGame;

public class LoadingScreen implements Screen {

    private MyGdxGame parent;

    public LoadingScreen(MyGdxGame myGdxGame){
        parent = myGdxGame;

    }

    @Override
    public void show() {
        System.out.println("Loading Screen");
    }

    @Override
    public void render(float delta) {
        parent.changeScreen(MyGdxGame.MENU);
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

