import java.io.File;
import java.io.IOException;

/**
 * Eine Klasse, die drei Klassenmethoden kapselt, die für Spiele benötigt werden.
 *
 * @author Thomas Röfer
 */
public abstract class Game
{
    /**
     * Warten auf und Liefern der nächsten gedrückten Taste.
     * @return Ein Tastencode, wie sie in der Klasse {@link java.awt.event.KeyEvent}
     *         definiert sind.
     */
    public static int getNextKey()
    {
        return GameObject.Canvas.getInstance().getNextKey();
    }

    /**
     * Warten für eine bestimmte Zeit.
     * @param millis Die Anzahl Millisekunden, die gewartet wird. Die tatsächliche
     *         Wartezeit kann etwas länger sein.
     */
    public static void sleep(final int millis)
    {
        try {
            Thread.sleep(millis);
        }
        catch (final InterruptedException e) {
            // Ignorieren
        }
    }

    /**
     * Abspielen einer Sound-Datei.
     * @param fileName Der Name der Datei. Sie wird im Unterverzeichnis "sounds"
     *                 gesucht. Wenn keine Dateiendung angegeben wurde, wird
     *                 ".wav" angehängt.
     * @throws IllegalArgumentException Die Datei konnte nicht gefunden werden.
     */
}
