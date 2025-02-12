package com.mygdx.galaxix.lwjgl2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.galaxix.Main;

public class DesktopLauncher {
    public static void main(String[] args) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "GalaxiX";
        config.width = 960;
        config.height = 540;
        new LwjglApplication(new Main(), config);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Closing game...");
            if (Gdx.app != null) {
                Gdx.app.exit();
            }
        }));
    }
}
