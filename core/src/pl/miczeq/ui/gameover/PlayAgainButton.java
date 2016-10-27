package pl.miczeq.ui.gameover;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import pl.miczeq.assets.AssetsManager;
import pl.miczeq.main.Main;
import pl.miczeq.ui.ClickCallback;

/**
 * Created by Mikolaj on 25.10.2016.
 */
public class PlayAgainButton extends TextButton
{
    private ShapeRenderer sr;

    private Skin skin;
    private Pixmap bg;

    public PlayAgainButton(ShapeRenderer sr, final ClickCallback callback)
    {
        super("Play Again", prepareButtonStyle());
        init(callback);

        this.sr = sr;
    }

    private void init(final ClickCallback callback)
    {
        this.setSize((Main.WIDTH - 60.0f) / 2, this.getHeight() + 50.0f);
        this.setPosition(20.0f, 180.0f);

        this.addListener(new ClickListener()
        {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                AssetsManager.colorGenerator.getRandomColor();
                callback.onClick();
                return super.touchDown(event, x, y, pointer, button);
            }
        });

        skin = new Skin();
        bg = new Pixmap(100, 100, Pixmap.Format.RGBA8888);
        bg.setColor(new Color(0.6f, 0.6f, 0.6f, 1.0f));
        bg.fill();
        skin.add("grayBG", new Texture(bg));
        this.getLabel().setAlignment(Align.center);

        this.getStyle().up = skin.newDrawable("grayBG", new Color(1.0f, 1.0f, 1.0f, 1.0f));
        this.getStyle().down = skin.newDrawable("grayBG", new Color(0.75f, 0.75f, 0.75f, 1.0f));

        this.getLabel().setAlignment(Align.center);
    }

    private static TextButtonStyle prepareButtonStyle()
    {
        TextButtonStyle style = new TextButtonStyle();
        style.font = AssetsManager.font38;
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
