package utils;

import components.sub.CustomToggleButton;
import components.sub.MyIcon;
import utils.enums.FillType;
import utils.enums.ShapeType;
import utils.enums.StrokeFill;
import utils.global.DrawVar;
import utils.global.Global;
import utils.interfaces.UpdateTabs;
import utils.sub.StrokePanel;
import utils.sub.SubComponents;

import javax.swing.*;
import java.awt.*;

public class Components
{
    public static JToggleButton[] createTogglesJavaShapes(ButtonGroup toolGroup)
    {
        JToggleButton[] buttons = new JToggleButton[8];
        buttons[0] = new CustomToggleButton(new MyIcon(ShapeType.LINE), "Line");
        buttons[0].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.LINE);

        buttons[1] = new CustomToggleButton(new MyIcon(ShapeType.RECTANGLE), "Rectangle");
        buttons[1].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.RECTANGLE);

        buttons[2] = new CustomToggleButton(new MyIcon(ShapeType.ROUNDRECTANGLE), "RoundRectangle");
        buttons[2].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.ROUNDRECTANGLE);

        buttons[3] = new CustomToggleButton(new MyIcon(ShapeType.ELLIPSE), "Ellipse");
        buttons[3].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.ELLIPSE);

        buttons[4] = new CustomToggleButton(new MyIcon(ShapeType.ARC), "Arc");
        buttons[4].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.ARC);

        buttons[5] = new CustomToggleButton(new MyIcon(ShapeType.POLYGON), "Polygon");
        buttons[5].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.POLYGON);

        buttons[6] = new CustomToggleButton(new MyIcon(ShapeType.RECTANGLE), "QuadCurve");
        buttons[6].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.QUADCURVE);

        buttons[7] = new CustomToggleButton(new MyIcon(ShapeType.ELLIPSE), "CubicCurve");
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
        buttons[0] = new CustomToggleButton(new MyIcon(ShapeType.ESTRELLA), "Estrella");
        buttons[0].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.ESTRELLA);

        buttons[1] = new CustomToggleButton(new MyIcon(ShapeType.LUNA), "Luna");
        buttons[1].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.LUNA);

        buttons[2] = new CustomToggleButton(new MyIcon(ShapeType.ESPADA), "Espada");
        buttons[2].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.ESPADA);

        buttons[3] = new CustomToggleButton(new MyIcon(ShapeType.CUBO), "Cubo");
        buttons[3].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.CUBO);

        buttons[4] = new CustomToggleButton(new MyIcon(ShapeType.PIRAMIDE), "Piramide");
        buttons[4].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.PIRAMIDE);

        buttons[5] = new CustomToggleButton(new MyIcon(ShapeType.LETRAE), "LetraE");
        buttons[5].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.LETRAE);

        buttons[6] = new CustomToggleButton(new MyIcon(ShapeType.TORRE), "Torre");
        buttons[6].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.TORRE);

        buttons[7] = new CustomToggleButton(new MyIcon(ShapeType.TREBOL), "Trebol");
        buttons[7].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.TREBOL);

        buttons[8] = new CustomToggleButton(new MyIcon(ShapeType.RAYO), "Rayo");
        buttons[8].addActionListener(e -> Global.ACTIVE_MODE = ShapeType.RAYO);

        buttons[9] = new CustomToggleButton(new MyIcon(ShapeType.CORAZON), "Corazon");
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
        btns[0] = new CustomToggleButton(new MyIcon(FillType.EMPTY), "Sin Relleno");
        btns[1] = new CustomToggleButton(new MyIcon(FillType.SOLID), "Solido");
        btns[2] = new CustomToggleButton(new MyIcon(FillType.GRADIENT), "Gradiante");
        btns[3] = new CustomToggleButton(new MyIcon(FillType.TEXTURED), "Texturizado");

        btns[1].setSelected(true);
        ButtonGroup toolGroup = new ButtonGroup();

        for (int i = 0; i < btns.length; i++)
        {
            toolGroup.add(btns[i]);
        }

        JPanel empty = new JPanel();
        empty.add(new JLabel("No paint"));
        JPanel fillPanel = SubComponents.createFillPanel();
        JPanel gradientPanel = SubComponents.createGradientPanel();
        //JPanel texturePanel = SubComponents.createTexturePanel();
        JPanel texturePanel = new JPanel();
        texturePanel.add(new JLabel("En espera de implementar"));

        JPanel containerCard = new JPanel(cardLayout);
        containerCard.add(empty, "Empty");
        containerCard.add(fillPanel, "Solid");
        containerCard.add(gradientPanel, "Gradient");
        containerCard.add(texturePanel, "Texture");

        JPanel opciones = new JPanel(new FlowLayout(FlowLayout.LEFT));
        opciones.add(btns[0]);
        opciones.add(btns[1]);
        opciones.add(btns[2]);
        opciones.add(btns[3]);

        btns[0].addActionListener(e ->
        {
            cardLayout.show(containerCard, "Empty");
            DrawVar.fillType = FillType.EMPTY;
        });
        btns[1].addActionListener(e ->
        {
            cardLayout.show(containerCard, "Solid");
            DrawVar.fillType = FillType.SOLID;
        });
        btns[2].addActionListener(e ->
        {
            cardLayout.show(containerCard, "Gradient");
            DrawVar.fillType = FillType.GRADIENT;
        });
        btns[3].addActionListener(e ->
        {
            cardLayout.show(containerCard, "Texture");
            DrawVar.fillType = FillType.TEXTURED;
        });

        cardLayout.show(containerCard, "Solid");

        container.add(opciones, BorderLayout.NORTH);
        container.add(containerCard, BorderLayout.CENTER);
        return container;
    }

    public static JPanel initStrokePanel()
    {
        CardLayout cardLayout = new CardLayout();
        JPanel container = new JPanel();

        container.setLayout(new BorderLayout());

        JToggleButton[] btns = new JToggleButton[2];
        btns[0] = new CustomToggleButton(new MyIcon(StrokeFill.EMPTY), "Sin Relleno");
        btns[1] = new CustomToggleButton(new MyIcon(StrokeFill.SOLID), "Solido");

        btns[1].setSelected(true);
        ButtonGroup toolGroup = new ButtonGroup();

        toolGroup.add(btns[0]);
        toolGroup.add(btns[1]);

        JPanel empty = new JPanel();
        empty.add(new JLabel("No paint"));
        JPanel strokePanel = new StrokePanel();

        JPanel containerCard = new JPanel(cardLayout);
        containerCard.add(empty, "Empty");
        containerCard.add(strokePanel, "Solid");

        JPanel opciones = new JPanel(new FlowLayout(FlowLayout.LEFT));
        opciones.add(btns[0]);
        opciones.add(btns[1]);

        btns[0].addActionListener(e ->
        {
            cardLayout.show(containerCard, "Empty");
            DrawVar.strokeFillType = StrokeFill.EMPTY;
        });
        btns[1].addActionListener(e ->
        {
            cardLayout.show(containerCard, "Solid");
            DrawVar.strokeFillType = StrokeFill.SOLID;
        });

        cardLayout.show(containerCard, "Solid");

        container.add(opciones, BorderLayout.NORTH);
        container.add(containerCard, BorderLayout.CENTER);
        return container;
    }
}
