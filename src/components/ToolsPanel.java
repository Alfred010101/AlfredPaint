package components;

import components.sub.CustomToggleButton;
import components.sub.MyIcon;
import utils.enums.Mode;
import utils.enums.ShapeType;
import utils.global.Global;

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
        btns[0] = new CustomToggleButton(new MyIcon(Mode.SELECT_ONE), "Select One");
        btns[0].addActionListener(e -> Global.ACTIVE_MODE = Mode.SELECT_ONE);

        btns[1] = new CustomToggleButton(new MyIcon(Mode.SELECT_POINT), "Select Point");
        btns[1].addActionListener(e -> Global.ACTIVE_MODE = Mode.SELECT_POINT);

        btns[2] = new CustomToggleButton(new MyIcon(Mode.SELECT_AREA), "Select Area");
        btns[2].addActionListener(e -> Global.ACTIVE_MODE = Mode.SELECT_AREA);

        btns[3] = new CustomToggleButton(new MyIcon(Mode.SELECT_ALL), "Select All");
        btns[3].addActionListener(e -> Global.ACTIVE_MODE = Mode.SELECT_ALL);

        for (int i = 0; i < btns.length; i++)
        {
            toolGroup.add(btns[i]);
            selectPanel.add(btns[i]);
        }
        add(selectPanel);
    }
}
