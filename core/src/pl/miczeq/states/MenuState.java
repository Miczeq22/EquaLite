package pl.miczeq.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import pl.miczeq.main.Main;
import pl.miczeq.ui.menu.Border;
import pl.miczeq.ui.menu.PlayLabel;

/**
 * Created by Mikolaj on 25.10.2016.
 */
public class MenuState extends State
{
    private Border leftBorder;
    private Border rightBorder;
    private PlayLabel playLabel;

    public MenuState(Main game)
    {
        super(game);
        init();
    }

    private void init()
    {
        initLeftBorder();
        initRightBorder();
        initPlayLabel();
    }

    private void initLeftBorder()
    {
        leftBorder = new Border(new Vector2(-Border.BORDER_WIDTH / 2, 0.0f), new Vector2(-Border.BORDER_WIDTH, 0.0f));
        stage.addActor(leftBorder);
    }

    private void initRightBorder()
    {
        rightBorder = new Border(new Vector2(Main.WIDTH - Border.BORDER_WIDTH / 2, 0.0f), new Vector2(Main.WIDTH, 0.0f));
        stage.addActor(rightBorder);
    }

    private void initPlayLabel()
    {
        playLabel = new PlayLabel();
        stage.addActor(playLabel);
    }

    public void update(float delta)
    {
        super.update(delta);

        if(Gdx.input.isTouched() && leftBorder.isAnimDone())
        {
            playLabel.addAction(Actions.hide());
            leftBorder.addAction(Actions.moveTo(0.0f, 0.0f, 2.0f, Interpolation.pow5));
            rightBorder.addAction(Actions.sequence(Actions.moveTo(Main.WIDTH / 2, 0.0f, 2.0f, Interpolation.pow5), Actions.run(stateChange())));
        }
    }

    private Runnable stateChange()
    {
        Runnable run = new Runnable()
        {
            @Override
            public void run()
            {
                game.setScreen(new PlayState(game));
            }
        };

        return run;
    }

    public void render(float delta)
    {
        super.render(delta);
    }
}
