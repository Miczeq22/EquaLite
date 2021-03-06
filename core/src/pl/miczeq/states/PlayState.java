package pl.miczeq.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
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
    private boolean over;

    private ResultButton leftButton;
    private ResultButton rightButton;
    private EquationLabel equationLabel;
    private TimerLabel timerLabel;
    private ScoreLabel scoreLabel;

    private int score;

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
        score = 0;
        over = false;

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
                if(!over)
                {
                    firstClick = true;

                    if (onLeft)
                    {
                        goodClickAction();
                    } else
                    {
                        wrongClickAction(leftButton);
                    }
                }
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
                if(!over)
                {
                    firstClick = true;

                    if (!onLeft)
                    {
                        goodClickAction();
                    } else
                    {
                        wrongClickAction(rightButton);
                    }
                }
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
        if(score >= 20)
        {
            int hard = MathUtils.random(0, 2);

            switch(hard)
            {
                case 0:
                {
                    equationAlgorithm.createSimpleEquation();
                }break;


                case 1:
                {
                    equationAlgorithm.createHardEquation();
                }break;

                case 2:
                {
                    equationAlgorithm.createBracketsEquation();
                }break;
            }
        }
        else
        {
            equationAlgorithm.createSimpleEquation();
        }

        equationLabel.setText(equationAlgorithm.getEquation());
        onLeft = MathUtils.randomBoolean();
        rightButton.setText(!onLeft ? equationAlgorithm.getResult() + "" : equationAlgorithm.getFakeResult() + "");
        leftButton.setText(onLeft ? equationAlgorithm.getResult() + "" : equationAlgorithm.getFakeResult() + "");
        timerLabel.resetTimer();
        score++;
    }

    private void wrongClickAction(ResultButton button)
    {
        over = true;
        equationAlgorithm.setPow(false);
        equationLabel.setScale(0.5f);
        equationLabel.setText("YOU LOSE");
        equationLabel.getStyle().fontColor = new Color(1.0f, 0.2f, 0.2f, 1.0f);
        firstClick = false;

        int highscore = AssetsManager.preferences.getInteger(Main.GAME_HIGHSCORE);
        AssetsManager.preferences.putInteger(Main.GAME_SCORE, score);
        if(score > highscore)
        {
            AssetsManager.preferences.putInteger(Main.GAME_HIGHSCORE, score);
        }
        AssetsManager.preferences.flush();

        if(button != null)
        {
            button.getStyle().fontColor = new Color(1.0f, 0.2f, 0.2f, 1.0f);
            button.addAction(Actions.sequence(Actions.delay(2.0f), Actions.run(changeToGameOverState())));
        }
        else
        {
            equationLabel.addAction(Actions.sequence(Actions.delay(2.0f), Actions.run(changeToGameOverState())));
        }
    }

    private Runnable changeToGameOverState()
    {
        Runnable run = new Runnable()
        {
            @Override
            public void run()
            {
                game.setScreen(new GameOverState(game));
            }
        };

        return run;
    }

    public void update(float delta)
    {
        super.update(delta);

        timerLabel.update(delta, firstClick);
        scoreLabel.setText("Score: " + score);

        if(timerLabel.isTimerEnd())
        {
            wrongClickAction(null);
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.BACK))
        {
            AssetsManager.colorGenerator.getRandomColor();
            game.setScreen(new MenuState(game));
        }
    }

    public void render(float delta)
    {
        Gdx.gl.glClearColor(AssetsManager.colorGenerator.getColor().r, AssetsManager.colorGenerator.getColor().g, AssetsManager.colorGenerator.getColor().b, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);

        batch.begin();
            stage.draw();
        batch.end();

        if(equationAlgorithm.isPow())
        {
            batch.setShader(AssetsManager.fontShader);
            batch.begin();
                AssetsManager.font38.setColor(AssetsManager.colorGenerator.getColor());
                AssetsManager.font38.draw(batch, "2", 200, Main.HEIGHT - 120);
            batch.end();
            batch.setShader(null);
        }
    }
}
