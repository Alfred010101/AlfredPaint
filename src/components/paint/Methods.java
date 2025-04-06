package components.paint;

import components.sub.StrokePanel;
import model.MyShape;
import model.fillColor.GradientColor;
import model.fillColor.SolidColor;
import utils.global.*;

import java.awt.*;
import model.PropertiesModel;
import utils.enums.StrokeType;

public class Methods
{

    public static BasicStroke updateStroke(PropertiesModel model)
    {
        return (model.getDashPattern() != null)
                ? new BasicStroke(model.getCurrentWidth(), model.getStrokeCap(), model.getStrokeJoin(), 1.0f, model.getDashPattern(), 0.0f)
                : new BasicStroke(model.getCurrentWidth(), model.getStrokeCap(), model.getStrokeJoin());
    }

    public static void actionSelectOne(PropertiesModel model)
    {
        for (int i = Global.shapes.size() - 1; i >= 0; i--)
        {
            if (Global.shapes.get(i).getShape().contains(Global.pointPressed))
            {
                MyShape shape = Global.shapes.get(i);
                switch (shape.getFillType())
                {
                    case SOLID ->
                    {
                        model.setFillColor(((SolidColor) shape.getFillColor()).getColor());
                    }
                    case GRADIENT ->
                    {
                        model.setStartGradientColor(((GradientColor) shape.getFillColor()).getStartColor());
                        model.setEndGradientColor(((GradientColor) shape.getFillColor()).getEndColor());
                    }
                }
                model.setFillType(shape.getFillType());

                if (shape.getStrokeType() == StrokeType.SOLID)
                {
                    model.setStrokeColor(shape.getStrokeColor());
                    model.setCurrentWidth((int) shape.getStroke().getLineWidth());
                    model.setStrokeCap(shape.getStroke().getEndCap());
                    model.setStrokeJoin(shape.getStroke().getLineJoin());
                    model.setDashPattern(shape.getStroke().getDashArray());
                }
                model.setStrokeType(shape.getStrokeType());
                model.notifyObservers();
                
                Global.selectedShape.put(i, shape);
                //SwingMethods.repaintJTabbProp();
                Global.offSet.x = Global.pointPressed.x;// - shape.getShape().getBounds().x;
                Global.offSet.y = Global.pointPressed.y;// - shape.getShape().getBounds().y;
                return;
            }
        }
        Global.selectedShape.clear();
    }
}
