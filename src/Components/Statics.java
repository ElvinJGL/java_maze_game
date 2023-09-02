package Components;
import Objects.Point;

public final class Statics {

    public static Character PLAYER = new Character();

    public static Point START = new Point();
    public static Point FINISH = new Point();

    public static Point U_BLOCK = new Point();
    public static Point D_BLOCK = new Point();
    public static Point L_BLOCK = new Point();
    public static Point R_BLOCK = new Point();

    public static Point MAP_DIMENSION = new Point();

    public static Map[] LEVELS = {
        new Map(1),
        new Map(2),
        new Map(3),
        new Map(4)
    };

    private Statics() {}
}
