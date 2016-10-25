package pl.miczeq.main.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import pl.miczeq.main.Main;

public class DesktopLauncher
{
	public static void main (String[] arg)
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Main.WIDTH;
		config.height = Main.HEIGHT;
		config.title = Main.TITLE;
		config.vSyncEnabled = true;
		config.foregroundFPS = 60;
		config.backgroundFPS = 60;
		new LwjglApplication(new Main(), config);
	}
}
