package components.paint;

import utils.enums.ShapeType;
import utils.global.DrawVar;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class Draw
{
    public static void drawRealTime(ShapeType shape)
    {
        int x = (int) Math.min(DrawVar.pointPressed.getX(), DrawVar.pointDragged.getX());
        int y = (int) Math.min(DrawVar.pointPressed.getY(), DrawVar.pointDragged.getY());
        int w = (int) Math.abs(DrawVar.pointPressed.getX() - DrawVar.pointDragged.getX());
        int h = (int) Math.abs(DrawVar.pointPressed.getY() - DrawVar.pointDragged.getY());
        DrawVar.partialShape  = switch (shape)
        {
            case RECTANGLE -> new Rectangle2D.Float(x, y, w, h);
            case ROUNDRECTANGLE -> new RoundRectangle2D.Float(x, y, w, h, 20, 20);
            case ELLIPSE -> new Ellipse2D.Float(x, y, w, h);
            case ARC -> new Arc2D.Float(x, y, w, h, 0, 180, Arc2D.OPEN);
            case POLYGON ->Shapes.pentagono(x, y, w, h);

            case ESTRELLA -> Shapes.estrella(x, y, w, h);
            case LUNA -> Shapes.luna(x, y, w, h);
            case ESPADA -> Shapes.espada(x, y, w, h);
            case CUBO -> Shapes.cubo(x, y, w, h);
            case LETRAE -> Shapes.letraE(x, y, w, h);
            case PIRAMIDE -> Shapes.piramide(x, y, w, h);
            case TORRE -> Shapes.torreE(x, y, w, h);
            case TREBOL -> Shapes.trebol(x, y, w, h);
            case RAYO -> Shapes.rayo(x, y, w, h);
            case CORAZON -> Shapes.corazon(x, y, w, h);

            default -> null;
        };
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

    public static GradientPaint getGradient(Shape shape, Color start, Color end, boolean cyclic)
    {
        return new GradientPaint(
                shape.getBounds().x,
                shape.getBounds().y,
                start,
                shape.getBounds().width,
                shape.getBounds().height,
                end,
                cyclic
        );
    }
}
