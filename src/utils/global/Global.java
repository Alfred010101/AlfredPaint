package utils.global;

import model.MyShape;
import utils.enums.ShapeType;
import utils.interfaces.UnionType;

import java.awt.*;
import java.util.ArrayList;

public class Global
{
    public static Point pointPressed = new Point();
    public static Point pointReleased = new Point();
    public static Point pointDragged = new Point();
    
    public static UnionType ACTIVE_MODE = ShapeType.RECTANGLE;
    public static ArrayList<MyShape> shapes = new ArrayList<>();
    public static ArrayList<MyShape> selectedShapes = new ArrayList<>();

    public static Shape partialShape = null;
}
