package utils.global;

public class SwingMethods
{
    public static void repaintJTabbProp()
    {
        SwingVar.colorFillButton.setBackground(DrawVars.fillColor);
        SwingVar.startGradientColorButton.setBackground(DrawVars.startGradientColor);
        SwingVar.endGradientColorButton.setBackground(DrawVars.endGradientColor);
        SwingVar.propertiesTabbed.repaint();
    }
}
