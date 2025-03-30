package utils.global;

import model.MyShape;
import model.edd.TuplaSimple;
import utils.enums.ShapeType;
import utils.interfaces.UnionModes;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Global
{
    public static Point pointPressed = new Point();
    public static Point pointReleased = new Point();
    public static Point pointDragged = new Point();

    public static UnionModes ACTIVE_MODE = ShapeType.RECTANGLE;
    public static ArrayList<MyShape> shapes = new ArrayList<>();
    public static ArrayList<MyShape> selectedShapes = new ArrayList<>();
//    /public static MyShape selectedShape = null;
//    public static int indexSelectedShape = -1;
    public static TuplaSimple<Integer, MyShape> selectedShape= new TuplaSimple<>();
    public static Shape partialShape = null;
}
