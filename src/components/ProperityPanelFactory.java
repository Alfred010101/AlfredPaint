package components;

import components.sub.GradientPreviewPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Alfred
 */
public class ProperityPanelFactory
{

    private final ProperityPanelBuilder builder = new ProperityPanelBuilder();

    public JPanel createEmptyPanel()
    {
        return builder.reset()
                .setLayout(new FlowLayout(FlowLayout.CENTER))
                .addComponent(new JLabel("No paint"))
                .build();
    }
    
    public JPanel createFillPanel(Color color)
    {
        JButton colorButton = new JButton();
        colorButton.setBackground(color);
        colorButton.setPreferredSize(new Dimension(50, 25));
        colorButton.addActionListener(e ->
        {
            Color newColor = JColorChooser.showDialog(null, "Select color", colorButton.getBackground());
            if (newColor != null)
            {
                //DrawVars.fillColor = newColor;
                colorButton.setBackground(newColor);
                //Update.shapeSelected();
            }
        });
        return builder.reset()
                .setLayout(new FlowLayout(FlowLayout.LEFT))
                .setBorder(10, 10, 10, 10)
                .addComponent(new JLabel("Color:"))
                .addComponent(colorButton)
                .build();
    }

    public JPanel createGradientPanel()
    {
        JButton start = new JButton();
        JButton end = new JButton();
        
        start.setPreferredSize(new Dimension(50, 25));
        start.setBackground(Color.MAGENTA);
        end.setPreferredSize(new Dimension(50, 25));
        end.setBackground(Color.ORANGE);
        
        start.addActionListener(e -> System.out.println("Start"));
        end.addActionListener(e -> System.out.println("End"));
        
        JPanel startColorPanel = new ProperityPanelBuilder()
                .setLayout(new FlowLayout(FlowLayout.LEFT))
                .addComponent(new JLabel("Start Color:"))
                .addComponent(start)
                .build();

        JPanel endColorPanel = new ProperityPanelBuilder()
                .setLayout(new FlowLayout(FlowLayout.LEFT))
                .addComponent(new JLabel("End Color:"))
                .addComponent(end)
                .build();

        JPanel previewPanel = new GradientPreviewPanel(start, end);

        return builder.reset()
                .setLayout(new BoxLayout(builder.build(), BoxLayout.Y_AXIS))
                .setBorder(10, 10, 10, 10)
                .addComponent(startColorPanel)
                .addComponent(endColorPanel)
                .addComponent(previewPanel)
                .addComponent(Box.createVerticalGlue())
                .build();

    }
}
