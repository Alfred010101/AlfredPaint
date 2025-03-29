package components;

import components.sub.CustomToggleButton;
import components.sub.ShapeIcon;
import utils.enums.ShapeType;

import javax.swing.*;
import java.awt.*;

public class ToolsPanel extends JPanel
{
    JPanel selectPanel;
    ButtonGroup toolGroup;
    public ToolsPanel(ButtonGroup toolGroup)
    {
        super(new FlowLayout(FlowLayout.LEFT));
        this.toolGroup = toolGroup;
        initComponents();
    }

    private void initComponents()
    {
        initSelectPanel();
    }

    private void initSelectPanel()
    {
        selectPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        selectPanel.setBorder(BorderFactory.createTitledBorder("Select Mode"));
        JToggleButton[] btns = new JToggleButton[4];
        btns[0] = new CustomToggleButton(new ShapeIcon(ShapeType.ELLIPSE), "Select One");
        btns[1] = new CustomToggleButton(new ShapeIcon(ShapeType.RECTANGLE), "Select Point");
        btns[2] = new CustomToggleButton(new ShapeIcon(ShapeType.LINE), "Select Area");
        btns[3] = new CustomToggleButton(new ShapeIcon(ShapeType.ELLIPSE), "Select All");

        for (int i = 0; i < btns.length; i++)
        {
            btns[i].setPreferredSize(new Dimension(30, 30)); // Tamaño compacto
            btns[i].setMinimumSize(new Dimension(30, 30));
            btns[i].setMaximumSize(new Dimension(30, 30));
            toolGroup.add(btns[i]);
            selectPanel.add(btns[i]);
        }
        add(selectPanel);
    }
}
