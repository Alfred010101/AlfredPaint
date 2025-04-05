package components;

import components.sub.CustomToggleButton;
import components.sub.MyIcon;
import java.awt.Color;
import javax.swing.JFrame;
import utils.enums.StrokeType;

/**
 *
 * @author Alfred
 */
public class StrokePanel extends ProperityPanel
{
    @Override
    protected void createOptions()
    {
        addOption(
                "Empty",
                new CustomToggleButton(new MyIcon(StrokeType.EMPTY), "Sin Relleno"),
                factory.createEmptyPanel("No borde")
        );

        addOption(
                "Solid",
                new CustomToggleButton(new MyIcon(StrokeType.SOLID), "Solido"),
                factory.createStrokePanel()
        );

        defaultSelection("Solid");
    }
}
