package utils.sub;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SubComponents
{
    public static JPanel createFillPanel()
    {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(new JLabel("Color:"));

        JButton colorButton = new JButton();
        colorButton.setBackground(Color.RED);
        colorButton.setPreferredSize(new Dimension(50, 25));
        colorButton.addActionListener(e ->
        {
            Color newColor = JColorChooser.showDialog(
                    null, "Seleccionar color", colorButton.getBackground());
            if (newColor != null)
            {
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
        JButton startColorBtn = createColorButton(Color.BLACK);
        startColorPanel.add(startColorBtn);
        panel.add(startColorPanel);

        // Selector de color final
        JPanel endColorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        endColorPanel.add(new JLabel("Color Final:"));
        JButton endColorBtn = createColorButton(Color.BLACK);
        endColorPanel.add(endColorBtn);
        panel.add(endColorPanel);

        // Control de ángulo
        JPanel anglePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        anglePanel.add(new JLabel("Ángulo (grados):"));
        JSpinner angleSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 359, 1));
        angleSpinner.setPreferredSize(new Dimension(60, 20));
        anglePanel.add(angleSpinner);
        panel.add(anglePanel);

        JPanel previewPanel = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                int angle = (int) angleSpinner.getValue();
                double radians = Math.toRadians(angle);
                float x2 = (float) Math.cos(radians);
                float y2 = (float) Math.sin(radians);

                // Escalar según el tamaño del panel
                x2 *= getWidth();
                y2 *= getHeight();

                GradientPaint gradient = new GradientPaint(
                        0, 0, startColorBtn.getBackground(),
                        x2, y2, endColorBtn.getBackground()
                );

                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        previewPanel.setPreferredSize(new Dimension(200, 50));
        previewPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(previewPanel);
        panel.add(Box.createVerticalGlue());

        // Listeners para actualizar la previsualización
        ActionListener updateListener = e -> previewPanel.repaint();
        startColorBtn.addActionListener(updateListener);
        endColorBtn.addActionListener(updateListener);
        angleSpinner.addChangeListener(e -> previewPanel.repaint());

        return panel;
    }

    private static JButton createColorButton(Color initialColor)
    {
        JButton colorButton = new JButton();
        colorButton.setBackground(initialColor);
        colorButton.setPreferredSize(new Dimension(50, 25));
        colorButton.addActionListener(e ->
        {
            Color newColor = JColorChooser.showDialog(
                    null, "Seleccionar color", colorButton.getBackground());
            if (newColor != null)
            {
                colorButton.setBackground(newColor);
            }
        });
        return colorButton;
    }

    public static JPanel createOpacityPanel()
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
}
