package components.paint;

import components.sub.StrokePanel;
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
                        SwingVar.btnsFillType[0].setSelected(true);
                        SwingVar.cardLayoutFill.show(SwingVar.containerCardFill, "Empty");
                    }
                    case SOLID ->
                    {
                        DrawVars.fillColor = ((SolidColor) shape.getFillColor()).getColor();
                        SwingVar.btnsFillType[1].setSelected(true);
                        SwingVar.cardLayoutFill.show(SwingVar.containerCardFill, "Solid");
                    }
                    case GRADIENT ->
                    {
                        DrawVars.startGradientColor = ((GradientColor) shape.getFillColor()).getStartColor();
                        DrawVars.endGradientColor = ((GradientColor) shape.getFillColor()).getEndColor();
                        SwingVar.btnsFillType[2].setSelected(true);
                        SwingVar.cardLayoutFill.show(SwingVar.containerCardFill, "Gradient");
                    }
                    case TEXTURED ->
                    {
                        SwingVar.btnsFillType[3].setSelected(true);
                        SwingVar.cardLayoutFill.show(SwingVar.containerCardFill, "Texture");
                    }
                }
                switch (shape.getStrokeType())
                {
                    case EMPTY ->
                    {
                        SwingVar.btnsStrokeType[0].setSelected(true);
                        SwingVar.cardLayoutStroke.show(SwingVar.containerCardStroke, "Empty");
                    }
                    case SOLID ->
                    {
                        DrawVars.strokeColor = shape.getStrokeColor();
                        SwingVar.btnsStrokeType[1].setSelected(true);
                        SwingVar.cardLayoutStroke.show(SwingVar.containerCardStroke, "Solid");
                        StrokePanel.currentWidth = shape.getStroke().getLineWidth();
                        StrokePanel.capType = shape.getStroke().getEndCap();
                        StrokePanel.joinType = shape.getStroke().getLineJoin();
                        StrokePanel.dashPattern = shape.getStroke().getDashArray();
                    }
                }
                Global.selectedShape.put(i, shape);
                SwingMethods.repaintJTabbProp();
                return;
            }
        }
        Global.selectedShape.clear();
    }
}
