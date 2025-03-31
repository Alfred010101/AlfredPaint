package components.paint;


import utils.enums.Mode;
import utils.enums.ShapeType;
import utils.global.DrawMethods;
import utils.global.Global;

import javax.swing.*;
import java.awt.*;
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
        } else if (Global.ACTIVE_MODE instanceof Mode mode)
        {
            switch (mode)
            {
                case SELECT_ONE -> moveOne();
                case SELECT_POINT -> System.out.println();
                case SELECT_AREA -> System.out.println();
                case SELECT_ALL -> System.out.println();
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
    }

    private void moveOne()
    {
        if (!Global.selectedShape.isEmty())
        {
            int x = Global.pointDragged.x - Global.offSet.x;
            int y = Global.pointDragged.y - Global.offSet.y;
            Global.selectedShape.getMyShape().move(x, y);
            Global.offSet = Global.pointDragged;
            panel.repaint();
        }
    }
}
