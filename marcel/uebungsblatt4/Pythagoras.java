package marcel.uebungsblatt4;

import gdp.stdlib.StdDraw;

public class Pythagoras {
    public static void main(String[] args) {
        StdDraw.setXscale(0, 3);
        StdDraw.setYscale(0, 3);
        printNextIteration(1, 1, 2, 1, 0, 2);
    }

    /**
     * Erstellt ein neues Qadrat und die dazugehörigen Seiten des Dreiecks
     * 
     * @param prevX1
     * @param prevY1
     * @param prevX2
     * @param prevY2
     */
    public static void printNextIteration(double prevX1, double prevY1, double prevX2, double prevY2, int currentLevel,
            int levelToStop) {
        if (currentLevel >= levelToStop)
            return;

        double x_delta = prevX2 - prevX1;
        double y_delta = prevY2 - prevY1;
        double prevLineLength = Math.sqrt(Math.pow(x_delta, 2) + Math.pow(y_delta, 2));

        double prevAngle = 0;
        System.out.println("XDelta: " + x_delta);
        if (x_delta > 0)
            prevAngle = Math.PI / 2 + Math.acos(Math.abs(x_delta) / prevLineLength);
        else
            prevAngle = Math.asin(Math.abs(x_delta) / prevLineLength);

        // Calculate Square Coordinates
        double squareLowerLeftX = prevX1;
        double squareLowerLeftY = prevY1;
        double squareLowerRightX = prevX2;
        double squareLowerRightY = prevY2;

        double squareUpperLeftX = prevX1 + Math.cos(prevAngle) * prevLineLength;
        double squareUpperLeftY = prevY1 + Math.sin(prevAngle) * prevLineLength;
        double squareUpperRightX = prevX2 + Math.cos(prevAngle) * prevLineLength;
        double squareUpperRightY = prevY2 + Math.sin(prevAngle) * prevLineLength;

        // Calculate Triangle Coordinates
        double alpha = Math.random() * Math.PI / 6 + Math.PI / 6;
        System.out.println("Alpha: " + alpha);

        double aLength = Math.sin(alpha) * prevLineLength;
        double bLength = Math.cos(alpha) * prevLineLength;

        double calcAngle = 0;
        if (x_delta > 0)
            calcAngle = alpha - prevAngle;
        else
            calcAngle = alpha + prevAngle;
        double triangleTopX = squareUpperLeftX + Math.cos(calcAngle) * bLength;
        double triangleTopY = squareUpperLeftY + Math.sin(alpha) * bLength;

        // Draw Square
        StdDraw.line(squareUpperLeftX, squareUpperLeftY, squareUpperRightX, squareUpperRightY);
        StdDraw.line(squareUpperRightX, squareUpperRightY, squareLowerRightX, squareLowerRightY);
        StdDraw.line(squareLowerRightX, squareLowerRightY, squareLowerLeftX, squareLowerLeftY);
        StdDraw.line(squareLowerLeftX, squareLowerLeftY, squareUpperLeftX, squareUpperLeftY);

        // Draw Triangle
        StdDraw.line(squareUpperLeftX, squareUpperLeftY, triangleTopX, triangleTopY);
        StdDraw.line(squareUpperRightX, squareUpperRightY, triangleTopX, triangleTopY);

        printNextIteration(squareUpperLeftX, squareUpperLeftY, triangleTopX, triangleTopY, currentLevel + 1,
                levelToStop);
        printNextIteration(squareUpperRightX, squareUpperRightY, triangleTopX, triangleTopY, currentLevel + 1,
                levelToStop);
    }
}
