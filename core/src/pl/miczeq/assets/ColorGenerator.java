package pl.miczeq.assets;

import com.badlogic.gdx.graphics.Color;

import java.util.Random;

/**
 * Created by Mikolaj on 23.10.2016.
 */
public class ColorGenerator
{
    private Color oldColor;
    private Color color;

    public ColorGenerator()
    {
        color = new Color(0.0f, 0.0f, 0.0f, 1.0f);
        getRandomColor();
    }

    public void getRandomColor()
    {
        oldColor = color;
        Random rand = new Random();

        float red = rand.nextFloat() / 2 - 0.1f;
        float green = rand.nextFloat()  + 0.1f;
        float blue = rand.nextFloat() + 0.5f;

        color = new Color(red, green, blue, 1.0f);
    }

    public Color getColor()
    {
        return color;
    }

    public Color getDarkerColor()
    {
        return new Color(color.r - 0.1f, color.g - 0.1f, color.b - 0.4f, 1.0f);
    }

    public Color getOldColor()
    {
        return oldColor;
    }
}
