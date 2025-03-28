package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ShapesPanel extends JPanel
{
    public ShapesPanel(String txt)
    {
        super(new ShapesPanel.ResponsiveGridLayout(5));
        for (int i = 1; i <= 40; i++)
        {
            JButton btn = new JButton(txt + " " + i);
            btn.setPreferredSize(new Dimension(100, 30));
            add(btn);
        }
        addComponentListener(new ComponentAdapter()
        {
            @Override
            public void componentResized(ComponentEvent e)
            {
                int availableWidth = getWidth() - 20; // Descontar márgenes
                int buttonWidth = 100;
                int spacing = 10;

                // Calcular máximo de columnas posibles
                int maxColumns = Math.max(1, availableWidth / (buttonWidth + spacing));
                ((ShapesPanel.ResponsiveGridLayout) getLayout()).updateColumns(maxColumns);
            }
        });
    }

    private static JPanel createResponsiveSheet(String prefix, int buttonCount)
    {
        JPanel sheet = new JPanel();
        sheet.setLayout(new ShapesPanel.ResponsiveGridLayout(5)); // Columnas iniciales

        // Configuración visual de la hoja
        sheet.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        sheet.setBackground(new Color(240, 240, 240));

        // Añadir botones
        for (int i = 1; i <= buttonCount; i++)
        {
            JButton btn = new JButton(prefix + i);
            btn.setPreferredSize(new Dimension(100, 30));
            sheet.add(btn);
        }

        // Listener para cambios de tamaño
        sheet.addComponentListener(new ComponentAdapter()
        {
            @Override
            public void componentResized(ComponentEvent e)
            {
                int availableWidth = sheet.getWidth() - 20; // Descontar márgenes
                int buttonWidth = 100;
                int spacing = 10;

                // Calcular máximo de columnas posibles
                int maxColumns = Math.max(1, availableWidth / (buttonWidth + spacing));
                ((ShapesPanel.ResponsiveGridLayout) sheet.getLayout()).updateColumns(maxColumns);
            }
        });

        return sheet;
    }

    private static class ResponsiveGridLayout extends GridLayout
    {
        public ResponsiveGridLayout(int cols)
        {
            super(0, cols, 10, 10);
        }

        public void updateColumns(int newColumns)
        {
            if (getColumns() != newColumns)
            {
                setColumns(newColumns);
            }
        }
    }
}
