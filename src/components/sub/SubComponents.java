package components.sub;

import utils.global.DrawVars;
import utils.interfaces.UpdatePreviewPanel;

import javax.swing.*;
import java.awt.*;

public class SubComponents
{
    public static JPanel createFillPanel()
    {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(new JLabel("Color:"));

        JButton colorButton = new JButton();
        colorButton.setBackground(DrawVars.fillColor);
        colorButton.setPreferredSize(new Dimension(50, 25));
        colorButton.addActionListener(e ->
        {
            Color newColor = JColorChooser.showDialog(
                    null, "Select color", colorButton.getBackground());
            if (newColor != null)
            {
                DrawVars.fillColor = newColor;
                colorButton.setBackground(newColor);
            }
        });
        panel.add(colorButton);
        return panel;
    }


    public static JPanel createGradientPanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Selector de color inicial
        JPanel startColorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        startColorPanel.add(new JLabel("Color Inicial:"));
        JButton startColorBtn = new JButton();
        startColorBtn.setBackground(DrawVars.startGradientColor);
        startColorBtn.setPreferredSize(new Dimension(50, 25));
        startColorPanel.add(startColorBtn);
        panel.add(startColorPanel);

        // Selector de color final
        JPanel endColorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        endColorPanel.add(new JLabel("Color Final:"));
        JButton endColorBtn = new JButton();
        endColorBtn.setBackground(DrawVars.endGradientColor);
        endColorBtn.setPreferredSize(new Dimension(50, 25));
        endColorPanel.add(endColorBtn);
        panel.add(endColorPanel);

        JPanel previewPanel = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                GradientPaint gradient = new GradientPaint(
                        0, 0, startColorBtn.getBackground(),
                        getWidth(), getHeight(), endColorBtn.getBackground()
                );

                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        previewPanel.setPreferredSize(new Dimension(200, 50));
        previewPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(previewPanel);
        panel.add(Box.createVerticalGlue());

        UpdatePreviewPanel preview = (btn) ->
        {
            Color newColor = JColorChooser.showDialog(null, "Seleccionar color", endColorBtn.getBackground());
            if (newColor != null)
            {
                btn.setBackground(newColor);
                previewPanel.repaint();
            }
        };

        startColorBtn.addActionListener(e ->
        {
            preview.update(startColorBtn);
            DrawVars.startGradientColor = startColorBtn.getBackground();
        });



        endColorBtn.addActionListener(e ->
        {
            preview.update(endColorBtn);
            DrawVars.endGradientColor = endColorBtn.getBackground();
        });

        return panel;
    }

    public static JPanel createTexturePanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Control de opacidad
        JPanel opacityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        opacityPanel.add(new JLabel("Opacidad:"));
        JSlider opacitySlider = new JSlider(0, 100, 100);
        opacitySlider.setPreferredSize(new Dimension(150, 25));
        opacityPanel.add(opacitySlider);
        panel.add(opacityPanel);

        // Modo de fusión
        JPanel blendPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        blendPanel.add(new JLabel("Modo de fusión:"));
        JComboBox<String> blendMode = new JComboBox<>(new String[]{
                "Normal", "Multiplicar", "Pantalla", "Superponer"
        });
        blendPanel.add(blendMode);
        panel.add(blendPanel);

        return panel;
    }

    public static JPanel createStrokePanel()
    {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(new JLabel("Color:"));

        JButton colorButton = new JButton();
        colorButton.setBackground(DrawVars.fillColor);
        colorButton.setPreferredSize(new Dimension(50, 25));
        colorButton.addActionListener(e ->
        {
            Color newColor = JColorChooser.showDialog(
                    null, "Select color", colorButton.getBackground());
            if (newColor != null)
            {
                DrawVars.fillColor = newColor;
                colorButton.setBackground(newColor);
            }
        });
        StrokePanel strokeStype = new StrokePanel();
        panel.add(colorButton);
        panel.add(strokeStype);
        return panel;
    }
}
