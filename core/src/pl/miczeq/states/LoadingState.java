package pl.miczeq.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import pl.miczeq.assets.AssetsManager;
import pl.miczeq.main.Main;

/**
 * Created by Mikolaj on 11.10.2016.
 */
public class LoadingState extends State
{
    private float progress;
    private Vector2 progressBarPosition;
    private Vector2 progressBarSize;

    public LoadingState(Main game)
    {
        super(game);
        init();
    }

    private void init()
    {
        AssetsManager.load();

        progress = 0.0f;
        progressBarPosition = new Vector2(27.0f, Main.HEIGHT / 2);
        progressBarSize = new Vector2(Main.WIDTH - (2 * progressBarPosition.x), 50.0f);
    }

    public void update(float delta)
    {
        super.update(delta);

        progress = MathUtils.lerp(progress, AssetsManager.manager.getProgress(), 0.1f);

        if(AssetsManager.manager.update() && (progress >= AssetsManager.manager.getProgress() - 0.01f))
        {
           // game.setScreen(new SplashState(game));
        }
    }

    public void render(float delta)
    {
        super.render(delta);

        drawProgressBar();
    }

    private void drawProgressBar()
    {
        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(Color.WHITE);
        sr.rect(20.0f, progressBarPosition.y - 7.0f, progressBarSize.x + (2 * (progressBarPosition.x - 20.0f)), progressBarSize.y + 14.0f);

        sr.setColor(new Color(0.7f, 0.7f, 0.7f, 1.0f));
        sr.rect(progressBarPosition.x, progressBarPosition.y, progressBarSize.x, progressBarSize.y);

        sr.setColor(new Color(0.25f, 0.25f, 0.25f, 1.0f));
        sr.rect(progressBarPosition.x, progressBarPosition.y, progress * progressBarSize.x, progressBarSize.y);
        sr.end();
    }
}
