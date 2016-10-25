package pl.miczeq.ui.menu;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import pl.miczeq.assets.AssetsManager;
import pl.miczeq.main.Main;

/**
 * Created by Mikolaj on 25.10.2016.
 */
public class Border extends Image
{
    public static final float BORDER_WIDTH = Main.WIDTH / 2;

    private boolean animDone;

    public Border(Vector2 position, Vector2 oldPosition)
    {
        super(AssetsManager.manager.get("rect.png", Texture.class));
        init(position, oldPosition);
    }

    private void init(Vector2 position, Vector2 oldPosition)
    {
        animDone = false;
        this.setPosition(oldPosition.x, oldPosition.y);
        this.setColor(AssetsManager.colorGenerator.getColor());
        this.setSize(BORDER_WIDTH, Main.HEIGHT);
        this.addAction(Actions.sequence(Actions.alpha(0.0f), Actions.parallel(Actions.moveTo(position.x, position.y, 2.0f, Interpolation.bounceOut),
                Actions.fadeIn(1.0f, Interpolation.pow2)), Actions.run(done())));
    }

    private Runnable done()
    {
        Runnable run = new Runnable()
        {
            @Override
            public void run()
            {
                animDone = true;
            }
        };

        return run;
    }

    public boolean isAnimDone()
    {
        return animDone;
    }
}
