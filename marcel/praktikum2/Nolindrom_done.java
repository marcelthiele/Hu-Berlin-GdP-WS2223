package marcel.praktikum2;

import java.math.BigInteger;

public class Nolindrom_done {

    // TODO checken ob alles funktioniert

    public static void main(String[] args) {
        int numToTest = Integer.parseInt(args[0]);
        if (args.length == 2) {
            if (args[1].equals("x")) {
                getNolindroms(numToTest, true);
            }
        } else {
            getNolindromsWithLong(numToTest);
        }
    }

    public static void getNolindroms(int numToTest, boolean finishOnFirstOccurence) {
        String N = "0";
        String R = "0";
        int steps = 0;

        boolean hasFoundPalindromeWhenLongCanceled = false;

        for (int i = 0; i <= numToTest; i++) {
            boolean currentIIsPalindrom = false;
            N = "" + i;
            // System.out.println("N ist jetzt: " + N.toString());

            boolean canceledOnOverflow = false;

            while (steps <= 100) {
                R = getReverse(N);
                if (isPalindrom(add(N, R))) {
                    // System.out.println(i + " führt zu Palindrom: " + add(N, R));
                    currentIIsPalindrom = true;
                    break;
                } else {
                    currentIIsPalindrom = false;
                }
                N = add(N, R);

                if (!canceledOnOverflow) {
                    try {
                        long test = Long.parseLong(N) + Long.parseLong(R);
                    } catch (Exception e) {
                        canceledOnOverflow = true;
                    }
                }

                // System.out.println("N : " + N + ", R: " + R + ", N+R: " + add(N, R) + ",
                // steps: " + steps);

                steps++;
            }
            if (canceledOnOverflow && currentIIsPalindrom) {
                // Wenn mit long abgebrochen wäre, aber nach exaktem rechnen doch ein palindrom
                // ist
                System.out.println(i + " braucht " + steps + " Iterationen bis zum Palindrom " + N);
                hasFoundPalindromeWhenLongCanceled = true;

                if (finishOnFirstOccurence)
                    return;
            }
            steps = 1;
        }

        if (!hasFoundPalindromeWhenLongCanceled) {
            System.out.println("alle Zahlen werden auch durch Abbruch per Ueberlauf gefunden");
        }
    }

    public static void getNolindromsWithLong(int numToTest) {
        long N = 0;
        long R = 0;
        int steps = 0;

        for (int i = 0; i < numToTest; i++) {
            boolean currentIIsPalindrom = false;
            N = i;
            // System.out.println("N ist jetzt: " + N.toString());
            while (steps <= 100) {
                try {
                    R = Long.parseLong(getReverse(N + ""));
                    if (isPalindrom((N + R) + "")) {
                        currentIIsPalindrom = true;
                        break;
                    } else {
                        currentIIsPalindrom = false;
                    }
                    N = N + R;
                    steps++;
                } catch (NumberFormatException e) {
                    break;
                }
            }
            if (!currentIIsPalindrom) {
                // Wenn bis 100 Schritten kein palindrom da ist
                System.out.println(i);
            }
            steps = 0;
        }
    }

    /**
     * 
     * @param l
     * @return returns whether i is a Palindrom (1001, 2002, 3113,...)
     */
    private static boolean isPalindrom(String l) {
        return getReverse(l).equals(l);
    }

    /**
     * 
     * @param n
     * @return reversed number from n (eg. 123 -> 321)
     */
    private static String getReverse(String n) {
        String nAsString = n;
        char[] nAsCharArray = nAsString.toCharArray();

        String reverseString = "";

        // Reverse String
        for (int i = 0; i < nAsCharArray.length; i++) {
            reverseString += nAsCharArray[nAsCharArray.length - 1 - i];
        }

        // System.out.println(reverseString + " is reverse of: " + n);

        // System.out.println("reverseString: " + new
        // BigInteger(reverseString).toString());

        return reverseString;
    }

    private static String add(String a, String b) {
        char[] aAsCharArray = a.toCharArray();
        char[] bAsCharArray = b.toCharArray();

        String returnString = "";

        int biggerArray = aAsCharArray.length >= bAsCharArray.length ? aAsCharArray.length : bAsCharArray.length;

        int imSinn = 0;
        for (int i = 0; i < biggerArray; i++) {
            // Von hinten durch die Zahlen durchlaufen
            int currentNumberFromA;
            int currentNumberFromB;

            if (i < aAsCharArray.length) {
                currentNumberFromA = Integer.parseInt(aAsCharArray[aAsCharArray.length - 1 - i] + "");
            } else {
                currentNumberFromA = 0;
            }
            if (i < bAsCharArray.length) {
                currentNumberFromB = Integer.parseInt(bAsCharArray[bAsCharArray.length - 1 - i] + "");
            } else {
                currentNumberFromB = 0;
            }

            int currentSum = currentNumberFromA + currentNumberFromB + imSinn;

            imSinn = (int) (currentSum / 10);
            currentSum = currentSum % 10;

            if (i == biggerArray - 1 && imSinn > 0) {
                // Wenn die letzte Zahl noch einsimsinn hat, dann müssen beide ziffern angehangen werden
                currentSum = currentSum + imSinn * 10;
            }
            returnString = currentSum + returnString;
        }

        // Clear leading zeros
        char[] retStringAsCharArray = returnString.toCharArray();
        returnString = "";
        boolean onlyZeroesSoFar = true;
        for (int i = 0; i < retStringAsCharArray.length; i++) {
            if (Integer.parseInt(retStringAsCharArray[i] + "") == 0 && onlyZeroesSoFar)
                continue;
            else {
                onlyZeroesSoFar = false;
                returnString += retStringAsCharArray[i];
            }
        }


        return returnString;
    }

}