package components.sub;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Alfred
 */
public class LineStyleRenderer extends JPanel implements ListCellRenderer<float[]>
{

    private float[] pattern;

    @Override
    public Component getListCellRendererComponent(JList<? extends float[]> list, float[] value, int index, boolean isSelected, boolean cellHasFocus)
    {
        this.pattern = value;
        setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
        return this;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibujar ejemplo de línea
        BasicStroke stroke = pattern != null
                ? new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1.0f, pattern, 0.0f)
                : new BasicStroke(2);

        g2.setColor(Color.BLACK);
        g2.setStroke(stroke);
        int y = getHeight() / 2;
        g2.drawLine(10, y, getWidth() - 10, y);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(200, 25);
    }
}
