import javax.swing.*;

/**
 * Exercise 1 gives 40% accounts for 40% of the points.
 *
 * When starting, this class is given a map with symbols on each (x,y) coordinate representing
 * the direction the player should move ('>', 'V', '<' and 'A' for the directions 0-3)
 * to get to the hidden chest, the location of which (x,y) contains the symbol 'X'.
 *
 * Program the constructor and the methods "move" and "giveMap" as required by them.
 * You do not need to create new Objects for this exercise.
 *
 * The method "main" tests your implementation.
 *
 * The location of the character used in the test case later will be different than the given ones.
 *
 * Changing the method "main" will not affect anything, so do not try that.
 *
 */

class Exercise1 {

    /** The player that will be controlled */
    private final GameObject player;

   //Insert variables as needed

    /** Constructor of the class Exercise1
     * @param player - the player that will be controlled
     * @param map - the map to be used */
    Exercise1(final GameObject player, final String[] Map) {
        //Add code here
    }

    /**
     * This method should return the given map.
     * @return The map that will be handed to the constructor.
     */
    String[] giveMap() {
        return null; //replace
    }

    /**
     * This method has to rotate the player based on the symbol that is
     * on the player's location on the map ('>', 'V', '<' and 'A' for the
     * Rotations 0-3) and return true, which will automatically move the player
     * accordingly. If the symbol on the map is 'X' (or any other symbol),
     * it should return false, which will stop the use of this method.
     *
     * Methods of the player to use: getX, getY and setRotation
     *
     * @return true, if the player should move forward.
     *
     * @return false, if the chest has been reached.
     */
    boolean move() {
        return false; //replace
    }

    /**
     * The method that will test your implementation. Changing this
     * will not affect tthe tests being run by the correction system.
     *
     * So just ignore this.
     */
    public static void main(String[] args) throws ReflectiveOperationException
    {
        final GameObject npc = new GameObject(0, 3, 0, "red-0");
        final Exercise1 instance = new Exercise1(npc, new String[] {
                "                    ",
                "      ____          ",
                "     |    |___      ",
                ">>>V|  ~      |     ",
                "   V |     ~   |    ",
                "   V  |_______|     ",
                "   V                ",
                "   V                ",
                " V<<                ",
                " V          X  __   ",
                " V          A |  |  ",
                " V          A |__|  ",
                " >>>>>>>>>>>A  ||   ",
                "               ||   ",
                "      /|            ",
                "     /  |__         ",
                "    /  /   |        ",
                "   /  /     |       ",
                "                    ",
                "                    ",
                "                    ",
        });

        final int[][] moveMe = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (instance.move()) {
            npc.setLocation(npc.getX() + moveMe[npc.getRotation()][0],
                    npc.getY() + moveMe[npc.getRotation()][1]);
            Game.sleep(100);
        }
        if(npc.getX()==12&&npc.getY()==9)
            JOptionPane.showMessageDialog(null,"Well Done!");
    }
}
