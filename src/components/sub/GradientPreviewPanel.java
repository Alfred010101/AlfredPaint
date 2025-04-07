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
import model.PropertiesModel;
import utils.global.Global;
import utils.global.ShapeController;
import utils.interfaces.PropertiesObserver;

/**
 *
 * @author Alfred
 */
public class GradientPreviewPanel extends JPanel implements PropertiesObserver
{

    private final JButton startColorButton;
    private final JButton endColorButton;
    private final PropertiesModel model;

    public GradientPreviewPanel(PropertiesModel model, JButton startColorButton, JButton endColorButton)
    {
        this.model = model;
        this.startColorButton = startColorButton;
        this.endColorButton = endColorButton;

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
                model.setStartGradientColor(newColor);
            } else
            {
                model.setEndGradientColor(newColor);
            }
            
            ShapeController.applyChangesToSelectedShape(model);
            
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gradient = new GradientPaint(0, 0, model.getStartGradientColor(), getWidth(), getHeight(), model.getEndGradientColor());
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }

    @Override
    public void onPropertiesChanged(PropertiesModel model)
    {

    }
}
