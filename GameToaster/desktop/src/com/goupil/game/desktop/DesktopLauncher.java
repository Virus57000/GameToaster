package com.goupil.game.desktop;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.goupil.game.GameToasterRun;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Game Toaster";
                config.width = 1280;
                config.height = 720;
                config.foregroundFPS = 62;
                config.backgroundFPS = -1;
                new LwjglApplication(new GameToasterRun(), config);
	}
}
