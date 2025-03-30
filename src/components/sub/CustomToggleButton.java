package components.sub;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomToggleButton extends JToggleButton
{
    private boolean hovered = false;
    private static final int BORDER_RADIUS = 20;

    public CustomToggleButton(Icon icon, String toolName)
    {
        super(icon);

        setBorder(new RoundedBorder(BORDER_RADIUS));
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setRolloverEnabled(true);
        setToolTipText(toolName);
        setPreferredSize(new Dimension(30, 30)); // Tamaño compacto
        setMinimumSize(new Dimension(30, 30));
        setMaximumSize(new Dimension(30, 30));

        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e)
            {
                hovered = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                hovered = false;
                repaint();
            }
        });

        addChangeListener((ChangeEvent e) -> repaint());
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (hovered || isSelected())
        {
            g2.setColor(isSelected() ? new Color(200, 200, 200) : new Color(220, 220, 220));
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), BORDER_RADIUS, BORDER_RADIUS);
        }

        super.paintComponent(g2);
        g2.dispose();
    }

    private class RoundedBorder implements Border
    {
        private int radius;

        RoundedBorder(int radius)
        {
            this.radius = radius;
        }

        @Override
        public Insets getBorderInsets(Component c)
        {
            return new Insets(radius, radius, radius, radius);
        }

        @Override
        public boolean isBorderOpaque()
        {
            return false;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
        {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.GRAY);
            g2.setStroke(new BasicStroke(2));
            g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }
}