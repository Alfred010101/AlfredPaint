package components.sub;

import utils.global.DrawMethods;
import utils.shapes.Shapes;
import utils.enums.*;
import utils.global.DrawVars;
import utils.interfaces.UnionIcons;

import javax.swing.*;
import java.awt.*;

public class MyIcon implements Icon
{
    private static final int SIZE = 20;
    private UnionIcons type;

    public MyIcon(UnionIcons type)
    {
        this.type = type;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));

        int padding = 4;
        int width = SIZE - 2 * padding;
        int height = SIZE - 2 * padding;

        if (type instanceof ShapeType icon)
        {
            switch (icon)
            {
                case LINE -> g2.drawLine(x + padding, y + padding, x + SIZE - padding, y + SIZE - padding);
                case RECTANGLE -> g2.drawRect(x + padding - 2, y + padding, width + 4, height);
                case ROUNDRECTANGLE -> g2.drawRoundRect(x + padding - 2, y + padding, width + 4, height, 5, 5);
                case ELLIPSE -> g2.drawOval(x + padding - 2, y + padding - 2, width + 4, height + 4);
                case ARC -> g2.drawArc(x + padding - 2, y + padding - 2, width + 4, height + 4, 0, 180);
                case POLYGON -> g2.draw(Shapes.pentagono(x + padding - 2, y + padding - 2, width + 4, height + 4));

                //propias
                case ESTRELLA -> g2.draw(Shapes.estrella(x + padding, y + padding, width, height));
                case LUNA -> g2.draw(Shapes.luna(x + padding, y + padding, width, height));
                case ESPADA -> g2.draw(Shapes.espada(x + padding, y + padding, width, height));
                case CUBO -> g2.draw(Shapes.cubo(x + padding, y + padding, width, height));
                case LETRAE -> g2.draw(Shapes.letraE(x + padding, y + padding, width, height));
                case PIRAMIDE -> g2.draw(Shapes.piramide(x + padding, y + padding, width, height));
                case TORRE -> g2.draw(Shapes.torreE(x + padding, y + padding, width, height));
                case TREBOL -> g2.draw(Shapes.trebol(x + padding, y + padding, width, height));
                case RAYO -> g2.draw(Shapes.rayo(x + padding, y + padding, width, height));
                case CORAZON -> g2.draw(Shapes.corazon(x + padding, y + padding, width, height));
            }
        } else if (type instanceof Mode icon)
        {
            switch (icon)
            {
                case SELECT_ONE ->
                {
                    int cursorSize = 8;
                    int startX = x + SIZE - padding - 3;
                    int startY = y + SIZE - padding - 3;

                    g2.drawLine(startX, startY, startX - cursorSize, startY - cursorSize);
                    g2.drawLine(startX - cursorSize, startY - cursorSize, startX - cursorSize + 3, startY - cursorSize);
                    g2.drawLine(startX - cursorSize, startY - cursorSize, startX - cursorSize, startY - cursorSize + 3);

                    g2.fillOval(startX - 1, startY - 1, 3, 3);
                }
                case SELECT_POINT ->
                {
                    int centerX = x + SIZE / 2;
                    int centerY = y + SIZE / 2;
                    int crossSize = 6;

                    g2.setStroke(new BasicStroke(1));
                    g2.drawLine(centerX - crossSize / 2, centerY, centerX + crossSize / 2, centerY);
                    g2.drawLine(centerX, centerY - crossSize / 2, centerX, centerY + crossSize / 2);
                    g2.setStroke(new BasicStroke(2));
                }
                case SELECT_AREA ->
                {
                    int rectSize = 14;
                    int rectX = x + (SIZE - rectSize) / 2;
                    int rectY = y + (SIZE - rectSize) / 2;

                    float[] dashPattern = {2f, 2f};
                    g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, dashPattern, 0.0f));
                    g2.drawRect(rectX, rectY, rectSize, rectSize);
                    g2.setStroke(new BasicStroke(2));
                }
                case SELECT_ALL ->
                {
                    int rectSize = 12;
                    int rectX = x + (SIZE - rectSize) / 2;
                    int rectY = y + (SIZE - rectSize) / 2;

                    g2.drawRect(rectX, rectY, rectSize, rectSize);

                    int dotSize = 2;
                    g2.fillRect(rectX - dotSize / 2, rectY - dotSize / 2, dotSize, dotSize);
                    g2.fillRect(rectX + rectSize - dotSize / 2, rectY - dotSize / 2, dotSize, dotSize);
                    g2.fillRect(rectX - dotSize / 2, rectY + rectSize - dotSize / 2, dotSize, dotSize);
                    g2.fillRect(rectX + rectSize - dotSize / 2, rectY + rectSize - dotSize / 2, dotSize, dotSize);
                }
            }
        } else if (type instanceof FillType icon)
        {
            Shape shape = new Rectangle.Float(x + padding - 3, y + padding - 3, width + 6, height + 6);
            switch (icon)
            {
                case EMPTY ->
                {
                    g2.drawLine(x + padding, y + padding, x + SIZE - padding, y + SIZE - padding);
                    g2.drawLine(x + SIZE - padding, y + padding, x + padding, y + SIZE - padding);
                }
                case SOLID ->
                {
                    g2.setColor(DrawVars.fillColor);
                    g2.fill(shape);
                }
                case GRADIENT ->
                {
                    g2.setPaint(DrawMethods.getGradient(shape, DrawVars.startGradientColor, DrawVars.endGradientColor, false));
                    g2.fill(shape);
                }
                case TEXTURED ->
                {
                    //g2.drawLine(x + padding, y + padding, x + SIZE - padding, y + SIZE - padding);
                    g2.drawLine(x + SIZE - padding, y + padding, x + padding, y + SIZE - padding);
                }
            }
        } else if (type instanceof StrokeCap icon)
        {
            int capType = switch (icon)
            {
                case CAP_BUTT -> 0;
                case CAP_ROUND -> 1;
                case CAP_SQUARE -> 2;
            };
            g2.setStroke(new BasicStroke(5, capType, BasicStroke.JOIN_MITER));
            g2.drawLine(x, y + 10, x + 20, y + 10);

        }else if (type instanceof StrokeJoin icon)
        {
            int joinType = switch (icon)
            {
                case JOIN_MITER -> 0;
                case JOIN_ROUND -> 1;
                case JOIN_BEVEL -> 2;
            };
            g2.setStroke(new BasicStroke(5, BasicStroke.CAP_BUTT, joinType));
            // Dibujar esquina
            Polygon p = new Polygon();
            p.addPoint(x, y + 18);
            p.addPoint(x + 10, y + 2);
            p.addPoint(x + 20, y + 18);
            g2.drawPolyline(p.xpoints, p.ypoints, p.npoints);
        } else if (type instanceof StrokeType icon)
        {
            Shape shape = new Rectangle.Float(x + padding - 3, y + padding - 3, width + 6, height + 6);

            switch (icon)
            {
                case EMPTY ->
                {
                    g2.drawLine(x + padding, y + padding, x + SIZE - padding, y + SIZE - padding);
                    g2.drawLine(x + SIZE - padding, y + padding, x + padding, y + SIZE - padding);
                }
                case SOLID ->
                {
                    g2.setColor(DrawVars.strokeColor);
                    g2.fill(shape);
                }
            }
        }

    }

    @Override
    public int getIconWidth()
    {
        return SIZE;
    }

    @Override
    public int getIconHeight()
    {
        return SIZE;
    }
}
