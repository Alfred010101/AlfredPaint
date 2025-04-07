package utils.global;

public class Const
{

    public static final String[] TAB_NAMES =
    {
        "Fill", "Stroke", "Opacity", "Close All"
    };
    public static final boolean[] tabVisibility = new boolean[TAB_NAMES.length];

    public static final float[][] patterns =
    {
        null, // Continua

        {
            5, 3
        },
        {
            8, 4
        },
        {
            10, 5
        },
        {
            12, 6
        },
        {
            15, 5
        },
        {
            20, 10
        }, // Discontinuos

        {
            2, 2
        },
        {
            3, 3
        },
        {
            4, 4
        },
        {
            5, 5
        }, // Punteados

        {
            10, 3, 3, 3
        },
        {
            15, 5, 5, 5
        },
        {
            20, 5, 5, 5, 5, 5
        }, // Mixtos

        {
            15, 5, 3, 5
        },
        {
            20, 10, 5, 10
        }, // Guiones

        {
            5, 3, 15, 3
        },
        {
            8, 4, 20, 4
        }, // Puntos-guis

        {
            10, 4, 2, 4, 2, 4
        },
        {
            15, 5, 3, 5, 3, 5, 3, 5
        } // Complejos
    };
}
