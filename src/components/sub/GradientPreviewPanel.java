package components.sub;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

/**
 *
 * @author Alfred
 */
public class GradientPreviewPanel extends JPanel
{

    private final JButton startColorButton;
    private final JButton endColorButton;
    private Color startColor;
    private Color endColor;

    public GradientPreviewPanel(JButton startColorButton, JButton endColorButton)
    {
        this.startColorButton = startColorButton;
        this.endColorButton = endColorButton;
        
        this.startColor = startColorButton.getBackground();
        this.endColor = endColorButton.getBackground();

        this.startColorButton.addActionListener(e -> updateColor(startColorButton, true));
        this.endColorButton.addActionListener(e -> updateColor(endColorButton, false));

        setPreferredSize(new Dimension(200, 50));
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }

    private void updateColor(JButton button, boolean isStartColor)
    {
        Color newColor = JColorChooser.showDialog(null, "Seleccionar color", button.getBackground());
        if (newColor != null)
        {
            button.setBackground(newColor);
            if (isStartColor)
            {
                startColor = newColor;
            } else
            {
                endColor = newColor;
            }
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gradient = new GradientPaint(0, 0, startColor, getWidth(), getHeight(), endColor);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}
