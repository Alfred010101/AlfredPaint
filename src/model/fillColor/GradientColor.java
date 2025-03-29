package model.fillColor;

import utils.interfaces.ColorStyle;

import java.awt.*;

public class GradientColor extends GradientPaint implements ColorStyle
{
    public GradientColor(int x1, int y1, Color color1, int x2, int y2, Color color2, boolean cíclico)
    {
        super(x1,  y1, color1, x2, y2, color2, cíclico);
    }
}

