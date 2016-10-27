package pl.miczeq.ui.splash;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import pl.miczeq.assets.AssetsManager;
import pl.miczeq.main.Main;

/**
 * Created by Mikolaj on 27.10.2016.
 */
public class StudioNameLabel extends Label
{
    public StudioNameLabel()
    {
        super("LionBit", prepareLabelStyle());
        init();
    }

    private void init()
    {
        this.setPosition(Main.WIDTH / 2 - this.getWidth() / 2, - this.getHeight());
        this.addAction(Actions.sequence(Actions.alpha(0.0f), Actions.delay(0.5f),
                Actions.parallel(Actions.moveTo(Main.WIDTH / 2 - this.getWidth() / 2, Main.HEIGHT / 2 - 150, 1.5f, Interpolation.exp10), Actions.fadeIn(2.0f, Interpolation.pow3)),
                Actions.fadeOut(1.0f, Interpolation.pow2)));
    }

    private static LabelStyle prepareLabelStyle()
    {
        LabelStyle style = new LabelStyle();
        style.font = AssetsManager.font50;
        style.fontColor = Color.WHITE;

        return style;
    }

    public void draw(Batch batch, float parentAlpha)
    {
        batch.setShader(AssetsManager.fontShader);
            super.draw(batch, parentAlpha);
        batch.setShader(null);
    }
}
