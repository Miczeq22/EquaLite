package pl.miczeq.ui.menu;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import pl.miczeq.assets.AssetsManager;
import pl.miczeq.main.Main;

/**
 * Created by Mikolaj on 27.10.2016.
 */
public class LogoLabel extends Label
{
    public LogoLabel()
    {
        super("EquaLite", prepareLabelStyle());
        init();
    }

    private void init()
    {
        this.setPosition(Main.WIDTH / 2 - this.getWidth() / 2, Main.HEIGHT - this.getHeight() - 40.0f);
        this.addAction(Actions.sequence(Actions.alpha(0.0f), Actions.fadeIn(1.5f, Interpolation.pow3)));
    }

    private static LabelStyle prepareLabelStyle()
    {
        LabelStyle style = new LabelStyle();
        style.font = AssetsManager.font45;

        return style;
    }

    public void draw(Batch batch, float parentAlpha)
    {
        batch.setShader(AssetsManager.fontShader);
            super.draw(batch, parentAlpha);
        batch.setShader(null);
    }
}
