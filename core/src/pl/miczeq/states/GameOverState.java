package pl.miczeq.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import pl.miczeq.assets.AssetsManager;
import pl.miczeq.main.Main;
import pl.miczeq.ui.ClickCallback;
import pl.miczeq.ui.gameover.ExitButton;
import pl.miczeq.ui.gameover.PlayAgainButton;
import pl.miczeq.ui.gameover.ScoreLabel;

/**
 * Created by Mikolaj on 25.10.2016.
 */
public class GameOverState extends State
{
    private ScoreLabel scoreLabel;
    private PlayAgainButton playAgainButton;
    private ExitButton exitButton;

    public GameOverState(Main game)
    {
        super(game);
        init();
    }

    private void init()
    {
        initScoreLabel();
        initPlayAgainButton();
        initExitButton();
    }

    private void initPlayAgainButton()
    {
        playAgainButton = new PlayAgainButton(sr, new ClickCallback()
        {
            @Override
            public void onClick()
            {
                game.setScreen(new PlayState(game));
            }
        });
        stage.addActor(playAgainButton);
    }

    private void initExitButton()
    {
        exitButton = new ExitButton(sr, new ClickCallback()
        {
            @Override
            public void onClick()
            {
                Gdx.app.exit();
            }
        });
        stage.addActor(exitButton);
    }

    private void initScoreLabel()
    {
        scoreLabel = new ScoreLabel(sr, AssetsManager.preferences.getInteger(Main.GAME_SCORE), AssetsManager.preferences.getInteger(Main.GAME_HIGHSCORE));
        stage.addActor(scoreLabel);
    }

    public void update(float delta)
    {
        super.update(delta);

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
    }
}
