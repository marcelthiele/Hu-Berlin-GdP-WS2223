package marcel.uebungsblatt4;

import gdp.stdlib.StdDraw;

public class Pythagoras {
    public static void main(String[] args) {
        StdDraw.setXscale(0, 15);
        StdDraw.setYscale(0, 15);
        drawNextHouse(5, 5, 8, 5, 0, 1);
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
        System.out.println("-------");

        double x_delta = prevX2 - prevX1;
        double y_delta = prevY2 - prevY1;
        double prevLineLength = Math.sqrt(Math.pow(x_delta, 2) + Math.pow(y_delta, 2));

        double prevAngle = 0;
        System.out.println("XDelta: " + x_delta);
        System.out.println("prevLineLength: " + prevLineLength);
        if (x_delta > 0) {
            double temp = Math.abs(x_delta) / prevLineLength;
            System.out.println("temp: " + temp);
            prevAngle = Math.PI / 2 + Math.acos(temp);
            System.out.println("Prev Angle: " + (prevAngle - Math.PI / 2));
        } else {
            prevAngle = Math.asin(Math.abs(x_delta) / prevLineLength);
            System.out.println("Prev Angle: " + (prevAngle));
        }

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
        if (x_delta < 0)
            calcAngle = alpha + prevAngle;
        else
            calcAngle = alpha - prevAngle;

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

        StdDraw.show(2000);

        printNextIteration(squareUpperLeftX, squareUpperLeftY, triangleTopX, triangleTopY, currentLevel + 1,
                levelToStop);
        printNextIteration(squareUpperRightX, squareUpperRightY, triangleTopX, triangleTopY, currentLevel + 1,
                levelToStop);
    }

    public static void drawNextHouse(double x1, double y1, double x2, double y2, int currentLevel, int levelToStop) {
        if (currentLevel >= levelToStop)
            return;

        double x_delta = x2 - x1;
        double y_delta = y2 - y1;
        double prevLineLength = Math.sqrt(Math.pow(x_delta, 2) + Math.pow(y_delta, 2));

        // Calculate Triangle Coordinates
        double alpha = Math.random() * Math.PI / 6 + Math.PI / 6;
        System.out.println("prevline: " + prevLineLength);

        double aLength = Math.sin(alpha) * prevLineLength;
        double bLength = Math.cos(alpha) * prevLineLength;

        double triangleTopX = x1 + Math.cos(alpha) * bLength;
        double triangleTopY = y1 + Math.sin(alpha) * bLength;

        
        // Draw Triangle
        StdDraw.line(x1, y1, triangleTopX, triangleTopY);
        StdDraw.line(x2, y2, triangleTopX, triangleTopY);

        // Calculate left Square Coordinates
        double squareLowerLeftX = x1;
        double squareLowerLeftY = y1;
        double squareLowerRightX = triangleTopX;
        double squareLowerRightY = triangleTopY;

        double correctedAngle = Math.PI/2 - alpha;

        double squareUpperLeftX = squareLowerLeftX - Math.cos(correctedAngle) * bLength;
        double squareUpperLeftY = squareLowerLeftY + Math.sin(correctedAngle) * bLength;
        double squareUpperRightX = squareLowerRightX - Math.cos(correctedAngle) * bLength;
        double squareUpperRightY = squareLowerRightY + Math.sin(correctedAngle) * bLength;
        
        // Draw left Square
        StdDraw.line(squareUpperLeftX, squareUpperLeftY, squareUpperRightX, squareUpperRightY);
        StdDraw.line(squareUpperRightX, squareUpperRightY, squareLowerRightX, squareLowerRightY);
        StdDraw.line(squareLowerRightX, squareLowerRightY, squareLowerLeftX, squareLowerLeftY);
        StdDraw.line(squareLowerLeftX, squareLowerLeftY, squareUpperLeftX, squareUpperLeftY);
        

        // Calculate Square Coordinates
        squareLowerLeftX = triangleTopX;
        squareLowerLeftY = triangleTopY;
        squareLowerRightX = x2;
        squareLowerRightY = y2;

        squareUpperLeftX = squareLowerLeftX + Math.cos(alpha) * aLength;
        squareUpperLeftY = squareLowerLeftY + Math.sin(alpha) * aLength;
        squareUpperRightX = squareLowerRightX + Math.cos(alpha) * aLength;
        squareUpperRightY = squareLowerRightY + Math.sin(alpha) * aLength;

        // Draw right Square
        StdDraw.line(squareUpperLeftX, squareUpperLeftY, squareUpperRightX, squareUpperRightY);
        StdDraw.line(squareUpperRightX, squareUpperRightY, squareLowerRightX, squareLowerRightY);
        StdDraw.line(squareLowerRightX, squareLowerRightY, squareLowerLeftX, squareLowerLeftY);
        StdDraw.line(squareLowerLeftX, squareLowerLeftY, squareUpperLeftX, squareUpperLeftY);
    }
}
