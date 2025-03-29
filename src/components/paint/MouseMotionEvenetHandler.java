package components.paint;


import utils.global.GV;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;

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
        if(GV.shapeType == GV.ShapeTypes.SELECCION_MODE)
        {
            if (GV.selectedShape != null)
            {
                AffineTransform transform = new AffineTransform();
                int dx = e.getX() - GV.lastMousePosition.x;
                int dy = e.getY() - GV.lastMousePosition.y;

                if (GV.selectedShape instanceof Line2D) {
                    Line2D line = (Line2D) GV.selectedShape;
                    GV.selectedShape = new Line2D.Float(
                            (float) line.getX1() + dx, (float) line.getY1() + dy,
                            (float) line.getX2() + dx, (float) line.getY2() + dy
                    );
                } else {
                    transform.setToTranslation(dx, dy);
                    GV.selectedShape = transform.createTransformedShape(GV.selectedShape);
                }

                //transform.setToTranslation(dx, dy);
                //GV.selectedShape = transform.createTransformedShape(GV.selectedShape);
                GV.shapes.set(GV.indexSelectedShape, GV.selectedShape);
                GV.lastMousePosition = e.getPoint();
                panel.repaint();
            }
            return;
        }

        Graphics2D g = (Graphics2D) panel.getGraphics();
        g.setXORMode(Color.WHITE);
        Point p1 = GV.points.get(GV.pointIndex - 1);
        switch (GV.shapeType)
        {
            case RECTANGLE ->
            {
                if (GV.p != null)
                {
                    g.drawRect(p1.x, p1.y, GV.p.x - p1.x, GV.p.y - p1.y);
                }
                GV.p = e.getPoint();
                g.drawRect(p1.x, p1.y, GV.p.x - p1.x, GV.p.y - p1.y);
            }
            case ROUNDRECTANGLE ->
            {
                if (GV.p != null)
                {
                    g.drawRoundRect(p1.x, p1.y,
                            GV.p.x - p1.x, GV.p.y - p1.y, 10, 10);
                }
                GV.p = e.getPoint();
                g.drawRoundRect(p1.x, p1.y, GV.p.x - p1.x, GV.p.y - p1.y, 10, 10);
            }
            case ELLIPSE ->
            {
                if (GV.p != null)
                {
                    g.drawOval(p1.x, p1.y, GV.p.x - p1.x, GV.p.y - p1.y);
                }
                GV.p = e.getPoint();
                g.drawOval(p1.x, p1.y, GV.p.x - p1.x, GV.p.y - p1.y);
            }
            case ARC ->
            {
                if (GV.p != null)
                {
                    g.drawArc(p1.x, p1.y, GV.p.x - p1.x, GV.p.y - p1.y, 0, 180);
                }
                GV.p = e.getPoint();
                g.drawArc(p1.x, p1.y, GV.p.x - p1.x, GV.p.y - p1.y, 0, 180);
            }
            case LINE ->
            {
                if (GV.p != null)
                {
                    g.drawLine(p1.x, p1.y, GV.p.x, GV.p.y);
                }
                GV.p = e.getPoint();
                g.drawLine(p1.x, p1.y, GV.p.x, GV.p.y);
            }
            case POLYGON ->
            {
                if (GV.polygonCenter != null)
                {
                    GV.polygonRadius = (int) GV.polygonCenter.distance(e.getPoint());
                    if (GV.polygon != null)
                    {
                        g.draw(GV.polygon);
                    }
                    GV.polygon = GV.createRegularPolygon();
                    g.draw(GV.polygon);
                }
            }
            case QUADCURVE2D ->
            {
                if (GV.pointIndex == 1)
                {
                    if (GV.p != null)
                    {
                        g.drawLine(p1.x, p1.y, GV.p.x, GV.p.y);
                    }
                    GV.p = e.getPoint();
                    g.drawLine(p1.x, p1.y, GV.p.x, GV.p.y);
                } else
                {
                    Point p2 = (Point) GV.points.get(GV.pointIndex - 2);
                    if (GV.p != null)
                    {
                        g.draw(GV.partialShape);
                    }
                    GV.p = e.getPoint();
                    GV.partialShape = new QuadCurve2D.Float(p2.x, p2.y,
                            p1.x, p1.y, GV.p.x, GV.p.y);
                    g.draw(GV.partialShape);
                }
            }
            case CUBICCURVE2D ->
            {
                switch (GV.pointIndex)
                {
                    case 1 ->
                    {
                        if (GV.p != null)
                        {
                            g.drawLine(p1.x, p1.y, GV.p.x, GV.p.y);
                        }
                        GV.p = e.getPoint();
                        g.drawLine(p1.x, p1.y, GV.p.x, GV.p.y);
                    }
                    case 2 ->
                    {
                        Point p2 = (Point) GV.points.get(GV.pointIndex - 2);
                        if (GV.p != null)
                        {
                            g.draw(GV.partialShape);
                        }
                        GV.p = e.getPoint();
                        GV.partialShape = new QuadCurve2D.Float(p2.x, p2.y,
                                p1.x, p1.y, GV.p.x, GV.p.y);
                        g.draw(GV.partialShape);
                    }
                    default ->
                    {
                        Point p2 = (Point) GV.points.get(GV.pointIndex - 2);
                        Point p3 = (Point) GV.points.get(GV.pointIndex - 3);
                        if (GV.p != null)
                        {
                            g.draw(GV.partialShape);
                        }
                        GV.p = e.getPoint();
                        GV.partialShape = new CubicCurve2D.Float(p3.x, p3.y,
                                p2.x, p2.y, p1.x, p1.y, GV.p.x, GV.p.y);
                        g.draw(GV.partialShape);
                    }
                }
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
    }
}
