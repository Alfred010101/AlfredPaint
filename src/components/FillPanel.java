package components;

import components.sub.CustomToggleButton;
import components.sub.MyIcon;
import java.awt.Color;
import javax.swing.JFrame;
import model.PropertiesModel;
import utils.enums.FillType;

/**
 *
 * @author Alfred
 */
public class FillPanel extends ProperityPanel
{
    public FillPanel(PropertiesModel model)
    {
        super(model);
    }
    
    @Override
    protected void createOptions()
    {
        addOption(FillType.EMPTY,
                new CustomToggleButton(new MyIcon(FillType.EMPTY), "Sin Relleno"),
                factory.createEmptyPanel("No paint")
        );

        addOption(FillType.SOLID,
                new CustomToggleButton(new MyIcon(FillType.SOLID), "Solido"),
                factory.createFillPanel(Color.BLUE)
        );

        addOption(FillType.GRADIENT,
                new CustomToggleButton(new MyIcon(FillType.GRADIENT), "Gradiante"),
                factory.createGradientPanel()
        );

        addOption(FillType.TEXTURED,
                new CustomToggleButton(new MyIcon(FillType.TEXTURED), "Texturizado"),
                factory.createEmptyPanel("No paint")
        );

        defaultSelection(FillType.SOLID);
    }
}
