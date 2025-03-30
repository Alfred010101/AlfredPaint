package model.edd;

public class TuplaSimple<Integer, MyShape>
{
    private Integer key;
    private MyShape shape;

    public TuplaSimple()
    {
        this.key = null;
        this.shape = null;
    }

    public TuplaSimple(Integer key, MyShape shape)
    {
        this.key = key;
        this.shape = shape;
    }

    public Integer getKey()
    {
        return key;
    }

//    public void setKey(Integer key)
//    {
//        this.key = key;
//    }

    public MyShape getMyShape()
    {
        return shape;
    }

//    public void setShape(MyShape shape)
//    {
//        this.shape = shape;
//    }

    public void put(Integer key, MyShape shape)
    {
        this.key = key;
        this.shape = shape;
    }

    public void clear()
    {
        this.key = null;
        this.shape = null;
    }

    public boolean isEmty()
    {
        return this.key == null && this.shape == null;
    }
}
