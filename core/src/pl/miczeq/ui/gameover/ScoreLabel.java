package pl.miczeq.ui.gameover;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import pl.miczeq.assets.AssetsManager;
import pl.miczeq.main.Main;

/**
 * Created by Mikolaj on 25.10.2016.
 */
public class ScoreLabel extends Label
{
    private ShapeRenderer sr;

    public ScoreLabel(ShapeRenderer sr, int score, int highscore)
    {
        super(score == highscore ? "You Lose\n\nScore:" + score + "\nHighscore:" + highscore + "\n\nNew Higscore!\nCongratulations!" : "You Lose\n\nScore:" + score + "\nHighscore:" + highscore, prepareLabelStyle());
        init();
        this.sr = sr;
    }

    private void init()
    {
        this.setSize(Main.WIDTH - 40.0f, this.getHeight() + 150.0f);
        this.setPosition(20.0f, Main.HEIGHT / 2 - 100.0f);
        this.setAlignment(Align.center);

        Pixmap bg = new Pixmap((int) this.getWidth(), (int) this.getHeight(), Pixmap.Format.RGBA8888);
        bg.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
        bg.fill();

        this.getStyle().background = new Image(new Texture(bg)).getDrawable();
    }

    private static LabelStyle prepareLabelStyle()
    {
        LabelStyle style = new LabelStyle();
        style.font = AssetsManager.font45;
        style.fontColor = AssetsManager.colorGenerator.getColor();

        return style;
    }

    public void draw(Batch batch, float parentAlpha)
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
