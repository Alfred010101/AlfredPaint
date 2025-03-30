package model.fillColor;

import utils.interfaces.ColorFill;

import java.awt.*;

public class GradientColor implements ColorFill
{
//    public GradientColor(int x1, int y1, Color color1, int x2, int y2, Color color2, boolean cíclico)
//    {
//        super(x1,  y1, color1, x2, y2, color2, cíclico);
//    }
    private Color startColor;
    private Color endColor;

    public GradientColor(Color startGradientColor, Color endGradientColor)
    {
        startColor = startGradientColor;
        endColor = endGradientColor;
    }

    public Color getStartColor()
    {
        return startColor;
    }

    public void setStartColor(Color startColor)
    {
        this.startColor = startColor;
    }

    public Color getEndColor()
    {
        return endColor;
    }

    public void setEndColor(Color endColor)
    {
        this.endColor = endColor;
    }


}

