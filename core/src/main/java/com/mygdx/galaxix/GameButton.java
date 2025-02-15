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

    public GameButton(String text, Skin skin, String style, String hoverSoundPath, String clickSoundPath, Runnable action) {
        super(text, skin, style);

        hoverSound = Gdx.audio.newSound(Gdx.files.internal(hoverSoundPath));
        clickSound = Gdx.audio.newSound(Gdx.files.internal(clickSoundPath));

        addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                clickSound.play();
                if (action != null) {
                    action.run();
                }
            }

            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                hoverSound.play();
            }
        });
    }
    public void dispose() {
        hoverSound.dispose();
        clickSound.dispose();
    }
}
