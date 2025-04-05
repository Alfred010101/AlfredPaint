package utils.enums;

import model.PropertiesModel;
import utils.interfaces.UnionIcons;
import utils.interfaces.UnionStrokeStyle;

public enum StrokeCap implements UnionIcons, UnionStrokeStyle
{
    CAP_BUTT(0),
    CAP_ROUND(1),
    CAP_SQUARE(2);

    private final int value;

    StrokeCap(int value)
    {
        this.value = value;
    }

    @Override
    public int getValue()
    {
        return value;
    }

    @Override
    public void applyTo(PropertiesModel model)
    {
        model.setStrokeCap(value);
    }

    @Override
    public boolean isSelected(PropertiesModel model)
    {
        return model.getStrokeCap() == this.value;
    }
}
