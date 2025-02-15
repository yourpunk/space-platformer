package com.mygdx.galaxix;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MainMenuScreen implements Screen {
    private final Main game;
    private Stage stage;
    private Skin skin;
    private Music backgroundMusic;
    private Texture background;
    private Texture titleTexture;
    private SpriteBatch batch;
    private Sound hoverSound;
    private Sound clickSound;

    public MainMenuScreen(final Main game) {
        this.game = game;
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        batch = new SpriteBatch();
        background = new Texture("background.png");
        titleTexture = new Texture("title.png");

        skin = new Skin(Gdx.files.internal("ui.json"));

        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("mainMenu.mp3"));
        hoverSound = Gdx.audio.newSound(Gdx.files.internal("hoverMenu.wav"));
        clickSound = Gdx.audio.newSound(Gdx.files.internal("clickMenu.wav"));
        backgroundMusic.setLooping(true);
        backgroundMusic.setVolume(2f);
        backgroundMusic.play();
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);


        GameButton newGameButton = new GameButton("New Game", skin, "default",
                "hoverMenu.wav", "clickMenu.wav", () -> {
            System.out.println("Starting new game...");
        });

        GameButton loadGameButton = new GameButton("Load Game", skin, "default",
                "hoverMenu.wav", "clickMenu.wav", () -> {
            System.out.println("Loading game...");
        });

        GameButton exitButton = new GameButton("Exit", skin, "default",
                "hoverMenu.wav", "clickMenu.wav", () -> {
            Gdx.app.exit();
        });
        table.padTop(150);

        table.add(newGameButton).width(200).height(64).padBottom(16).row();
        table.add(loadGameButton).width(200).height(64).padBottom(16).row();
        table.add(exitButton).width(200).height(64).row();

    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        float titleHeight = Gdx.graphics.getHeight() / 4;
        float titleWidth = Gdx.graphics.getWidth() / 2.5f;
        float titleX = (Gdx.graphics.getWidth() - titleWidth) / 2;
        float titleY = (Gdx.graphics.getHeight() - titleHeight) / 1.2f;
        batch.draw(titleTexture, titleX, titleY, titleWidth, titleHeight);

        batch.end();

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
        background.dispose();
        backgroundMusic.dispose();
        batch.dispose();
    }
}
