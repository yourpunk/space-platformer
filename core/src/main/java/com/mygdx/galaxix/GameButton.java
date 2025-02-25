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
    private Runnable action;


    public GameButton(String text, Skin skin, String style, Runnable action) {
        super(text, skin, style);
        this.action = action;

        hoverSound = Gdx.audio.newSound(Gdx.files.internal("music/hoverMenu.wav"));
        clickSound = Gdx.audio.newSound(Gdx.files.internal("music/clickMenu.wav"));
        addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                clickSound.play(0.3f);
                if (action != null) {
                    action.run();
                }
            }

            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                if (!isHovered) {
                    hoverSound.play(0.5f);
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
