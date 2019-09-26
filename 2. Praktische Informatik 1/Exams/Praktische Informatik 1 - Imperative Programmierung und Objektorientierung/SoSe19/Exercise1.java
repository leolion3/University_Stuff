import java.util.Arrays;
import java.util.List;

/**
 * Exercise 1 ( 40 pts )
 *
 * The character gets a card given containing a direction he should
 * turn for each field in order to reach the treasure('>', 'V', '<' und 'A'
 * for the directions 0-3).
 *
 * An 'X' is located at the treasure's location. The character must follow
 * these symbols, or drown in the quicksand. If the field the character is
 * standing on does not contain a symbol, then you have done something wrong.
 *
 * Complete the Constructor and the method "moveMe" and "giveMap" accordingly.
 * You do not need to create any new Objects in this exercise.
 *
 * The method "main" can be used to test your implementation.
 *
 * Any changes to the "main" method will not be accounted for.
 */
class Exercise1
{
    /** The Character that gets moved */
    private final GameObject character;

    // Here you can add more attributes, should you need them

    /**
     * Constructor
     * @param character - the character that gets moved.
     * @param map       = The map (see down below). Each field containing
     *                    a direction the character should turn when he's
     *                    standing on that field.
     */
    Exercise1(final GameObject character, final List<String> map)
    {
        // add stuff here
    }

    /**
     * This method must return the map.
     * @return the map, that is given to the constructor
     */
    List<String> giveMap()
    {
        // replace this
    }

    /**
     * This method must turn the character each time it is called according
     * to the symbol located at the character's position on the map ('>',
     * 'V', '<' and 'A' for the directions 0-3) and then return true, which
     * will then move the character in that direction. Should the character
     * be standing on the 'X' symbol (or any other symbol), it should
     * return false, which will no longer move the player.
     *
     * Methods of the character to use: getX, getY, setRotation
     *
     * @return true, if the character should move forward.
     * @return false, if the treasure has been reached.
     */
    boolean moveMe()
    {
        return false; // replace this
    }

    /**
     * The test method. If your implementation is correct the Character
     * will follow the symbols of the map (below) and stop at the chest's
     * location. When the chest is reached the program should terminate.
     * @throws ReflectiveOperationException the classes it uses could
     * throw that exception, has no meaning here.
     */
    @SuppressWarnings("all")
    public static void main(String[] args) throws ReflectiveOperationException
    {
        final GameObject figure = new GameObject(0, 3, 0, "red");
        final Exercise1 instance = new Exercise1(figure, Arrays.asList(new String[] {
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
        }));

        final int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (instance.moveMe()) {
            figure.setLocation(figure.getX() + move[figure.getRotation()][0],
                              figure.getY() + move[figure.getRotation()][1]);
            Game.sleep(100);
        }
    }
}
