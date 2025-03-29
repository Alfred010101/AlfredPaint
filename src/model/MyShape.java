package model;

import model.fillColor.GradientColor;
import utils.enums.FillType;
import utils.enums.ShapeType;
import utils.enums.StrokeStyle;
import utils.interfaces.ColorStyle;

import java.awt.*;

public class MyShape
{
    private String name;
    private Point position;
    private int width;
    private int height;
    private FillType fillType;
    private StrokeStyle strokeStyle;
    private ColorStyle fillColor;
    private Color strokeColor;
    private double strokeWidth;
    private ShapeType type;
    private Shape shape;

    public MyShape(String name, ShapeType type, Point position, int width, int height)
    {
        this.name = name;
        this.type = type;
        this.position = position;
        this.width = width;
        this.height = height;
        // Valores por defecto
        this.fillType = FillType.SOLID;
        this.strokeStyle = StrokeStyle.SOLID;
        this.strokeWidth = 1.0;
    }

    public Shape getShape()
    {
        return shape;
    }

    public void setShape(Shape shape)
    {
        this.shape = shape;
    }

    // Getters y setters para todas las propiedades
    public void setFill(FillType type, ColorStyle color)
    {
        this.fillType = type;
        this.fillColor = color;
    }

    public void setStroke(Color color, StrokeStyle style, double width)
    {
        this.strokeColor = color;
        this.strokeStyle = style;
        this.strokeWidth = width;
    }

    // Otros métodos útiles
    public void move(int deltaX, int deltaY)
    {
        this.position = new Point(
                this.position.x + deltaX,
                this.position.y + deltaY
        );
    }

    public void resize(double scale)
    {
        this.width *= scale;
        this.height *= scale;
    }

    @Override
    public String toString()
    {
        return String.format(
                "Shape[name=%s, position=(%.1f,%.1f), size=%.1fx%.1f, fill=%s]",
                name, position.getX(), position.getY(), width, height, fillType
        );
    }
}