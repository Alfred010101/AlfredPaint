package components.sub;

import utils.global.DrawVars;
import utils.global.SwingVar;
import utils.global.Update;
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

//        JButton colorButton = new JButton();
        SwingVar.colorFillButton.setBackground(DrawVars.fillColor);
        SwingVar.colorFillButton.setPreferredSize(new Dimension(50, 25));
        SwingVar.colorFillButton.addActionListener(e ->
        {
            Color newColor = JColorChooser.showDialog(
                    null, "Select color", SwingVar.colorFillButton.getBackground());
            if (newColor != null)
            {
                DrawVars.fillColor = newColor;
                SwingVar.colorFillButton.setBackground(newColor);
                Update.shapeSelected();
            }
        });
        panel.add(SwingVar.colorFillButton);
        return panel;
    }


    public static JPanel createGradientPanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Selector de color inicial
        JPanel startColorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        startColorPanel.add(new JLabel("Start Color :"));
//        JButton startColorBtn = new JButton();
        SwingVar.startGradientColorButton.setBackground(DrawVars.startGradientColor);
        SwingVar.startGradientColorButton.setPreferredSize(new Dimension(50, 25));
        startColorPanel.add(SwingVar.startGradientColorButton);
        panel.add(startColorPanel);

        // Selector de color final
        JPanel endColorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        endColorPanel.add(new JLabel("  End Color :"));
//        JButton endColorBtn = new JButton();
        SwingVar.endGradientColorButton.setBackground(DrawVars.endGradientColor);
        SwingVar.endGradientColorButton.setPreferredSize(new Dimension(50, 25));
        endColorPanel.add(SwingVar.endGradientColorButton);
        panel.add(endColorPanel);

        JPanel previewPanel = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                GradientPaint gradient = new GradientPaint(
                        0, 0, SwingVar.startGradientColorButton.getBackground(),
                        getWidth(), getHeight(), SwingVar.endGradientColorButton.getBackground()
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
            Color newColor = JColorChooser.showDialog(null, "Seleccionar color", SwingVar.endGradientColorButton.getBackground());
            if (newColor != null)
            {
                btn.setBackground(newColor);
                previewPanel.repaint();
            }
        };

        SwingVar.startGradientColorButton.addActionListener(e ->
        {
            preview.update(SwingVar.startGradientColorButton);
            DrawVars.startGradientColor = SwingVar.startGradientColorButton.getBackground();
            Update.shapeSelected();
        });



        SwingVar.endGradientColorButton.addActionListener(e ->
        {
            preview.update(SwingVar.endGradientColorButton);
            DrawVars.endGradientColor = SwingVar.endGradientColorButton.getBackground();
            Update.shapeSelected();
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
