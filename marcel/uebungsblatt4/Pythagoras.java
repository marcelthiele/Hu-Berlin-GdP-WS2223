package marcel.uebungsblatt4;

import gdp.stdlib.StdDraw;

public class Pythagoras {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(1000, 1000);

        StdDraw.setXscale(0, 30);
        StdDraw.setYscale(0, 30);

        double x1 = 13;
        double y1 = 2;
        double x2 = 17;
        double y2 = 2;
        double x3 = 17;
        double y3 = 6;
        double x4 = 13;
        double y4 = 6;

        drawSquare(x1, y1, x2, y2, x3, y3, x4, y4);
        draw(x4, y4, x3, y3, 0, 0, 10);
    }

    public static void draw(double x1, double y1, double x2, double y2, double prevAlpha, int currentLevel,
            int levelToStop) {
        if (currentLevel >= levelToStop)
            return;

        double alpha = Math.random() * Math.PI / 6 + Math.PI / 6;

        double prevLineLength = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        double a = Math.sin(alpha) * prevLineLength;
        double b = Math.cos(alpha) * prevLineLength;

        double dx1 = Math.sin(Math.PI/2 - (alpha + prevAlpha));
        double dy1 = Math.cos(Math.PI/2 - (alpha + prevAlpha));

        double x3 = x1 + b * dx1;
        double y3 = y1 + b * dy1;

        drawTriangle(x1, y1, x2, y2, x3, y3);

        double dx2 = Math.cos(Math.PI / 2 + (alpha + prevAlpha));
        double dy2 = Math.sin(Math.PI / 2 + (alpha + prevAlpha));

        double x4 = x3 + b * dx2;
        double y4 = y3 + b * dy2;

        double x5 = x1 + b * dx2;
        double y5 = y1 + b * dy2;

        drawSquare(x1, y1, x3, y3, x4, y4, x5, y5);
        draw(x5, y5, x4, y4, prevAlpha + alpha, currentLevel + 1, levelToStop);

        double dx3 = Math.sin(alpha + prevAlpha - Math.PI/2);
        double dy3 = Math.cos(alpha + prevAlpha - Math.PI/2);

        // System.out.println("dx3: " + dx3 + ", dy3: " + dy3);
        // System.out.println("a: " + a + ", b: " + b);

        double x6 = x3 - a * dx3;
        double y6 = y3 + a * dy3;

        double x7 = x2 - a * dx3;
        double y7 = y2 + a * dy3;

        drawSquare(x3, y3, x2, y2, x7, y7, x6, y6);
        draw(x6, y6, x7, y7, (prevAlpha + alpha) - Math.PI/2, currentLevel + 1, levelToStop);
    }

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

    private static void drawTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(x1, y1, x2, y2);
        StdDraw.line(x2, y2, x3, y3);
        StdDraw.line(x3, y3, x1, y1);
    }
}
