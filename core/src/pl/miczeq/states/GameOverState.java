package pl.miczeq.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import pl.miczeq.assets.AssetsManager;
import pl.miczeq.main.Main;

/**
 * Created by Mikolaj on 25.10.2016.
 */
public class GameOverState extends State
{
    public GameOverState(Main game)
    {
        super(game);
    }

    public void update(float delta)
    {
        super.update(delta);
    }

    public void render(float delta)
    {
        Gdx.gl.glClearColor(AssetsManager.colorGenerator.getColor().r, AssetsManager.colorGenerator.getColor().g, AssetsManager.colorGenerator.getColor().b, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);

        batch.begin();
            stage.draw();
        batch.end();
    }
}
