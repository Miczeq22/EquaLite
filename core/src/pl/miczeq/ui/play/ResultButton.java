package pl.miczeq.ui.play;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
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
public class ResultButton extends TextButton
{
    private static Skin skin;
    private Pixmap grayBG;
    private ShapeRenderer sr;
    private boolean clicked;

    public ResultButton(ShapeRenderer sr, final ClickCallback callback)
    {
        super("-10", preprareButtonStyle());
        init(callback);
        this.sr = sr;
    }

    private void init(final ClickCallback callback)
    {
        clicked = false;
        this.setSize(this.getWidth() + 30.0f, this.getHeight() + 180.0f);
        this.setPosition(Main.WIDTH / 2 - this.getWidth() / 2, Main.HEIGHT / 2);
        this.addListener(new ClickListener()
        {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                clicked = true;
                callback.onClick();
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button)
            {
                clicked = false;
                super.touchUp(event, x, y, pointer, button);
            }
        });

        this.addAction(Actions.sequence(Actions.alpha(0.0f), Actions.fadeIn(1.0f, Interpolation.pow2)));

        skin = new Skin();
        grayBG = new Pixmap(100, 100, Pixmap.Format.RGBA8888);
        grayBG.setColor(new Color(0.6f, 0.6f, 0.6f, 1.0f));
        grayBG.fill();
        skin.add("grayBG", new Texture(grayBG));
        this.getLabel().setAlignment(Align.center);

        this.getStyle().up = skin.newDrawable("grayBG", new Color(1.0f, 1.0f, 1.0f, 1.0f));
        this.getStyle().down = skin.newDrawable("grayBG", new Color(0.75f, 0.75f, 0.75f, 1.0f));
    }

    private static TextButton.TextButtonStyle preprareButtonStyle()
    {
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = AssetsManager.font120;
        style.fontColor = AssetsManager.colorGenerator.getColor();

        return style;
    }

    public void draw (Batch batch, float parentAlpha)
    {
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        //simple shadow drop
        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(clicked ? new Color(0.4f, 0.4f, 0.4f, 1.0f) : new Color(0.8f, 0.8f, 0.8f, 1.0f));
        sr.rect(this.getX(), this.getY() - 7.0f, this.getWidth() + 7.0f, this.getHeight() + 7.0f);
        sr.end();

        batch.setShader(AssetsManager.fontShader);
        Color fontColor;
        if (isDisabled() && this.getStyle().disabledFontColor != null)
            fontColor = this.getStyle().disabledFontColor;
        else if (isPressed() && this.getStyle().downFontColor != null)
            fontColor = this.getStyle().downFontColor;
        else if (this.isChecked() && this.getStyle().checkedFontColor != null)
            fontColor = (isOver() && this.getStyle().checkedOverFontColor != null) ? this.getStyle().checkedOverFontColor : this.getStyle().checkedFontColor;
        else if (isOver() && this.getStyle().overFontColor != null)
            fontColor = this.getStyle().overFontColor;
        else
            fontColor = this.getStyle().fontColor;
        if (fontColor != null) this.getStyle().fontColor = fontColor;
        super.draw(batch, parentAlpha);
        batch.setShader(null);

        Gdx.gl.glDisable(GL20.GL_BLEND);
    }
}
