package utils;

import components.sub.CustomToggleButton;
import components.sub.ShapeIcon;

import javax.swing.*;
import java.awt.*;

public class Components
{
    public static JToggleButton[] sf(ButtonGroup toolGroup)
    {
        JToggleButton[] buttons = new JToggleButton[12];
        buttons[0] = new CustomToggleButton(new ShapeIcon(ShapeType.RECTANGLE), "Rectángulo");
        buttons[1] = new CustomToggleButton(new ShapeIcon(ShapeType.ELLIPSE), "Elipse");
        buttons[2] = new CustomToggleButton(new ShapeIcon(ShapeType.LINE), "Línea");
        buttons[3] = new CustomToggleButton(new ShapeIcon(ShapeType.RECTANGLE), "Rectángulo");
        buttons[4] = new CustomToggleButton(new ShapeIcon(ShapeType.ELLIPSE), "Elipse");
        buttons[5] = new CustomToggleButton(new ShapeIcon(ShapeType.LINE), "Línea");

        buttons[6] = new CustomToggleButton(new ShapeIcon(ShapeType.RECTANGLE), "Rectángulo");
        buttons[7] = new CustomToggleButton(new ShapeIcon(ShapeType.ELLIPSE), "Elipse");
        buttons[8] = new CustomToggleButton(new ShapeIcon(ShapeType.LINE), "Línea");
        buttons[9] = new CustomToggleButton(new ShapeIcon(ShapeType.RECTANGLE), "Rectángulo");
        buttons[10] = new CustomToggleButton(new ShapeIcon(ShapeType.ELLIPSE), "Elipse");
        buttons[11] = new CustomToggleButton(new ShapeIcon(ShapeType.LINE), "Línea");

//        buttons[12] = new CustomToggleButton(new ShapeIcon(ShapeType.RECTANGLE), "Rectángulo");
//        buttons[13] = new CustomToggleButton(new ShapeIcon(ShapeType.ELLIPSE), "Elipse");
//        buttons[14] = new CustomToggleButton(new ShapeIcon(ShapeType.LINE), "Línea");
//        buttons[15] = new CustomToggleButton(new ShapeIcon(ShapeType.RECTANGLE), "Rectángulo");
//        buttons[16] = new CustomToggleButton(new ShapeIcon(ShapeType.ELLIPSE), "Elipse");
//        buttons[17] = new CustomToggleButton(new ShapeIcon(ShapeType.LINE), "Línea");
//
//        buttons[18] = new CustomToggleButton(new ShapeIcon(ShapeType.RECTANGLE), "Rectángulo");
//        buttons[19] = new CustomToggleButton(new ShapeIcon(ShapeType.ELLIPSE), "Elipse");
//        buttons[20] = new CustomToggleButton(new ShapeIcon(ShapeType.LINE), "Línea");
//        buttons[21] = new CustomToggleButton(new ShapeIcon(ShapeType.RECTANGLE), "Rectángulo");
//        buttons[22] = new CustomToggleButton(new ShapeIcon(ShapeType.ELLIPSE), "Elipse");
//        buttons[23] = new CustomToggleButton(new ShapeIcon(ShapeType.LINE), "Línea");

        for (int i = 0; i < buttons.length; i++)
        {
            toolGroup.add(buttons[i]);
        }

        return buttons;
    }
}
