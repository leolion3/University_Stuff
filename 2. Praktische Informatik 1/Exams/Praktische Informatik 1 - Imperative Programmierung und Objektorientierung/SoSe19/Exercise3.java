// Useful imports for your implementation
import java.util.*;
import java.util.Scanner;
import java.nio.file.*;


/**
 *
 * Exercise 3 (20 pts)
 *
 * The MapReader reads the Map from a file named ("map.txt") which
 * he then uses, with the help of exercise 1's algorithm, to navigate
 * towards the treasure. This does however mean, that this exercise
 * can only be correctly implemented after exercise 1 has been completed.
 *
 *  Let this class extend the class from exercise 1. Then implement the
 *  Constructor of this class so that the result of "readMap" gets passed
 *  to the Superclass. Implement the methods "readMap" and "move" according
 *  to their description.
 *
 * The mathod "main" will be used for testing.
 *
 * Again, no changed done to main will be taken into account.
 */
class Exercise3
{
    /**
     * Constructor of the class Exercise3.
     * @param figure the figure that will be moved. Must be passed
     *               to superclass.
     * @param fileName the name of the file containing the map. The
     *                 format is the same as in Exercise 1, where the
     *                 Strings there represent the lines here.
     */
    Exercise3(final GameObject figure, final String fileName)
    {
        // Must be passed to superclass
    }

    /**
     * The method reads in the Map and returns it.
     * @param fileName the name of the file containing the map.
     * @return          the map that the file contained, or null
     *                  if the file couldn't be read
     */
    static List<String> readMap(final String fileName)
    {
        return null; // replace this
    }

    /**
     * If the map could be read, this method needs to call the same
     * method from the superclass and return the outcome of the
     * superclass's method. If the map could not be read, that means
     * "giveMap" returns null, then this method must return false.
     *
     * @return true, if the character is supposed to move forward.
     *         false, if the treasure has been reached or the map
     *         couldn't be read.
     */
    boolean moveMe()
    {
        return false; // replace this
    }

    /**
     * Again, none of your business! Focus on getting your methods implemented!
     */
    public static void main(String[] args)
    {
        final GameObject[] figures = {
            new GameObject(0, 3, 0, "green")
        };
        final Exercise3[] instances = {
            new Exercise3(figures[0], "map.txt")
        };
        final int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        boolean continueMoving = true;
        while (continueMoving) {
            continueMoving = false;
            for (int i = 0; i < figures.length; ++i) {
                if (instances[i].moveMe()) {
                    final GameObject figure = figures[i];
                    figure.setLocation(figure.getX() + move[figure.getRotation()][0],
                                      figure.getY() + move[figure.getRotation()][1]);
                    continueMoving = true;
                }
            }
            Game.sleep(100);
        }
    }
}
