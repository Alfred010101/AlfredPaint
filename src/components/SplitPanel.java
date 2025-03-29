package components;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SplitPanel extends JSplitPane
{
    private Component paneLeft;
    private Component paneRight;
    private final int MIN_LEFT_PANEL = 50;
    private final int MAX_LEFT_PANEL = 160;

    public SplitPanel(Component paneLeft, Component paneRight)
    {
        super(JSplitPane.HORIZONTAL_SPLIT, paneLeft, paneRight);
        this.paneLeft = paneLeft;
        this.paneRight = paneRight;

        setContinuousLayout(true);
        setOneTouchExpandable(true);
        setDividerLocation(50);

        addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY, (PropertyChangeEvent evt) ->
        {
            int currentLocation = getDividerLocation();

            if (currentLocation < MIN_LEFT_PANEL)
            {
                setDividerLocation(MIN_LEFT_PANEL);
            } else if (currentLocation > MAX_LEFT_PANEL)
            {
                setDividerLocation(MAX_LEFT_PANEL);
            }

        });
    }
}
