package utils.global;

import utils.enums.FillType;
import utils.enums.StrokeFill;

import java.awt.*;

public class DrawVar
{
    //puede ser local?
    public static Shape partialShape = null;

    public static Point pointPressed = new Point();
    public static Point pointReleased = new Point();
    public static Point pointDragged = new Point();

    public static FillType fillType = FillType.SOLID;

    public static Color fillColor = new Color(
            (int) (Math.random() * 255) + 0,
            (int) (Math.random() * 255) + 0,
            (int) (Math.random() * 255) + 0
    );

    public static Color startGradientColor = new Color(
            (int) (Math.random() * 255) + 0,
            (int) (Math.random() * 255) + 0,
            (int) (Math.random() * 255) + 0
    );

    public static Color endGradientColor = new Color(
            (int) (Math.random() * 255) + 0,
            (int) (Math.random() * 255) + 0,
            (int) (Math.random() * 255) + 0
    );

    public static Color strokeColor = new Color(
            (int) (Math.random() * 255) + 0,
            (int) (Math.random() * 255) + 0,
            (int) (Math.random() * 255) + 0
    );

    public static StrokeFill strokeFillType = StrokeFill.SOLID;
    public static BasicStroke strokeDraw = new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
}
