package pl.miczeq.ui.play;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import pl.miczeq.assets.AssetsManager;
import pl.miczeq.main.Main;

/**
 * Created by Mikolaj on 25.10.2016.
 */
public class TimerLabel extends Label
{
    private float time;
    private ShapeRenderer sr;

    public TimerLabel(ShapeRenderer sr)
    {
        super("", prepareLabelStyle());
        this.sr = sr;

        init();
    }

    private void init()
    {
        time = 1.0f;

        this.setPosition(20.0f, Main.HEIGHT - 60.0f);
        this.setSize(Main.WIDTH - 40.0f, 40.0f);
    }

    private static Label.LabelStyle prepareLabelStyle()
    {
        Label.LabelStyle style = new Label.LabelStyle();
        style.font = AssetsManager.font38;

        return style;
    }

    public void update(float delta, boolean start)
    {
        if(start && time > 0.0f)
        {
            time -= delta * 0.13f;
        }
    }

    public void resetTimer()
    {
        time = 1.0f;
    }

    public void draw(Batch batch, float parentAlpha)
    {
        sr.begin(ShapeRenderer.ShapeType.Filled);

        sr.setColor(new Color(0.8f, 0.8f, 0.8f, 1.0f));
        sr.rect(this.getX() - 7.0f, this.getY() -7.0f, this.getWidth() + 14.0f, this.getHeight() + 14.0f);

        sr.setColor(Color.WHITE);
        sr.rect(this.getX(), this.getY(), this.getWidth(), this.getHeight());

        if((this.getWidth() * time) > this.getWidth() * 0.8f)
        {
            sr.setColor(new Color(0.4f, 1.0f, 0.4f, 1.0f));
        }
        else if((this.getWidth() * time > this.getWidth() * 0.5f) && (this.getWidth() * time < this.getWidth() * 0.8f))
        {
            sr.setColor(new Color(0.7f, 1.0f, 0.4f, 1.0f));
        }
        else if((this.getWidth() * time > this.getWidth() * 0.3f) && (this.getWidth() * time < this.getWidth() * 0.5f))
        {
            sr.setColor(new Color(1.0f, 0.7f, 0.4f, 1.0f));
        }
        else
        {
            sr.setColor(new Color(1.0f, 0.4f, 0.4f, 1.0f));
        }
        sr.rect(this.getX(), this.getY(), this.getWidth() * time, this.getHeight());
        sr.end();


        batch.setShader(AssetsManager.fontShader);
        super.draw(batch, parentAlpha);
        batch.setShader(null);
    }
}
