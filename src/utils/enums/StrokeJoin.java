package utils.enums;

import model.PropertiesModel;
import utils.interfaces.UnionIcons;
import utils.interfaces.UnionStrokeStyle;

public enum StrokeJoin implements UnionIcons, UnionStrokeStyle
{
    JOIN_MITER(0),
    JOIN_ROUND(1),
    JOIN_BEVEL(2);    
    
    private final int value;

    StrokeJoin(int value) {
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
        model.setStrokeJoin(value);
    }

    @Override
    public boolean isSelected(PropertiesModel model)
    {
        return model.getStrokeJoin() == this.value;
    }
}
