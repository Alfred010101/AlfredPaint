package components;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ShapesPanel extends JPanel
{
    public ShapesPanel(JToggleButton[] buttons)
    {
        super(new ShapesPanel.ResponsiveGridLayout(1));
        for (JToggleButton btn : buttons)
        {
            btn.setPreferredSize(new Dimension(30, 30)); // Tamaño compacto
            btn.setMinimumSize(new Dimension(30, 30));
            btn.setMaximumSize(new Dimension(30, 30));

            add(btn);
        }
        setBorder(BorderFactory.createTitledBorder("Java"));
        addComponentListener(new ComponentAdapter()
        {
            @Override
            public void componentResized(ComponentEvent e)
            {
                int availableWidth = getWidth() - 20; // Descontar márgenes
                System.out.println(availableWidth);
                int buttonWidth = 30;
                int spacing = 0;

                // Calcular máximo de columnas posibles
                int maxColumns = Math.max(1, availableWidth / (buttonWidth + spacing));
                ((ShapesPanel.ResponsiveGridLayout) getLayout()).updateColumns(maxColumns);
            }
        });
    }

    private static class ResponsiveGridLayout extends GridLayout
    {
        public ResponsiveGridLayout(int cols)
        {
            super(0, cols, 0, 0);
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
