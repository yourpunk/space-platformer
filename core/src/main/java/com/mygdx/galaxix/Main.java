package com.mygdx.galaxix;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class Main extends Game {
    @Override
    public void create() {

        this.setScreen(new MainMenuScreen(this));
    }
}
