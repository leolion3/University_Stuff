// Der Import wird nur von main() benötigt
import java.lang.reflect.*;

/**
 * Exercise 2 accounts for 20% of the total points.
 *
 * This exercise uses the first one, and can therefor only be programmed after
 * successfully completing exercise 1.
 *
 * Let this class extend exercise 1, then program the constructor so that the
 * result of createMap gets given to the superclass. Implement the method
 * createMap like described.
 *
 * The method "main" will test your implementation.
 *
 * The start and end coordinates will be different in the correction
 * algorithm, so do not try modifying the main method.
 *
 * Code that does not compile will not be accounted for, and will be given 0 points.
 */

class Exercise2 {

    /**
     * Cconstructor of the class exercise 2
     * @param player - the controlled player, must be given to the superclass
     *
     * @param width - the with of the map (the length of the strings that make up the map)
     *
     * @param hight - the hight of the map (the amount of strings that make up the map)

     * @param xDestination the x coordinate (horizontal) of the destination.
     *
     * @param yDestination the y coordinate (vertical) of the destination.
     */
    Exercise2(final GameObject player, final int width, final int height, final int xDestination, final int yDestination) {
        //Add code here
    }

    /** This method must produce a map that allows the player to move
     * from any given location towards the chest.
     * To do this you just have to enter for each (x,y) position what rotation
     * should be given if the player is in that location.
     * he map is made up of the symbols ('>', 'V', '<' and  'A' for the
     * Directions +x, +y, -x and -y) and 'X' for the chest's location.
     *
     * @param width - the width of the map (the length of the strings that make up
     *              the map)
     * @param hight - The hight of the map (the amount of strings that make up
     *              the map)
     * @param xDestination - The x location of the chest (horizontally)
     * @param yDestination - the y location of the chest (vertically)
     * @return The produced map
     */
    static String[] producedMap(final int width, final int hight, final int xDestination, final int yDestination) {
        return null; //Ersetzen
    }

    /**
     * The method that will test your implementation. Changing this
     * will not affect tthe tests being run by the correction system.
     *
     * So just ignore this.
     */
    public static void main(String[] args) throws ReflectiveOperationException, ClassCastException
    {
        final GameObject npc = new GameObject(4, 0, 0, "yellow-0");
        final Exercise2 instance = new Exercise2(npc, 20, 21, 12, 9);

        final Method move = Exercise2.class.getSuperclass() == Object.class
                ? null : Exercise2.class.getSuperclass().getDeclaredMethod("move");

        final int[][] moveMe = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (move != null && (Boolean) move.invoke(instance)) {
            npc.setLocation(npc.getX() + moveMe[npc.getRotation()][0],
                    npc.getY() + moveMe[npc.getRotation()][1]);
            Game.sleep(100);
        }
    }

}
