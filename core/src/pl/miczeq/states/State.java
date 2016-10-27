package pl.miczeq.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import pl.miczeq.assets.AssetsManager;
import pl.miczeq.main.Main;

/**
 * Created by Mikolaj on 25.10.2016.
 */
public class State implements Screen
{
    protected Main game;
    protected OrthographicCamera camera;
    protected Stage stage;
    protected SpriteBatch batch;
    protected ShapeRenderer sr;

    public State(Main game)
    {
        this.game = game;
        createCamera();
        stage = new Stage(new StretchViewport(Main.WIDTH, Main.HEIGHT, camera));
        batch = new SpriteBatch();
        sr = new ShapeRenderer();

        Gdx.input.setInputProcessor(stage);
        Gdx.input.setCatchBackKey(true);
    }

    private void createCamera()
    {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Main.WIDTH, Main.HEIGHT);
        camera.update();
    }

    public void update(float delta)
    {
        batch.setProjectionMatrix(camera.combined);
        sr.setProjectionMatrix(camera.combined);

        stage.act(delta);
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(AssetsManager.colorGenerator.getDarkerColor().r, AssetsManager.colorGenerator.getDarkerColor().g, AssetsManager.colorGenerator.getDarkerColor().b, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);

        batch.begin();
            stage.draw();
        batch.end();
    }

    @Override
    public void show()
    {

    }


    @Override
    public void resize(int width, int height)
    {

    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void hide()
    {

    }

    @Override
    public void dispose()
    {
        game.dispose();
        stage.dispose();
        sr.dispose();
        batch.dispose();
    }
}
