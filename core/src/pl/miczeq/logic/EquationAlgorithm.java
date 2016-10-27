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
    private boolean pow;

    public EquationAlgorithm()
    {
        pow = false;
        createSimpleEquation();
    }

    public void createSimpleEquation()
    {
        pow = false;
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

    public void createHardEquation()
    {
        boolean strong = MathUtils.randomBoolean();

        if(strong)
        {
            pow = false;
            int n = MathUtils.random(2, 6);

            result = 1;
            equation = n + "!";

            for(int i = n; i >= 1; i--)
            {
                result *= i;
            }
        }
        else
        {
            pow = true;
            int a = (MathUtils.random(1, 9));
            int b = (MathUtils.random(0, 9));

            boolean plus = MathUtils.randomBoolean();

            equation = plus ? a + " + " + b : a  + " - " + b;
            result =  plus ? (a * a) + b : (a * a) - b;
        }

        boolean plus = MathUtils.randomBoolean();

        fakeResult = plus ? result + (MathUtils.random(1, 5)) : result - (MathUtils.random(1, 5));
    }

    public void createBracketsEquation()
    {
        pow = false;
        boolean plus = MathUtils.randomBoolean();

        int a = MathUtils.random(1, 9);
        int b = MathUtils.random(0, 9);
        int c = MathUtils.random(1, 9);

        equation = plus ? "(" + a + " + " + b + ")" + " x " + c : "(" + a + " - " + b + ")" + " x " + c;
        result = plus ? (a + b) * c : (a - b) * c;

        plus = MathUtils.randomBoolean();

        fakeResult = plus ? result + MathUtils.random(1, 5) : result - MathUtils.random(1, 5);
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

    public boolean isPow()
    {
        return pow;
    }

    public void setPow(boolean pow)
    {
        this.pow = pow;
    }
}
