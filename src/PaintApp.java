import components.ShapesPanel;
import components.SplitPanel;
import components.ToolsPanel;
import components.paint.WorkPanel;
import utils.Components;
import utils.Const;
import utils.interfaces.UpdateTabs;

import javax.swing.*;
import java.awt.*;

public class PaintApp extends JFrame
{
    private JMenuBar menuBar;
    private JSplitPane splitPane;
    private JPanel javaShapes;
    private JPanel myShapes;
    private JPanel toolsPanel;
    private JPanel workPanel;

    private ButtonGroup toolGroup;

    private JTabbedPane propertiesTabbed;
    private JPanel[] propertiesPanels;

    public PaintApp()
    {
        super("Paint");
        setSize(new Dimension(1200, 600));
        setMinimumSize(new Dimension(800, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        initComponents();
    }

    private void initComponents()
    {
        toolGroup = new ButtonGroup();

        javaShapes = new ShapesPanel(Components.createTogglesJavaShapes(toolGroup), "Java");
        myShapes = new ShapesPanel(Components.createTogglesMyShapes(toolGroup), "Own");

        initJTabbed();
        initJMenu();
        initToolsPanel();
        initWorkPanel();
        initJSplit();

        setJMenuBar(menuBar);
        add(toolsPanel, BorderLayout.NORTH);
        add(splitPane, BorderLayout.CENTER);
        add(propertiesTabbed, BorderLayout.EAST);
    }

    private void initJMenu()
    {
        menuBar = new JMenuBar();
        Components.addFileMenu(menuBar);
        Components.addEditMenu(menuBar);
        Components.addViewMenu(menuBar, updateTabs());
    }

    private void initToolsPanel()
    {
        toolsPanel = new ToolsPanel(toolGroup);
    }

    private void initJSplit()
    {
        JScrollPane scrollPane = Components.initJSplit(javaShapes,myShapes);
        splitPane = new SplitPanel(scrollPane, workPanel);
    }

    private void initWorkPanel()
    {
        workPanel = new WorkPanel();
    }

    private void initJTabbed()
    {
        propertiesTabbed = new JTabbedPane();
        propertiesPanels = new JPanel[3];
        propertiesPanels[0] = Components.initFillPanel();
        propertiesPanels[1] = Components.initStrokePaintPanel();
        propertiesPanels[2] = Components.initStrokeStylePanel();
    }

    private UpdateTabs updateTabs()
    {
        return new UpdateTabs()
        {
            @Override
            public void updateTabs()
            {
                boolean isEmpty = true;
                propertiesTabbed.removeAll();
                for (int i = 0; i < Const.TAB_NAMES.length; i++)
                {
                    //aqui va dar error si entra a la opc deshabilitada
                    if (Const.tabVisibility[i])
                    {
                        isEmpty = false;
                        propertiesTabbed.addTab(Const.TAB_NAMES[i], propertiesPanels[i]);
                    }
                }
                propertiesTabbed.setVisible(!isEmpty);
            }
        };
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new PaintApp().setVisible(true));
    }
}
