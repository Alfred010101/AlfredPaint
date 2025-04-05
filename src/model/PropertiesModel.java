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
    
    private int currentWidth = 2;
    private int strokeCap = BasicStroke.CAP_BUTT;
    private int strokeJoin = BasicStroke.JOIN_MITER;
    private float[] dashPattern = null;

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
     * @return the currentWidth
     */
    public int getCurrentWidth()
    {
        return currentWidth;
    }

    /**
     * @param currentWidth the currentWidth to set
     */
    public void setCurrentWidth(int currentWidth)
    {
        this.currentWidth = currentWidth;
        notifyObservers();
    }

    /**
     * @return the strokeCap
     */
    public int getStrokeCap()
    {
        return strokeCap;
    }

    /**
     * @param strokeCap the capType to set
     */
    public void setStrokeCap(int strokeCap)
    {
        this.strokeCap = strokeCap;
        notifyObservers();
    }

    /**
     * @return the strokeJoin
     */
    public int getStrokeJoin()
    {
        return strokeJoin;
    }

    /**
     * @param strokeJoin the joinType to set
     */
    public void setStrokeJoin(int strokeJoin)
    {
        this.strokeJoin = strokeJoin;
        notifyObservers();
    }

    /**
     * @return the dashPattern
     */
    public float[] getDashPattern()
    {
        return dashPattern;
    }

    /**
     * @param dashPattern the dashPattern to set
     */
    public void setDashPattern(float[] dashPattern)
    {
        this.dashPattern = dashPattern;
        notifyObservers();
    }
}
