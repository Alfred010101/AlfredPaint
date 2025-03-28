package components.sub;

import utils.ShapeType;

import javax.swing.*;
import java.awt.*;

public class ShapeIcon implements Icon
{
    private static final int SIZE = 24;
    private ShapeType shapeType;

    public ShapeIcon(ShapeType shapeType)
    {
        this.shapeType = shapeType;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3));

        int padding = 4;
        int width = SIZE - 2 * padding;
        int height = SIZE - 2 * padding;

        switch (shapeType)
        {
            case RECTANGLE -> g2.drawRect(x + padding, y + padding, width, height);
            case ELLIPSE -> g2.drawOval(x + padding, y + padding, width, height);
            case LINE -> g2.drawLine(x + padding, y + padding, x + SIZE - padding, y + SIZE - padding);
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
