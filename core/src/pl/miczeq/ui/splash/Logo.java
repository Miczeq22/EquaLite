package pl.miczeq.ui.splash;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import pl.miczeq.assets.AssetsManager;
import pl.miczeq.main.Main;

/**
 * Created by Mikolaj on 25.10.2016.
 */
public class Logo extends Image
{
    public Logo(Main game)
    {
        super(AssetsManager.manager.get("leon.png", Texture.class));
        init(game);
    }

    private void init(Main game)
    {
        this.setPosition(Main.WIDTH / 2 - this.getWidth() / 2, Main.HEIGHT / 2);
        this.setOrigin(this.getWidth() / 2, this.getHeight() / 2);
        this.addAction(Actions.sequence(Actions.parallel(Actions.scaleTo(0.0f, 0.0f), Actions.alpha(0.0f)), Actions.parallel(Actions.scaleTo(3.0f, 3.0f, 2.0f, Interpolation.pow5),
                Actions.fadeIn(2.0f, Interpolation.pow2), Actions.moveTo(Main.WIDTH / 2 - this.getWidth() / 2, Main.HEIGHT / 2)), Actions.delay(1.0f), Actions.fadeOut(1.5f, Interpolation.exp10Out),
                Actions.run(changeState(game))));
    }

    private Runnable changeState(final Main game)
    {
        Runnable run = new Runnable()
        {
            @Override
            public void run()
            {
               // game.setScreen(new MenuState(game));
            }
        };

        return run;
    }
}
