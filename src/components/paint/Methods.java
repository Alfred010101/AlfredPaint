package components.paint;

import model.MyShape;
import model.fillColor.GradientColor;
import model.fillColor.SolidColor;
import utils.enums.FillType;
import utils.enums.StrokeType;
import utils.global.*;

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
                    case EMPTY ->
                    {
                        SwingVar.btns[0].setSelected(true);
                        SwingVar.cardLayoutFill.show(SwingVar.containerCardFill, "Empty");
                    }
                    case SOLID ->
                    {
                        DrawVars.fillColor = ((SolidColor) shape.getFillColor()).getColor();
                        SwingVar.btns[1].setSelected(true);
                        SwingVar.cardLayoutFill.show(SwingVar.containerCardFill, "Solid");
                    }
                    case GRADIENT ->
                    {
                        DrawVars.startGradientColor = ((GradientColor) shape.getFillColor()).getStartColor();
                        DrawVars.endGradientColor = ((GradientColor) shape.getFillColor()).getEndColor();
                        SwingVar.btns[2].setSelected(true);
                        SwingVar.cardLayoutFill.show(SwingVar.containerCardFill, "Gradient");
                    }
                    case TEXTURED ->
                    {
                        SwingVar.btns[3].setSelected(true);
                        SwingVar.cardLayoutFill.show(SwingVar.containerCardFill, "Texture");
                    }

                }

//                if (shape.getStrokeType() != StrokeType.EMPTY)
//                {
//                    g2.setColor(shape.getStrokeColor());
//                    g2.setStroke(shape.getStroke());
//                    g2.draw(shape.getShape());
//                }
                Global.selectedShape.put(i, shape);
                SwingMethods.repaintJTabbProp();
                return;
            }
        }
        Global.selectedShape.clear();
    }
}
