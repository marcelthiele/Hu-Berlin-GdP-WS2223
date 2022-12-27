package marcel.uebungsblatt4;

import gdp.stdlib.StdDraw;

public class Pythagoras {
    public static void main(String[] args) {
        StdDraw.setXscale(0, 3);
        StdDraw.setYscale(0, 3);
        printNextIteration(1, 1, 2, 1);
    }

    /**
     * Erstellt ein neues Qadrat und die dazugehörigen Seiten des Dreiecks
     * 
     * @param prevX1
     * @param prevY1
     * @param prevX2
     * @param prevY2
     */
    public static void printNextIteration(double prevX1, double prevY1, double prevX2, double prevY2) {
        double x_delta = Math.abs(prevX1 - prevX2);
        double y_delta = Math.abs(prevY1 - prevY2);
        double prevLineLength = Math.sqrt(Math.pow(x_delta, 2) + Math.pow(y_delta, 2));

        //Calculate Square Coordinates
        double squareLowerLeftX = prevX1;
        double squareLowerLeftY = prevY1;
        double squareLowerRightX = prevX2;
        double squareLowerRightY = prevY2;

        double squareUpperLeftX = prevX1;
        double squareUpperLeftY = prevY1 + prevLineLength;
        double squareUpperRightX = prevX2;
        double squareUpperRightY = prevY2 + prevLineLength;

        //Calculate Triangle Coordinates
        double alpha = Math.random() * Math.PI / 6 + Math.PI / 6;

        double aLength = Math.sin(alpha) * prevLineLength;
        double bLength = Math.cos(alpha) * prevLineLength;

        double triangleTopX = squareUpperLeftX + Math.cos(alpha) * bLength;
        double triangleTopY = squareUpperLeftY + Math.sin(alpha) * bLength;

        // Draw Square
        StdDraw.line(squareUpperLeftX, squareUpperLeftY, squareUpperRightX, squareUpperRightY);
        StdDraw.line(squareUpperRightX, squareUpperRightY, squareLowerRightX, squareLowerRightY);
        StdDraw.line(squareLowerRightX, squareLowerRightY, squareLowerLeftX, squareLowerLeftY);
        StdDraw.line(squareLowerLeftX, squareLowerLeftY, squareUpperLeftX, squareUpperLeftY);

        //Draw Triangle
        StdDraw.line(squareUpperLeftX, squareUpperLeftY, triangleTopX, triangleTopY);
        StdDraw.line(squareUpperRightX, squareUpperRightY, triangleTopX, triangleTopY);
    }
}
