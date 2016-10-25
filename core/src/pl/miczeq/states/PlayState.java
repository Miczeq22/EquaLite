package pl.miczeq.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import pl.miczeq.assets.AssetsManager;
import pl.miczeq.main.Main;
import pl.miczeq.ui.ClickCallback;
import pl.miczeq.ui.play.EquationLabel;
import pl.miczeq.ui.play.ResultButton;

/**
 * Created by Mikolaj on 25.10.2016.
 */
public class PlayState extends State
{
    private ResultButton leftButton;
    private ResultButton rightButton;
    private EquationLabel equationLabel;

    public PlayState(Main game)
    {
        super(game);

        init();
    }

    private void init()
    {
        initLeftButton();
        initRightButton();
        initEquationLabel();
    }

    private void initLeftButton()
    {
        leftButton = new ResultButton(sr, new ClickCallback()
        {
            @Override
            public void onClick()
            {

            }
        });

        leftButton.setX(20.0f);

        stage.addActor(leftButton);
    }

    private void initRightButton()
    {
        rightButton = new ResultButton(sr, new ClickCallback()
        {
            @Override
            public void onClick()
            {

            }
        });

        rightButton.setX(Main.WIDTH - rightButton.getWidth() - 20.0f);

        stage.addActor(rightButton);
    }

    private void initEquationLabel()
    {
        equationLabel = new EquationLabel(sr);
        stage.addActor(equationLabel);
    }

    public void update(float delta)
    {
        super.update(delta);
    }

    public void render(float delta)
    {
        Gdx.gl.glClearColor(AssetsManager.colorGenerator.getColor().r, AssetsManager.colorGenerator.getColor().g, AssetsManager.colorGenerator.getColor().b, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);

        batch.begin();
            stage.draw();
        batch.end();
    }
}
