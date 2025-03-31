package utils.global;
import mian.PaintApp;

import model.MyShape;
import model.fillColor.GradientColor;
import model.fillColor.SolidColor;
import utils.enums.Mode;
import utils.enums.StrokeType;
import utils.interfaces.ColorFill;

public class Update
{
    public static void shapeSelected()
    {
        if(!(Global.ACTIVE_MODE instanceof Mode) || Global.selectedShape.isEmty())
            return;


        ColorFill color = switch (DrawVars.fillType)
        {
            case EMPTY -> null;
            case SOLID -> new SolidColor(DrawVars.fillColor);
            case GRADIENT -> new GradientColor(DrawVars.startGradientColor, DrawVars.endGradientColor);
            case TEXTURED -> null;
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
