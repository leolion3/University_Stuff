import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Semaphore;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Die Klasse für Spielobjekte. Ein Spielobjekt wird auf einem Gitter platziert,
 * dessen Ursprung am oberen Rand in der Mitte der Zeichenfläche ist. x-Koordinaten
 * wachsen nach unten rechts (Südost), y-Koordinaten nach unten links (Südwest). Ein
 * Spielobjekt hat eine Rotation, die 0 in Richtung +x, 1 in Richtung y, 2 in
 * Richtung -x und 3 in Richtung -y ist. Ein Spielobjekt hat außerdem eine visuelle
 * Erscheinung, die durch ein Bild vorgegeben ist. Dieses kann entweder aus einer
 * geladenen Grafikdatei stammen oder direkt gesetzt werden. Für das Laden aus
 * Dateien existiert die Konvention, dass abhängig von der Rotation Dateien mit den
 * entsprechenden Endungen "-0", "-1", "-2" und "-3" geladen werden, wenn es sie
 * gibt. Grafikdateien werden im Unterverzeichnis "images" und Sound-Dateien im
 * Unterverzeichnis "sounds" erwartet.
 *
 * @author Thomas Röfer
 */
public class GameObject extends Game
{
    // Wird vor dem Erzeugen des ersten GameObjects ausgeführt
    static {
        bufferedImages = new HashMap<>();
        nextId = 1;
        new Canvas(640, 504, 48, 24);
        new GameObject(10, 10, 0, "treasure-map.jpg");
        new GameObject(12, 9, 0, "goal");
    }
    
    /**
     * Eine Zeichenfläche, die Spielobjekte in isometrischer Darstellung verwaltet
     * und anzeigt. Die Zeichenfläche kümmert sich um die Anzeige der Spielobjekte
     * mit der richtigen Verdeckung. Dies wird darüber erreicht, dass alle Objekte
     * von hinten nach vorne gezeichnet werden. Befinden sich Objekte an derselben
     * Stelle, werden sie in der Reihenfolge ihres Hinzufügens gezeichnet. Auch
     * die Bewegung (aber nicht die Drehung) eines Objekts bedeutet ein erneutes
     * Hinzufügen, d.h. bewegte Objekte werden vor statischen Objekten mit
     * denselben Koordinaten gezeichnet.
     */
    public static class Canvas extends JPanel
    {
        /** Die einzige Instanz der Zeichenfläche. */
        private static Canvas instance;

        /** Die Breite einer Zelle in Pixeln. */
        private final int cellWidth;

        /** Die Höhe einer Zelle in Pixeln. */
        private final int cellHeight;

        /**
         * Alle Spielobjekte, von hinten nach vorne geordnet, aber mit eindeutigen
         * Schlüsseln.
         */
        private final Set<GameObject> gameObjects = new TreeSet<>(
                (a, b) -> {
                    // Spezialbehandlung für Hintergrund
                    if (a.id == 1) {
                        return -1;
                    }
                    else if (b.id == 1) {
                        return 1;
                    }
                    final int aDepth = a.getX() + a.getY();
                    final int bDepth = b.getX() + b.getY();
                    return aDepth == bDepth ? a.id - b.id : aDepth - bDepth;
                });

        /**
         * Eine Semaphore, die für jede neue gedrückte Taste erhöht und für jede
         * abgeholte Taste verringert wird. Steht keine Taste zur Verfügung, muss
         * der Abholer warten.
         */
        private final Semaphore waitForKey = new Semaphore(0);

        /** Die Liste der gedrückten und noch nicht abgeholten Tasten. */
        private final Queue<Integer> keys = new LinkedList<>();

        /**
         * Liefert die einzige Instanz der Zeichenfläche. Wenn es noch keine gibt,
         * wird eine in einer Standardgröße erzeugt.
         * @return Die Zeichenfläche.
         */
        public static Canvas getInstance()
        {
            if (instance == null) {
                instance = new Canvas(720, 449, 180, 90);
            }
            return instance;
        }

        /**
         * Erzeugt eine neue Zeichenfläche für Objekte in isometrischer Perspektive.
         *
         * @param canvasWidth Die Breite der Fläche in Pixeln.
         * @param canvasHeight Die Höhe der Fläche in Pixeln.
         * @param cellWidth Die Breite einer Zelle in Pixeln.
         * @param cellHeight Die Höhe einer Zelle in Pixeln.
         */
        public Canvas(final int canvasWidth, final int canvasHeight,
                final int cellWidth, final int cellHeight)
        {
            instance = this;
            this.cellWidth = cellWidth;
            this.cellHeight = cellHeight;
            final JFrame frame = new JFrame("PI-1-Spiel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(this);
            frame.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(final KeyEvent event) {
                    synchronized (keys) {
                        keys.offer(event.getKeyCode());
                    }
                    waitForKey.release();
                }
            });
            setPreferredSize(new Dimension(canvasWidth, canvasHeight));
            frame.pack();
            frame.setVisible(true);
        }

