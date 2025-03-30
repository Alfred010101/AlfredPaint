package components.paint;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

public class Shapes
{

    public static Shape estrella(int x, int y, int width, int height)
    {
        GeneralPath estrella = new GeneralPath();
        estrella.moveTo(x + width / 2, y);
        estrella.lineTo(x + width * 0.62, y + height * 0.38);

        estrella.lineTo(x + width, y + height * 0.38);
        estrella.lineTo(x + width * 0.69, y + height * 0.62);

        estrella.lineTo(x + width * 0.81, y + height);
        estrella.lineTo(x + width / 2, y + height * 0.75);

        estrella.lineTo(x + width * 0.19, y + height);
        estrella.lineTo(x + width * 0.31, y + height * 0.62);

        estrella.lineTo(x, y + height * 0.38);
        estrella.lineTo(x + width * 0.38, y + height * 0.38);

        estrella.closePath();
        return estrella;
    }

    public static Shape luna(int x, int y, int width, int height)
    {

        GeneralPath luna = new GeneralPath();
        luna.moveTo(x, y);
        luna.curveTo(x + width / 2, y + height / 15, x + width / 2, y + height / 15 * 14, x, y + height);
        luna.curveTo(x + width / 3, y + height / 15 * 14, x + width / 3, y + height / 15, x, y);

        luna.closePath();
        return luna;
    }

    public static Shape espada(int x, int y, int width, int height)
    {

        GeneralPath espada = new GeneralPath();
        espada.moveTo(x + width * .5, y);

        espada.lineTo((x + width * .35), y + height * .15);

        espada.lineTo((x + width * .35), y + height * .8);
        espada.lineTo((x), y + height * .8);

        espada.lineTo((x), y + height * .83);
        espada.lineTo((x + width * .4), y + height * .83);

        espada.lineTo((x + width * .4), y + height * .92);
        espada.lineTo((x + width * .3), y + height * .96);

        espada.lineTo((x + width / 2), y + height);

        espada.lineTo((x + width * .7), y + height * .96);
        espada.lineTo((x + width * .6), y + height * .92);

        espada.lineTo((x + width * .6), y + height * .83);
        espada.lineTo((x + width), y + height * .83);

        espada.lineTo((x + width), y + height * .8);
        espada.lineTo((x + width * .65), y + height * .8);

        espada.lineTo((x + width * .65), y + height * .15);

        espada.closePath();
        return espada;
    }

    public static Shape piramide(int x, int y, int width, int height)
    {

        GeneralPath piramide = new GeneralPath();
        piramide.moveTo(x + width / 2, y + height); //x1

        piramide.lineTo(x + width / 2, y);
        piramide.lineTo(x, y + height * 0.7);
        piramide.lineTo(x + width / 2, y + height); //x1

        piramide.lineTo(x + width, y + height * 0.7);
        piramide.lineTo(x + width / 2, y);

        //piramide.closePath();
        return piramide;
    }

    public static Shape letraE(int x, int y, int width, int height)
    {
        GeneralPath letra = new GeneralPath();
        letra.moveTo(x + width, y); //x1

        letra.lineTo(x, y);
        letra.lineTo(x, y + height);

        letra.lineTo(x + width, y + height);

        letra.lineTo(x + width, y + height * .8);
        letra.lineTo(x + width * .3, y + height * .8);

        letra.lineTo(x + width * .3, y + height * .6);
        letra.lineTo(x + width, y + height * .6);
        letra.lineTo(x + width, y + height * .4);
        letra.lineTo(x + width * .3, y + height * .4);

        letra.lineTo(x + width * .3, y + height * .2);
        letra.lineTo(x + width, y + height * .2);

        letra.closePath();

        letra.moveTo(x + width, y + height * .2);
        letra.lineTo(x + width * 1.2, y + height * .05);
        letra.lineTo(x + width * 1.2, y + height * -.1);
        letra.lineTo(x + width * .2, y + height * -.1);
        letra.lineTo(x, y);

        letra.moveTo(x + width, y);
        letra.lineTo(x + width * 1.2, y + height * -.1);

        letra.moveTo(x + width, y + height * .6);
        letra.lineTo(x + width * 1.2, y + height * .45);
        letra.lineTo(x + width * 1.2, y + height * .3);
        letra.lineTo(x + width * .5, y + height * .3);
        letra.lineTo(x + width * .3, y + height * .4);
        letra.moveTo(x + width * .5, y + height * .3);
        letra.lineTo(x + width * .5, y + height * .2);

        letra.moveTo(x + width, y + height * .4);
        letra.lineTo(x + width * 1.2, y + height * .3);

        letra.moveTo(x + width, y + height);
        letra.lineTo(x + width * 1.2, y + height * .85);
        letra.lineTo(x + width * 1.2, y + height * .7);
        letra.lineTo(x + width * .5, y + height * .7);
        letra.lineTo(x + width * .3, y + height * .8);
        letra.moveTo(x + width * .5, y + height * .7);
        letra.lineTo(x + width * .5, y + height * .6);

        letra.moveTo(x + width, y + height * .8);
        letra.lineTo(x + width * 1.2, y + height * .7);

        return letra;
    }

