package com.mygdx.galaxix;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class GameButton extends TextButton {
    private Sound hoverSound;
    private Sound clickSound;
    private boolean isHovered = false;


    public GameButton(String text, Skin skin, String style, Runnable action) {
        super(text, skin, style);

        hoverSound = Gdx.audio.newSound(Gdx.files.internal("hoverMenu.wav"));
        clickSound = Gdx.audio.newSound(Gdx.files.internal("clickMenu.wav"));

        addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                clickSound.play();
                if (action != null) {
                    action.run();
                }
            }

            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                if (!isHovered) {
                    hoverSound.play();
                    isHovered = true;
                }
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                isHovered = false;
            }
        });
    }
    public void dispose() {
        hoverSound.dispose();
        clickSound.dispose();
    }
}
