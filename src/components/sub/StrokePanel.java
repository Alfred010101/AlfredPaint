package components.sub;

import mian.PaintApp;
import utils.enums.StrokeCap;
import utils.enums.StrokeJoin;
import utils.global.DrawVars;
import utils.global.Global;
import utils.global.ShapeController;

import javax.swing.*;
import java.awt.*;

public class StrokePanel extends JPanel
{
    public static float currentWidth = 2.0f;
    public static int capType = BasicStroke.CAP_BUTT;
    public static int joinType = BasicStroke.JOIN_MITER;
    public static float[] dashPattern = null;


    private static JSlider widthSlider;
    private JLabel widthValueLabel;
    private ButtonGroup capButtonGroup, joinButtonGroup;
    private JComboBox<float[]> styleCombo;
    private JButton colorButton;
    private JToggleButton[] buttonJoin = new CustomToggleButton[3];
    private JToggleButton[] buttonCap = new CustomToggleButton[3];

    private float[][] patternsClase;

    public StrokePanel()
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel colorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        colorPanel.add(new JLabel("Color:"));

        colorButton = new JButton();
        colorButton.setBackground(DrawVars.strokeColor);
        colorButton.setPreferredSize(new Dimension(50, 25));
        colorButton.addActionListener(e ->
        {
            Color newColor = JColorChooser.showDialog(
                    null, "Select color", colorButton.getBackground());
            if (newColor != null)
            {
                DrawVars.strokeColor = newColor;
                colorButton.setBackground(newColor);
                if (!Global.selectedShape.isEmty())
                {
                    Global.selectedShape.getMyShape().setStrokeColor(DrawVars.strokeColor);
                    PaintApp.workPanel.repaint();
                    // ShapeController.shapeSelected();
                }
            }
        });
        colorPanel.add(colorButton);
        add(colorPanel);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBorder(BorderFactory.createTitledBorder("Style"));
        // Control de grosor
        JPanel widthPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        widthPanel.add(new JLabel("Width: "));

        widthSlider = new JSlider(1, 20, (int) currentWidth);
        widthSlider.addChangeListener(e ->
        {
            currentWidth = widthSlider.getValue();
            widthValueLabel.setText(String.valueOf((int) currentWidth));
            updateStroke();
        });

        widthValueLabel = new JLabel(String.valueOf((int) currentWidth));
        widthValueLabel.setPreferredSize(new Dimension(20, 15));

        widthPanel.add(widthSlider);
        widthPanel.add(widthValueLabel);
        container.add(widthPanel);

        // Control de terminación

        JPanel capPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        capPanel.add(new JLabel("Cap:"));
        capButtonGroup = new ButtonGroup();

        StrokeCap[] capValues = {StrokeCap.CAP_BUTT, StrokeCap.CAP_ROUND, StrokeCap.CAP_SQUARE};
        String[] capNames = {"BUTT CAP", "ROUND CAP", "SQUARE CAP"};
        for (int i = 0; i < capValues.length; i++)
        {
            buttonCap[i] = new CustomToggleButton(new MyIcon(capValues[i]), capNames[i]);
            buttonCap[i].setPreferredSize(new Dimension(35, 35)); // Tamaño compacto
            buttonCap[i].setMinimumSize(new Dimension(35, 35));
            buttonCap[i].setMaximumSize(new Dimension(35, 35));
            final int capValue = switch (capValues[i])
            {
                case CAP_BUTT -> 0;
                case CAP_ROUND -> 1;
                case CAP_SQUARE -> 2;
            };
            buttonCap[i].addActionListener(e ->
            {
                capType = capValue;
                updateStroke();
            });
            if (i == 0) buttonCap[i].setSelected(true);
            capButtonGroup.add(buttonCap[i]);
            capPanel.add(buttonCap[i]);
        }
        container.add(capPanel);

        // Control de unión

        JPanel joinPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        joinPanel.add(new JLabel("Join:"));
        joinButtonGroup = new ButtonGroup();

