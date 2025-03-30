package utils.global;

import model.MyShape;
import model.fillColor.GradientColor;
import model.fillColor.SolidColor;
import utils.shapes.Shapes;
import utils.enums.ShapeType;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class DrawMethods
{
    public static void drawRealTime(ShapeType shape)
    {
        int x = (int) Math.min(Global.pointPressed.getX(), Global.pointDragged.getX());
        int y = (int) Math.min(Global.pointPressed.getY(), Global.pointDragged.getY());
        int w = (int) Math.abs(Global.pointPressed.getX() - Global.pointDragged.getX());
        int h = (int) Math.abs(Global.pointPressed.getY() - Global.pointDragged.getY());
        Global.partialShape  = switch (shape)
        {
            case RECTANGLE -> new Rectangle2D.Float(x, y, w, h);
            case ROUNDRECTANGLE -> new RoundRectangle2D.Float(x, y, w, h, 20, 20);
            case ELLIPSE -> new Ellipse2D.Float(x, y, w, h);
            case ARC -> new Arc2D.Float(x, y, w, h, 0, 180, Arc2D.OPEN);
            case POLYGON -> Shapes.pentagono(x, y, w, h);

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
        return switch (DrawVars.fillType)
        {
            case EMPTY -> null;
            case SOLID -> new GradientPaint(
                    Global.partialShape.getBounds().x,
                    Global.partialShape.getBounds().y,
                    DrawVars.fillColor,
                    Global.partialShape.getBounds().width,
                    Global.partialShape.getBounds().height,
                    DrawVars.fillColor,
                    false
            );

            case GRADIENT -> new GradientPaint(
                    Global.partialShape.getBounds().x,
                    Global.partialShape.getBounds().y,
                    DrawVars.startGradientColor,
                    Global.partialShape.getBounds().width,
                    Global.partialShape.getBounds().height,
                    DrawVars.endGradientColor,
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

    public static GradientPaint getGradient(MyShape shape)
    {
        return switch (shape.getFillType())
        {
            case SOLID ->
                    DrawMethods.getGradient(
                            shape.getShape(),
                            ((SolidColor)shape.getFillColor()).getColor(),
                            ((SolidColor)shape.getFillColor()).getColor(),
                            false
                    );
            case GRADIENT ->
                    DrawMethods.getGradient(
                            shape.getShape(),
                            ((GradientColor)shape.getFillColor()).getStartColor(),
                            ((GradientColor)shape.getFillColor()).getEndColor(),
                            false
                    );
            default -> null;
        };
    }
}
