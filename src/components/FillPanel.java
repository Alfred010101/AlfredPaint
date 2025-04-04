package components;

import components.sub.CustomToggleButton;
import components.sub.MyIcon;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import utils.enums.FillType;

/**
 *
 * @author Alfred
 */
public class FillPanel extends ProperityPanel
{

    public FillPanel()
    {
        super();
        
    }
    
    public static void main(String[] args)
    {
        JFrame f = new JFrame();
        f.add(new FillPanel());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(349, 242);
        f.setVisible(true);
    }

    @Override
    protected void createOptions()
    {
        addOption("Empty", new CustomToggleButton(new MyIcon(FillType.EMPTY), "Sin Relleno"), factory.createEmptyPanel());
        addOption("Solid", new CustomToggleButton(new MyIcon(FillType.SOLID), "Solido"), factory.createFillPanel(Color.BLUE));
        addOption("Gradiant", new CustomToggleButton(new MyIcon(FillType.GRADIENT), "Gradiante"), factory.createGradientPanel());
        addOption("Texture", new CustomToggleButton(new MyIcon(FillType.TEXTURED), "Texturizado"), factory.createEmptyPanel());
        defaultSelection("Solid");        
    }
}
