package com.mygdx.galaxix;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Level1Screen extends ScreenAdapter {
    private Main game;
    private OrthographicCamera camera;
    private TiledMap map;
    private MapRenderer mapRenderer;
    private Texture background;
    private SpriteBatch batch;

    public Level1Screen(Main game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch = new SpriteBatch();
        //background = new Texture("2.png");
        map = new TmxMapLoader().load("maps/level1.tmx");
        mapRenderer = new OrthogonalTiledMapRenderer(map);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        mapRenderer.setView(camera);

        batch.setProjectionMatrix(camera.combined);
       // batch.begin();
       // batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //batch.end();

        mapRenderer.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
      //  background.dispose();
        map.dispose();
    }
}
