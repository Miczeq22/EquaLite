package pl.miczeq.ui.menu;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import pl.miczeq.assets.AssetsManager;
import pl.miczeq.main.Main;

/**
 * Created by Mikolaj on 23.10.2016.
 */
public class PlayLabel extends Label
{
    public PlayLabel()
    {
        super("Touch to play!", prepareLabelStyle());
        init();
    }

    private void init()
    {
        this.setPosition(Main.WIDTH / 2 - this.getWidth() / 2, Main.HEIGHT / 2);
        this.addAction(Actions.sequence(Actions.alpha(0.0f), Actions.delay(1.0f), Actions.forever(Actions.sequence(Actions.fadeIn(1.1f, Interpolation.pow5),
                Actions.fadeOut(1.1f,Interpolation.pow5)))));
    }

    private static LabelStyle prepareLabelStyle()
    {
        LabelStyle style = new LabelStyle();
        style.font = AssetsManager.font38;

        return style;
    }

    public void draw(Batch batch, float parentAlpha)
    {
        batch.setShader(AssetsManager.fontShader);
        super.draw(batch, parentAlpha);
        batch.setShader(null);
    }
}
