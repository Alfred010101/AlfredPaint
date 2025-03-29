package components.paint;


import utils.enums.ShapeType;
import utils.global.DrawVar;
import utils.global.GV;
import utils.global.Global;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.*;

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
        DrawVar.pointDragged = e.getPoint();
        if(Global.ACTIVE_MODE instanceof ShapeType shape)
        {
            Draw.drawRealTime(shape);
            panel.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
    }
}
