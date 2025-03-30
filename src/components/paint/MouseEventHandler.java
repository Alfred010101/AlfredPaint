package components.paint;

import model.MyShape;
import model.fillColor.GradientColor;
import model.fillColor.SolidColor;
import utils.enums.FillType;
import utils.enums.Mode;
import utils.enums.ShapeType;
import utils.enums.StrokeType;
import utils.global.DrawVars;
import utils.global.Global;
import utils.interfaces.ColorFill;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
        Global.pointPressed = e.getPoint();

        if(Global.ACTIVE_MODE instanceof Mode mode)
        {
            switch (mode)
            {
                case SELECT_ONE -> Methods.actionSelectOne();
                case SELECT_POINT -> System.out.println();
                case SELECT_AREA -> System.out.println();
                case SELECT_ALL -> System.out.println();
            }
            panel.repaint();
        }

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        if(Global.ACTIVE_MODE instanceof ShapeType shape && Global.partialShape != null)
        {
            ColorFill color = switch (DrawVars.fillType)
            {
                case EMPTY -> null;
                case SOLID -> new SolidColor(DrawVars.fillColor);
                case GRADIENT -> new GradientColor(DrawVars.startGradientColor, DrawVars.endGradientColor);
                case TEXTURED -> null;
            };

            MyShape myShape = new MyShape(
                    (ShapeType) Global.ACTIVE_MODE,
                    Global.partialShape,
                    DrawVars.fillType,
                    color,
                    DrawVars.strokeType,
                    DrawVars.strokeType == StrokeType.EMPTY ? null : DrawVars.strokeColor,
                    DrawVars.strokeType == StrokeType.EMPTY ? null : DrawVars.strokeDraw
            );
            Global.shapes.add(myShape);
            Global.partialShape = null;
        }

    }
}