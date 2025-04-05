package utils.enums;

import model.PropertiesModel;
import utils.interfaces.UnionFillStroke;
import utils.interfaces.UnionIcons;

public enum FillType implements UnionIcons, UnionFillStroke
{
    EMPTY,
    SOLID,
    GRADIENT,
    TEXTURED;

    @Override
    public String getKey()
    {
        return name();
    }

    @Override
    public void applyToModel(PropertiesModel model)
    {
        model.setFillType(this);
    }
}
