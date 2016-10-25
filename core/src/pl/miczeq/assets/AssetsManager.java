package pl.miczeq.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import pl.miczeq.main.Main;

/**
 * Created by Mikolaj on 25.10.2016.
 */
public class AssetsManager
{
    public static AssetManager manager;
    public static ColorGenerator colorGenerator;

    public static ShaderProgram fontShader;

    public static BitmapFont font38;
    public static BitmapFont font50;
    public static BitmapFont font80;
    public static BitmapFont font100;
    public static BitmapFont font120;

    public static Preferences preferences;

    public static void load()
    {
        preferences = (Preferences) Gdx.app.getPreferences(Main.GAME_PREFS);

        manager = new AssetManager();
        colorGenerator = new ColorGenerator();

        manager.load("leon.png", Texture.class);
        manager.load("rect.png", Texture.class);

        fontShader = new ShaderProgram(Gdx.files.internal("fonts/font.vert"), Gdx.files.internal("fonts/font.frag"));
        if(!fontShader.isCompiled())
        {
            Gdx.app.error("fontShader", "compilation failder:\n" + fontShader.getLog());
        }

        Texture fontTexture = new Texture(Gdx.files.internal("fonts/font38.png"), true);
        fontTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        font38 = new BitmapFont(Gdx.files.internal("fonts/font38.fnt"), new TextureRegion(fontTexture), false);
        font38.getData().setScale(0.9f, 0.9f);

        fontTexture = new Texture(Gdx.files.internal("fonts/font50.png"), true);
        fontTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        font50 = new BitmapFont(Gdx.files.internal("fonts/font50.fnt"), new TextureRegion(fontTexture), false);
        font50.getData().setScale(0.9f, 0.9f);

        fontTexture = new Texture(Gdx.files.internal("fonts/font80.png"), true);
        fontTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        font80 = new BitmapFont(Gdx.files.internal("fonts/font80.fnt"), new TextureRegion(fontTexture), false);
        font80.getData().setScale(0.9f, 0.9f);

        fontTexture = new Texture(Gdx.files.internal("fonts/font100.png"), true);
        fontTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        font100 = new BitmapFont(Gdx.files.internal("fonts/font100.fnt"), new TextureRegion(fontTexture), false);
        font100.getData().setScale(0.9f, 0.9f);

        fontTexture = new Texture(Gdx.files.internal("fonts/font120.png"), true);
        fontTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        font120 = new BitmapFont(Gdx.files.internal("fonts/font120.fnt"), new TextureRegion(fontTexture), false);
        font120.getData().setScale(0.9f, 0.9f);
    }

    public static void dispose()
    {
        manager.unload("leon.png");
        manager.unload("rect.png");
        manager.dispose();

        font38.dispose();
        font50.dispose();
        font80.dispose();
        font100.dispose();
        font120.dispose();
    }
}

