package components.paint;

import utils.enums.ShapeType;
import utils.global.DrawVar;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Draw
{
    public static void drawRealTime(ShapeType shape)
    {
        switch (shape)
        {
            case ShapeType.LINE ->
            {

            }
            case ShapeType.RECTANGLE ->
            {
                DrawVar.partialShape = new Rectangle2D.Float(
                        (int) Math.min(DrawVar.pointPressed.getX(), DrawVar.pointDragged.getX()),
                        (int) Math.min(DrawVar.pointPressed.getY(), DrawVar.pointDragged.getY()),
                        (int) Math.abs(DrawVar.pointPressed.getX() - DrawVar.pointDragged.getX()),
                        (int) Math.abs(DrawVar.pointPressed.getY() - DrawVar.pointDragged.getY())
                );
            }
            case ShapeType.ELLIPSE ->
            {
                DrawVar.partialShape = new Ellipse2D.Float(
                        (int) Math.min(DrawVar.pointPressed.getX(), DrawVar.pointDragged.getX()),
                        (int) Math.min(DrawVar.pointPressed.getY(), DrawVar.pointDragged.getY()),
                        (int) Math.abs(DrawVar.pointPressed.getX() - DrawVar.pointDragged.getX()),
                        (int) Math.abs(DrawVar.pointPressed.getY() - DrawVar.pointDragged.getY())
                );
            }
        }
    }

    public static GradientPaint getGradient()
    {
        return switch (DrawVar.fillType)
        {
            case EMPTY -> null;
            case SOLID -> new GradientPaint(
                    DrawVar.partialShape.getBounds().x,
                    DrawVar.partialShape.getBounds().y,
                    DrawVar.fillColor,
                    DrawVar.partialShape.getBounds().width,
                    DrawVar.partialShape.getBounds().height,
                    DrawVar.fillColor,
                    false
            );

            case GRADIENT -> new GradientPaint(
                    DrawVar.partialShape.getBounds().x,
                    DrawVar.partialShape.getBounds().y,
                    DrawVar.startGradientColor,
                    DrawVar.partialShape.getBounds().width,
                    DrawVar.partialShape.getBounds().height,
                    DrawVar.endGradientColor,
                    false
            );
            case TEXTURED -> null;
        };
    }
}
