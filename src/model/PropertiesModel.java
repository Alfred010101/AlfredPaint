package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import utils.enums.FillType;
import utils.enums.StrokeType;
import utils.interfaces.PropertiesObserver;

/**
 *
 * @author Alfred
 */
public class PropertiesModel
{
    private final List<PropertiesObserver> observers = new ArrayList<>();
    
    private FillType fillType = FillType.SOLID;

    private Color fillColor = new Color(
            (int) (Math.random() * 255) + 0,
            (int) (Math.random() * 255) + 0,
            (int) (Math.random() * 255) + 0
    );

    private Color startGradientColor = new Color(
            (int) (Math.random() * 255) + 0,
            (int) (Math.random() * 255) + 0,
            (int) (Math.random() * 255) + 0
    );

    private Color endGradientColor = new Color(
            (int) (Math.random() * 255) + 0,
            (int) (Math.random() * 255) + 0,
            (int) (Math.random() * 255) + 0
    );

    private StrokeType strokeType = StrokeType.SOLID;
    
    private Color strokeColor = new Color(
            (int) (Math.random() * 255) + 0,
            (int) (Math.random() * 255) + 0,
            (int) (Math.random() * 255) + 0
    );

    private BasicStroke strokeDraw = new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);

    public void addObserver(PropertiesObserver obs)
    {
        observers.add(obs);
    }

    public void removeObserver(PropertiesObserver obs)
    {
        observers.remove(obs);
    }

    private void notifyObservers()
    {
        for (PropertiesObserver ob : observers)
        {
            ob.onPropertiesChanged(this);
        }
    }

    /**
     * @return the fillType
     */
    public FillType getFillType()
    {
        return fillType;
    }

    /**
     * @param fillType the fillType to set
     */
    public void setFillType(FillType fillType)
    {
        this.fillType = fillType;
        notifyObservers();
    }

    /**
     * @return the fillColor
     */
    public Color getFillColor()
    {
        return fillColor;
    }

    /**
     * @param fillColor the fillColor to set
     */
    public void setFillColor(Color fillColor)
    {
        this.fillColor = fillColor;
        notifyObservers();
    }

    /**
     * @return the startGradientColor
     */
    public Color getStartGradientColor()
    {
        return startGradientColor;
    }

    /**
     * @param startGradientColor the startGradientColor to set
     */
    public void setStartGradientColor(Color startGradientColor)
    {
        this.startGradientColor = startGradientColor;
        notifyObservers();
    }

    /**
     * @return the endGradientColor
     */
    public Color getEndGradientColor()
    {
        return endGradientColor;
    }

    /**
     * @param endGradientColor the endGradientColor to set
     */
    public void setEndGradientColor(Color endGradientColor)
    {
        this.endGradientColor = endGradientColor;
        notifyObservers();
    }

    /**
     * @return the strokeColor
     */
    public Color getStrokeColor()
    {
        return strokeColor;
    }

    /**
     * @param strokeColor the strokeColor to set
     */
    public void setStrokeColor(Color strokeColor)
    {
        this.strokeColor = strokeColor;
        notifyObservers();
    }

    /**
     * @return the strokeType
     */
    public StrokeType getStrokeType()
    {
        return strokeType;
    }

    /**
     * @param strokeType the strokeType to set
     */
    public void setStrokeType(StrokeType strokeType)
    {
        this.strokeType = strokeType;
        notifyObservers();
    }

    /**
     * @return the strokeDraw
     */
    public BasicStroke getStrokeDraw()
    {
        return strokeDraw;
    }

    /**
     * @param strokeDraw the strokeDraw to set
     */
    public void setStrokeDraw(BasicStroke strokeDraw)
    {
        this.strokeDraw = strokeDraw;
        notifyObservers();
    }
}
