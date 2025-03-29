package components.paint;

import utils.global.DrawVar;
import utils.global.GV;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;

public class MouseEventHandler implements MouseListener
{

    private final JPanel panel;

    public MouseEventHandler(JPanel panel)
    {
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        DrawVar.pointPressed = e.getPoint();

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }
}