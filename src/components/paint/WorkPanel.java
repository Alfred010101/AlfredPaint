package components.paint;

import model.MyShape;
import model.fillColor.GradientColor;
import model.fillColor.SolidColor;
import utils.enums.FillType;
import utils.enums.Mode;
import utils.enums.ShapeType;
import utils.enums.StrokeType;
import utils.global.DrawMethods;
import utils.global.DrawVars;
import utils.global.Global;

import javax.swing.*;
import java.awt.*;
import model.PropertiesModel;
import utils.interfaces.PropertiesObserver;

public class WorkPanel extends JPanel implements PropertiesObserver
{
    private final PropertiesModel model;
    private final MouseEventHandler mouseEventHandler;
    private final MouseMotionEvenetHandler mouseMotionEventHandler = new MouseMotionEvenetHandler(WorkPanel.this);

    public WorkPanel(PropertiesModel model)
    {
        super();
        this.model = model;
        this.model.addObserver(WorkPanel.this);
        mouseEventHandler = new MouseEventHandler(model, WorkPanel.this);
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
            if (shape.getFillType() != FillType.EMPTY && shape.getFillType() != FillType.TEXTURED)
            {
                GradientPaint gradient = DrawMethods.getGradient(shape);
                g2.setPaint(gradient);
                g2.fill(shape.getShape());
            }
            if (shape.getStrokeType() != StrokeType.EMPTY)
            {
                g2.setColor(shape.getStrokeColor());
                g2.setStroke(shape.getStroke());
                g2.draw(shape.getShape());
            }
        }

        if(Global.ACTIVE_MODE instanceof Mode mode)
        {
            if(!Global.selectedShape.isEmty())
            {
                g2.setColor(Color.BLUE);
                float[] dashPattern = {5, 5};
                g2.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, dashPattern, 0));
                Rectangle dim = Global.selectedShape.getMyShape().getShape().getBounds();
                g2.drawRect(dim.x - 3, dim.y - 3, dim.width + 6, dim.height + 6);
            }
        }

        if (Global.ACTIVE_MODE instanceof ShapeType && Global.partialShape != null)
        {
            GradientPaint gradient = DrawMethods.getGradient(model);
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

    @Override
    public void onPropertiesChanged(PropertiesModel model)
    {
        
    }
}
