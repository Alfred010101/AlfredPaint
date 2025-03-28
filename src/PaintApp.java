import components.ShapesPanel;
import components.SplitPanel;

import javax.swing.*;
import java.awt.*;

public class PaintApp extends JFrame
{
    private JSplitPane splitPane;
    private JPanel javaShapes;
    private JPanel myShapes;
    private ButtonGroup toolGroup;

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
        javaShapes = new ShapesPanel("Up");
        myShapes = new ShapesPanel("Down");

        JPanel containerShapes = new JPanel();
        containerShapes.setLayout(new BoxLayout(containerShapes, BoxLayout.Y_AXIS));
        containerShapes.add(javaShapes);
        containerShapes.add(Box.createRigidArea(new Dimension(0, 20)));
        containerShapes.add(myShapes);

        JScrollPane scrollPane = new JScrollPane(containerShapes);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        splitPane = new SplitPanel(scrollPane, new JPanel());
        add(splitPane);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new PaintApp().setVisible(true));
    }
}
