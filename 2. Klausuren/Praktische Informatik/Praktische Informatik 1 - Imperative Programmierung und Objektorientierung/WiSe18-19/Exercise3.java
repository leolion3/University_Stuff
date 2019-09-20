// Nützliche Importe für die Implementierung
import javax.swing.*;
import java.util.*;

/**
 * Exercise 3 accounts for another 20% of the final point amount
 *
 * This class should read the mmap out of a file ("map.txt") and
 * navigate using exercise1. Basically this means you can only
 * solve this exercise after having successfully solved exercise 1
 *
 * Make this class extend exercise 1, then setup the constructor so that
 * the output of readMap gets given to the superclass. Implement the methods
 * readMap and move as required.
 *
 * The method "main" will test your implementation.
 */
class Exercise3
{
    /** Constructor of the class Exercise3
     *
     * @param player - the player to be controlled, must be given to superclass
     *
     * @param fileName - the fileName in which the map is saved. Uses the same symbols
     *                 as in the first 2 exercises.
     */
    Exercise3(final GameObject player, final String fileName)
    {
        readMap(fileName); // must be given to superclass
    }

    /** This method reads the map and returns it.
     * @param fileName - the fileName that contains the map
     * @return The read map, or null if the file cannot be found.
     */
    static String[] readMap(final String fileName)
    {
        final List<String> rows = new ArrayList<>();

        // implementation here

        return rows.toArray(new String[rows.size()]);
    }

    /**If the map was read successfully, then this method should call the
     * move method from the superclass and return its output. If the file
     * couldn't be read, then it must return false.
     *
     * @return true if the player should move forward.
     *         false, if the chest has been reached or the map couldn't be read.
     */
    boolean move()
    {
            return false; // replace
    }

    /**
     * The method that will test your implementation. Changing this
     * will not affect tthe tests being run by the correction system.
     *
     * So just ignore this.
     */
    public static void main(String[] args)
    {
        final GameObject[] players = {
            new GameObject(0, 3, 0, "green-0")
        };
        final Exercise3[] instance = {
            new Exercise3(players[0], "map.txt"),
        };
        final int[][] moveMe = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        boolean continueGoing = true;
        while (continueGoing) {
            continueGoing = false;
            for (int i = 0; i < players.length; ++i) {
                if (instance[i].move()) {
                    final GameObject player = players[i];
                    player.setLocation(player.getX() + moveMe[player.getRotation()][0],
                                      player.getY() + moveMe[player.getRotation()][1]);
                    continueGoing = true;
                }
            }
            Game.sleep(100);
        }
        if(players[0].getX()==12&&players[0].getY()==9)
            JOptionPane.showMessageDialog(null,"Well Done! You have successfully completed the exam!");
    }
}
