package pl.miczeq.ui.play;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import pl.miczeq.assets.AssetsManager;
import pl.miczeq.main.Main;

/**
 * Created by Mikolaj on 25.10.2016.
 */
public class ScoreLabel extends Label
{
    public ScoreLabel()
    {
        super("Score: 1001", prepareLabelStyle());
        init();
    }

    private void init()
    {
        this.setPosition(Main.WIDTH - this.getWidth() - 38.0f, 60.0f);
        this.addAction(Actions.sequence(Actions.alpha(0.0f), Actions.fadeIn(1.0f, Interpolation.pow2)));
    }

    private static LabelStyle prepareLabelStyle()
    {
        LabelStyle style = new LabelStyle();
        style.font = AssetsManager.font38;
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
