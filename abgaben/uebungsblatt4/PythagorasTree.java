import gdp.stdlib.StdDraw;

/**
 * PythagorasTree zeichnet einen Pythagorasbaum. D.h. es werden n Quadrate an
 * den beiden Katheten eines generierten Dreiecks gezeichnet. Hierdurch entsteht
 * durch rekursive Anwendung eine Graphik, die einem Baum ähnelt
 * 
 * @author HU-GDP-Gruppe90-Edima-Thiele
 * @version 1.0.0
 */
public class PythagorasTree {
    /**
     * Generiert einen Pythagorasbaum mithilfe von StdDraw.
     * 
     * @param args an Stelle 0 muss ein Integer-Wert übergeben werden, der die
     *             Anzahl der Rekursionen angibt
     */
    public static void main(String[] args) {
        if (args.length == 0)
            System.exit(0);

        int n = Integer.parseInt(args[0]);

        initStdDraw();

        startDrawing(n);
    }

    /**
     * Initialisiert die StdDraw Zeichenfläche
     * mit x- und y-Werten zwischen 0 und 30.
     */
    public static void initStdDraw() {
        // StdDraw.setCanvasSize(1000, 1000);
        StdDraw.setXscale(0, 30);
        StdDraw.setYscale(0, 30);
    }

    /**
     * Startet die Zeichnung des ersten Rekursionschrittes. Zudem wird das erste
     * (vorher festgelegte) Quadrat gezeichnet.
     * 
     * @param numOfLevels gibt an, wie viele Rekursionsschritte stattfinden sollen
     */
    public static void startDrawing(int numOfLevels) {
        double x1 = 13;
        double y1 = 2;
        double x2 = 17;
        double y2 = 2;
        double x3 = 17;
        double y3 = 6;
        double x4 = 13;
        double y4 = 6;

        drawSquare(x1, y1, x2, y2, x3, y3, x4, y4);
        drawNextRecursiveStep(x4, y4, x3, y3, 0, 0, numOfLevels);
    }

    /**
     * Zeichnet den nächsten Rekursiven Schritt - also ein generiertes Dreieck mit
     * alpha < 60deg, alpha >= 30deg.
     * 
     * @param x1           x-Wert der linken oberen Ecke des vorherigen Quadrates
     * @param y1           y-Wert der linken oberen Ecke des vorherigen Quadrates
     * @param x2           x-Wert der rechten oberen Ecke des vorherigen Quadrates
     * @param y2           y-Wert der rechten oberen Ecke des vorherigen Quadrates
     * @param prevAlpha    Winkel des vorherigen Dreiecks
     * @param currentLevel das derzeitige Iterationslevel
     * @param levelToStop  die maximale Rekusionstiefe
     */
    public static void drawNextRecursiveStep(double x1, double y1, double x2, double y2, double prevAlpha,
            int currentLevel,
            int levelToStop) {
        if (currentLevel >= levelToStop)
            return;

        double alpha = Math.random() * Math.PI / 6 + Math.PI / 6;

        double prevLineLength = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        double a = Math.sin(alpha) * prevLineLength;
        double b = Math.cos(alpha) * prevLineLength;

        double dx1 = b * Math.sin(Math.PI / 2 - (alpha + prevAlpha));
        double dy1 = b * Math.cos(Math.PI / 2 - (alpha + prevAlpha));

        double x3 = x1 + dx1;
        double y3 = y1 + dy1;

        drawTriangle(x1, y1, x2, y2, x3, y3);

        double dx2 = b * Math.cos(Math.PI / 2 + (alpha + prevAlpha));
        double dy2 = b * Math.sin(Math.PI / 2 + (alpha + prevAlpha));

        double x4 = x3 + dx2;
        double y4 = y3 + dy2;

        double x5 = x1 + dx2;
        double y5 = y1 + dy2;

        drawSquare(x1, y1, x3, y3, x4, y4, x5, y5);
        drawNextRecursiveStep(x5, y5, x4, y4, prevAlpha + alpha, currentLevel + 1, levelToStop); // Left Square

        double dx3 = a * Math.sin(alpha + prevAlpha - Math.PI / 2);
        double dy3 = a * Math.cos(alpha + prevAlpha - Math.PI / 2);

        // System.out.println("dx3: " + dx3 + ", dy3: " + dy3);
        // System.out.println("a: " + a + ", b: " + b);

        double x6 = x3 - dx3;
        double y6 = y3 + dy3;

        double x7 = x2 - dx3;
        double y7 = y2 + dy3;

        drawSquare(x3, y3, x2, y2, x7, y7, x6, y6);
        drawNextRecursiveStep(x6, y6, x7, y7, (prevAlpha + alpha) - Math.PI / 2, currentLevel + 1, levelToStop); // Right
                                                                                                                 // Square
    }

    /**
     * Zeichnet ein Quadrat (streng genommen ein Rechteck) Zwischen den angegebenen
     * vier Eckpunkten. Die Reihenfolge der Punkte ist hierbei entscheidend! Die
     * nacheinander übergebenen Punkte müssen der gleichen Richtung um das Quadrat
     * folgen. Die in den '@param' beschriebenen Punkte sollten also befolgt werden
     * 
     * @param x1 x-Wert des unteren linken Punktes
     * @param y1 y-Wert des unteren linken Punktes
     * @param x2 x-Wert des oberen linken Punktes
     * @param y2 y-Wert des oberen linken Punktes
     * @param x3 x-Wert des oberen rechten Punktes
     * @param y3 y-Wert des oberen rechten Punktes
     * @param x4 x-Wert des unteren rechten Punktes
     * @param y4 y-Wert des unteren rechten Punktes
     */
    private static void drawSquare(double x1, double y1, double x2, double y2, double x3, double y3, double x4,
            double y4) {
        // StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.line(x1, y1, x2, y2);
        // StdDraw.setPenColor(StdDraw.CYAN);
        StdDraw.line(x2, y2, x3, y3);
        // StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.line(x3, y3, x4, y4);
        // StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.line(x4, y4, x1, y1);
    }

    /**
     * Zeichnet ein Dreieck zwischen den Punkten (x1, y1), (x2, y2), (x3, y3)
     * 
     * @param x1 x-Wert des unteren linken Punktes
     * @param y1 y-Wert des unteren linken Punktes
     * @param x2 x-Wert des unteren rechten Punktes
     * @param y2 y-Wert des unteren rechten Punktes
     * @param x3 x-Wert des oberen Punktes
     * @param y3 y-Wert des oberen Punktes
     */
    private static void drawTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(x1, y1, x2, y2);
        StdDraw.line(x2, y2, x3, y3);
        StdDraw.line(x3, y3, x1, y1);
    }
}
