package utils.global;

import components.sub.StrokePanel;

import javax.swing.*;
import java.awt.*;

public class SwingMethods
{
    public static void repaintJTabbProp()
    {
        SwingVar.colorFillButton.setBackground(DrawVars.fillColor);
        SwingVar.startGradientColorButton.setBackground(DrawVars.startGradientColor);
        SwingVar.endGradientColorButton.setBackground(DrawVars.endGradientColor);
        SwingVar.propertiesTabbed.repaint();
        ((StrokePanel)SwingVar.strokePanel).updateInterfaz();
        SwingVar.strokePanel.repaint();
    }
}
