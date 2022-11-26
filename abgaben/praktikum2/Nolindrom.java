public class Nolindrom {

    public static void main(String[] args) {
        if (args.length == 0) {
			System.out.println("Bitte geben Sie die Obergrenze als Parameter an.");
			System.exit(-1);
		}
        int numToTest = Integer.parseInt(args[0]);

		if (numToTest > 100000) {
			System.out.println("Bitte geben Sie die Obergrenze als Parameter an.");
			System.exit(-1);
		}

        if (args.length == 2) {
            if (args[1].equals("x")) {
                getNolindroms(numToTest, false);
            }
        } else {
            getNolindromsWithLong(numToTest);
        }
    }

    /**
     * 
     * @param numToTest Up to which number Nolindromes should be searched for
     * @param finishOnFirstOccurence    Whether to print out only the first occurence of a Nolindrome that would have NOT been found by searching for it with Long -> see getNolindromsWithLong()
     */
    public static void getNolindroms(int numToTest, boolean finishOnFirstOccurence) {
        String N = "0";
        String R = "0";
        int steps = 0;

        boolean hasFoundNolindromWhenLongCanceled = false;

        for (int i = 0; i <= numToTest; i++) {
            boolean currentIIsPalindrom = false;
            N = "" + i;

            boolean canceledOnOverflow = false;

            while (steps <= 100) {
                R = getReverse(N);
                if (isPalindrom(add(N, R))) {
                    currentIIsPalindrom = true;
                    break;
                } else {
                    currentIIsPalindrom = false;
                }
                N = add(N, R);

                if (!canceledOnOverflow) {
                    try {
                        long temp = Long.parseLong(N) + Long.parseLong(R);
                    } catch (Exception e) {
                        canceledOnOverflow = true;
                    }
                }

                steps++;
            }
            if (canceledOnOverflow && currentIIsPalindrom) {
                // Wenn mit long abgebrochen wäre, aber nach exaktem rechnen doch ein palindrom ist
                System.out.println(i + " braucht " + steps + " Iterationen bis zum Palindrom " + N);
                hasFoundNolindromWhenLongCanceled = true;

                if (finishOnFirstOccurence) // Wenn false, werden ALLE Zahlen ausgegeben, die zu einem Nolindrom geführt hätten, nicht nur die erste
                    return;
            }
            steps = 1;
        }

        if (!hasFoundNolindromWhenLongCanceled) {
            // Wenn KEIN Nolindrom gefunden wurde, welches durch long NICHT ERKANNT worden wäre
            System.out.println("alle Zahlen werden auch durch Abbruch per Ueberlauf gefunden");
        }
    }

    /***
     * Prints all Nolindroms up to `numToTest`
     * Caution: could overflow because of Long.MAXVALUE
     * 
     * @param numToTest up to which number Nolindromes should be found
     */
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
     * @param l Any String that should be checked whether it is a Palindrom
     * @return returns whether i is a Palindrom (1001, 2002, 3113,...)
     */
    private static boolean isPalindrom(String l) {
        return getReverse(l).equals(l);
    }

    /**
     * 
     * @param n Any String
     * @return reversed String from n (eg. 123 -> 321, abc -> cba)
     */
    private static String getReverse(String n) {
        String nAsString = n;
        char[] nAsCharArray = nAsString.toCharArray();

        String reverseString = "";

        // Reverse String
        for (int i = 0; i < nAsCharArray.length; i++) {
            reverseString += nAsCharArray[nAsCharArray.length - 1 - i];
        }

        return reverseString;
    }

    /**
     * Adds any two given Numbers - No overflow "possible"
     * 
     * @param a Any Number as String representation
     * @param b Any Number as String representation
     * @return  String containing the sum of a and b
     */
    private static String add(String a, String b) {
        char[] aAsCharArray = a.toCharArray();
        char[] bAsCharArray = b.toCharArray();

        String returnString = "";

        int biggerArray = aAsCharArray.length >= bAsCharArray.length ? aAsCharArray.length : bAsCharArray.length;

        int imSinn = 0;
        for (int i = 0; i < biggerArray; i++) {
            // Loop from Back to Forth - "Schrifliches Addieren" lol
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