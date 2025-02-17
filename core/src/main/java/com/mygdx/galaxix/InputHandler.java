package com.mygdx.galaxix;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;

public class InputHandler implements InputProcessor {
    private boolean inMenu = true; // Флаг состояния
    private Runnable onStartGame; // Callback для старта игры

    public InputHandler(Runnable onStartGame) {
        this.onStartGame = onStartGame;
    }

    public void setInMenu(boolean inMenu) {
        this.inMenu = inMenu;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (inMenu) {
            return handleMenuInput(keycode);
        } else {
            return handlePlayerInput(keycode);
        }
    }

    private boolean handleMenuInput(int keycode) {
        if (keycode == Input.Keys.ENTER) {
            onStartGame.run();
            return true;
        }
        return false;
    }

    private boolean handlePlayerInput(int keycode) {
        if (keycode == Input.Keys.LEFT) {
            System.out.println("Move left");
        } else if (keycode == Input.Keys.RIGHT) {
            System.out.println("Move right");
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) { return false; }
    @Override
    public boolean keyTyped(char character) { return false; }
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) { return false; }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) { return false; }

    @Override
    public boolean touchCancelled(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) { return false; }
    @Override
    public boolean mouseMoved(int screenX, int screenY) { return false; }
    @Override
    public boolean scrolled(float amountX, float amountY) { return false; }
}