        /**
         * Warten auf und Liefern der nächsten gedrückten Taste.
         * @return Ein Tastencode, wie sie in der Klasse
         *         {@link java.awt.event.KeyEvent} definiert sind.
         */
        public int getNextKey()
        {
            try {
                waitForKey.acquire();
                synchronized (keys) {
                    return keys.poll();
                }
            }
            catch (final InterruptedException e) {
                // Abbruch während des Wartens auf Taste: So tun als ob ESC gedrückt.
                return KeyEvent.VK_ESCAPE;
            }
        }

        /**
         * Neuzeichnen des Fensters. Diese Methode wird immer automatisch aufgerufen,
         * wenn etwas neu gezeichnet werden muss.
         * @param graphics Der Grafik-Kontext, in den gezeichnet wird.
         */
        @Override
        public void paintComponent(final Graphics graphics)
        {
            // Hintergrund neu zeichnen
            super.paintComponent(graphics);

            // Alle Spielobjekte zeichnen
            synchronized (this) {
                for (final GameObject gameObject : gameObjects) {
                    final Rectangle drawRectangle = getDrawRectangle(gameObject);
                    graphics.drawImage(gameObject.getImage(),
                            (int) drawRectangle.getX(), (int) drawRectangle.getY(),
                            null);
                }
            }
        }

        /**
         * Hinzufügen eines Spielobjekts zur Zeichenfläche.
         * @param gameObject Das Spielobjekt, das hinzugefügt wird. Es erscheint an
         *         der Stelle, die seine Position vorgibt. Wenn das Objekt bereits an
         *         dieser Stelle vorhanden war, passiert nichts.
         */
        private void addObject(final GameObject gameObject)
        {
            synchronized (this) {
                if (!gameObject.isVisible()) {
                    gameObject.id = nextId++;
                    gameObjects.add(gameObject);
                    repaintObject(gameObject);
                }
            }
        }

        /**
         * Entfernen eines Spielobjekts von der Zeichenfläche.
         * @param gameObject Das Spielobjekt, das entfernt wird. Die Position des
         *         Objekts muss immer noch dieselbe wie beim Einfügen sein, sonst
         *         wird es nicht gefunden. Ist das Objekt nicht vorhanden, passiert
         *         nichts.
         * @return Wurde das Objekt wirklich gelöscht?
         */
        private boolean removeObject(final GameObject gameObject)
        {
            synchronized (this) {
                final boolean removed = gameObjects.remove(gameObject);
                repaintObject(gameObject);
                return removed;
            }
        }

        /**
         * Überprüfen, ob ein Spielobjekt auf der Zeichenfläche enthalten ist.
         * @param gameObject Das Spielobjekt, das überprüft wird. Die Position des
         *         Objekts muss immer noch dieselbe wie beim Einfügen sein, sonst
         *         wird es nicht gefunden.
         * @return Ist das Objekt in der Zeichenfläche enthalten?
         */
        private boolean containsObject(final GameObject gameObject)
        {
            return gameObjects.contains(gameObject);
        }

        /**
         * Zeichnet den Bereich der Zeichenfläche neu, an dem ein Spielobjekt
         * erscheinen würde. Ist das Objekt zur Zeichenfläche hinzugefügt, wird es
         * dadurch gezeichnet. Ist es nicht hinzugefügt, wird nur der Bereich neu
         * gezeichnet, z.B. um das Objekt verschwinden zu lassen, nachdem es von
         * der Zeichenfläche entfernt wurde.
         * @param gameObject Das Objekt, dessen Bereich neu gezeichnet wird.
         */
        private void repaintObject(final GameObject gameObject)
        {
            repaint(getDrawRectangle(gameObject));
        }

