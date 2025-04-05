package utils.enums;

import model.PropertiesModel;
import utils.interfaces.UnionFillStroke;
import utils.interfaces.UnionIcons;

public enum StrokeType implements UnionIcons, UnionFillStroke
{
    EMPTY,
    SOLID;
     
    @Override
    public String getKey() {
        return name();
    }

    @Override
    public void applyToModel(PropertiesModel model) {
        model.setStrokeType(this);
    }
}
