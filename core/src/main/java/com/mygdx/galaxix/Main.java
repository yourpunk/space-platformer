package com.mygdx.galaxix;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
        private SpriteBatch batch;
        private Texture backgroundTexture;
        private Texture titleTexture;
        @Override
        public void create() {
            batch = new SpriteBatch();
            backgroundTexture = new Texture("background.png");
            titleTexture = new Texture("title.png");
            System.out.println("Game started!");
        }

        @Override
        public void render() {
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            batch.begin();
            batch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            float titleWidth = titleTexture.getWidth() * 0.4f;
            float titleHeight = titleTexture.getHeight() * 0.4f;
            float titleX = (Gdx.graphics.getWidth() - titleWidth) / 2;
            float titleY = (Gdx.graphics.getHeight() - titleHeight) / 1.2f;
            batch.draw(titleTexture, titleX, titleY, titleWidth, titleHeight);

            batch.end();
        }

        @Override
        public void dispose() {
            batch.dispose();
            backgroundTexture.dispose();
            System.out.println("Game ended!");
        }
}
