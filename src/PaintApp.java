import components.ShapesPanel;
import components.SplitPanel;
import utils.Components;
import utils.Const;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;

public class PaintApp extends JFrame
{
    private JSplitPane splitPane;
    private JPanel javaShapes;
    private JPanel myShapes;
    private ButtonGroup toolGroup;

    private JMenuBar menuBar;

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

        javaShapes = new ShapesPanel(Components.createTogglesShapes(toolGroup));
        myShapes = new ShapesPanel(Components.createTogglesShapes(toolGroup));

        initJMenu();
        initJSplit();

        setJMenuBar(menuBar);
        add(splitPane, BorderLayout.CENTER);
    }

    private void initJMenu()
    {
        menuBar = new JMenuBar();
        Components.addViewMenu(menuBar);
    }

    private void initJSplit()
    {
        JPanel containerShapes = new JPanel();
        containerShapes.setLayout(new BoxLayout(containerShapes, BoxLayout.Y_AXIS));
        containerShapes.add(javaShapes);
        containerShapes.add(myShapes);
        containerShapes.add(Box.createVerticalGlue());

        JScrollPane scrollPane = new JScrollPane(containerShapes);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        JSplitPane splitInternal = new SplitPanel(scrollPane, new JPanel(), true);
        splitPane = new SplitPanel(splitInternal, new JPanel(), false);

        addComponentListener(new ComponentAdapter()
        {
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt)
            {
                int nuevaPosicion = splitPane.getWidth() - 240;
                splitPane.setDividerLocation(nuevaPosicion);
            }
        });
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new PaintApp().setVisible(true));
    }
}
