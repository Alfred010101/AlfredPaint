package components.paint;


import utils.enums.ShapeType;
import utils.global.DrawMethods;
import utils.global.Global;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionEvenetHandler implements MouseMotionListener
{

    private final JPanel panel;

    public MouseMotionEvenetHandler(JPanel panel)
    {
        this.panel = panel;
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        Global.pointDragged = e.getPoint();
        if(Global.ACTIVE_MODE instanceof ShapeType shape)
        {
            DrawMethods.drawRealTime(shape);
            panel.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
    }
}
