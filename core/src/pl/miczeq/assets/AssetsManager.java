package pl.miczeq.assets;

import com.badlogic.gdx.assets.AssetManager;

/**
 * Created by Mikolaj on 25.10.2016.
 */
public class AssetsManager
{
    public static AssetManager manager;
    public static ColorGenerator colorGenerator;

    public static void load()
    {
        manager = new AssetManager();
        colorGenerator = new ColorGenerator();
    }

    public static void dispose()
    {
        manager.dispose();
    }
}

