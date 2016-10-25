package pl.miczeq.states;

import com.badlogic.gdx.math.Vector2;
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
    }

    public void render(float delta)
    {
        super.render(delta);
    }
}
