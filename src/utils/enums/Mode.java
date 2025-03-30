package utils.enums;

import utils.interfaces.UnionIcons;
import utils.interfaces.UnionType;

public enum Mode implements UnionType, UnionIcons
{
    DRAW_MODE,
    SELECT_ONE,
    SELECT_POINT,
    SELECT_AREA,
    SELECT_ALL
}
