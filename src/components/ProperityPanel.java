package components;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author Alfred
 */
public abstract class ProperityPanel extends JPanel
{

    protected final ProperityPanelFactory factory = new ProperityPanelFactory();
    private final JPanel panelOpciones = new JPanel();
    private final Map<String, JToggleButton> buttons = new HashMap<>();
    private final CardLayout cardLayout = new CardLayout();
    private final JPanel containerCard = new JPanel(cardLayout);
    private final Map<String, JPanel> panels = new HashMap<>();
    private final ButtonGroup toolGroup = new ButtonGroup();

    public ProperityPanel()
    {
        setLayout(new BorderLayout());
        initPanelOpciones();
        add(panelOpciones, BorderLayout.NORTH);
        add(containerCard, BorderLayout.CENTER);
        createOptions();
    }

    private void initPanelOpciones()
    {
        panelOpciones.setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    protected abstract void createOptions();

    protected void defaultSelection(String key)
    {
        cardLayout.show(containerCard, key);
        buttons.get(key).setSelected(true);
    }

    protected void addOption(String key, JToggleButton button, JPanel panel)
    {
        if (key == null || button == null || panel == null)
        {
            return;
        }
        buttons.put(key, button);
        panels.put(key, panel);

        toolGroup.add(button);
        panelOpciones.add(button);
        containerCard.add(panel, key);
        button.addActionListener((e) -> cardLayout.show(containerCard, key));
    }
}