        StrokeJoin[] joinValues = {StrokeJoin.JOIN_MITER, StrokeJoin.JOIN_ROUND, StrokeJoin.JOIN_BEVEL};
        String[] joinNames = {"MITER JOIN", "ROUND JOIN", "BEVEL JOIN"};
        for (int i = 0; i < joinValues.length; i++)
        {
            buttonJoin[i] = new CustomToggleButton(new MyIcon(joinValues[i]), joinNames[i]);
            buttonJoin[i].setPreferredSize(new Dimension(35, 35)); // Tamaño compacto
            buttonJoin[i].setMinimumSize(new Dimension(35, 35));
            buttonJoin[i].setMaximumSize(new Dimension(35, 35));

            final int joinValue = switch (joinValues[i])
            {
                case JOIN_MITER -> 0;
                case JOIN_ROUND -> 1;
                case JOIN_BEVEL -> 2;
            };
            buttonJoin[i].addActionListener(e ->
            {
                joinType = joinValue;
                updateStroke();
            });
            if (i == 0) buttonJoin[i].setSelected(true);
            joinButtonGroup.add(buttonJoin[i]);
            joinPanel.add(buttonJoin[i]);
        }
        container.add(joinPanel);

        JPanel stylePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        stylePanel.add(new JLabel("Estilo:"));
        float[][] patterns = {
                null, // Continua
                {5, 3}, {8, 4}, {10, 5}, {12, 6}, {15, 5}, {20, 10}, // Discontinuos
                {2, 2}, {3, 3}, {4, 4}, {5, 5}, // Punteados
                {10, 3, 3, 3}, {15, 5, 5, 5}, {20, 5, 5, 5, 5, 5}, // Mixtos
                {15, 5, 3, 5}, {20, 10, 5, 10}, // Guiones
                {5, 3, 15, 3}, {8, 4, 20, 4}, // Puntos-guis
                {10, 4, 2, 4, 2, 4}, {15, 5, 3, 5, 3, 5, 3, 5} // Complejos
        };

        patternsClase = patterns;

        styleCombo = new JComboBox<>(patterns);
        styleCombo.setRenderer(new StrokePanel.LineStyleRenderer());
        styleCombo.setMaximumRowCount(20);
        styleCombo.addActionListener(e ->
        {
            int patter = styleCombo.getSelectedIndex();
            dashPattern = (patter == -1) ? null : patterns[patter];
            updateStroke();
        });
        stylePanel.add(styleCombo);
        container.add(stylePanel);
        add(container);
        add(Box.createVerticalGlue());
    }

    private class LineStyleRenderer extends JPanel implements ListCellRenderer<float[]>
    {
        private float[] pattern;

        @Override
        public Component getListCellRendererComponent(JList<? extends float[]> list, float[] value,
                                                      int index, boolean isSelected, boolean cellHasFocus)
        {
            this.pattern = value;
            setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
            updateStroke();
            return this;
        }

        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Dibujar ejemplo de línea
            BasicStroke stroke = pattern != null ?
                    new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1.0f, pattern, 0.0f) :
                    new BasicStroke(2);

            g2.setColor(Color.BLACK);
            g2.setStroke(stroke);
            int y = getHeight() / 2;
            g2.drawLine(10, y, getWidth() - 10, y);
        }

        @Override
        public Dimension getPreferredSize()
        {
            return new Dimension(200, 25);
        }
    }

    private void updateStroke()
    {
        DrawVars.strokeDraw = (dashPattern != null) ?
                new BasicStroke(currentWidth, capType, joinType, 1.0f, dashPattern, 0.0f) :
                new BasicStroke(currentWidth, capType, joinType);
        if(!Global.selectedShape.isEmty())
        {
            Global.selectedShape.getMyShape().setStroke(DrawVars.strokeDraw);
            PaintApp.workPanel.repaint();
        }
    }

    public void updateInterfaz()
    {
        widthValueLabel.setText(String.valueOf((int) StrokePanel.currentWidth));
        widthSlider.setValue((int) StrokePanel.currentWidth);

        styleCombo.setSelectedIndex(encontrarIndicePatron(dashPattern));
        colorButton.setBackground(DrawVars.strokeColor);
        buttonCap[capType].setSelected(true);
        buttonJoin[joinType].setSelected(true);
    }

    private int encontrarIndicePatron(float[] patronBuscado)
    {
        for (int i = 0; i < patternsClase.length; i++)
        {
            if (patternsClase[i] == null)
            {
                if (patronBuscado == null)
                {
                    return i; // Caso especial para el primer elemento null
                }
                continue;
            }

            if (patronBuscado == null)
            {
                continue;
            }

            if (patternsClase[i].length != patronBuscado.length)
            {
                continue;
            }

            boolean coincide = true;
            for (int j = 0; j < patternsClase[i].length; j++)
            {
                if (patternsClase[i][j] != patronBuscado[j])
                {
                    coincide = false;
                    break;
                }
            }

            if (coincide)
            {
                return i;
            }
        }
        return -1; // Retorna -1 si no se encuentra el patrón
    }
}
