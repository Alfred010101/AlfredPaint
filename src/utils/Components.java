package utils;

import components.sub.CustomToggleButton;
import components.sub.ShapeIcon;
import utils.enums.ShapeType;
import utils.global.Global;
import utils.interfaces.UpdateTabs;
import utils.sub.SubComponents;

import javax.swing.*;
import java.awt.*;

public class Components
{
    public static JToggleButton[] createTogglesJavaShapes(ButtonGroup toolGroup)
    {
        JToggleButton[] buttons = new JToggleButton[8];
        buttons[0] = new CustomToggleButton(new ShapeIcon(ShapeType.RECTANGLE), "Line");
        buttons[0].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.LINE);

        buttons[1] = new CustomToggleButton(new ShapeIcon(ShapeType.ELLIPSE), "Rectangle");
        buttons[1].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.RECTANGLE);

        buttons[2] = new CustomToggleButton(new ShapeIcon(ShapeType.LINE), "RoundRectangle");
        buttons[2].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.ROUNDRECTANGLE);

        buttons[3] = new CustomToggleButton(new ShapeIcon(ShapeType.RECTANGLE), "Ellipse");
        buttons[3].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.ELLIPSE);

        buttons[4] = new CustomToggleButton(new ShapeIcon(ShapeType.ELLIPSE), "Arc");
        buttons[4].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.ARC);

        buttons[5] = new CustomToggleButton(new ShapeIcon(ShapeType.LINE), "Polygon");
        buttons[5].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.POLYGON);

        buttons[6] = new CustomToggleButton(new ShapeIcon(ShapeType.RECTANGLE), "QuadCurve");
        buttons[6].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.QUADCURVE);

        buttons[7] = new CustomToggleButton(new ShapeIcon(ShapeType.ELLIPSE), "CubicCurve");
        buttons[7].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.CUBICCURVE);

        for (int i = 0; i < buttons.length; i++)
        {
            toolGroup.add(buttons[i]);
        }

        return buttons;
    }

    public static JToggleButton[] createTogglesMyShapes(ButtonGroup toolGroup)
    {
        JToggleButton[] buttons = new JToggleButton[10];
        buttons[0] = new CustomToggleButton(new ShapeIcon(ShapeType.RECTANGLE), "Estrella");
        buttons[0].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.ESTRELLA);

        buttons[1] = new CustomToggleButton(new ShapeIcon(ShapeType.ELLIPSE), "Luna");
        buttons[1].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.LUNA);

        buttons[2] = new CustomToggleButton(new ShapeIcon(ShapeType.LINE), "Espada");
        buttons[2].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.ESPADA);

        buttons[3] = new CustomToggleButton(new ShapeIcon(ShapeType.RECTANGLE), "Cubo");
        buttons[3].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.CUBO);

        buttons[4] = new CustomToggleButton(new ShapeIcon(ShapeType.ELLIPSE), "Piramide");
        buttons[4].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.PIRAMIDE);

        buttons[5] = new CustomToggleButton(new ShapeIcon(ShapeType.LINE), "LetraE");
        buttons[5].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.LETRAE);

        buttons[6] = new CustomToggleButton(new ShapeIcon(ShapeType.RECTANGLE), "Torre");
        buttons[6].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.TORRE);

        buttons[7] = new CustomToggleButton(new ShapeIcon(ShapeType.ELLIPSE), "Trebol");
        buttons[7].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.TREBOL);

        buttons[8] = new CustomToggleButton(new ShapeIcon(ShapeType.RECTANGLE), "Rayo");
        buttons[8].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.RAYO);

        buttons[9] = new CustomToggleButton(new ShapeIcon(ShapeType.ELLIPSE), "Corazon");
        buttons[9].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.CORAZON);

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
        CardLayout cardLayout = new CardLayout();
        JPanel container = new JPanel();

        container.setLayout(new BorderLayout());

        JToggleButton[] btns = new JToggleButton[4];
        btns[0] = new CustomToggleButton(new ShapeIcon(ShapeType.ELLIPSE), "Relleno texturizado");
        btns[1] = new CustomToggleButton(new ShapeIcon(ShapeType.RECTANGLE), "Relleno Solido");
        btns[2] = new CustomToggleButton(new ShapeIcon(ShapeType.LINE), "Relleno degradado");
        btns[3] = new CustomToggleButton(new ShapeIcon(ShapeType.ELLIPSE), "Relleno texturizado");

        btns[1].setSelected(true);
        ButtonGroup toolGroup = new ButtonGroup();

        for (int i = 0; i < btns.length; i++)
        {
            btns[i].setPreferredSize(new Dimension(30, 30)); // Tamaño compacto
            btns[i].setMinimumSize(new Dimension(30, 30));
            btns[i].setMaximumSize(new Dimension(30, 30));
            toolGroup.add(btns[i]);
        }

        JPanel empty = new JPanel();
        empty.add(new JLabel("No paint"));
        JPanel fillPanel = SubComponents.createFillPanel();
        JPanel strokePanel = SubComponents.createGradientPanel();
        JPanel opacityPanel = SubComponents.createOpacityPanel();

        JPanel containerCard = new JPanel(cardLayout);
        containerCard.add(empty, "Empty");
        containerCard.add(fillPanel, "Relleno");
        containerCard.add(strokePanel, "Borde");
        containerCard.add(opacityPanel, "Opacidad");

        JPanel opciones = new JPanel(new FlowLayout(FlowLayout.LEFT));
        opciones.add(btns[0]);
        opciones.add(btns[1]);
        opciones.add(btns[2]);
        opciones.add(btns[3]);

        btns[0].addActionListener(e -> cardLayout.show(containerCard, "Empty"));
        btns[1].addActionListener(e -> cardLayout.show(containerCard, "Relleno"));
        btns[2].addActionListener(e -> cardLayout.show(containerCard, "Borde"));
        btns[3].addActionListener(e -> cardLayout.show(containerCard, "Opacidad"));

        cardLayout.show(containerCard, "Relleno");

        container.add(opciones, BorderLayout.NORTH);
        container.add(containerCard, BorderLayout.CENTER);
        return container;
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