    public static Shape torreE(int x, int y, int width, int height)
    {
        GeneralPath torre = new GeneralPath();
        torre.moveTo(x + width / 2, y);

        torre.lineTo(x + width / 2, y + height * .1);
        torre.lineTo(x + width * .55, y + height * .1);
        torre.lineTo(x + width * .58, y + height * .15);
        torre.lineTo(x + width * .55, y + height * .2);

        torre.quadTo(x + width * .58, y + height * .4, x + width * .7, y + height * .6);
        torre.lineTo(x + width * .74, y + height * .6);
        torre.lineTo(x + width * .72, y + height * .63);
        torre.lineTo(x + width * .71, y + height * .63);
        torre.quadTo(x + width * .73, y + height * .67, x + width * .78, y + height * .75);
        torre.lineTo(x + width * .82, y + height * .75);
        torre.lineTo(x + width * .82, y + height * .79);
        torre.quadTo(x + width * .86, y + height * .85, x + width, y + height);
        torre.lineTo(x + width * .8, y + height);

        torre.quadTo(x + width * .5, y + height * .7, x + width * .2, y + height);

        torre.lineTo(x, y + height);
        torre.quadTo(x + width * .14, y + height * .85, x + width * .18, y + height * .79);
        torre.lineTo(x + width * .18, y + height * .75);
        torre.lineTo(x + width * .22, y + height * .75);
        torre.quadTo(x + width * .27, y + height * .67, x + width * .28, y + height * .63);
        torre.lineTo(x + width * .27, y + height * .63);
        torre.lineTo(x + width * .26, y + height * .6);
        torre.lineTo(x + width * .3, y + height * .6);
        torre.quadTo(x + width * .42, y + height * .4, x + width * .45, y + height * .2);

        torre.lineTo(x + width * .42, y + height * .15);
        torre.lineTo(x + width * .45, y + height * .1);
        torre.lineTo(x + width / 2, y + height * .1);

        torre.moveTo(x + width * .34, y + height * .75);
        torre.lineTo(x + width * .66, y + height * .75);
        torre.quadTo(x + width * .62, y + height * .7, x + width * .6, y + height * .63);
        torre.lineTo(x + width * .4, y + height * .63);
        torre.quadTo(x + width * .38, y + height * .7, x + width * .34, y + height * .75);

        return torre;
    }

    public static Shape trebol(int x, int y, int width, int height)
    {
        GeneralPath trebol = new GeneralPath();
        trebol.moveTo(x, y + height);

        trebol.quadTo(x + width * .25, y + height, x + width * .5, y + height * .5);
        trebol.quadTo(x + width * .3, y + height, x, y + height);
//        x.quadTo(x + width * .15, y + height * 1.10, x + width * .52, y + height * .90);
        GeneralPath trebolB = new GeneralPath();
        trebolB.moveTo(x + width * .5, y + height * .5);
        trebolB.curveTo(x + width * .15, y + height * 1.10, x + width * .45, y + height * 1.1, x + width * .52, y + height * .85);
        trebolB.curveTo(x + width * .57, y + height * 1.10, x + width * .87, y + height * 1.1, x + width * .5, y + height * .5);
        trebolB.quadTo(x + width * .47, y + height * .7, x + width * .5, y + height * .8);
//        x.lineTo(x + width * .5, y + height * .8);
        GeneralPath combinedShape = new GeneralPath();
        for (int i = 0; i < 4; i++)
        {
            AffineTransform tr = new AffineTransform();
            tr.rotate(Math.toRadians(80 + 90 * i), x + width / 2, y + height / 2);
            Shape rotacion = tr.createTransformedShape(trebolB);
            combinedShape.append(rotacion, false); // Añade rotacion
        }

        combinedShape.append(trebol, false);
        return combinedShape;
    }

    public static Shape rayo(int x, int y, int width, int height)
    {
        GeneralPath rayo = new GeneralPath();

        rayo.moveTo(x, y + height);

        rayo.lineTo(x + width * .4, y + height * .6);
        rayo.lineTo(x, y + height * .6);
        rayo.lineTo(x + width, y);
        rayo.lineTo(x + width * .6, y + height * .4);
        rayo.lineTo(x + width, y + height * .4);
        rayo.closePath();

        return rayo;
    }

    public static Shape corazon(int x, int y, int width, int height)
    {
        GeneralPath corazon = new GeneralPath();

        corazon.moveTo(x + width * .5, y + height);
        corazon.curveTo(x + width * .1, y + height * .4, x + width * .4, y, x + width * .5, y + height * .5);
        corazon.curveTo(x + width * .6, y, x + width * .9, y + height * .4, x + width * .5, y + height);

        return corazon;
    }

    public static Shape pentagono(int x, int y, int width, int height)
    {
        int radius = Math.min(width, height) / 2;
        int centerX = x + width / 2;
        int centerY = y + height / 2;
        // Crear el polígono del pentágono
        Polygon pentagon = new Polygon();
        // Calcular los 5 vértices del pentágono
        for (int i = 0; i < 5; i++)
        {
            // Ángulo en radianes (90° para empezar en la punta + 72° por cada vértice)
            double angle = Math.toRadians(90 + (i * 72));
            int vertexX = centerX + (int) (radius * Math.cos(angle));
            int vertexY = centerY - (int) (radius * Math.sin(angle)); // Restamos porque en pantalla Y crece hacia abajo
            pentagon.addPoint(vertexX, vertexY);
        }
        return pentagon;
    }
}