package utils.global;

import components.paint.Methods;
import java.awt.Shape;
import mian.PaintApp;

import model.MyShape;
import model.PropertiesModel;
import model.fillColor.GradientColor;
import model.fillColor.SolidColor;
import static utils.enums.FillType.EMPTY;
import static utils.enums.FillType.GRADIENT;
import static utils.enums.FillType.SOLID;
import static utils.enums.FillType.TEXTURED;
import utils.enums.Mode;
import utils.enums.ShapeType;
import utils.enums.StrokeType;
import utils.interfaces.ColorFill;

public class ShapeController
{

    public static MyShape createShape(PropertiesModel model, ShapeType shapeType)
    {
        return ShapeController.returnShape(model, shapeType, Global.partialShape);
    }

    public static void applyChangesToSelectedShape(PropertiesModel model)
    {
        if (!(Global.ACTIVE_MODE instanceof Mode) || Global.selectedShape.isEmty())
        {
            return;
        }

        MyShape myShape = ShapeController.returnShape(
                model, Global.selectedShape.getMyShape().getShapeType(),
                Global.selectedShape.getMyShape().getShape()
        );

        Global.shapes.set(Global.selectedShape.getKey(), myShape);
        model.notifyObservers();
    }

    private static MyShape returnShape(PropertiesModel model, ShapeType shapeType, Shape shape)
    {
        return new MyShape(
                shapeType,
                shape,
                model.getFillType(),
                ShapeController.applyChangesFiller(model),
                model.getStrokeType(),
                model.getStrokeType() == StrokeType.EMPTY ? null : model.getStrokeColor(),
                model.getStrokeType() == StrokeType.EMPTY ? null : Methods.updateStroke(model)
        );
    }

    public static ColorFill applyChangesFiller(PropertiesModel model)
    {
        return switch (model.getFillType())
        {
            case EMPTY ->
                null;
            case SOLID ->
                new SolidColor(model.getFillColor());
            case GRADIENT ->
                new GradientColor(model.getStartGradientColor(), model.getEndGradientColor());
            case TEXTURED ->
                null;
        };
    }

    //descontinuar este metodo
    public static void shapeSelected()
    {
        if (!(Global.ACTIVE_MODE instanceof Mode) || Global.selectedShape.isEmty())
        {
            return;
        }

        ColorFill color = switch (DrawVars.fillType)
        {
            case EMPTY ->
                null;
            case SOLID ->
                new SolidColor(DrawVars.fillColor);
            case GRADIENT ->
                new GradientColor(DrawVars.startGradientColor, DrawVars.endGradientColor);
            case TEXTURED ->
                null;
        };

        MyShape myShape = new MyShape(
                Global.selectedShape.getMyShape().getShapeType(),
                Global.selectedShape.getMyShape().getShape(),
                DrawVars.fillType,
                color,
                DrawVars.strokeType,
                DrawVars.strokeType == StrokeType.EMPTY ? null : DrawVars.strokeColor,
                DrawVars.strokeType == StrokeType.EMPTY ? null : DrawVars.strokeDraw
        );
        Global.shapes.set(Global.selectedShape.getKey(), myShape);
        PaintApp.workPanel.repaint();
    }
}
