package model.fillColor;

import utils.interfaces.ColorFill;

import java.awt.*;

public class SolidColor implements ColorFill
{
    private Color color;

    public SolidColor(Color color)
    {
        this.color = color;
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }
}
