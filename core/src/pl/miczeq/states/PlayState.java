package pl.miczeq.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.MathUtils;
import pl.miczeq.assets.AssetsManager;
import pl.miczeq.logic.EquationAlgorithm;
import pl.miczeq.main.Main;
import pl.miczeq.ui.ClickCallback;
import pl.miczeq.ui.play.EquationLabel;
import pl.miczeq.ui.play.ResultButton;
import pl.miczeq.ui.play.ScoreLabel;
import pl.miczeq.ui.play.TimerLabel;

/**
 * Created by Mikolaj on 25.10.2016.
 */
public class PlayState extends State
{
    private boolean firstClick;
    private boolean onLeft;

    private ResultButton leftButton;
    private ResultButton rightButton;
    private EquationLabel equationLabel;
    private TimerLabel timerLabel;
    private ScoreLabel scoreLabel;

    private EquationAlgorithm equationAlgorithm;

    public PlayState(Main game)
    {
        super(game);

        init();
    }

    private void init()
    {
        firstClick = false;
        onLeft = MathUtils.randomBoolean();

        equationAlgorithm = new EquationAlgorithm();

        initLeftButton();
        initRightButton();
        initEquationLabel();
        initTimerLabel();
        initScoreLabel();
    }

    private void initScoreLabel()
    {
        scoreLabel = new ScoreLabel();
        stage.addActor(scoreLabel);
    }

    private void initTimerLabel()
    {
        timerLabel = new TimerLabel(sr);
        stage.addActor(timerLabel);
    }

    private void initLeftButton()
    {
        leftButton = new ResultButton(sr, new ClickCallback()
        {
            @Override
            public void onClick()
            {
                firstClick = true;
            }
        });

        leftButton.setX(20.0f);
        leftButton.setText(onLeft ? equationAlgorithm.getResult() + "" : equationAlgorithm.getFakeResult() + "");

        stage.addActor(leftButton);
    }

    private void initRightButton()
    {
        rightButton = new ResultButton(sr, new ClickCallback()
        {
            @Override
            public void onClick()
            {
                firstClick = true;
            }
        });

        rightButton.setX(Main.WIDTH - rightButton.getWidth() - 20.0f);
        rightButton.setText(!onLeft ? equationAlgorithm.getResult() + "" : equationAlgorithm.getFakeResult() + "");

        stage.addActor(rightButton);
    }

    private void initEquationLabel()
    {
        equationLabel = new EquationLabel(sr);
        equationLabel.setText(equationAlgorithm.getEquation());
        stage.addActor(equationLabel);
    }

    private void goodClickAction()
    {
        
    }

    public void update(float delta)
    {
        super.update(delta);

        timerLabel.update(delta, firstClick);
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
