package components;

import components.sub.CustomToggleButton;
import components.sub.GradientPreviewPanel;
import components.sub.LineStyleRenderer;
import components.sub.MyIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import model.PropertiesModel;
import utils.enums.StrokeCap;
import utils.enums.StrokeJoin;
import utils.interfaces.UnionIcons;
import utils.interfaces.UnionStrokeStyle;

/**
 *
 * @author Alfred
 */
public class ProperityPanelFactory
{

    private final PropertiesModel model;

    public ProperityPanelFactory(PropertiesModel model)
    {
        this.model = model;
    }

    private final ProperityPanelBuilder builder = new ProperityPanelBuilder();

    public JPanel createEmptyPanel(String txt)
    {
        return builder.reset()
                .setLayout(new FlowLayout(FlowLayout.CENTER))
                .addComponent(new JLabel(txt))
                .build();
    }

    public JPanel createFillPanel()
    {
        JButton colorButton = new JButton();
        colorButton.setBackground(model.getFillColor());
        colorButton.setPreferredSize(new Dimension(50, 25));
        colorButton.addActionListener(e ->
        {
            Color newColor = JColorChooser.showDialog(null, "Select color", colorButton.getBackground());
            if (newColor != null)
            {
                model.setFillColor(newColor);
                colorButton.setBackground(newColor);
            }
        });
        return builder.reset()
                .setLayout(new FlowLayout(FlowLayout.LEFT))
                .setBorder(10, 10, 10, 10)
                .addComponent(new JLabel("Color:"))
                .addComponent(colorButton)
                .build();
    }

    public JPanel createGradientPanel()
    {
        JButton start = new JButton();
        JButton end = new JButton();

        start.setPreferredSize(new Dimension(50, 25));
        start.setBackground(model.getStartGradientColor());
        end.setPreferredSize(new Dimension(50, 25));
        end.setBackground(model.getEndGradientColor());

        JPanel startColorPanel = new ProperityPanelBuilder()
                .setLayout(new FlowLayout(FlowLayout.LEFT))
                .addComponent(new JLabel("Start Color:"))
                .addComponent(start)
                .build();

        JPanel endColorPanel = new ProperityPanelBuilder()
                .setLayout(new FlowLayout(FlowLayout.LEFT))
                .addComponent(new JLabel("End Color:"))
                .addComponent(end)
                .build();

        JPanel previewPanel = new GradientPreviewPanel(model, start, end);

        return builder.reset()
                .setLayout(new BoxLayout(builder.build(), BoxLayout.Y_AXIS))
                .setBorder(10, 10, 10, 10)
                .addComponent(startColorPanel)
                .addComponent(endColorPanel)
                .addComponent(previewPanel)
                .addComponent(Box.createVerticalGlue())
                .build();
    }

    public JPanel createStrokePanel()
    {
        return builder
                .reset()
                .setLayout(new BoxLayout(builder.build(), BoxLayout.Y_AXIS))
                .setBorder(0, 10, 10, 10)
                .addComponent(panelButton())
                .addComponent(panelConfig())
                .build();
    }

    private JPanel panelButton()
    {
        JButton colorButton = new JButton();
        colorButton.setBackground(Color.RED);
        colorButton.setPreferredSize(new Dimension(50, 25));
        colorButton.addActionListener(e ->
        {
            Color newColor = JColorChooser.showDialog(
                    null, "Select color", colorButton.getBackground());
            if (newColor != null)
            {
                //DrawVars.strokeColor = newColor;
                colorButton.setBackground(newColor);
//                if (!Global.selectedShape.isEmty())
//                {
//                    Global.selectedShape.getMyShape().setStrokeColor(DrawVars.strokeColor);
//                    PaintApp.workPanel.repaint();
//                    // Update.shapeSelected();
//                }
            }
        });

        return new ProperityPanelBuilder()
                .setLayout(new FlowLayout(FlowLayout.LEFT))
                .addComponent(new JLabel("Color:"))
                .addComponent(colorButton)
                .build();
    }

