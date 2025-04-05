package components;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Alfred
 */
public class ProperityPanelBuilder
{
    private JPanel panel;

    public ProperityPanelBuilder()
    {
        this.panel = new JPanel();
    }

    public ProperityPanelBuilder setLayout(LayoutManager layout)
    {
        panel.setLayout(layout);
        return this;
    }

    public ProperityPanelBuilder setBorder(int top, int left, int bottom, int right)
    {
        panel.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));
        return this;
    }
    
    public ProperityPanelBuilder setBorder(Border borde)
    {
        panel.setBorder(borde);
        return this;
    }

    public ProperityPanelBuilder addComponent(Component component)
    {
        panel.add(component);
        return this;
    }
    
    public ProperityPanelBuilder addComponent(Component[] components)
    {
        for (Component component : components)
        {
            panel.add(component);
        }        
        return this;
    }

    public ProperityPanelBuilder setPreferredSize(Dimension dimension)
    {
        panel.setPreferredSize(dimension);
        return this;
    }

    public JPanel build()
    {
        return panel;
    }

    public ProperityPanelBuilder reset()
    {
        this.panel = new JPanel();
        return this;
    }
}
