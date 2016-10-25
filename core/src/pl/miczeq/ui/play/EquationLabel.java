package pl.miczeq.ui.play;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import pl.miczeq.assets.AssetsManager;
import pl.miczeq.main.Main;

/**
 * Created by Mikolaj on 25.10.2016.
 */
public class EquationLabel extends Label
{
    private ShapeRenderer sr;

    public EquationLabel(ShapeRenderer sr)
    {
        super("5 x 5", prepareLabelStyle());

        this.sr = sr;
        init();
    }

    private void init()
    {
        this.setPosition(20.0f, Main.HEIGHT - 200.0f);
        this.setSize(Main.WIDTH - 40.0f, 85.0f);
        this.setAlignment(Align.center);
        this.addAction(Actions.sequence(Actions.alpha(0.0f), Actions.fadeIn(1.0f, Interpolation.pow2)));

        Pixmap bg = new Pixmap((int) this.getWidth(), (int) this.getHeight(), Pixmap.Format.RGBA8888);

        bg.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
        bg.fill();

        this.getStyle().background = new Image(new Texture(bg)).getDrawable();
    }

    private static LabelStyle prepareLabelStyle()
    {
        LabelStyle style = new LabelStyle();
        style.font = AssetsManager.font100;
        style.fontColor = AssetsManager.colorGenerator.getColor();

        return style;
    }

    public void draw (Batch batch, float parentAlpha)
    {
        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(new Color(0.8f, 0.8f, 0.8f, 1.0f));
        sr.rect(this.getX() - 7.0f, this.getY() - 7.0f, this.getWidth() + 14.0f, this.getHeight() + 14.0f);
        sr.end();

        batch.setShader(AssetsManager.fontShader);
        super.draw(batch, parentAlpha);
        batch.setShader(null);
    }
}