        /**
         * Berechnen des Bereichs, an dem ein Objekt auf der Zeichenfläche erscheinen
         * würde.
         * @param gameObject Das Objekt, dessen Zeichenbereich bestimmt wird.
         * @return Das Rechteck mit Pixelkoordinaten, das den Bereich des Objekts auf
         *         der Zeichenfläche umschließt.
         */
        private Rectangle getDrawRectangle(final GameObject gameObject)
        {
            final int xOrigin = getWidth() / 2;
            final int yOrigin = (getHeight() % cellHeight + cellHeight) / 2;
            final int x = xOrigin + (gameObject.getX() - gameObject.getY())
                    * cellWidth / 2 - gameObject.getImage().getWidth() / 2;
            final int y = yOrigin + ((gameObject.getX() + gameObject.getY())
                    * cellHeight) / 2 - gameObject.getImage().getHeight() / 2;
            return new Rectangle(x, y, gameObject.getImage().getWidth(),
                    gameObject.getImage().getHeight());
        }
    }

    /** Cache für geladene Grafikdateien. Die Abbildung von Dateinamen auf Bilder */
    private static final Map<String, BufferedImage> bufferedImages;

    /** Die nächste zu vergebene Identifikationsnummer für Spielobjekte. */
    private static int nextId;

    /** Die Identifikationsnummer dieses Spielobjekts. */
    private int id;

    /** Die x-Koordinate dieses Spielobjekts im Gitter. */
    private int x;

    /** Die y-Koordinate dieses Spielobjekts im Gitter. */
    private int y;

    /** Die Rotation im Gitter (0 = Südost ... 3 = Nordost). */
    private int rotation;

    /**
     * Der Dateiname des Bildes dieses Spielobjekts. Wenn {@code null}, wurde das
     * Bild nicht aus einer Datei geladen.
     */
    private String imageFileName;

    /** Das Bild, mit dem dieses Spielobjekt dargestellt wird. */
    private BufferedImage image;

    /**
     * Erzeugen und Anzeigen eines neuen Spielobjekts.
     * @param x Die x-Koordinate dieses Spielobjekts im Gitter.
     * @param y Die y-Koordinate dieses Spielobjekts im Gitter.
     * @param rotation Die Rotation dieses Spielobjekts (0 = Südost ... 3 = Nordost).
     * @param fileName Der Dateiname des Bildes, durch das dieses Spielobjekt
     *         dargestellt wird.
     */
    public GameObject(final int x, final int y, int rotation, final String fileName)
    {
        this.x = x;
        this.y = y;
        this.rotation = rotation & 3;
        setImage(fileName);
        setVisible(true);
    }

    /**
     * Erzeugen und anzeigen eines neuen Spielobjekts.
     * @param x Die x-Koordinate dieses Spielobjekts im Gitter.
     * @param y Die y-Koordinate dieses Spielobjekts im Gitter.
     * @param image Das Bild, durch das dieses Spielobjekt dargestellt wird.
     */
    public GameObject(final int x, final int y, final BufferedImage image)
    {
        this.x = x;
        this.y = y;
        setImage(image);
        setVisible(true);
    }

    /**
     * Bewegt das Spielobjekt an eine andere Position.
     * @param x Die neue x-Koordinate dieses Spielobjekts im Gitter.
     * @param y Die neue y-Koordinate dieses Spielobjekts im Gitter.
     */
    public void setLocation(final int x, final int y)
    {
        final boolean removed = Canvas.getInstance().removeObject(this);
        this.x = x;
        this.y = y;
        if (removed) {
            Canvas.getInstance().addObject(this);
        }
    }

    /**
     * Liefern der aktuellen x-Koordinate dieses Spielobjekts im Gitter.
     * @return Die x-Koordinate.
     */
    public int getX()
    {
        return x;
    }

    /**
     * Liefern der aktuellen y-Koordinate dieses Spielobjekts im Gitter.
     * @return Die y-Koordinate.
     */
    public int getY()
    {
        return y;
    }

    /**
     * Setzen der Rotation dieses Spielobjekts.
     * @param rotation Die Rotation im Gitter (0 = Südost ... 3 = Nordost).
     */
    public void setRotation(final int rotation)
    {
        // Alten Wert für Vergleich merken.
        final int prevRotation = this.rotation;

        // In Bereich 0..3 bewegen und übernehmen.
        this.rotation = rotation & 3;

        // Bild bei Bedarf an Orientierung anpassen.
        if (imageFileName != null && this.rotation != prevRotation) {
            setImage(imageFileName);
        }
    }

    /**
     * Liefern der Rotation dieses Spielobjekts im Gitter.
     * @return Die Rotation im Gitter (0 = Südost ... 3 = Nordost).
     */
    public int getRotation()
    {
        return rotation;
    }

    /**
     * Setzen des Bildes, mit dem dieses Spielobjekt dargestellt wird.
     * @param fileName Der Name der Datei. Sie wird im Unterverzeichnis "images"
     *         gesucht. Wenn keine Dateiendung angegeben wurde, wird ".png"
     *         angehängt. Es wird zuerst versucht, eine Version passend zur aktuellen
     *         Rotation zu laden, indem die entsprechende Ergänzung "-0", "-1", "-2"
     *         oder "-3" an den Dateinamen angehängt wird (vor der Dateiendung, d.h.
     *         dem Punkt). Wird keine solche Variante gefunden, wird der Dateiname
     *         direkt verwendet.
     * @throws IllegalArgumentException Die Datei konnte nicht gefunden werden oder
     *         sie enthält kein Bild.
     */
    public void setImage(final String fileName)
    {
        // Dateinamen in Teile vor und nach dem Punkt zerlegen.
        final int period = fileName.lastIndexOf('.');
        final int separator = fileName.lastIndexOf(File.separator);
        final String baseName;
        final String extension;

        // Punkt hinter letztem Pfadtrenner gefunden?
        if (period > separator) {
            baseName = fileName.substring(0, period);
            extension = fileName.substring(period);
        }
        else {
            baseName = fileName;
            extension = ".png";
        }

        // Bild aus Cache verwenden
        BufferedImage image = bufferedImages.get(baseName + "-" + rotation + extension);

        // Wenn nicht gefunden, dann Datei laden
        if (image == null) {
            try {
                // Zuerst mit Orientierung versuchen.
                image = ImageIO.read(new File("images" + File.separator + baseName
                        + "-" + rotation + extension));
            }
            catch (final IOException e1) {
                // Ansonsten ohne Orientierung versuchen.
                try {
                    image = ImageIO.read(new File("images" + File.separator
                            + baseName + extension));
                }
                catch (final IOException e2) {
                    throw new IllegalArgumentException("Die Bilddatei '"
                            + baseName + extension
                            + "' konnte nicht geladen werden.");
                }
            }

            // Überprüfen, ob ein Bild geladen wurde.
            if (image == null) {
                throw new IllegalArgumentException("Die Datei '" + baseName
                        + extension + "' enthält kein Bild.");
            }

            // Geladenes Bild im Cache speichern.
            bufferedImages.put(baseName + "-" + rotation + extension, image);
        }

        // Bild setzen
        setImage(image);

        // Dateinamen übernehmen.
        imageFileName = fileName;
    }

    /**
     * Setzen des Bildes, mit dem dieses Spielobjekt dargestellt wird.
     * @param image Ein Bild.
     */
    public void setImage(final BufferedImage image)
    {
        // Das Bild muss existieren, sonst kommt es beim Zeichnen zum Fehler.
        if (image == null) {
            throw new NullPointerException("Das Bild darf nicht 'null' sein.");
        }

        // Bisherigen Zeichenbereich des Objekts merken.
        Rectangle drawRectangle = this.image != null
                ? Canvas.getInstance().getDrawRectangle(this) : new Rectangle(x, y, 0, 0);

        // Bild übernehmen. Dateinamen löschen, da er nun nicht mehr zum Bild gehört.
        this.image = image;
        imageFileName = null;

        // Neuzeichnen der Vereinigung aus bisherigem und neuem Zeichenbereich,
        // wenn das Objekt Teil der Zeichenfläche ist.
        if (isVisible()) {
            drawRectangle.add(Canvas.getInstance().getDrawRectangle(this));
            Canvas.getInstance().repaint(drawRectangle);
        }
    }

    /**
     * Liefert das Bild, mit dem dieses Spielobjekt dargestellt wird. Das Bild darf
     * nicht verändert werden, da es möglicherweise von mehreren Spielobjekten
     * gemeinsam genutzt wird.
     * @return Das Bild.
     */
    private BufferedImage getImage()
    {
        return image;
    }

    /**
     * Macht dieses Spielobjekt sichtbar bzw. versteckt es.
     * @param visible Soll das Objekt sichtbar in der Zeichenfläche sein?
     */
    public void setVisible(final boolean visible)
    {
        if (visible) {
            Canvas.getInstance().addObject(this);
        }
        else {
            Canvas.getInstance().removeObject(this);
        }
    }
    
    /**
     * Ist das Spielobjekt sichtbar, also Teil der Zeichenfläche?
     * Diese Funktion liefert nicht, ob das Spielobjekt innerhalb der Grenzen der
     * Zeichenfläche zu sehen ist, sondern nur, ob es generell dazu gehört.
     * @return Ist es sichtbar?
     */
    public boolean isVisible()
    {
        return Canvas.getInstance().containsObject(this);
    }
}
