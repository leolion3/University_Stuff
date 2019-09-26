// The first import is used by the main method, the second one is for you
import java.lang.reflect.*;
import java.util.*;

/**
 * Exercise 2 (20 pts)
 *
 * The Cartograph creates himself a map which he then uses to navigate
 * his way to the treasure using the algorithm in exercise 1. That means
 * that this exercise can only be completed after exercise 1 has been
 * correctly implemented.
 *
 * Let this class extend the class from Exercise1. Implement the class's
 * constructor so that the output of "createMap" gets passed to the
 * Superclass. Implement the method "createMap" according to its description.
 *
 * The method "main" will be used for testing.
 *
 * Any changes to the "main" method will be ignored.
 */
class Exercise2 extends Exercise1
{
    /**
     * Constructor of the class Exercise2.
     * @param figure the figure that will be moved, must be passed
     *               to superclass.
     * @param width the width of the map, or in other words, the length
     *              of the Strings that make up the map.
     * @param height the height of the map, or in other words, the amount
     *               of Strings that make up the map.
     * @param xTreasure the x-location of the Treasure.
     * @param yTreasure the y-Location of the Treasure.
     */
    Exercise2(final GameObject figure, final int width, final int height,
              final int xTreasure, final int yTreasure)
    {
        super(figure,createMap(width,height,xTreasure,yTreasure));
    }

    /**
     * This method must create a Map that makes it possible to reach
     * the treasure from any location on the map. In order to do that,
     * each location must simply contain a symbol to turn the character
     * towards the Treasure ('>', 'V', '<' and  'A' for the directions
     * +x, +y, -x, -y) and 'X' for the treasure's location.
     * @param width the width of the Map, i.o.w. the length of the Strings
     *              that make it the map.
     * @param height the height of the map, i.o.w. the amount of Strings,
     *               that the map is made of.
     * @param xTreasure the x-Location of the Treasure.
     * @param yTreasure the y-Location of the Treasure.
     * @return the created Map.
     */
    static List<String> createMap(final int width, final int height,
                                  final int xTreasure, final int yTreasure)
    {
        List<String> newMap = new ArrayList<>();
        for (int y=0;y<height;y++){
            StringBuilder builder = new StringBuilder();
            for (int x=0;x<width;x++){
                if (x==xTreasure&&y==yTreasure){
                    builder.append('X');
                }
                if (x<xTreasure){
                    if (y<yTreasure){
                        builder.append('>');
                    }
                    else{
                        builder.append('A');
                    }
                }
                else{
                    if (y<yTreasure){
                        builder.append('V');
                    }
                    else {
                        builder.append('<');
                    }
                }
            }
            newMap.add(builder.toString());
        }
        return newMap;
    }

    /**
     * The way this method works is none of your concern, so just focus on getting
     * your implementation done correctly :]
     */
    public static void main(String[] args) throws ReflectiveOperationException, ClassCastException
    {
        final GameObject figure = new GameObject(4, 0, 0, "yellow");
        final Exercise2 instance = new Exercise2(figure, 20, 21, 12, 9);

        final Method moveMe = Exercise2.class.getSuperclass() == Object.class
                ? null : Exercise2.class.getSuperclass().getDeclaredMethod("moveMe");

        final int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (moveMe != null && (Boolean) moveMe.invoke(instance)) {
            figure.setLocation(figure.getX() + move[figure.getRotation()][0],
                              figure.getY() + move[figure.getRotation()][1]);
            Game.sleep(100);
        }
    }
}
