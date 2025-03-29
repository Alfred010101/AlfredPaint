package components;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SplitPanel extends JSplitPane
{
    private Component paneLeft;
    private Component paneRight;
    private boolean propertyDefault;

    private final int MIN_LEFT_PANEL = 50;
    private final int MAX_LEFT_PANEL = 160;

    public SplitPanel(Component paneLeft, Component paneRight, boolean propertyDefault)
    {
        super(JSplitPane.HORIZONTAL_SPLIT, paneLeft, paneRight);
        this.paneLeft = paneLeft;
        this.paneRight = paneRight;
        this.propertyDefault = propertyDefault;

        setContinuousLayout(true);
        setOneTouchExpandable(true);
        setDividerLocation(50);

        addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY, (PropertyChangeEvent evt) ->
        {
            if(propertyDefault)
            {
                int currentLocation = getDividerLocation();

                if (currentLocation < MIN_LEFT_PANEL)
                {
                    setDividerLocation(MIN_LEFT_PANEL);
                } else if (currentLocation > MAX_LEFT_PANEL)
                {
                    setDividerLocation(MAX_LEFT_PANEL);
                }
            }else {
                int currentLocation = getDividerLocation();
                int minRightLocation = getWidth() - 300;
                int maxRightLocation = getWidth();

                if (currentLocation < minRightLocation)
                {
                    setDividerLocation(minRightLocation);
                } else if (currentLocation > maxRightLocation)
                {
                    setDividerLocation(maxRightLocation);
                }
            }
        });
    }
}
