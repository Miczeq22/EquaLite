package pl.miczeq.states;

import pl.miczeq.main.Main;
import pl.miczeq.ui.splash.Logo;
import pl.miczeq.ui.splash.StudioNameLabel;

/**
 * Created by Mikolaj on 25.10.2016.
 */
public class SplashState extends State
{
    private Logo logo;
    private StudioNameLabel studioNameLabel;

    public SplashState(Main game)
    {
        super(game);
        init();
    }

    private void init()
    {
        initLogo();
        initStudioNameLabel();
    }

    private void initStudioNameLabel()
    {
        studioNameLabel = new StudioNameLabel();
        stage.addActor(studioNameLabel);
    }

    private void initLogo()
    {
        logo = new Logo(game);
        stage.addActor(logo);
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
