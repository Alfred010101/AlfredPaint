package components;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ShapesPanel extends JPanel
{
    public ShapesPanel(JToggleButton[] buttons, String title)
    {
        super(new ShapesPanel.ResponsiveGridLayout(1));
        for (JToggleButton btn : buttons)
        {
            add(btn);
        }
        setBorder(BorderFactory.createTitledBorder(title));
        addComponentListener(new ComponentAdapter()
        {
            @Override
            public void componentResized(ComponentEvent e)
            {
                int availableWidth = getWidth() - 20; // Descontar márgenes
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
