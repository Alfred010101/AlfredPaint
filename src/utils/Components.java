package utils;

import components.sub.CustomToggleButton;
import components.sub.ShapeIcon;
import utils.interfaces.UpdateTabs;

import javax.swing.*;

public class Components
{
    public static JToggleButton[] createTogglesShapes(ButtonGroup toolGroup)
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

    public static void addFileMenu(JMenuBar menuBar)
    {
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
    }

    public static void addEditMenu(JMenuBar menuBar)
    {
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(editMenu);
    }

    public static void addViewMenu(JMenuBar menuBar, UpdateTabs update)
    {
        JMenu viewMenu = new JMenu("View");
        for (int i = 0; i < Const.TAB_NAMES.length; i++)
        {
            JCheckBoxMenuItem checkBoxItem = new JCheckBoxMenuItem(Const.TAB_NAMES[i], Const.tabVisibility[i]);
            int tabIndex = i;
            checkBoxItem.addActionListener(e ->
            {
                Const.tabVisibility[tabIndex] = checkBoxItem.isSelected();
                update.updateTabs();
            });

            if (i == Const.TAB_NAMES.length - 1 || i == Const.TAB_NAMES.length - 2 )
            {
                checkBoxItem.setEnabled(false);
            }

            viewMenu.add(checkBoxItem);
        }
        menuBar.add(viewMenu);
    }

    public static JScrollPane initJSplit(JPanel left, JPanel right)
    {
        JPanel containerShapes = new JPanel();
        containerShapes.setLayout(new BoxLayout(containerShapes, BoxLayout.Y_AXIS));
        containerShapes.add(left);
        containerShapes.add(right);
        containerShapes.add(Box.createVerticalGlue());

        JScrollPane scrollPane = new JScrollPane(containerShapes);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        return scrollPane;
    }

    public static JPanel initFillPanel()
    {
        JPanel panel = new JPanel();
        panel.add(new JButton("Algo"));
        panel.add(new JTextField(60));
        return  panel;
    }

    public static JPanel initStrokeStylePanel()
    {
        JPanel panel = new JPanel();
        panel.add(new JButton("Algo"));
        panel.add(new JTextField());
        return  panel;
    }

    public static JPanel initStrokePaintPanel()
    {
        JPanel panel = new JPanel();
        panel.add(new JButton("Algo"));
        panel.add(new JTextField(20));
        return  panel;
    }
}
