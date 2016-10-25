package pl.miczeq.main;

import com.badlogic.gdx.Game;
import pl.miczeq.assets.AssetsManager;
import pl.miczeq.states.LoadingState;

public class Main extends Game
{
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	public static final String TITLE = "EquaLite";

	public static final String GAME_PREFS = "pl.miczeq.equalite.prefs";
	public static final String GAME_HIGHSCORE = "pl.miczeq.equalite.prefs.highscore";
	public static final String GAME_SCORE = "pl.miczeq.equalite.prefs.score";


	public void create ()
	{
		this.setScreen(new LoadingState(this));
	}

	public void dispose()
	{
		AssetsManager.dispose();
	}

}
