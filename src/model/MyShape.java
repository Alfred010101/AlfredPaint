package model;

import utils.enums.FillType;
import utils.enums.ShapeType;
import utils.enums.StrokeType;
import utils.interfaces.ColorFill;

import java.awt.*;

public class MyShape
{
    //typo de shape
    private ShapeType shapeType;
    //shape implementada
    private Shape shape;
    //tipo de relleno EMPTY, SOLID, GRADIENT, TEXTURED
    private FillType fillType;
    //color de relleno
    private ColorFill fillColor;
    //tipo de relleno para el stroke EMPTY, SOLID
    private StrokeType strokeType;
    //color del stroke
    private Color strokeColor;
    //stroke implementado
    private BasicStroke stroke;

    public MyShape(ShapeType shapeType, Shape shape, FillType fillType, ColorFill fillColor, StrokeType strokeType, Color strokeColor, BasicStroke stroke)
    {
        this.shapeType = shapeType;
        this.shape = shape;
        this.fillType = fillType;
        this.fillColor = fillColor;
        this.strokeType = strokeType;
        this.strokeColor = strokeColor;
        this.stroke = stroke;
    }

    public ShapeType getShapeType()
    {
        return shapeType;
    }

    public void setShapeType(ShapeType shapeType)
    {
        this.shapeType = shapeType;
    }

    public Shape getShape()
    {
        return shape;
    }

    public void setShape(Shape shape)
    {
        this.shape = shape;
    }

    public FillType getFillType()
    {
        return fillType;
    }

    public void setFillType(FillType fillType)
    {
        this.fillType = fillType;
    }

    public ColorFill getFillColor()
    {
        return fillColor;
    }

    public void setFillColor(ColorFill fillColor)
    {
        this.fillColor = fillColor;
    }

    public StrokeType getStrokeType()
    {
        return strokeType;
    }

    public void setStrokeType(StrokeType strokeType)
    {
        this.strokeType = strokeType;
    }

    public Color getStrokeColor()
    {
        return strokeColor;
    }

    public void setStrokeColor(Color strokeColor)
    {
        this.strokeColor = strokeColor;
    }

    public BasicStroke getStroke()
    {
        return stroke;
    }

    public void setStroke(BasicStroke stroke)
    {
        this.stroke = stroke;
    }

    // Metodos bajo demanda
    public void setFillShape(FillType type, ColorFill color)
    {
        this.fillType = type;
        this.fillColor = color;
    }
}