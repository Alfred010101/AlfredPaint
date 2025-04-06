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
import model.PropertiesModel;
import utils.global.ShapeController;

public class MouseEventHandler implements MouseListener
{

    private final JPanel panel;
    private final PropertiesModel model;

    public MouseEventHandler(PropertiesModel model, JPanel panel)
    {
        this.model = model;
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
                case SELECT_ONE -> Methods.actionSelectOne(model);
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
//            ColorFill color = switch (model.getFillType())
//            {
//                case EMPTY -> null;
//                case SOLID -> new SolidColor(model.getFillColor());
//                case GRADIENT -> new GradientColor(model.getStartGradientColor(), model.getEndGradientColor());
//                case TEXTURED -> null;
//            };
//
//            MyShape myShape = new MyShape(
//                    (ShapeType) Global.ACTIVE_MODE,
//                    Global.partialShape,
//                    model.getFillType(),
//                    color,
//                    model.getStrokeType(),
//                    model.getStrokeType() == StrokeType.EMPTY ? null : model.getStrokeColor(),
//                    model.getStrokeType() == StrokeType.EMPTY ? null : Methods.updateStroke(model)
//            );
            MyShape myShape = ShapeController.createShape(model, (ShapeType)Global.ACTIVE_MODE);
            Global.shapes.add(myShape);
            Global.partialShape = null;
        }

    }
}