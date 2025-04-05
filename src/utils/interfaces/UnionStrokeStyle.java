
package utils.interfaces;

import model.PropertiesModel;


/**
 *
 * @author Alfred
 */
public interface UnionStrokeStyle
{
    int getValue();
    void applyTo(PropertiesModel model);
    boolean isSelected(PropertiesModel model);
}
