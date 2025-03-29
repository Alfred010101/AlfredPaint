package components.paint;

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
    public void mouseClicked(MouseEvent ev)
    {
    }

    @Override
    public void mouseEntered(MouseEvent ev)
    {
    }

    @Override
    public void mouseExited(MouseEvent ev)
    {
    }

    @Override
    public void mousePressed(MouseEvent ev)
    {
        Point clickPoint = ev.getPoint();
        if (GV.shapeType == GV.ShapeTypes.SELECCION_MODE)
        {
            //GV.selectedShape = null;
            if (GV.selectedShape != null && GV.selectedShape.getBounds2D().contains(clickPoint.x, clickPoint.y))
            {
                GV.lastMousePosition = clickPoint;
            }else
            {
                //GV.lastMousePosition = clickPoint;
                for (int index = GV.shapes.size() - 1; index >= 0; index--)
                {
                    Shape shape = GV.shapes.get(index);
                    GV.indexSelectedShape = index;
                    if (shape instanceof Line2D)
                    {
                        Line2D line = (Line2D) shape;
                        if (line.ptSegDist(clickPoint) < 5)
                        { // Si el punto está cerca de la línea
                            GV.selectedShape = shape;
                            break;
                        }
                        GV.selectedShape = null;
                    } else if (shape.contains(clickPoint))
                    { // Para otras figuras, usar contains()
                        GV.selectedShape = shape;
                        break;
                    }
                    GV.selectedShape = null;
                }
                panel.repaint();
            }
        } else
        {
            if (GV.shapeType == GV.ShapeTypes.POLYGON)
            {
                GV.polygonCenter = clickPoint;
            }
            GV.points.add(ev.getPoint());
            GV.pointIndex++;
            GV.p = null;
        }
    }

    @Override
    public void mouseReleased(MouseEvent ev)
    {
        if(GV.shapeType == GV.ShapeTypes.SELECCION_MODE)
        {
            GV.lastMousePosition = null;
            //GV.indexSelectedShape = -1;
            //GV.selectedShape = null;
            return;
        }
        Graphics g = panel.getGraphics();
        Point p1 = GV.points.get(GV.pointIndex - 1);
        GV.p = ev.getPoint();
        Shape s = null;
        switch (GV.shapeType)
        {
            case RECTANGLE ->
                    s = new Rectangle(p1.x, p1.y, GV.p.x - p1.x, GV.p.y - p1.y);
            case ROUNDRECTANGLE ->
                    s = new RoundRectangle2D.Float(p1.x, p1.y,GV.p.x - p1.x, GV.p.y - p1.y, 10, 10);
            case ELLIPSE ->
                    s = new Ellipse2D.Float(p1.x, p1.y, GV.p.x - p1.x, GV.p.y - p1.y);
            case ARC ->
                    s = new Arc2D.Float(p1.x, p1.y, GV.p.x - p1.x,GV.p.y - p1.y, 0, 180, Arc2D.OPEN);
            case LINE ->
                    s = new Line2D.Float(p1.x, p1.y, GV.p.x, GV.p.y);
            case QUADCURVE2D ->
            {
                if (GV.pointIndex > 1)
                {
                    Point p2 = (Point) GV.points.get(0);
                    s = new QuadCurve2D.Float(p2.x, p2.y, p1.x, p1.y, GV.p.x, GV.p.y);
                }
            }
            case CUBICCURVE2D ->
            {
                if (GV.pointIndex > 2)
                {
                    Point p2 = (Point) GV.points.get(GV.pointIndex - 2);
                    Point p3 = (Point) GV.points.get(GV.pointIndex - 3);
                    s = new CubicCurve2D.Float(p3.x, p3.y, p2.x, p2.y,
                            p1.x, p1.y, GV.p.x, GV.p.y);
                }
            }
            case POLYGON ->
            {
                s = GV.polygon;
            }
        }
        if (s != null)
        {
            GV.shapes.add(s);
            GV.points.clear();
            GV.pointIndex = 0;
            GV.polygon = null;
            GV.p = null;
            panel.repaint();
        }
    }
}