package components;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import model.PropertiesModel;
import utils.enums.Mode;
import utils.enums.StrokeType;
import utils.global.Global;
import utils.global.ShapeController;
import utils.interfaces.PropertiesObserver;
import utils.interfaces.UnionFillStroke;

/**
 *
 * @author Alfred
 */
public abstract class ProperityPanel extends JPanel implements PropertiesObserver
{

    private static PropertiesModel model;
    protected final ProperityPanelFactory factory;
    private final JPanel panelOpciones = new JPanel();
    private final Map<UnionFillStroke, JToggleButton> buttons = new HashMap<>();
    private final CardLayout cardLayout = new CardLayout();
    private final JPanel containerCard = new JPanel(cardLayout);
    private final Map<UnionFillStroke, JPanel> panels = new HashMap<>();
    private final ButtonGroup toolGroup = new ButtonGroup();

    public ProperityPanel(PropertiesModel model)
    {
        ProperityPanel.model = model;
        ProperityPanel.model.addObserver(ProperityPanel.this);
        factory = new ProperityPanelFactory(ProperityPanel.model);
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
    protected abstract UnionFillStroke getCurrentType(PropertiesModel model);

    protected void defaultSelection(UnionFillStroke key)
    {
        cardLayout.show(containerCard, key.getKey());
        buttons.get(key).setSelected(true);
    }

    protected void addOption(UnionFillStroke key, JToggleButton button, JPanel panel)
    {
        if (key == null || button == null || panel == null)
        {
            return;
        }
        buttons.put(key, button);
        panels.put(key, panel);

        toolGroup.add(button);
        panelOpciones.add(button);
        containerCard.add(panel, key.getKey());
        button.addActionListener(changedFillType(key));
    }

    @Override
    public void onPropertiesChanged(PropertiesModel model)
    {
        if (Global.ACTIVE_MODE instanceof Mode)
        {
            UnionFillStroke key = getCurrentType(model);
            buttons.get(key).setSelected(true);
            cardLayout.show(containerCard, key.getKey());
        }
    }

    private ActionListener changedFillType(UnionFillStroke key)
    {
        return (ActionEvent e) ->
        {
            key.applyToModel(model);
            cardLayout.show(containerCard, key.getKey());
            
            if (!Global.selectedShape.isEmty())
            {
                ShapeController.applyChangesToSelectedShape(model);                
            }
        };
    }
}
