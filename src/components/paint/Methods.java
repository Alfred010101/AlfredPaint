package components.paint;

import model.MyShape;
import model.fillColor.GradientColor;
import model.fillColor.SolidColor;
import utils.enums.FillType;
import utils.enums.StrokeType;
import utils.global.DrawMethods;
import utils.global.DrawVars;
import utils.global.Global;
import utils.global.SwingVar;

import java.awt.*;
import java.util.ArrayList;

public class Methods
{
    public static void actionSelectOne()
    {
        for (int i = Global.shapes.size() - 1; i >= 0; i--)
        {
            if (Global.shapes.get(i).getShape().contains(Global.pointPressed))
            {
                MyShape shape = Global.shapes.get(i);
                switch (shape.getFillType())
                {
                    case EMPTY, TEXTURED ->
                    {
                        DrawVars.fillColor = Color.WHITE;
                        DrawVars.startGradientColor = Color.WHITE;
                        DrawVars.endGradientColor = Color.WHITE;
                    }
                    case SOLID ->
                    {
                        DrawVars.fillColor = ((SolidColor)shape.getFillColor()).getColor();
                    }
                    case GRADIENT ->
                    {
                        DrawVars.startGradientColor = ((GradientColor)shape.getFillColor()).getStartColor();
                        DrawVars.endGradientColor = ((GradientColor)shape.getFillColor()).getEndColor();
                    }
                }

//                if (shape.getStrokeType() != StrokeType.EMPTY)
//                {
//                    g2.setColor(shape.getStrokeColor());
//                    g2.setStroke(shape.getStroke());
//                    g2.draw(shape.getShape());
//                }
                Global.selectedShape.put(i, shape);
                SwingVar.propertiesTabbed.repaint();
                return;
            }
        }
        Global.selectedShape.clear();
    }
}
