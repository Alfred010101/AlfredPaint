package components.paint;

import model.MyShape;
import utils.enums.ShapeType;
import utils.enums.StrokeType;
import utils.global.DrawMethods;
import utils.global.DrawVars;
import utils.global.Global;

import javax.swing.*;
import java.awt.*;

public class WorkPanel extends JPanel
{

    private final MouseEventHandler mouseEventHandler = new MouseEventHandler(WorkPanel.this);
    private final MouseMotionEvenetHandler mouseMotionEventHandler = new MouseMotionEvenetHandler(WorkPanel.this);

    public WorkPanel()
    {
        super();
        addMouseListener(mouseEventHandler);
        addMouseMotionListener(mouseMotionEventHandler);
        setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (MyShape shape : Global.shapes)
        {
            g2.draw(shape.getShape());
        }

        if (Global.ACTIVE_MODE instanceof ShapeType && Global.partialShape != null)
        {
            GradientPaint gradient = DrawMethods.getGradient();

            if(gradient != null)
            {
                g2.setPaint(gradient);
                g2.fill(Global.partialShape);
            }

            if(DrawVars.strokeType != StrokeType.EMPTY)
            {
                g2.setColor(DrawVars.strokeColor);
                g2.setStroke(DrawVars.strokeDraw);
                g2.draw(Global.partialShape);
            }
        }
    }
}
