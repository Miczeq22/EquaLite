package pl.miczeq.logic;

import com.badlogic.gdx.math.MathUtils;

/**
 * Created by Mikolaj on 25.10.2016.
 */
public class EquationAlgorithm
{
    private String equation;
    private int result;
    private int fakeResult;

    public EquationAlgorithm()
    {
        createSimpleEquation();
    }

    public void createSimpleEquation()
    {
        int mark = MathUtils.random(0, 2);

        int a = MathUtils.random(1, 9);
        int b = MathUtils.random(0, 9);

        switch(mark)
        {
            case 0:
            {
                equation = a + " + " + b;
                result = a + b;
            }break;

            case 1:
            {
                equation = a + " - " + b;
                result = a - b;
            }break;

            case 2:
            {
                equation = a + " x " + b;
                result = a * b;
            }break;
        }

        boolean minus = MathUtils.randomBoolean();
        fakeResult = minus ? result - (MathUtils.random(1, 5)) : result + (MathUtils.random(1, 5));
    }

    public String getEquation()
    {
        return equation;
    }

    public int getResult()
    {
        return result;
    }

    public int getFakeResult()
    {
        return fakeResult;
    }
}
