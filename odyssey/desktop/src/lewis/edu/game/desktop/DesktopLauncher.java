package lewis.edu.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import lewis.edu.game.OdysseyGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "OdysseyAdventures";
		//config.useGL20 = false;
		config.width = 800;
		config.height = 480;
		new LwjglApplication(new OdysseyGame(), config);
	}
}
