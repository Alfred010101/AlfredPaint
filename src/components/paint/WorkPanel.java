package components.paint;

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
//        for (Shape shape : GV.shapes)
//        {
//            g2.draw(shape);
//        }
//
//        if (GV.selectedShape != null)
//        {
//            Rectangle bounds = GV.selectedShape.getBounds();
//
//            Stroke dashed = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
//                    0, new float[]{5}, 0);
//            g2.setStroke(dashed);
//            g2.setColor(Color.RED);
//            g2.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
//        }

//        if (GV.isDrawingPolygon && GV.currentPolygon.npoints > 1) {
//            g2.draw(GV.currentPolygon);
//        }
    }
}
