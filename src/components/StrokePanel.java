package components;

import components.sub.CustomToggleButton;
import components.sub.MyIcon;
import java.awt.Color;
import javax.swing.JFrame;
import model.PropertiesModel;
import utils.enums.StrokeType;

/**
 *
 * @author Alfred
 */
public class StrokePanel extends ProperityPanel
{

    public StrokePanel(PropertiesModel model)
    {
        super(model);
    }    
    
    @Override
    protected void createOptions()
    {
        addOption(
                StrokeType.EMPTY,
                new CustomToggleButton(new MyIcon(StrokeType.EMPTY), "Sin Relleno"),
                factory.createEmptyPanel("No borde")
        );

        addOption(
                StrokeType.SOLID,
                new CustomToggleButton(new MyIcon(StrokeType.SOLID), "Solido"),
                factory.createStrokePanel()
        );

        defaultSelection(StrokeType.SOLID);
    }
}
