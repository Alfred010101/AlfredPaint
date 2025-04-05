package components;

import components.sub.CustomToggleButton;
import components.sub.MyIcon;
import java.awt.Color;
import javax.swing.JFrame;
import utils.enums.FillType;

/**
 *
 * @author Alfred
 */
public class FillPanel extends ProperityPanel
{

    @Override
    protected void createOptions()
    {
        addOption(
                "Empty",
                new CustomToggleButton(new MyIcon(FillType.EMPTY), "Sin Relleno"),
                factory.createEmptyPanel("No paint")
        );

        addOption(
                "Solid",
                new CustomToggleButton(new MyIcon(FillType.SOLID), "Solido"),
                factory.createFillPanel(Color.BLUE)
        );

        addOption("Gradiant",
                new CustomToggleButton(new MyIcon(FillType.GRADIENT), "Gradiante"),
                factory.createGradientPanel()
        );

        addOption(
                "Texture",
                new CustomToggleButton(new MyIcon(FillType.TEXTURED), "Texturizado"),
                factory.createEmptyPanel("No paint")
        );

        defaultSelection("Solid");
    }
}