    private JPanel panelConfig()
    {
        ProperityPanelBuilder container = new ProperityPanelBuilder();
        return container
                .setLayout(new BoxLayout(container.build(), BoxLayout.Y_AXIS))
                .setBorder(BorderFactory.createTitledBorder("Style"))
                .addComponent(panelWidth())
                .addComponent(panelProp(
                        " Cap :",
                        new StrokeCap[]
                        {
                            StrokeCap.CAP_BUTT, StrokeCap.CAP_ROUND, StrokeCap.CAP_SQUARE
                        },
                        new String[]
                        {
                            "BUTT CAP", "ROUND CAP", "SQUARE CAP"
                        }
                ))
                .addComponent(panelProp(
                        "Join :",
                        new StrokeJoin[]
                        {
                            StrokeJoin.JOIN_MITER, StrokeJoin.JOIN_ROUND, StrokeJoin.JOIN_BEVEL
                        },
                        new String[]
                        {
                            "MITER JOIN", "ROUND JOIN", "BEVEL JOIN"
                        }
                ))
                .addComponent(panelStyle())
                .build();
    }

    private JPanel panelWidth()
    {
        JSlider widthSlider = new JSlider(1, 20, 2);
        widthSlider.addChangeListener(e ->
        {
//            currentWidth = widthSlider.getValue();
//            widthValueLabel.setText(String.valueOf((int) currentWidth));
//            updateStroke();
        });

        JLabel widthValueLabel = new JLabel("20");
        widthValueLabel.setPreferredSize(new Dimension(20, 15));

        return new ProperityPanelBuilder()
                .setLayout(new FlowLayout(FlowLayout.LEFT))
                .addComponent(new JLabel("Width: "))
                .addComponent(widthSlider)
                .addComponent(widthValueLabel)
                .build();

    }

    private JPanel panelProp(String txt, UnionStrokeStyle[] items, String[] names)
    {

        ButtonGroup capButtonGroup = new ButtonGroup();

//        StrokeCap[] capValues = {StrokeCap.CAP_BUTT, StrokeCap.CAP_ROUND, StrokeCap.CAP_SQUARE};
//        String[] capNames = {"BUTT CAP", "ROUND CAP", "SQUARE CAP"};
        JToggleButton[] btns = new JToggleButton[items.length];

        for (int i = 0; i < items.length; i++)
        {
            btns[i] = new CustomToggleButton(new MyIcon((UnionIcons) items[i]), names[i]);
            btns[i].setPreferredSize(new Dimension(35, 35)); // Tamaño compacto
            btns[i].setMinimumSize(new Dimension(35, 35));
            btns[i].setMaximumSize(new Dimension(35, 35));
            btns[i].addActionListener(e ->
            {
//                capType = switch (items[i])
//                {
//                    case CAP_BUTT ->
//                        0;
//                    case CAP_ROUND ->
//                        1;
//                    case CAP_SQUARE ->
//                        2;
//                };;
//                updateStroke();
            });
            capButtonGroup.add(btns[i]);
        }

        return new ProperityPanelBuilder()
                .setLayout(new FlowLayout(FlowLayout.LEFT))
                .addComponent(new JLabel(txt))
                .addComponent(btns)
                .build();
    }

    private JPanel panelStyle()
    {
        float[][] patterns =
        {
            null, // Continua
            
            {
                5, 3
            }, 
            {
                8, 4
            }, 
            {
                10, 5
            }, 
            {
                12, 6
            }, 
            {
                15, 5
            }, 
            {
                20, 10
            }, // Discontinuos
            
            {
                2, 2
            }, 
            {
                3, 3
            }, 
            {
                4, 4
            }, 
            {
                5, 5
            }, // Punteados
            
            {
                10, 3, 3, 3
            }, 
            {
                15, 5, 5, 5
            }, 
            {
                20, 5, 5, 5, 5, 5
            }, // Mixtos
            
            {
                15, 5, 3, 5
            }, 
            {
                20, 10, 5, 10
            }, // Guiones
            
            {
                5, 3, 15, 3
            }, 
            {
                8, 4, 20, 4
            }, // Puntos-guis
            
            {
                10, 4, 2, 4, 2, 4
            }, 
            {
                15, 5, 3, 5, 3, 5, 3, 5
            } // Complejos
        };
        JComboBox<float[]> styleCombo = new JComboBox<>(patterns);
        styleCombo.setRenderer(new LineStyleRenderer());
        styleCombo.setMaximumRowCount(20);
        styleCombo.addActionListener(e ->
        {
            int patter = styleCombo.getSelectedIndex();
//            dashPattern = (patter == -1) ? null : patterns[patter];
//            updateStroke();
        });
        return new ProperityPanelBuilder()
                .setLayout(new FlowLayout(FlowLayout.LEFT))
                .addComponent(new JLabel("Estilo:"))
                .addComponent(styleCombo)
                .build();
    }
}
