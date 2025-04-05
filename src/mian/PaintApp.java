package mian;

import components.ShapesPanel;
import components.SplitPanel;
import components.ToolsPanel;
import components.paint.WorkPanel;
import components.Components;
import components.FillPanel;
import components.StrokePanel;
import utils.global.Const;
import utils.global.SwingVar;
import utils.interfaces.UpdateTabs;

import javax.swing.*;
import java.awt.*;
import model.PropertiesModel;

public class PaintApp extends JFrame
{

    private JMenuBar menuBar;
    private JSplitPane splitPane;
    private JPanel javaShapes;
    private JPanel myShapes;
    private JPanel toolsPanel;
    public static JPanel workPanel;

    private ButtonGroup toolGroup;

    //private JTabbedPane propertiesTabbed;
    private JPanel[] propertiesPanels;

    private PropertiesModel model;
    public JTabbedPane propertiesTabbed = new JTabbedPane();

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
        model = new PropertiesModel();
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
        add(SwingVar.propertiesTabbed, BorderLayout.EAST);
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
        JScrollPane scrollPane = Components.initJSplit(javaShapes, myShapes);
        splitPane = new SplitPanel(scrollPane, workPanel);
    }

    private void initWorkPanel()
    {
        workPanel = new WorkPanel();
    }

    private void initJTabbed()
    {
        //SwingVar.propertiesTabbed = new JTabbedPane();
        propertiesPanels = new JPanel[2];
        propertiesPanels[0] = new FillPanel(model);
        propertiesPanels[1] = new StrokePanel(model);
    }

    private UpdateTabs updateTabs()
    {
        return new UpdateTabs()
        {
            @Override
            public void updateTabs()
            {
                boolean isEmpty = true;
                SwingVar.propertiesTabbed.removeAll();
                for (int i = 0; i < Const.TAB_NAMES.length; i++)
                {
                    //aqui va dar error si entra a la opc deshabilitada
                    if (Const.tabVisibility[i])
                    {
                        isEmpty = false;
                        SwingVar.propertiesTabbed.addTab(Const.TAB_NAMES[i], propertiesPanels[i]);
                    }
                }
                SwingVar.propertiesTabbed.setVisible(!isEmpty);
            }
        };
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new PaintApp().setVisible(true));
    }
}
