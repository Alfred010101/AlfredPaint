package utils.global;

import javax.swing.*;
import java.awt.*;

public class SwingVar
{
    /***Inicio de variables del JTabbedPane*****/
    public static JTabbedPane propertiesTabbed = new JTabbedPane();
    /***Inicio de variables del panel Fill*****/
    public static JButton colorFillButton = new JButton();
    public static JButton startGradientColorButton = new JButton();
    public static JButton endGradientColorButton = new JButton();
    public static JToggleButton[] btns = new JToggleButton[4];
    public static CardLayout cardLayoutFill = new CardLayout();
    public static JPanel containerCardFill = new JPanel(SwingVar.cardLayoutFill);
    /**Fin de variables del panel Fill*****/
    /***Fin de variables del JTabbedPane*****/
}
